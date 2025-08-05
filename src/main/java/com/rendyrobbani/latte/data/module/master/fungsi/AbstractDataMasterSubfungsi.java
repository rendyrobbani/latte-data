package com.rendyrobbani.latte.data.module.master.fungsi;

import com.rendyrobbani.espresso.classification.fungsi.SubfungsiClassificationFactory;
import com.rendyrobbani.latte.core.data.domain.master.fungsi.DataMasterSubfungsi;
import com.rendyrobbani.latte.data.module.master.AbstractDataMasterClassificationEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractDataMasterSubfungsi extends AbstractDataMasterClassificationEntity implements DataMasterSubfungsi {

	@Column(name = "fungsi_id")
	protected String fungsiId;

	@Id
	@Column(name = "id")
	protected String id;

	protected AbstractDataMasterSubfungsi(String code) {
		var classification = SubfungsiClassificationFactory.classify(code);
		this.fungsiId = classification.getFungsiCode();
		this.id = classification.getSubfungsiCode();
	}

}