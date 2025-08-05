package com.rendyrobbani.latte.data.module.master;

import com.rendyrobbani.latte.core.data.domain.master.DataMaster;
import com.rendyrobbani.latte.data.module.AbstractLockableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractDataMasterEntity<ID> extends AbstractLockableEntity implements DataMaster<ID> {

	@Column(name = "name")
	protected String name;

}