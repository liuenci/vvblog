package com.liuenci.vblog.utils.backup.db;

import lombok.*;

/**
 * @author liuenci
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Column {
	private String catalogName;
	private String schemaName;
	private String tableName;
	private String name;
	private String label;
	private int type;
	private String typeName;
	private String columnClassName;
	private int displaySize;
	private int precision;
	private int scale;
}
