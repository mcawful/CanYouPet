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
 * The DAO entity representing the Game object.
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
	 * The ID of the {@link Game} object.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
	@SequenceGenerator(name = "game_seq")
	@Column(name = "id")
	private int gameId;

	/**
	 * The {@link String} titleURI of the {@link Game} object.
	 */
	@Column(nullable = false, unique = true)
	@NonNull
	private String titleURI;

	/**
	 * The {@link String} title of the {@link Game} object.
	 */
	@Column(nullable = false, unique = true)
	@NonNull
	private String title;

	/**
	 * The {@link List} of {@link Animal} objects in the {@link Game} object.
	 */
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "animal_id", nullable = false)
	@NonNull
	private List<Animal> animals;

}
