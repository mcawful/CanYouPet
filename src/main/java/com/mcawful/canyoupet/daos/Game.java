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
import javax.persistence.OneToMany;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

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
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Column(nullable = false)
	@NonNull
	private List<Animal> animals;

}
