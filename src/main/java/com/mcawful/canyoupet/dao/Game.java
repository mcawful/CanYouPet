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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The DAO representing the {@code Game} entity.
 *
 * @author Michael McAuliffe
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Game {

	/**
	 * The ID of the {@code Game} entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
	@SequenceGenerator(name = "game_seq", allocationSize = 1)
	@Column(name = "id")
	private int gameId;

	/**
	 * The URI path of the {@code Game} endpoint.
	 */
	@Column(nullable = false, unique = true)
	private String titleURI;

	/**
	 * The title of the {@code Game}.
	 */
	@Column(nullable = false, unique = true)
	private String title;

	/**
	 * The {@link List} of {@link Animal} objects the {@code Game} contains.
	 */
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_game", nullable = false)
	private List<Animal> animals;

}
