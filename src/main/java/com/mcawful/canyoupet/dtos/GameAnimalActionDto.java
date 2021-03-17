/**
 * 
 */
package com.mcawful.canyoupet.dtos;

import java.util.List;
import java.util.stream.Collectors;

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
	 * The {@link List} of {@link AnimalActionDto} objects of the
	 * {@link GameAnimalActionDto} object.
	 */
	@NonFinal
	private List<AnimalActionDto> animalActions;

	/**
	 * Constructs a {@link GameAnimalActionDto} from a {@link Game} object.
	 * 
	 * @param game the {@link Game} object to construct from
	 */
	public GameAnimalActionDto(Game game) {

		this.gameTitle = game.getTitle();
		this.animalActions = game.getAnimals().stream().map(animalAction -> new AnimalActionDto(animalAction))
				.collect(Collectors.toList());
	}
}
