/**
 *
 */
package com.mcawful.canyoupet.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * The DOA that represents the {@code Source} entity.
 *
 * @author Michael McAuliffe
 *
 */
@Builder
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Source {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "source_seq")
	@SequenceGenerator(name = "source_seq", allocationSize = 1)
	@Column(name = "id")
	private int sourceId;

	@Column(nullable = false, unique = true)
	private String url;
}
