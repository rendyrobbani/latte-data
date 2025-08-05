package com.rendyrobbani.latte.data.converter;

import com.rendyrobbani.espresso.identify.PangkatASN;
import com.rendyrobbani.espresso.identify.PangkatP3K;
import com.rendyrobbani.espresso.identify.PangkatPNS;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public final class PangkatASNConverter implements AttributeConverter<PangkatASN, String> {

	@Override
	public String convertToDatabaseColumn(PangkatASN pangkatASN) {
		if (pangkatASN == null) return null;
		return pangkatASN.getValue();
	}

	@Override
	public PangkatASN convertToEntityAttribute(String value) {
		PangkatASN pangkatASN = PangkatPNS.fromValue(value);
		if (pangkatASN != null) return pangkatASN;
		pangkatASN = PangkatP3K.fromValue(value);
		return pangkatASN;
	}

}