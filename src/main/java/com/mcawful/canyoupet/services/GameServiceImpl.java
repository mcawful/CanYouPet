/**
 * 
 */
package com.mcawful.canyoupet.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcawful.canyoupet.daos.Action;
import com.mcawful.canyoupet.daos.Animal;
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
	 * Retrieves a {@link List} of all {@link Game} objects by making a call to the
	 * {@link GameRepo} repository.
	 * 
	 * @return a {@link List} of {@link Game} objects
	 */
	@Override
	public List<Game> getAllGames() {

		return this.gameRepo.findAll();
	}

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
	@Override
	public Game getGame(String titleURI) throws NoSuchElementException {

		return this.gameRepo.findByTitleURI(titleURI).orElseThrow(NoSuchElementException::new);
	}

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
	@Override
	public Animal getAnimal(String titleURI, String animalName) throws NoSuchElementException {

		Game game = this.gameRepo.findByTitleURIAndAnimals_Name(titleURI, animalName)
				.orElseThrow(NoSuchElementException::new);

		return game.getAnimals().stream().filter(a -> a.getName().equals(animalName)).findFirst()
				.orElseThrow(NoSuchElementException::new);
	}

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
	@Override
	public Action getAction(String titleURI, String animalName, String actionName) throws NoSuchElementException {

		Game game = this.gameRepo.findByTitleURIAndAnimals_NameAndAnimals_Actions_Name(titleURI, animalName, actionName)
				.orElseThrow(NoSuchElementException::new);

		Animal animal = game.getAnimals().stream().filter(a -> a.getName().equals(animalName)).findFirst()
				.orElseThrow(NoSuchElementException::new);

		return animal.getActions().stream().filter(a -> a.getName().equals(actionName)).findFirst()
				.orElseThrow(NoSuchElementException::new);
	}

}
