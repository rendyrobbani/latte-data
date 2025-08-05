package com.rendyrobbani.latte.data.schema.user;

import com.rendyrobbani.espresso.database.Column;
import com.rendyrobbani.espresso.database.Constraint;
import com.rendyrobbani.espresso.database.Table;
import com.rendyrobbani.espresso.database.factory.ColumnFactory;
import com.rendyrobbani.latte.data.factory.LatteCheckFactory;
import com.rendyrobbani.latte.data.factory.LatteTableFactory;
import com.rendyrobbani.latte.data.schema.LockableTable;
import com.rendyrobbani.latte.data.schema.ReadableTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataUserTable {

	public static final String TABLE_NAME = "data_user";

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createChar("id", 18, false, true));
			columns.add(ColumnFactory.createChar("pangkat", 2, false));
			columns.add(ColumnFactory.createVarChar("name", false));
			columns.add(ColumnFactory.createVarChar("title_prefix", true));
			columns.add(ColumnFactory.createVarChar("title_suffix", true));
			columns.add(ColumnFactory.createVarChar("password", false));
			columns.add(ColumnFactory.createDateOnly("birth_date", false));
			columns.add(ColumnFactory.createDateOnly("start_date", true));
			columns.add(ColumnFactory.createTinyInt("gender", false));
			columns.add(ColumnFactory.createSmallInt("number", false));
			columns.add(ColumnFactory.createBoolean("is_pns", false));
			columns.add(ColumnFactory.createBoolean("is_p3k", false));
			columns.addAll(LockableTable.getColumns());
			columns.addAll(ReadableTable.getColumns());
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
			checks.add(LatteCheckFactory.columnIsNIP(1, getTable(), getTable().getId()));
			checks.add(LatteCheckFactory.columnIsPangkatASN(checks.size() + 1, getTable(), getTable().findColumn("pangkat")));
			checks.add(LatteCheckFactory.columnIsGender(checks.size() + 1, getTable(), getTable().findColumn("gender")));
			checks.add(LatteCheckFactory.columnBetween(checks.size() + 1, getTable(), getTable().findColumn("number"), 1, 999));
		}
		return checks;
	}

	private static List<Constraint> foreignKeys;

	public static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(LockableTable.getForeignKeys(1, getTable()));
			foreignKeys.addAll(ReadableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
		}
		return foreignKeys;
	}

}