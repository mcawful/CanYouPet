/**
 *
 */
package com.mcawful.canyoupet.daos;

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
 * The DAO representing the {@code Game} entity.
 *
 * @author Michael McAuliffe
 *
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Game {

	/**
	 * The ID of the {@code Game} entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
	@SequenceGenerator(name = "game_seq")
	@Column(name = "id")
	private int gameId;

	/**
	 * The URI path of the {@code Game} endpoint.
	 */
	@Column(nullable = false, unique = true)
	@NonNull
	private String titleURI;

	/**
	 * The title of the {@code Game}.
	 */
	@Column(nullable = false, unique = true)
	@NonNull
	private String title;

	/**
	 * The {@link List} of {@link Animal} objects the {@code Game} contains.
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "animal_id", nullable = false)
	@NonNull
	private List<Animal> animals;

}
