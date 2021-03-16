/**
 * 
 */
package com.mcawful.canyoupet.dtos;

import com.mcawful.canyoupet.daos.Action;
import com.mcawful.canyoupet.daos.Game;

import lombok.Value;
import lombok.experimental.NonFinal;

/**
 * A DTO that contains information from a {@link Game} object and the related
 * {@link Animal} and {@link Action} objects.
 * 
 * @author Michael McAuliffe
 *
 */
@Value
public class GameAnimalActionDto {

	/**
	 * The {@code gameTitle} {@link String} of the {@link GameAnimalActionDto}
	 * object.
	 */
	private String gameTitle;

	/**
	 * The array of {@link AnimalActionDto} objects of the
	 * {@link GameAnimalActionDto} object.
	 */
	@NonFinal
	private AnimalActionDto[] animalActions;

	/**
	 * Constructs a {@link GameAnimalActionDto} from a {@link Game} object.
	 * 
	 * @param game the {@link Game} object to construct from
	 */
	public GameAnimalActionDto(Game game) {

		this.gameTitle = game.getTitle();
		this.animalActions = game.getAnimals().toArray(animalActions);
	}
}
