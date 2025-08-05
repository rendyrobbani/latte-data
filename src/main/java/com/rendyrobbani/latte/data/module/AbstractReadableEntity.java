package com.rendyrobbani.latte.data.module;

import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.latte.core.data.domain.Readable;
import com.rendyrobbani.latte.data.converter.NIPConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractReadableEntity extends AbstractEntity implements Readable {

	@Column(name = "created_at")
	protected LocalDateTime createdAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "created_by")
	protected NIP createdBy;

	@Column(name = "updated_at")
	protected LocalDateTime updatedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "updated_by")
	protected NIP updatedBy;

	@Column(name = "isDeleted")
	protected boolean isDeleted;

	@Column(name = "deleted_at")
	protected LocalDateTime deletedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "deleted_by")
	protected NIP deletedBy;

	protected AbstractReadableEntity(NIP createdBy) {
		this.createdAt = LocalDateTime.now();
		this.createdBy = createdBy;
		this.updatedAt = null;
		this.updatedBy = null;
		this.isDeleted = false;
		this.deletedAt = null;
		this.deletedBy = null;
	}

}