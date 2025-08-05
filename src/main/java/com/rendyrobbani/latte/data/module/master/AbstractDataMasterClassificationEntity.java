package com.rendyrobbani.latte.data.module.master;

import com.rendyrobbani.latte.core.data.domain.master.DataMasterClassification;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractDataMasterClassificationEntity extends AbstractDataMasterEntity<String> implements DataMasterClassification {

}