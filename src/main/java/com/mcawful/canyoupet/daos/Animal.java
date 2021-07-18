/**
 *
 */
package com.mcawful.canyoupet.daos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * The DOA entity that represents the Animal object.
 *
 * @author Michael McAuliffe
 *
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Animal {

	/**
	 * The ID of the {@link Animal} object.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_seq")
	@SequenceGenerator(name = "animal_seq")
	@Column(name = "id")
	private int animalId;

	/**
	 * The {@link String} name of the {@link Animal} object.
	 */
	@Column(nullable = false)
	@NonNull
	private String name;

	/**
	 * The {@link List} of {@link Action} objects in the {@link Animal} object.
	 */
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "action_id", nullable = false)
	@NonNull
	private List<Action> actions;

}
