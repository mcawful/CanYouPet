/**
 * 
 */
package com.mcawful.canyoupet.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * The DAO entity representing the Game object.
 * 
 * @author Michael McAuliffe
 *
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Game {
	/**
	 * The ID of the {@link Game} object.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * The {@link String} titleURI of the {@link Game} object.
	 */
	@Column(nullable = false, unique = true)
	@NonNull
	private String titleURI;

	/**
	 * The {@link String} title of the {@link Game} object.
	 */
	@Column(nullable = false, unique = true)
	@NonNull
	private String title;

	/**
	 * The {@link List} of {@link Animal} objects in the {@link Game} object.
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Column(nullable = false)
	@NonNull
	private List<Animal> animals;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (animals == null) {
			if (other.animals != null)
				return false;
		} else if (!new ArrayList<>(animals).equals(other.animals))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (titleURI == null) {
			if (other.titleURI != null)
				return false;
		} else if (!titleURI.equals(other.titleURI))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animals == null) ? 0 : animals.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((titleURI == null) ? 0 : titleURI.hashCode());
		return result;
	}
}
