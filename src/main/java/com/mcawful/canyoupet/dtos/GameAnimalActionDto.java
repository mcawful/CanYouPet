/**
 * 
 */
package com.mcawful.canyoupet.dtos;

import com.mcawful.canyoupet.daos.Action;

import lombok.Value;

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
	private AnimalActionDto[] animalActions;
}
