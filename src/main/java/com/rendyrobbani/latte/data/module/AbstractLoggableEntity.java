package com.rendyrobbani.latte.data.module;

import com.rendyrobbani.espresso.identify.NIP;
import com.rendyrobbani.latte.core.data.domain.Loggable;
import com.rendyrobbani.latte.data.converter.NIPConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractLoggableEntity<Subject extends AbstractReadableEntity> extends AbstractReadableEntity implements Loggable<Subject> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;

	@Column(name = "logged_at")
	protected LocalDateTime loggedAt;

	@Convert(converter = NIPConverter.class)
	@Column(name = "logged_by")
	protected NIP loggedBy;

	protected AbstractLoggableEntity(NIP loggedBy) {
		this.loggedAt = LocalDateTime.now();
		this.loggedBy = loggedBy;
	}

}