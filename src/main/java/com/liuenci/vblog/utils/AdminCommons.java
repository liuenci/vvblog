package com.liuenci.vblog.utils;


import com.liuenci.vblog.model.vo.MetaVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 后台公共函数
 * <p>
 * @author liuenci
 */
@Component
public final class AdminCommons {

    /**
     * 判断category和cat的交集
     *
     * @param cats
     * @return
     */
    public static boolean existCat(MetaVo category, String cats) {
        String[] arr = StringUtils.split(cats, ",");
        if (null != arr && arr.length > 0) {
            for (String c : arr) {
                if (c.trim().equals(category.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final String[] COLORS = {"default", "primary", "success", "info", "warning", "danger", "inverse", "purple", "pink"};

    public static String randColor() {
        int r = Tools.rand(0, COLORS.length - 1);
        return COLORS[r];
    }

}
