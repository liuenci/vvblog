package com.liuenci.vblog.model.vo;

import lombok.*;

import java.io.Serializable;


/**
 * @author liuenci
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttachVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String fname;

    private String ftype;

    private String fkey;

    private Integer authorId;

    private Integer created;
}