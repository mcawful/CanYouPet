/**
 * 
 */
package com.mcawful.canyoupet.views;

import java.util.List;
import java.util.NoSuchElementException;

import com.mcawful.canyoupet.daos.Action;
import com.mcawful.canyoupet.daos.Animal;

/**
 * @author Michael McAuliffe
 *
 */
interface ActionListView extends AnimalView {

	@Override
	default Animal getAnimalByName(String name) {
		return AnimalView.super.getAnimalByName(name);
	}

	/**
	 * 
	 * @param animalName
	 * @param actionName
	 * @return
	 */
	default List<Action> getActionsByAnimalName(String animalName) {
		return getAnimalByName(animalName).getActions();

	}

	/**
	 * 
	 * @param animalName
	 * @param actionName
	 * @return
	 */
	default Action getActionByAnimalNameAndActionName(String animalName, String actionName) {
		return getActionsByAnimalName(animalName).stream().filter(action -> action.getName().equals(actionName))
				.findFirst().orElseThrow(NoSuchElementException::new);
	}
}
