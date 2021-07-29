/**
 *
 */
package com.mcawful.canyoupet.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * The DOA representing the {@code Animal} entity.
 *
 * @author Michael McAuliffe
 *
 */
@Builder
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Animal {

	/**
	 * The ID of the {@code Animal} entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_seq")
	@SequenceGenerator(name = "animal_seq", allocationSize = 1)
	@Column(name = "id")
	private int animalId;

	/**
	 * The name of the {@code Animal}.
	 */
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "fk_animal_name", nullable = false)
	private AnimalName name;

	/**
	 * The {@link List} of {@link Action} objects that can be performed on the
	 * {@code Animal}.
	 */
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_animal", nullable = false)
	private List<Action> actions;

	/**
	 * Gets the name of the {@code Animal}.
	 *
	 * @return {@link String} the animal's name
	 */
	public String getName() {

		return this.name.getName();
	}
}
