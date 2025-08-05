package com.rendyrobbani.latte.data.module.user;

import com.rendyrobbani.espresso.identify.Gender;
import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.espresso.identify.PangkatASN;
import com.rendyrobbani.latte.core.data.domain.user.DataUser;
import com.rendyrobbani.latte.data.converter.GenderConverter;
import com.rendyrobbani.latte.data.converter.NIPConverter;
import com.rendyrobbani.latte.data.converter.PangkatASNConverter;
import com.rendyrobbani.latte.data.module.AbstractLockableEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractDataUserEntity extends AbstractLockableEntity implements DataUser {

	@Id
	@Column(name = "id")
	protected String id;

	@Getter(AccessLevel.NONE)
	@Convert(converter = NIPConverter.class)
	@Column(name = "id", insertable = false, updatable = false)
	protected NIP nip;

	@Convert(converter = PangkatASNConverter.class)
	@Column(name = "pangkat")
	protected PangkatASN pangkat;

	@Setter
	@Column(name = "name")
	protected String name;

	@Setter
	@Column(name = "title_prefix")
	protected String titlePrefix;

	@Setter
	@Column(name = "title_suffix")
	protected String titleSuffix;

	@Setter
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

	@Override
	public NIP getNIP() {
		return this.nip;
	}

	public void setPangkat(PangkatASN pangkat) {
		this.pangkat = pangkat;
		this.isPNS = pangkat.isPNS();
		this.isP3K = pangkat.isP3K();
	}

	public void setStartDate(LocalDate startDate) {
		if (this.pangkat.isPNS()) return;
		this.startDate = startDate;
	}

	protected AbstractDataUserEntity(NIP nip, NIP createdBy) {
		super(createdBy);
		if (nip != null) {
			this.id = nip.getValue();
			this.nip = nip;
			this.birthDate = nip.getBirthDate();
			this.startDate = nip.getStartDate();
			this.gender = nip.getGender();
			this.number = nip.getNumber();
		}
	}

}