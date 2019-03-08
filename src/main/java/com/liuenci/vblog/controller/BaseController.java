package com.liuenci.vblog.controller;

import com.liuenci.vblog.model.vo.UserVo;
import com.liuenci.vblog.utils.MapCache;
import com.liuenci.vblog.utils.CommonUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * @author liuenci
 */
public abstract class BaseController {

    public static String THEME = "themes/default";

    protected MapCache cache = MapCache.single();

    /**
     * 主页的页面主题
     * @param viewName
     * @return
     */
    public String render(String viewName) {
        return THEME + "/" + viewName;
    }

    public BaseController title(HttpServletRequest request, String title) {
        request.setAttribute("title", title);
        return this;
    }

    public BaseController keywords(HttpServletRequest request, String keywords) {
        request.setAttribute("keywords", keywords);
        return this;
    }

    /**
     * 获取请求绑定的登录对象
     * @param request
     * @return
     */
    public UserVo user(HttpServletRequest request) {
        return CommonUtils.getLoginUser(request);
    }

    /**
     * 获取请求绑定的登录对象的ID
     * @param request
     * @return
     */
    public Integer getUid(HttpServletRequest request){
        return this.user(request).getUid();
    }

    /**
     * 不存在的路径，路由到 404 页面
     * @return
     */
    public String render404() {
        return "comm/error_404";
    }

}
