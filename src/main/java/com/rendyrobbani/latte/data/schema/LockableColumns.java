package com.rendyrobbani.latte.data.schema;

import com.rendyrobbani.espresso.database.Column;
import com.rendyrobbani.espresso.database.factory.ColumnFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LockableColumns {

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

}