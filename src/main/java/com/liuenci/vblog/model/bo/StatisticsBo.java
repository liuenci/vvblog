package com.liuenci.vblog.model.bo;

import lombok.*;

import java.io.Serializable;

/**
 * 后台统计对象
 * @author liuenci
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatisticsBo implements Serializable {

    private Long articles;
    private Long comments;
    private Long links;
    private Long attachs;
}
