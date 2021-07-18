/**
 * 
 */
package com.mcawful.canyoupet.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * The DOA entity that represents the Action object.
 * 
 * @author Michael McAuliffe
 *
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Action {

	/**
	 * The ID of the {@link Action} object.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action_seq")
	@SequenceGenerator(name = "action_seq")
	@Column(name = "id")
	private int actionId;

	/**
	 * The {@link String} name of the {@link Action} object.
	 */
	@Column(nullable = false)
	@NonNull
	private String name;

	/**
	 * Indicates if the action of the {@link Action} object can be done.
	 */
	@Column(nullable = false)
	@NonNull
	private Boolean canYou;

	/**
	 * The {@link String} source URL of the {@link Action} object.
	 */
	@Column(nullable = false)
	@NonNull
	private String sourceURL;
}
