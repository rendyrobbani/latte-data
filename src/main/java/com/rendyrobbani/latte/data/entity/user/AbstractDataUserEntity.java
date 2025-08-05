package com.rendyrobbani.latte.data.entity.user;

import com.rendyrobbani.espresso.identify.Gender;
import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.espresso.identify.PangkatASN;
import com.rendyrobbani.latte.core.data.domain.user.DataUser;
import com.rendyrobbani.latte.data.converter.NIPConverter;
import com.rendyrobbani.latte.data.converter.PangkatASNConverter;
import com.rendyrobbani.latte.data.entity.AbstractLockableEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@MappedSuperclass
@SuppressWarnings("DefaultAnnotationParam")
public abstract class AbstractDataUserEntity<DataUserEntity, TargetEntity> extends AbstractLockableEntity<DataUserEntity, TargetEntity> implements DataUser {

	@Id
	@Column(name = "id", nullable = false, length = 18)
	protected String id;

	@Getter(AccessLevel.NONE)
	@Convert(converter = NIPConverter.class)
	@Column(name = "id", insertable = false, updatable = false)
	protected NIP nip;

	@Convert(converter = PangkatASNConverter.class)
	@Column(name = "pangkat", nullable = false)
	protected PangkatASN pangkat;

	@Setter
	@Column(name = "name", nullable = false, length = 255)
	protected String name;

	@Setter
	@Column(name = "title_prefix", nullable = true, length = 255)
	protected String titlePrefix;

	@Setter
	@Column(name = "title_suffix", nullable = true, length = 255)
	protected String titleSuffix;

	@Setter
	@Column(name = "password", nullable = false, length = 255)
	protected String password;

	@Column(name = "birth_date", nullable = false)
	protected LocalDate birthDate;

	@Column(name = "start_date", nullable = true)
	protected LocalDate startDate;

	@Column(name = "gender", nullable = false)
	protected Gender gender;

	@Column(name = "number", nullable = false)
	protected Integer number;

	@Column(name = "is_pns", nullable = false)
	protected boolean isPNS;

	@Column(name = "is_p3k", nullable = false)
	protected boolean isP3K;

	@Override
	public NIP getNIP() {
		return this.nip;
	}

	public void setPangkat(PangkatASN pangkat) {
		if (pangkat == null) throw new IllegalArgumentException("Pangkat cannot be null");
		this.pangkat = pangkat;
		this.isPNS = pangkat.isPNS();
		this.isP3K = pangkat.isP3K();
	}

	public void setStartDate(LocalDate startDate) {
		if (this.pangkat == null) throw new IllegalStateException("Pangkat must be set before");
		if (this.pangkat.isPNS()) throw new IllegalStateException("PNS cannot change start date");
		this.startDate = startDate;
	}

	public AbstractDataUserEntity(NIP nip, DataUserEntity createdBy) {
		super(createdBy);

		if (nip == null) throw new IllegalArgumentException("NIP cannot be null");
		this.id = nip.getValue();
		this.nip = nip;
		this.birthDate = nip.getBirthDate();
		this.startDate = nip.getStartDate();
		this.gender = nip.getGender();
		this.number = nip.getNumber();
	}

}