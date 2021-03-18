/**
 * 
 */
package com.mcawful.canyoupet.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.mcawful.canyoupet.daos.Action;
import com.mcawful.canyoupet.daos.Animal;
import com.mcawful.canyoupet.daos.Game;

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
	public List<Game> readAllGames();

	/**
	 * Retrieves a {@link Game} object by the {@code titleURI} {@link String} by
	 * making a call to the appropriate repository.
	 * 
	 * @param titleURI the {@code titleURI} {@link String} field of the {@link Game}
	 *                 object
	 * @return a {@link Game} object
	 * @throws EntityNotFoundException when a matching {@link Game} object cannot be
	 *                                 found in the repository
	 */
	public Game readGameByTitleURI(String titleURI) throws EntityNotFoundException;

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
	 * @throws EntityNotFoundException when a matching {@link Game} object cannot be
	 *                                 found in the repository
	 */
	public Animal readAnimalByGameTitleURIAndAnimalName(String titleURI, String animalName)
			throws EntityNotFoundException;

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
	 * @throws EntityNotFoundException when a matching {@link Game} object cannot be
	 *                                 found in the repository
	 */
	public Action readActionByGameTitleURIAndAnimalNameAndActionName(String titleURI, String animalName,
			String actionName) throws EntityNotFoundException;
}
