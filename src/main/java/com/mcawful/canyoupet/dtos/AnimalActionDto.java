/**
 * 
 */
package com.mcawful.canyoupet.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.mcawful.canyoupet.daos.Action;
import com.mcawful.canyoupet.daos.Animal;

import lombok.Value;
import lombok.experimental.NonFinal;

/**
 * A DTO that contains information from an {@link Animal} object and the related
 * and {@link Action} objects.
 * 
 * @author Michael McAuliffe
 *
 */
@Value
public class AnimalActionDto {

	/**
	 * The {@code animalName} {@link String} of the {@link AnimalActionDto} object.
	 */
	private String animalName;

	/**
	 * The {@link List} of {@link ActionDto} objects of the {@link AnimalActionDto}
	 * object.
	 */
	@NonFinal
	private List<ActionDto> actions;

	/**
	 * Constructs a {@link AnimalActionDto} from an {@link Animal} object.
	 * 
	 * @param animal the {@link Animal} object to construct from
	 */
	public AnimalActionDto(Animal animal) {

		this.animalName = animal.getName();
		this.actions = animal.getActions().stream().map(action -> new ActionDto(action)).collect(Collectors.toList());
	}
}
