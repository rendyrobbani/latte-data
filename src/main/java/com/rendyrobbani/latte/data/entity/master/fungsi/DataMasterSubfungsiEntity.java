package com.rendyrobbani.latte.data.entity.master.fungsi;

import com.rendyrobbani.latte.data.module.master.fungsi.AbstractDataMasterSubfungsiEntity;
import com.rendyrobbani.latte.data.schema.master.fungsi.DataMasterSubfungsiTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = DataMasterSubfungsiTable.TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataMasterSubfungsiEntity extends AbstractDataMasterSubfungsiEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fungsi_id", insertable = false, updatable = false)
	private DataMasterFungsiEntity fungsi;

}