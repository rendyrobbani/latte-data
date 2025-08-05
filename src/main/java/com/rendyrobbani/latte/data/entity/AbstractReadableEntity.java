package com.rendyrobbani.latte.data.entity;

import com.rendyrobbani.latte.core.data.domain.Readable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AbstractReadableEntity<DataUserEntity> extends AbstractEntity implements Readable<DataUserEntity> {

	@Column(name = "created_at")
	protected LocalDateTime createdAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", referencedColumnName = "id")
	protected DataUserEntity createdBy;

	@Column(name = "updated_at")
	protected LocalDateTime updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by", referencedColumnName = "id")
	protected DataUserEntity updatedBy;

	@Column(name = "isDeleted")
	protected boolean isDeleted;

	@Column(name = "deleted_at")
	protected LocalDateTime deletedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deleted_by", referencedColumnName = "id")
	protected DataUserEntity deletedBy;

	protected AbstractReadableEntity(DataUserEntity createdBy) {
		this.createdAt = LocalDateTime.now();
		this.createdBy = createdBy;
		this.updatedAt = null;
		this.updatedBy = null;
		this.isDeleted = false;
		this.deletedAt = null;
		this.deletedBy = null;
	}

}