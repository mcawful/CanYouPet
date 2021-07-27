/**
 *
 */
package com.mcawful.canyoupet.dto;

import com.mcawful.canyoupet.dao.Action;

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

	/**
	 * The {@code sourceURL} {@link String} of the {@link ActionDto} object.
	 */
	private String sourceURL;

	/**
	 * Constructs an {@link ActionDto} object from an {@link Action} object.
	 *
	 * @param action the {@link Action} object to construct from
	 */
	public ActionDto(Action action) {
		this.actionName = action.getName();
		this.canYou = action.getCanYou();
		this.sourceURL = action.getSource().getUrl();
	}
}
