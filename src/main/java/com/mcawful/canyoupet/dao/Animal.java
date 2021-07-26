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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * The DOA representing the {@code Animal} entity.
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
	 * The ID of the {@code Animal} entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_seq")
	@SequenceGenerator(name = "animal_seq")
	@Column(name = "id")
	private int animalId;

	/**
	 * The name of the {@code Animal}.
	 */
	@Column(nullable = false)
	@NonNull
	private String name;

	/**
	 * The {@link List} of {@link Action} objects that can be performed on the
	 * {@code Animal}.
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "actions_id", nullable = false)
	@NonNull
	private List<Action> actions;

}
