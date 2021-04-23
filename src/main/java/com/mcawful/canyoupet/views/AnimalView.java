/**
 * 
 */
package com.mcawful.canyoupet.views;

import com.mcawful.canyoupet.daos.Animal;

/**
 * @author Michael McAuliffe
 *
 */
public interface AnimalView extends AnimalListView {

	@Override
	default Animal getAnimalByName(String name) {
		return AnimalListView.super.getAnimalByName(name);
	}
}
