/**
 * 
 */
package com.mcawful.canyoupet.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcawful.canyoupet.daos.Game;

/**
 * Repo layer for persisting {@link Game} objects
 * 
 * @author Michael McAuliffe
 *
 */
public interface GameRepo extends JpaRepository<Game, Integer> {

	/**
	 * Finds a {@link Game object based off of its {@link String} TitleURL field.
	 * 
	 * @param titleURL the {@link String} titleURL of the {@link Game} object to
	 *                 find
	 * @return an {@link Optional} of a {@link Game} object
	 */
	public Optional<Game> findByTitleURL(String titleURL);

}
