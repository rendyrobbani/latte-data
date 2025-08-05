package com.rendyrobbani.latte.data.entity.master.fungsi;

import com.rendyrobbani.latte.data.module.master.fungsi.AbstractDataMasterFungsiEntity;
import com.rendyrobbani.latte.data.schema.master.fungsi.DataMasterFungsiTable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = DataMasterFungsiTable.TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DataMasterFungsiEntity extends AbstractDataMasterFungsiEntity {

}