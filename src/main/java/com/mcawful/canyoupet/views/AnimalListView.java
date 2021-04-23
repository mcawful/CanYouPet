/**
 * 
 */
package com.mcawful.canyoupet.views;

import java.util.List;
import java.util.NoSuchElementException;

import com.mcawful.canyoupet.daos.Animal;

/**
 * @author Michael McAuliffe
 *
 */
interface AnimalListView {

	/**
	 * 
	 * @return
	 */
	List<Animal> getAnimals();

	/**
	 * 
	 * @param name
	 * @return
	 */
	default Animal getAnimalByName(String name) {
		return getAnimals().stream().filter(animal -> animal.getName().equals(name)).findFirst()
				.orElseThrow(NoSuchElementException::new);
	}
}
