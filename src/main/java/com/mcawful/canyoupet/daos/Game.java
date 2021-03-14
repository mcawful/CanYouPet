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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The DAO entity representing the Game object.
 * 
 * @author Michael McAuliffe
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Game {

	/**
	 * The ID of the {@link Game} object.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * The {@link String} titleURL of the {@link Game} object.
	 */
	@Column(nullable = false, unique = true)
	private String titleURL;

	/**
	 * The {@link String} title of the {@link Game} object.
	 */
	@Column(nullable = false, unique = true)
	private String title;

	/**
	 * The {@link List of {@link Animal} objects in the {@link Game} object.
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Column(nullable = false)
	private List<Animal> animals;

}