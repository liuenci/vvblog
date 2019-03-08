package com.liuenci.vblog.dto;

/**
 * @author liuenci
 */

public enum Types {
    /**
     * tag
     */
    TAG("tag"),
    /**
     * category
     */
    CATEGORY("category"),
    /**
     * post
     */
    ARTICLE("post"),
    /**
     * publish
     */
    PUBLISH("publish"),
    /**
     * page
     */
    PAGE("page"),
    /**
     * draft
     */
    DRAFT("draft"),
    /**
     * link
     */
    LINK("link"),
    /**
     * image
     */
    IMAGE("image"),
    /**
     * file
     */
    FILE("file"),
    /**
     * csrf_token
     */
    CSRF_TOKEN("csrf_token"),
    /**
     * comments:frequency
     */
    COMMENTS_FREQUENCY("comments:frequency"),

    /**
     * 附件存放的URL，默认为网站地址，如集成第三方则为第三方CDN域名
     */
    ATTACH_URL("attach_url"),

    /**
     * 网站要过滤，禁止访问的ip列表
     */
    BLOCK_IPS("site_block_ips");


    private String type;

    public java.lang.String getType() {
        return type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    Types(java.lang.String type) {
        this.type = type;
    }
}
