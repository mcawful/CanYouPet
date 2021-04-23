/**
 * 
 */
package com.mcawful.canyoupet.views;

import com.mcawful.canyoupet.daos.Action;

/**
 * @author Michael McAuliffe
 *
 */
public interface ActionView extends ActionListView {

	@Override
	default Action getActionByAnimalNameAndActionName(String animalName, String actionName) {
		return ActionListView.super.getActionByAnimalNameAndActionName(animalName, actionName);
	}
}
