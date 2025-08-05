package com.rendyrobbani.latte.data.schema.master.fungsi;

import com.rendyrobbani.espresso.database.Column;
import com.rendyrobbani.espresso.database.Table;
import com.rendyrobbani.espresso.database.factory.ColumnFactory;
import com.rendyrobbani.latte.data.factory.LatteTableFactory;
import com.rendyrobbani.latte.data.schema.master.DataMasterTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataMasterFungsiTable {

	public static final String TABLE_NAME = "data_master_fungsi";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createChar("id", 2, false, true));
			columns.add(ColumnFactory.createVarChar("name", false));
			columns.addAll(DataMasterTable.getColumns());
		}
		return columns;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = LatteTableFactory.create(TABLE_NAME, getColumns());
		return table;
	}

}