package com.rendyrobbani.latte.data.module;

import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractEntity implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

}