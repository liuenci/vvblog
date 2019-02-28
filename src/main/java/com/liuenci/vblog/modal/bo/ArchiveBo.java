package com.liuenci.vblog.modal.bo;

import com.liuenci.vblog.modal.vo.ContentVo;
import lombok.*;

import java.io.Serializable;
import java.util.List;


/**
 * @author liuenci
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArchiveBo implements Serializable {
    private String date;
    private String count;
    private List<ContentVo> articles;
}
