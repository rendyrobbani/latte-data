package com.rendyrobbani.latte.data.entity.user;

import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.latte.data.module.user.AbstractLogsUserEntity;
import com.rendyrobbani.latte.data.schema.user.LogsUserTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = LogsUserTable.TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LogsUserEntity extends AbstractLogsUserEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private DataUserEntity subject;

	public LogsUserEntity(DataUserEntity subject, NIP loggedBy) {
		super(subject, loggedBy);
	}

}