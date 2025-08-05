package com.rendyrobbani.latte.data.schema.user;

import com.rendyrobbani.espresso.database.Constraint;
import com.rendyrobbani.espresso.database.Table;
import com.rendyrobbani.espresso.database.factory.ForeignKeyFactory;
import com.rendyrobbani.latte.data.factory.LatteCheckFactory;
import com.rendyrobbani.latte.data.factory.LatteTableFactory;
import com.rendyrobbani.latte.data.schema.common.LockableTable;
import com.rendyrobbani.latte.data.schema.common.LoggableTable;
import com.rendyrobbani.latte.data.schema.common.ReadableTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogsUserTable {

	public static final String TABLE_NAME = "logs_user";

	public static final Table SUBJECT_TABLE = DataUserTable.getTable();

	private static Table table;

	public static Table getTable() {
		if (table == null) table = LatteTableFactory.createLog(TABLE_NAME, SUBJECT_TABLE);
		return table;
	}

	private static List<Constraint> checks;

	public static List<Constraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.add(LatteCheckFactory.columnIsPangkatASN(1, getTable(), getTable().findColumn("pangkat")));
			checks.add(LatteCheckFactory.columnIsGender(checks.size() + 1, getTable(), getTable().findColumn("gender")));
			checks.add(LatteCheckFactory.columnBetween(checks.size() + 1, getTable(), getTable().findColumn("number"), 1, 999));
		}
		return checks;
	}

	private static List<Constraint> foreignKeys;

	public static List<Constraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.add(ForeignKeyFactory.create(1, getTable(), List.of(getTable().findColumn("subject_id")), SUBJECT_TABLE, List.of(SUBJECT_TABLE.getId())));
			foreignKeys.addAll(LockableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.addAll(ReadableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
			foreignKeys.addAll(LoggableTable.getForeignKeys(foreignKeys.size() + 1, getTable()));
		}
		return foreignKeys;
	}

}