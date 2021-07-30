/**
 *
 */
package com.mcawful.canyoupet.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The DOA representing the {@code Action} entity.
 *
 * @author Michael McAuliffe
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Action {

	/**
	 * The ID of the {@code Action} entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action_seq")
	@SequenceGenerator(name = "action_seq", allocationSize = 1)
	@Column(name = "id")
	private int actionId;

	/**
	 * The name of the {@code Action}.
	 */
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "fk_action_name", nullable = false)
	private ActionName actionName;

	/**
	 * Indicates if the {@code Action} can be done.
	 */
	@Column(nullable = false)
	private Boolean canYou;

	/**
	 * The {@link Source} containing the URL.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_source", nullable = false)
	private Source source;

	/**
	 * Gets the name of the {@code Action}.
	 *
	 * @return {@link String} the action's name
	 */
	public String getName() {

		return this.actionName.getName();
	}
}
