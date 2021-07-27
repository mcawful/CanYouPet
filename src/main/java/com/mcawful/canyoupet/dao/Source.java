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

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * The DOA that represents the {@code Source} entity.
 *
 * @author Michael McAuliffe
 *
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Source {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "source_seq")
	@SequenceGenerator(name = "source_seq")
	@Column(name = "id")
	private int sourceId;

	@Column(nullable = false, unique = true)
	@NonNull
	private String url;
}
