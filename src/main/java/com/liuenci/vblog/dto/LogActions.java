package com.liuenci.vblog.dto;

/**
 * 日志表的action字段
 * @author liuenci
 */
public enum LogActions {
    /**
     * 登录后台
     */
    LOGIN("登录后台"),
    /**
     * 修改密码
     */
    UP_PWD("修改密码"),
    /**
     * 修改个人信息
     */
    UP_INFO("修改个人信息"),
    /**
     * 删除文章
     */
    DEL_ARTICLE("删除文章"),
    /**
     * 删除页面
     */
    DEL_PAGE("删除页面"),
    /**
     * 系统备份
     */
    SYS_BACKUP("系统备份"),
    /**
     * 保存系统设置
     */
    SYS_SETTING("保存系统设置"),
    /**
     * 初始化站点
     */
    INIT_SITE("初始化站点");

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    LogActions(String action) {
        this.action = action;
    }
}
