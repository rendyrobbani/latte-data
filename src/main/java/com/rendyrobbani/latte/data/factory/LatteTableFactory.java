package com.rendyrobbani.latte.data.factory;

import com.rendyrobbani.espresso.database.Column;
import com.rendyrobbani.espresso.database.Table;
import com.rendyrobbani.espresso.database.factory.ColumnFactory;
import com.rendyrobbani.espresso.database.factory.TableFactory;
import com.rendyrobbani.latte.data.schema.common.LoggableTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LatteTableFactory {

	public static Table create(String name, List<Column> columns) {
		return TableFactory.create(name, columns);
	}

	public static Table createLog(String name, Table subject) {
		var columns = new ArrayList<Column>();
		columns.add(ColumnFactory.createBigInt("id", false, true, true));
		for (var column : subject.getColumns()) {
			if (column.isPrimaryKey()) columns.add(ColumnFactory.copyOf("subject_id", column, false));
			else columns.add(column);
		}
		columns.addAll(LoggableTable.getColumns());
		return create(name, columns);
	}

}