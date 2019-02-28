package com.liuenci.vblog.modal.vo;

import lombok.*;

import java.io.Serializable;

/**
 * @author 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OptionVo implements Serializable {
    /**
     * 配置名称
     */
    private String name;

    /**
     * 配置值
     */
    private String value;

    private String description;

    private static final long serialVersionUID = 1L;


}