/**
 * 
 */
package com.mcawful.canyoupet.dtos;

import com.mcawful.canyoupet.daos.Action;

import lombok.Value;

/**
 * A DTO that contains information from an {@link Action} object.
 * 
 * @author Michael McAuliffe
 *
 */
@Value
public class ActionDto {

	/**
	 * The {@code actionName} {@link String} of the {@link ActionDto} object.
	 */
	private String actionName;

	/**
	 * The {@code canYou} {@link Boolean} of the {@link ActionDto} object.
	 */
	private Boolean canYou;
}