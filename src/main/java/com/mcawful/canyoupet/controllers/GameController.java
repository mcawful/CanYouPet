/**
 * 
 */
package com.mcawful.canyoupet.controllers;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * 
	 * @return
	 */
	@GetMapping
	public List<GameAnimalActionDto> getAllGameAnimalActions() {
		
		return new ArrayList<>();
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
