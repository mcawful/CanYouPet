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
 * The DOA representing the {@code AnimalName} entity.
 *
 * @author Michael McAuliffe
 *
 */
@Builder
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class AnimalName {

	/**
	 * The ID of the {@code AnimalName} entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_name_seq")
	@SequenceGenerator(name = "animal_name_seq", allocationSize = 1)
	@Column(name = "id")
	private int animalNameId;

	/**
	 * The name of the animal.
	 */
	@Column(unique = true, nullable = false)
	private String name;
}
