package com.rendyrobbani.latte.data.factory;

import com.rendyrobbani.espresso.classification.fungsi.FungsiClassification;
import com.rendyrobbani.espresso.classification.fungsi.SubfungsiClassification;
import com.rendyrobbani.espresso.database.Check;
import com.rendyrobbani.espresso.database.Column;
import com.rendyrobbani.espresso.database.Table;
import com.rendyrobbani.espresso.database.factory.CheckFactory;
import com.rendyrobbani.espresso.identify.Gender;
import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.espresso.identify.PangkatP3K;
import com.rendyrobbani.espresso.identify.PangkatPNS;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LatteCheckFactory {

	public static Check create(Integer index, Table table, String logic) {
		return CheckFactory.create(index, table, logic);
	}

	public static Check columnRegex(Integer index, Table table, Column column, String regex) {
		var logic = column.getName() + " regexp '" + regex + "'";
		return create(index, table, logic);
	}

	public static Check columnIn(Integer index, Table table, Column column, String[] values) {
		var inValues = String.join(", ", Stream.of(values).map(value -> "'" + value + "'").toArray(String[]::new));
		var logic = column.getName() + " in (" + inValues + ")";
		return create(index, table, logic);
	}

	public static Check columnIn(Integer index, Table table, Column column, Integer[] values) {
		var inValues = String.join(", ", Stream.of(values).map(String::valueOf).toArray(String[]::new));
		var logic = column.getName() + " in (" + inValues + ")";
		return create(index, table, logic);
	}

	public static Check columnBetween(Integer index, Table table, Column column, Integer min, Integer max) {
		var logic = column.getName() + " between " + min + " and " + max;
		return create(index, table, logic);
	}

	public static Check columnIsNIP(Integer index, Table table, Column column) {
		return columnRegex(index, table, column, NIP.REGEX);
	}

	public static Check columnIsPangkatASN(Integer index, Table table, Column column) {
		return columnRegex(index, table, column, PangkatPNS.REGEX + "|" + PangkatP3K.REGEX);
	}

	public static Check columnIsGender(Integer index, Table table, Column column) {
		return columnIn(index, table, column, Arrays.stream(Gender.values()).map(Gender::getValue).toArray(Integer[]::new));
	}

	public static Check columnIsFungsiCode(Integer index, Table table, Column column) {
		return columnRegex(index, table, column, FungsiClassification.FUNGSI_REGEX_GROUP);
	}

	public static Check columnIsSubfungsiCode(Integer index, Table table, Column column) {
		return columnRegex(index, table, column, SubfungsiClassification.SUBFUNGSI_REGEX_GROUP);
	}

}