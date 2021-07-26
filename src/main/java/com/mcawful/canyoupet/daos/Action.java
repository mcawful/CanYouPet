/**
 *
 */
package com.mcawful.canyoupet.daos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * The DOA that represents the {@code Action} entity.
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
	 * The ID of the {@code Action} entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action_seq")
	@SequenceGenerator(name = "action_seq")
	@Column(name = "id")
	private int actionId;

	/**
	 * The name of the {@code Action}.
	 */
	@Column(nullable = false)
	@NonNull
	private String name;

	/**
	 * Indicates if the {@code Action} can be done.
	 */
	@Column(nullable = false)
	@NonNull
	private Boolean canYou;

	/**
	 * The {@link Source} containing the URL.
	 */
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "source_id", nullable = false)
	@NonNull
	private Source source;
}
