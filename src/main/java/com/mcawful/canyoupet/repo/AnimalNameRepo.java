/**
 *
 */
package com.mcawful.canyoupet.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcawful.canyoupet.dao.AnimalName;

/**
 * Repository layer for {@link AnimalName} entities.
 *
 * @author Michael McAuliffe
 *
 */
@Repository
public interface AnimalNameRepo extends JpaRepository<AnimalName, Integer> {

	/**
	 * Finds a {@link AnimalName} entity by its name field.
	 *
	 * @param name the animal name
	 * @return an {@link Optional} of an {@link AnimalName}
	 */
	public Optional<AnimalName> findByName(String name);
}
