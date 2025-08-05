package com.rendyrobbani.latte.data.entity;

import jakarta.persistence.MappedSuperclass;

import java.io.Serial;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

}