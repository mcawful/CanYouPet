/**
 * 
 */
package com.mcawful.canyoupet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcawful.canyoupet.dtos.ActionDto;
import com.mcawful.canyoupet.dtos.AnimalActionDto;
import com.mcawful.canyoupet.dtos.GameAnimalActionDto;

/**
 * @author Michael McAuliffe
 *
 */
@RestController
@RequestMapping("/api")
public class GameController {

	@GetMapping
	public GameAnimalActionDto[] getAllGameAnimalActions() {
		
		return new GameAnimalActionDto[0];
	}
	
	/**
	 * 
	 * @param titleURI
	 * @return
	 */
	@GetMapping("/{titleURI}")
	public GameAnimalActionDto getGameAnimalAction(@PathVariable String titleURI) {

		return null;
	}

	/**
	 * 
	 * @param titleURI
	 * @param animalName
	 * @return
	 */
	@GetMapping("/{titleURI}/{animalName}")
	public AnimalActionDto getAnimalAction(@PathVariable String titleURI, @PathVariable String animalName) {

		return null;
	}

	/**
	 * 
	 * @param titleURI
	 * @param animalName
	 * @param actionName
	 * @return
	 */
	@GetMapping("/{titleURI}/{animalName}/{actionName}")
	public ActionDto getAction(@PathVariable String titleURI, @PathVariable String animalName,
			@PathVariable String actionName) {

		return null;
	}
}
