package com.rendyrobbani.latte.data.schema.master;

import com.rendyrobbani.espresso.database.Column;
import com.rendyrobbani.latte.data.schema.common.LockableTable;
import com.rendyrobbani.latte.data.schema.common.ReadableTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataMasterTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.addAll(LockableTable.getColumns());
			columns.addAll(ReadableTable.getColumns());
		}
		return columns;
	}

}