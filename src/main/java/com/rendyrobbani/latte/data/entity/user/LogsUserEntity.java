package com.rendyrobbani.latte.data.entity.user;

import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.latte.data.module.user.AbstractLogsUserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LogsUserEntity extends AbstractLogsUserEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private DataUserEntity subject;

	public LogsUserEntity(DataUserEntity subject, NIP loggedBy) {
		super(subject, loggedBy);
	}

}