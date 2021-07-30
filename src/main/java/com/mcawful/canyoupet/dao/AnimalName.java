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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The DOA representing the {@code AnimalName} entity.
 *
 * @author Michael McAuliffe
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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
