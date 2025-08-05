package com.rendyrobbani.latte.data.schema.user;

import com.rendyrobbani.espresso.database.Column;
import com.rendyrobbani.espresso.database.Constraint;
import com.rendyrobbani.espresso.database.Table;
import com.rendyrobbani.espresso.database.factory.CheckFactory;
import com.rendyrobbani.espresso.database.factory.ColumnFactory;
import com.rendyrobbani.espresso.database.factory.TableFactory;
import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.espresso.identify.PangkatP3K;
import com.rendyrobbani.espresso.identify.PangkatPNS;
import com.rendyrobbani.latte.data.schema.LockableColumns;
import com.rendyrobbani.latte.data.schema.ReadableColumns;
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
			columns.add(ColumnFactory.createVarChar("titlePrefix", true));
			columns.add(ColumnFactory.createVarChar("titleSuffix", true));
			columns.add(ColumnFactory.createVarChar("password", false));
			columns.add(ColumnFactory.createDateOnly("birth_date", false));
			columns.add(ColumnFactory.createDateOnly("start_date", true));
			columns.add(ColumnFactory.createTinyInt("gender", false));
			columns.add(ColumnFactory.createTinyInt("number", false));
			columns.add(ColumnFactory.createBoolean("is_pns", false));
			columns.add(ColumnFactory.createBoolean("is_p3k", false));
			columns.addAll(LockableColumns.getColumns());
			columns.addAll(ReadableColumns.getColumns());
		}
		return columns;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.create(TABLE_NAME, getColumns());
		return table;
	}

	private static List<Constraint> checks;

	@SuppressWarnings("ConstantValue")
	public static List<Constraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.add(CheckFactory.create(checks.size() + 1, getTable(), getTable().getId().getName() + " regexp '" + NIP.REGEX + "'"));
			checks.add(CheckFactory.create(checks.size() + 1, getTable(), getTable().findColumn("pangkat") + " regexp '" + PangkatPNS.REGEX + "|" + PangkatP3K.REGEX + "'"));
		}
		return checks;
	}

}