package com.rendyrobbani.latte.data.converter;

import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.espresso.identify.factory.NIPFactory;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public final class NIPConverter implements AttributeConverter<NIP, String> {

	@Override
	public String convertToDatabaseColumn(NIP nip) {
		if (nip == null) return null;
		return nip.getValue();
	}

	@Override
	public NIP convertToEntityAttribute(String value) {
		if (value == null) return null;
		return NIPFactory.create(value);
	}

}