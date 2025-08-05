package com.rendyrobbani.latte.data.module;

import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.latte.core.data.domain.Lockable;
import com.rendyrobbani.latte.data.converter.NIPConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractLockableEntity extends AbstractWritableEntity implements Lockable {

	@Column(name = "isLocked")
	protected boolean isLocked;

	@Column(name = "locked_at")
	protected LocalDateTime lockedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "locked_by")
	protected NIP lockedBy;

	protected AbstractLockableEntity(NIP createdBy) {
		super(createdBy);
		this.isLocked = false;
		this.lockedAt = null;
		this.lockedBy = null;
	}

	@Override
	public void lock(NIP lockedBy) {
		this.isLocked = true;
		this.lockedAt = LocalDateTime.now();
		this.lockedBy = lockedBy;
	}

	@Override
	public void unlock(NIP unlockedBy) {
		this.isLocked = false;
		this.lockedAt = null;
		this.lockedBy = null;
		this.updatedAt = LocalDateTime.now();
		this.updatedBy = unlockedBy;
	}

}