/**
 * 
 */
package com.mcawful.canyoupet.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.mcawful.canyoupet.dao.Action;
import com.mcawful.canyoupet.dao.Game;

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
public class GameDto {

	/**
	 * The {@code gameTitle} {@link String} of the {@link GameDto} object.
	 */
	private String gameTitle;

	/**
	 * The {@code gameURI} {@link String} of the {@link GameDto} object.
	 */
	private String gameURI;

	/**
	 * The {@link List} of {@link AnimalDto} objects of the {@link GameDto} object.
	 */
	@NonFinal
	private List<AnimalDto> animals;

	/**
	 * Constructs a {@link GameDto} from a {@link Game} object.
	 * 
	 * @param game the {@link Game} object to construct from
	 */
	public GameDto(Game game) {

		this.gameTitle = game.getTitle();
		this.gameURI = game.getTitleURI();
		this.animals = game.getAnimals().stream().map(animalAction -> new AnimalDto(animalAction))
				.collect(Collectors.toList());
	}
}
