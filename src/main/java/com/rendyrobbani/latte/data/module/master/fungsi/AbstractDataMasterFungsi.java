package com.rendyrobbani.latte.data.module.master.fungsi;

import com.rendyrobbani.espresso.classification.fungsi.FungsiClassificationFactory;
import com.rendyrobbani.latte.core.data.domain.master.fungsi.DataMasterFungsi;
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
public abstract class AbstractDataMasterFungsi extends AbstractDataMasterClassificationEntity implements DataMasterFungsi {

	@Id
	@Column(name = "id")
	protected String id;

	protected AbstractDataMasterFungsi(String code) {
		var classification = FungsiClassificationFactory.classify(code);
		this.id = classification.getFungsiCode();
	}

}