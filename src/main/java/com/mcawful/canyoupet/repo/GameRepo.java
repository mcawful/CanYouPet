/**
 * 
 */
package com.mcawful.canyoupet.repo;

import java.util.Optional;

import javax.persistence.OneToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcawful.canyoupet.dao.Action;
import com.mcawful.canyoupet.dao.Animal;
import com.mcawful.canyoupet.dao.Game;

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
	 * Finds a {@link Game} object based off of its {@code titleURI} {@link String}
	 * field.
	 * 
	 * @param titleURI the {@code titleURI} {@link String} of the {@link Game}
	 *                 object to find
	 * @return an {@link Optional} of a {@link Game} object
	 */
	public Optional<Game> findByTitleURI(String titleURI);

	/**
	 * Finds a {@link Game} object based off of its {@code titleURI} {@link String}
	 * field and its related {@link Animal} object's {@code name} {@link String}
	 * field.
	 * 
	 * @param titleURI   the {@code titleURI} {@link String} of the {@link Game}
	 *                   object to find
	 * @param animalName the {@code name} {@link String} of the related
	 *                   {@link Animal} object in the {@link Game} object to find
	 * @return an {@link Optional} of a {@link Game} object
	 */
	public Optional<Game> findByTitleURIAndAnimals_Name(String titleURI, String animalName);

	/**
	 * Finds a {@link Game} object based off of its {@code titleURI} {@link String}
	 * field and its related {@link Animal} object's {@code name} {@link String}
	 * field and the {@link Animal} object's related {@link Action} object's
	 * {@code name} field.
	 * 
	 * @param titleURI   the {@code titleURI} {@link String} of the {@link Game}
	 *                   object to find
	 * @param animalName the {@code name} {@link String} of the related
	 *                   {@link Animal} object in the {@link Game} object to find
	 * @param actionName the {@code name} {@link String} of the {@link Action}
	 *                   object of the related {@link Animal} object of the related
	 *                   {@link Game} object to find
	 * @return an {@link Optional} of a {@link Game} object
	 */
	public Optional<Game> findByTitleURIAndAnimals_NameAndAnimals_Actions_Name(String titleURI, String animalName,
			String actionName);
}
