/**
 * 
 */
package com.mcawful.canyoupet.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The DOA entity that represents the Action object.
 * 
 * @author Michael McAuliffe
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Action {

	/**
	 * The ID of the {@link Action} object.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/**
	 * The {@link String} name of the {@link Action} object.
	 */
	@Column(nullable = false)
	private String name;

	/**
	 * The {@link String} source URL of the {@link Action} object.
	 */
	@Column(nullable = false)
	private String sourceURL;

	/**
	 * Indicates if the action of the {@link Action} object can be done.
	 */
	@Column(nullable = false)
	private boolean canYou;

}
