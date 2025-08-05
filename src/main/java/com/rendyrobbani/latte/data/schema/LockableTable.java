package com.rendyrobbani.latte.data.schema;

import com.rendyrobbani.espresso.database.Column;
import com.rendyrobbani.espresso.database.Constraint;
import com.rendyrobbani.espresso.database.Table;
import com.rendyrobbani.espresso.database.factory.ColumnFactory;
import com.rendyrobbani.espresso.database.factory.ForeignKeyFactory;
import com.rendyrobbani.latte.data.schema.user.DataUserTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LockableTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createBoolean("is_locked", false));
			columns.add(ColumnFactory.createDateTime("locked_at", true));
			columns.add(ColumnFactory.createChar("locked_by", 18, true));
		}
		return columns;
	}

	public static List<Constraint> getForeignKeys(Integer index, Table table) {
		var foreignKeys = new ArrayList<Constraint>();
		foreignKeys.add(ForeignKeyFactory.create(
				index,
				table,
				List.of(table.findColumn("locked_by")),
				DataUserTable.getTable(),
				List.of(DataUserTable.getTable().getId())
		));
		return foreignKeys;
	}

}