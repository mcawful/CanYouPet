/**
 * 
 */
package com.mcawful.canyoupet.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.mcawful.canyoupet.dao.Action;
import com.mcawful.canyoupet.dao.Animal;

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
public class AnimalDto {

	/**
	 * The {@code animalName} {@link String} of the {@link AnimalDto} object.
	 */
	private String animalName;

	/**
	 * The {@link List} of {@link ActionDto} objects of the {@link AnimalDto}
	 * object.
	 */
	@NonFinal
	private List<ActionDto> actions;

	/**
	 * Constructs a {@link AnimalDto} from an {@link Animal} object.
	 * 
	 * @param animal the {@link Animal} object to construct from
	 */
	public AnimalDto(Animal animal) {

		this.animalName = animal.getName();
		this.actions = animal.getActions().stream().map(action -> new ActionDto(action)).collect(Collectors.toList());
	}
}
