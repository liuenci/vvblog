package com.liuenci.vblog.model.bo;

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
public class BackResponseBo implements Serializable {
    private String attachPath;
    private String themePath;
    private String sqlPath;
}
