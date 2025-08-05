package com.rendyrobbani.latte.data.entity;

import com.rendyrobbani.latte.core.data.domain.Lockable;
import com.rendyrobbani.latte.core.data.domain.user.DataUser;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class AbstractLockableEntity<DataUserEntity, TargetEntity> extends AbstractWritableEntity<DataUserEntity, TargetEntity> implements Lockable<DataUserEntity, TargetEntity> {

	@Column(name = "isLocked")
	protected boolean isLocked;

	@Column(name = "locked_at")
	protected LocalDateTime lockedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locked_by", referencedColumnName = "id")
	protected DataUserEntity lockedBy;

	public AbstractLockableEntity(DataUserEntity createdBy) {
		super(createdBy);
		this.isLocked = false;
		this.lockedAt = null;
		this.lockedBy = null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public TargetEntity lock(DataUser user) {
		this.isLocked = true;
		this.lockedAt = LocalDateTime.now();
		this.lockedBy = user;
		return (TargetEntity) this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public TargetEntity unlock(DataUser user) {
		if (!(DataUserEntity instanceof DataUser)) throw new IllegalArgumentException("User must be a DataUser");
		this.isLocked = false;
		this.lockedAt = null;
		this.lockedBy = null;
		this.updatedAt = LocalDateTime.now();
		this.updatedBy = user;
		return (TargetEntity) this;
	}

}