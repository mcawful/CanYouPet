/**
 * 
 */
package com.mcawful.canyoupet.dtos;

import com.mcawful.canyoupet.daos.Action;

import lombok.Value;

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
	 * The array of {@link ActionDto} objects of the {@link AnimalActionDto} object.
	 */
	private ActionDto[] actions;
}
