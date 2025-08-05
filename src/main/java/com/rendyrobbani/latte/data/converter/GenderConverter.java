package com.rendyrobbani.latte.data.converter;

import com.rendyrobbani.espresso.identify.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public final class GenderConverter implements AttributeConverter<Gender, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Gender gender) {
		if (gender == null) return null;
		return gender.getValue();
	}

	@Override
	public Gender convertToEntityAttribute(Integer value) {
		if (value == null) return null;
		return Gender.fromValue(value);
	}

}