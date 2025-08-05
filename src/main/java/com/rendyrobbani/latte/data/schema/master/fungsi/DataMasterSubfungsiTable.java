package com.rendyrobbani.latte.data.schema.master.fungsi;

import com.rendyrobbani.espresso.database.Column;
import com.rendyrobbani.espresso.database.Constraint;
import com.rendyrobbani.espresso.database.Table;
import com.rendyrobbani.espresso.database.factory.ColumnFactory;
import com.rendyrobbani.espresso.database.factory.UniqueKeyFactory;
import com.rendyrobbani.latte.data.factory.LatteCheckFactory;
import com.rendyrobbani.latte.data.factory.LatteForeignKeyFactory;
import com.rendyrobbani.latte.data.factory.LatteTableFactory;
import com.rendyrobbani.latte.data.schema.common.LockableTable;
import com.rendyrobbani.latte.data.schema.common.ReadableTable;
import com.rendyrobbani.latte.data.schema.master.DataMasterTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataMasterSubfungsiTable {

	public static final String TABLE_NAME = "data_master_subfungsi";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createChar("id", 5, false, true));
			columns.add(ColumnFactory.createChar("fungsi_id", 2, false));
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

	private static List<Constraint> checks;

	public static List<Constraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.add(LatteCheckFactory.columnIsSubfungsiCode(1, getTable(), getTable().getId()));
		}
		return checks;
	}

	private static List<Constraint> foreignKeys;

	public static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.add(LatteForeignKeyFactory.referenceDataMasterFungsiId(1, getTable(), getTable().findColumn("fungsi_id")));
			foreignKeys.addAll(LockableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.addAll(ReadableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
		}
		return foreignKeys;
	}

	private static Constraint uniqueKey;

	public static Constraint getUniqueKey() {
		if (uniqueKey == null) {
			uniqueKey = UniqueKeyFactory.create(1, getTable(), List.of(
					getTable().findColumn("fungsi_id"),
					getTable().findColumn("id")
			));
		}
		return uniqueKey;
	}

}