/**
 * 
 */
package com.mcawful.canyoupet.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The model entity that represents the Action object.
 * 
 * @author Michael McAuliffe
 *
 */
@Data
@AllArgsConstructor
public class Action {

	/**
	 * The {@link String} name of the {@link Action} object.
	 */
	private String name;

	/**
	 * The {@link String} source URL of the {@link Action} object.
	 */
	private String sourceURL;

	/**
	 * Indicates if the action of the {@link Action} object can be done.
	 */
	private boolean canYou;

}
