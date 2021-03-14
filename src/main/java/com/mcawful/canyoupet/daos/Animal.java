/**
 * 
 */
package com.mcawful.canyoupet.daos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The DOA entity that represents the Animal object.
 * 
 * @author Michael McAuliffe
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Animal {

	/**
	 * The ID of the {@link Animal} object.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/**
	 * The {@link String} name of the {@link Animal} object.
	 */
	@Column(nullable = false)
	private String name;

	/**
	 * The {@link List} of {@link Action} objects in the {@link Animal} object.
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Column(nullable = false)
	private List<Action> actions;

}
