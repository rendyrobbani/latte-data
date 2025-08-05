package com.rendyrobbani.latte.data.factory;

import com.rendyrobbani.espresso.database.Column;
import com.rendyrobbani.espresso.database.Constraint;
import com.rendyrobbani.espresso.database.Table;
import com.rendyrobbani.espresso.database.factory.ForeignKeyFactory;
import com.rendyrobbani.latte.data.schema.master.fungsi.DataMasterFungsiTable;
import com.rendyrobbani.latte.data.schema.master.fungsi.DataMasterSubfungsiTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LatteForeignKeyFactory {

	public static Constraint referenceDataMasterFungsiId(Integer index, Table table, Column column) {
		return ForeignKeyFactory.create(
				index,
				table,
				List.of(column),
				DataMasterFungsiTable.getTable(),
				List.of(DataMasterFungsiTable.getTable().getId())
		);
	}

	public static Constraint referenceDataMasterSubfungsiId(Integer index, Table table, Column column) {
		return ForeignKeyFactory.create(
				index,
				table,
				List.of(column),
				DataMasterSubfungsiTable.getTable(),
				List.of(DataMasterSubfungsiTable.getTable().getId())
		);
	}

	public static Constraint referenceDataMasterSubfungsiUnique(Integer index, Table table, List<Column> columns) {
		return ForeignKeyFactory.create(
				index,
				table,
				columns,
				DataMasterSubfungsiTable.getUniqueKey().getTable(),
				DataMasterSubfungsiTable.getUniqueKey().getTable().getColumns()
		);
	}

}