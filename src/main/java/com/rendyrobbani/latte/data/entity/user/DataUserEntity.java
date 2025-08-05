package com.rendyrobbani.latte.data.entity.user;

import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.latte.data.module.user.AbstractDataUserEntity;
import com.rendyrobbani.latte.data.schema.user.DataUserTable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = DataUserTable.TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataUserEntity extends AbstractDataUserEntity {

	public DataUserEntity(NIP nip, NIP createdBy) {
		super(nip, createdBy);
	}

}