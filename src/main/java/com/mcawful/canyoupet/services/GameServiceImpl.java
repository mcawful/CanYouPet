/**
 * 
 */
package com.mcawful.canyoupet.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcawful.canyoupet.daos.Game;
import com.mcawful.canyoupet.repos.GameRepo;

/**
 * An implementation of the {@link GameService} interface to handle requests for
 * {@link Game} objects.
 * 
 * @author Michael McAuliffe
 *
 */
@Service
public class GameServiceImpl implements GameService {

	private GameRepo gameRepo;

	/**
	 * Autowires the {@link GameRepo}.
	 * 
	 * @param gameRepo
	 */
	@Autowired
	public GameServiceImpl(GameRepo gameRepo) {
		super();
		this.gameRepo = gameRepo;
	}

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
	@Override
	public Game retrieveGameByTitleURI(String titleURI) throws EntityNotFoundException {

		return this.gameRepo.findByTitleURI(titleURI).orElseThrow(EntityNotFoundException::new);
	}

}
