package com.liuenci.vblog.utils.backup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author liuenci
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Column {
	private String name;
	private String typeName;
	private int dataType;
}
