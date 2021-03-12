/**
 * 
 */
package com.mcawful.canyoupet.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The model entity that represents the Animal object.
 * 
 * @author Michael McAuliffe
 *
 */
@Data
@AllArgsConstructor
public class Animal {

	/**
	 * The {@link String} name of the {@link Animal} object.
	 */
	private String name;

	/**
	 * The array of {@link Action} objects in the {@link Animal} object.
	 */
	private Action[] actions;

}
