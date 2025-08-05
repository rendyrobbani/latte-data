package com.rendyrobbani.latte.data.schema;

import com.rendyrobbani.espresso.database.Constraint;
import com.rendyrobbani.latte.data.schema.master.fungsi.DataMasterFungsiTable;
import com.rendyrobbani.latte.data.schema.master.fungsi.DataMasterSubfungsiTable;
import com.rendyrobbani.latte.data.schema.user.DataUserTable;
import com.rendyrobbani.latte.data.schema.user.LogsUserTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LatteSchema {

	public static String getUserDDL() {
		var value = new ArrayList<String>();

		value.add(DataUserTable.getTable().getCreateDDL(true, true));
		value.add(String.join(System.lineSeparator(), DataUserTable.getChecks().stream().map(Constraint::getCreateDDL).toList()));
		value.add(String.join(System.lineSeparator(), DataUserTable.getForeignKeys().stream().map(Constraint::getCreateDDL).toList()));

		value.add(LogsUserTable.getTable().getCreateDDL(true, true));
		value.add(String.join(System.lineSeparator(), LogsUserTable.getChecks().stream().map(Constraint::getCreateDDL).toList()));
		value.add(String.join(System.lineSeparator(), LogsUserTable.getForeignKeys().stream().map(Constraint::getCreateDDL).toList()));

		return String.join(System.lineSeparator().repeat(2), value);
	}

	public static String getMasterDDL() {
		var value = new ArrayList<String>();

		value.add(DataMasterFungsiTable.getTable().getCreateDDL(true, true));
		value.add(String.join(System.lineSeparator(), DataMasterFungsiTable.getChecks().stream().map(Constraint::getCreateDDL).toList()));
		value.add(String.join(System.lineSeparator(), DataMasterFungsiTable.getForeignKeys().stream().map(Constraint::getCreateDDL).toList()));

		value.add(DataMasterSubfungsiTable.getTable().getCreateDDL(true, true));
		value.add(String.join(System.lineSeparator(), DataMasterSubfungsiTable.getChecks().stream().map(Constraint::getCreateDDL).toList()));
		value.add(String.join(System.lineSeparator(), DataMasterSubfungsiTable.getForeignKeys().stream().map(Constraint::getCreateDDL).toList()));

		return String.join(System.lineSeparator().repeat(2), value);
	}

}