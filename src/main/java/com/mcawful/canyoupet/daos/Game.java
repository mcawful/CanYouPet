/**
 * 
 */
package com.mcawful.canyoupet.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mcawful.canyoupet.models.Animal;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The DAO entity representing the Game object.
 * 
 * @author Michael McAuliffe
 *
 */
@Data
@AllArgsConstructor
@Entity
public class Game {

	/**
	 * The ID of the {@link Game} object.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int id;

	/**
	 * The {@link String} titleURL of the {@link Game} object.
	 */
	@Column(nullable = false)
	private String titleURL;

	/**
	 * The {@link String} title of the {@link Game} object.
	 */
	@Column(nullable = false)
	private String title;

	/**
	 * The array of {@link Animal} objects in the {@link Game} object.
	 */
	@Column(nullable = false)
	private Animal[] animals;

}
