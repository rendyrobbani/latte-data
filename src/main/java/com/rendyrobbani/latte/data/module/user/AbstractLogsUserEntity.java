package com.rendyrobbani.latte.data.module.user;

import com.rendyrobbani.espresso.identify.Gender;
import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.espresso.identify.PangkatASN;
import com.rendyrobbani.latte.data.converter.GenderConverter;
import com.rendyrobbani.latte.data.converter.NIPConverter;
import com.rendyrobbani.latte.data.converter.PangkatASNConverter;
import com.rendyrobbani.latte.data.module.AbstractLoggableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractLogsUserEntity extends AbstractLoggableEntity<AbstractDataUserEntity> {

	@Convert(converter = PangkatASNConverter.class)
	@Column(name = "pangkat")
	protected PangkatASN pangkat;

	@Column(name = "name")
	protected String name;

	@Column(name = "title_prefix")
	protected String titlePrefix;

	@Column(name = "title_suffix")
	protected String titleSuffix;

	@Column(name = "password")
	protected String password;

	@Column(name = "birth_date")
	protected LocalDate birthDate;

	@Column(name = "start_date")
	protected LocalDate startDate;

	@Convert(converter = GenderConverter.class)
	@Column(name = "gender")
	protected Gender gender;

	@Column(name = "number")
	protected Integer number;

	@Column(name = "is_pns")
	protected boolean isPNS;

	@Column(name = "is_p3k")
	protected boolean isP3K;

	@Column(name = "isLocked")
	protected boolean isLocked;

	@Column(name = "locked_at")
	protected LocalDateTime lockedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "locked_by")
	protected NIP lockedBy;

	protected AbstractLogsUserEntity(AbstractDataUserEntity subject, NIP loggedBy) {
		super(loggedBy);
		this.pangkat = subject.getPangkat();
		this.name = subject.getName();
		this.titlePrefix = subject.getTitlePrefix();
		this.titleSuffix = subject.getTitleSuffix();
		this.password = subject.getPassword();
		this.birthDate = subject.getBirthDate();
		this.startDate = subject.getStartDate();
		this.gender = subject.getGender();
		this.number = subject.getNumber();
		this.isPNS = subject.isPNS();
		this.isP3K = subject.isP3K();
		this.isLocked = subject.isLocked();
		this.lockedAt = subject.getLockedAt();
		this.lockedBy = subject.getLockedBy();
		this.isLocked = subject.isLocked();
		this.lockedAt = subject.getLockedAt();
		this.lockedBy = subject.getLockedBy();
		this.createdAt = subject.getCreatedAt();
		this.createdBy = subject.getCreatedBy();
		this.updatedAt = subject.getUpdatedAt();
		this.updatedBy = subject.getUpdatedBy();
		this.isDeleted = subject.isDeleted();
		this.deletedAt = subject.getDeletedAt();
		this.deletedBy = subject.getDeletedBy();
	}

}