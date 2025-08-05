package com.rendyrobbani.latte.data.schema;

import com.rendyrobbani.espresso.database.Column;
import com.rendyrobbani.espresso.database.factory.ColumnFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReadableColumns {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createDateTime("created_at", true));
			columns.add(ColumnFactory.createChar("created_by", 18, true));
			columns.add(ColumnFactory.createDateTime("updated_at", true));
			columns.add(ColumnFactory.createChar("updated_by", 18, true));
			columns.add(ColumnFactory.createBoolean("is_deleted", false));
			columns.add(ColumnFactory.createDateTime("deleted_at", true));
			columns.add(ColumnFactory.createChar("deleted_by", 18, true));
		}
		return columns;
	}

}