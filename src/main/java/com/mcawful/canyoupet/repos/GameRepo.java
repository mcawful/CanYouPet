/**
 * 
 */
package com.mcawful.canyoupet.repos;

import java.util.Optional;

import javax.persistence.OneToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcawful.canyoupet.daos.Action;
import com.mcawful.canyoupet.daos.Game;

/**
 * Repository layer for {@link Game} objects.
 * <p>
 * Note that a {@link Game} object contains a {@link OneToMany} relationship
 * with a {@link List} of {@link Animal} objects. An {@link Animal} object in
 * turn also contains a {@link OneToMany} relationship with a {@link List} of
 * {@link Action} objects.
 * 
 * @author Michael McAuliffe
 *
 */
@Repository
public interface GameRepo extends JpaRepository<Game, Integer> {

	/**
	 * Finds a {@link Game} object based off of its {@code titleURI}
	 * {@link String} field.
	 * 
	 * @param titleURI the {@code titleURI} {@link String} of the {@link Game}
	 *                 object to find
	 * @return an {@link Optional} of a {@link Game} object
	 */
	public Optional<Game> findByTitleURI(String titleURI);

}
