/**
 *
 */
package com.mcawful.canyoupet.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcawful.canyoupet.dao.ActionName;

/**
 * Repository layer for {@link ActionName} entities.
 *
 * @author Michael McAuliffe
 *
 */
@Repository
public interface ActionNameRepo extends JpaRepository<ActionName, Integer> {

	/**
	 * Finds a {@link ActionName} entity by its name field.
	 *
	 * @param name the action name
	 * @return an {@link Optional} of an {@link ActionName}
	 */
	public Optional<ActionName> findByName(String name);
}
