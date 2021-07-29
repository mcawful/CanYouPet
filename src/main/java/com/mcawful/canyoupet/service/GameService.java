/**
 *
 */
package com.mcawful.canyoupet.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.mcawful.canyoupet.dao.Action;
import com.mcawful.canyoupet.dao.Animal;
import com.mcawful.canyoupet.dao.Game;

// TODO: Rewrite Javadocs

/**
 * A service interface to handle requests for {@link Game} objects.
 *
 * @author Michael McAuliffe
 *
 */
public interface GameService {

	/**
	 * Retrieves a {@link List} of all {@link Game} objects by making a call to the
	 * appropriate repository.
	 *
	 * @return a {@link List} of {@link Game} objects
	 */
	public List<Game> getAllGames();

	/**
	 * Retrieves a {@link Game} object by the {@code titleURI} {@link String} by
	 * making a call to the appropriate repository.
	 *
	 * @param titleURI the {@code titleURI} {@link String} field of the {@link Game}
	 *                 object
	 * @return a {@link Game} object
	 * @throws NoSuchElementException when a matching {@link Game} object cannot be
	 *                                found in the repository
	 */
	public Game getGame(String titleURI) throws NoSuchElementException;

	/**
	 * Retrieves a {@link Game} object by the {@code titleURI} {@link String} and
	 * the {@code name} {@link String} of the related {@link Animal} object by
	 * making a call to the appropriate repository.
	 *
	 * @param titleURI   the {@code titleURI} {@link String} field of the
	 *                   {@link Game} object
	 * @param animalName the {@code name} {@link String} field of the related
	 *                   {@link Animal} object of the {@link Game} object
	 * @return a {@link Animal} object
	 * @throws NoSuchElementException when a matching {@link Game} object cannot be
	 *                                found in the repository
	 */
	public Animal getAnimal(String titleURI, String animalName) throws NoSuchElementException;

	/**
	 * Retrieves a {@link Game} object by the {@code titleURI} {@link String} and
	 * the {@code name} {@link String} of the related {@link Animal} object and the
	 * {@code name} {@link String} of the related {@link Action} object of the
	 * related {@link Animal} object by making a call to the appropriate repository.
	 *
	 * @param titleURI   the {@code titleURI} {@link String} field of the
	 *                   {@link Game} object
	 * @param animalName the {@code name} {@link String} field of the related
	 *                   {@link Animal} object of the {@link Game} object
	 * @param actionName the {@code name} {@link String} field of the related
	 *                   {@link Action} object of the related {@link Animal} object
	 *                   of the {@link Game} object
	 * @return a {@link Action} object
	 * @throws NoSuchElementException when a matching {@link Game} object cannot be
	 *                                found in the repository
	 */
	public Action getAction(String titleURI, String animalName, String actionName) throws NoSuchElementException;
}
