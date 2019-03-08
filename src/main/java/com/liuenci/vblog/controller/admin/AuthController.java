package com.liuenci.vblog.controller.admin;

import com.liuenci.vblog.controller.BaseController;
import com.liuenci.vblog.dto.LogActions;
import com.liuenci.vblog.model.bo.RestResponseBo;
import com.liuenci.vblog.model.vo.UserVo;
import com.liuenci.vblog.utils.Commons;
import com.liuenci.vblog.utils.CommonUtils;
import com.liuenci.vblog.constant.WebConst;
import com.liuenci.vblog.exception.TipException;
import com.liuenci.vblog.service.ILogService;
import com.liuenci.vblog.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户后台登录/登出
 * @author liuenci
 */
@Controller
@RequestMapping("/admin")
@Transactional(rollbackFor = TipException.class)
@Slf4j
public class AuthController extends BaseController {


    @Resource
    private IUserService usersService;

    @Resource
    private ILogService logService;

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping(value = "/login")
    public String login() {
        return "admin/login";
    }

    /**
     * 管理后台登录
     * @param username 用户名
     * @param password 密码
     * @param remeberMe 记住我
     * @param request 请求
     * @param response 响应
     * @return
     */
    @PostMapping(value = "login")
    @ResponseBody
    public RestResponseBo doLogin(@RequestParam String username,
                                  @RequestParam String password,
                                  @RequestParam(required = false) String remeberMe,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        // 登录失败的次数
        Integer errorCount = cache.get("login_error_count");
        try {
            UserVo user = usersService.login(username, password);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            if (StringUtils.isNotBlank(remeberMe)) {
                CommonUtils.setCookie(response, user.getUid());
            }
            logService.insertLog(LogActions.LOGIN.getAction(), null, request.getRemoteAddr(), user.getUid());
        } catch (Exception e) {
            errorCount = null == errorCount ? 1 : errorCount + 1;
            if (errorCount > 3) {
                return RestResponseBo.fail("您输入密码已经错误超过3次，请10分钟后尝试");
            }
            cache.set("login_error_count", errorCount, 10 * 60);
            String msg = "登录失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                log.error(msg, e);
            }
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

    /**
     * 注销
     * @param session
     * @param response
     */
    @RequestMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response) {
        session.removeAttribute(WebConst.LOGIN_SESSION_KEY);
        Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        try {
            response.sendRedirect("login");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("注销失败", e);
        }
    }
}
