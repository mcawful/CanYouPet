/**
 * 
 */
package com.mcawful.canyoupet.services;

import javax.persistence.EntityNotFoundException;

import com.mcawful.canyoupet.daos.Game;

/**
 * A service interface to handle requests for {@link Game} objects.
 * 
 * @author Michael McAuliffe
 *
 */
public interface GameService {

	/**
	 * Retrieves a {@link Game} object by the {@code titleURI} {@link String} by
	 * making a call to the appropriate repository.
	 * 
	 * @param titleURI the {@code titleURI} {@link String} field of the {@link Game}
	 *                 object
	 * @return a {@link Game} object
	 * @throws EntityNotFoundException when a {@link Game} object cannot be found in
	 *                                 the repository
	 */
	public Game retrieveGameByTitleURI(String titleURI) throws EntityNotFoundException;

}
