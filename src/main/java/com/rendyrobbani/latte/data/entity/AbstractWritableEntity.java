package com.rendyrobbani.latte.data.entity;

import com.rendyrobbani.latte.core.data.domain.Writable;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractWritableEntity<DataUserEntity, TargetEntity> extends AbstractReadableEntity<DataUserEntity> implements Writable<DataUserEntity, TargetEntity> {

	@Override
	@SuppressWarnings("unchecked")
	public TargetEntity update(DataUserEntity user) {
		this.updatedAt = LocalDateTime.now();
		this.updatedBy = user;
		return (TargetEntity) this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public TargetEntity delete(DataUserEntity user) {
		this.isDeleted = true;
		this.deletedAt = LocalDateTime.now();
		this.deletedBy = user;
		return (TargetEntity) this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public TargetEntity restore(DataUserEntity user) {
		this.isDeleted = false;
		this.deletedAt = null;
		this.deletedBy = null;
		this.updatedAt = LocalDateTime.now();
		this.updatedBy = user;
		return (TargetEntity) this;
	}

	public AbstractWritableEntity(DataUserEntity createdBy) {
		super(createdBy);
	}

}