package com.mcawful.canyoupet.views;

import com.mcawful.canyoupet.daos.Animal;

public interface AnimalView extends AnimalListView {

	@Override
	default Animal getAnimalByName(String name) {

		return AnimalListView.super.getAnimalByName(name);
	}
}
