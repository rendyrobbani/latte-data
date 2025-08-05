package com.rendyrobbani.latte.data.module;

import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.latte.core.data.domain.Writable;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractWritableEntity extends AbstractReadableEntity implements Writable {

	@Override
	public void update(NIP updatedBy) {
		this.updatedAt = LocalDateTime.now();
		this.updatedBy = updatedBy;
	}

	@Override
	public void delete(NIP deletedBy) {
		this.isDeleted = true;
		this.deletedAt = LocalDateTime.now();
		this.deletedBy = deletedBy;
	}

	@Override
	public void restore(NIP restoredBy) {
		this.isDeleted = false;
		this.deletedAt = null;
		this.deletedBy = null;
		this.updatedAt = LocalDateTime.now();
		this.updatedBy = restoredBy;
	}

	protected AbstractWritableEntity(NIP createdBy) {
		super(createdBy);
	}

}