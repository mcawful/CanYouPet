/**
 * 
 */
package com.mcawful.canyoupet.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mcawful.canyoupet.dao.Action;
import com.mcawful.canyoupet.dao.Animal;
import com.mcawful.canyoupet.dao.Game;
import com.mcawful.canyoupet.dto.ActionDto;
import com.mcawful.canyoupet.dto.AnimalDto;
import com.mcawful.canyoupet.dto.GameDto;
import com.mcawful.canyoupet.service.GameService;

/**
 * Controller to handle {@code GET} requests for {@link Game} and related
 * {@link Animal} and {@link Action} objects.
 * 
 * @author Michael McAuliffe
 *
 */
@RestController
@RequestMapping("/api")
public class RestGetControllerMvc {

	GameService gameService;

	/**
	 * Autowires the {@link GameService}.
	 * 
	 * @param gameRepo
	 */
	@Autowired
	public RestGetControllerMvc(GameService gameService) {
		super();
		this.gameService = gameService;
	}

	/**
	 * Handles a {@code GET} request for all {@link Game} objects. Response status
	 * code is {@code OK} when the request is successful.
	 * 
	 * @return a {@link List} of {@link GameDto} objects
	 */
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<GameDto> getAllGames() {

		return this.gameService.getAllGames().stream().map(game -> new GameDto(game)).collect(Collectors.toList());
	}

	/**
	 * Handles a {@code GET} request for a single {@link Game} object.
	 * 
	 * @param titleURI the {@code titleURI} {@link String} of the {@link Game}
	 *                 object
	 * @return a {@link GameDto} object
	 */
	@GetMapping("/{titleURI}")
	@ResponseStatus(value = HttpStatus.OK)
	public GameDto getGame(@PathVariable String titleURI) {

		return new GameDto(this.gameService.getGame(titleURI));
	}

	/**
	 * Handles a {@code GET} request for a single {@link Animal} object.
	 * 
	 * @param titleURI   the {@code titleURI} {@link String} of the {@link Game}
	 *                   object
	 * @param animalName the {@code name} of the {@link Animal} object
	 * @return an {@link AnimalDto} object
	 */
	@GetMapping("/{titleURI}/{animalName}")
	@ResponseStatus(value = HttpStatus.OK)
	public AnimalDto getAnimal(@PathVariable String titleURI, @PathVariable String animalName) {

		return new AnimalDto(this.gameService.getAnimal(titleURI, animalName));
	}

	/**
	 * Handles a {@code GET} request for a single {@link Action} object.
	 * 
	 * @param titleURI   the {@code titleURI} {@link String} of the {@link Game}
	 *                   object
	 * @param animalName the {@code name} of the {@link Animal} object
	 * @param actionName the {@code name} of the {@link Action} object
	 * @return an {@link ActionDto} object
	 */
	@GetMapping("/{titleURI}/{animalName}/{actionName}")
	@ResponseStatus(value = HttpStatus.OK)
	public ActionDto getAction(@PathVariable String titleURI, @PathVariable String animalName,
			@PathVariable String actionName) {

		return new ActionDto(this.gameService.getAction(titleURI, animalName, actionName));
	}
}
