/**
 * 
 */
package com.mcawful.canyoupet.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcawful.canyoupet.aspects.GlobalControllerExceptionHandler;
import com.mcawful.canyoupet.daos.Action;
import com.mcawful.canyoupet.daos.Animal;
import com.mcawful.canyoupet.daos.Game;
import com.mcawful.canyoupet.dtos.ActionDto;
import com.mcawful.canyoupet.dtos.AnimalDto;
import com.mcawful.canyoupet.dtos.GameDto;
import com.mcawful.canyoupet.services.GameService;

/**
 * Tests for the {@link RestGetControllerMvc} methods.
 * 
 * @author Michael McAuliffe
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
class RestGetControllerMvcTest {

	@Autowired
	private RestGetControllerMvc restGetControllerMvc;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GameService gameService;

	private Game game;

	private Animal animal;

	private Action action;

	private String gameJson;

	private String animalJson;

	private String actionJson;

	private String allGamesJson;

	private String baseURI, titleURI, animalName, actionName;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets up the {@link MockMvc} and the various objects to be used in the tests.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		this.mockMvc = MockMvcBuilders.standaloneSetup(this.restGetControllerMvc)
				.setControllerAdvice(GlobalControllerExceptionHandler.class).build();

		this.baseURI = "/api";

		this.titleURI = "test_game";
		this.animalName = "dog";
		this.actionName = "pet";

		this.action = new Action(this.actionName, true, "http://test.url");
		this.animal = new Animal(this.animalName, Arrays.asList(this.action));
		this.game = new Game(this.titleURI, "Test Game", Arrays.asList(this.animal));

		this.gameJson = new ObjectMapper().writeValueAsString(new GameDto(this.game));
		this.animalJson = new ObjectMapper().writeValueAsString(new AnimalDto(this.animal));
		this.actionJson = new ObjectMapper().writeValueAsString(new ActionDto(this.action));

		this.allGamesJson = new ObjectMapper().writeValueAsString(Arrays.asList(new GameDto(this.game)));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test asserts that the {@link RestGetControllerMvc} has been instantiated.
	 * 
	 * @throws Exception
	 */
	@Test
	void contextLoads() throws Exception {

		assertThat(this.restGetControllerMvc).isNotNull();
	}

	/**
	 * Tests the {@link RestGetControllerMvc} {@code getAllGames} method.
	 * <p>
	 * Test performs the appropriate {@code GET} request to call the
	 * {@code getAllGames} endpoint, expects the response status to be {@code OK}
	 * and that the returned {@code JSON} matches what is expected. Test then
	 * verifies that the {@link GameService} {@code getAllGames} method was called.
	 * 
	 * @throws Exception
	 */
	@Test
	void getAllsTest_Success() throws Exception {

		when(this.gameService.getAllGames()).thenReturn(Arrays.asList(game));

		String path = this.baseURI;
		RequestBuilder request = MockMvcRequestBuilders.get(path);

		this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(this.allGamesJson));

		verify(this.gameService).getAllGames();
	}

	/**
	 * Tests the {@link RestGetControllerMvc} {@code getGame} method when passed a
	 * {@code titleURL} that matches an existing {@link Game} object.
	 * <p>
	 * Test performs the appropriate {@code GET} request to call the {@code getGame}
	 * endpoint, expects the response status to be {@code OK} and that the returned
	 * {@code JSON} matches what is expected. Test then verifies that the
	 * {@link GameService} {@code getGame} method was called.
	 * 
	 * @throws Exception
	 */
	@Test
	void getGameTest_GameExists() throws Exception {

		when(this.gameService.getGame(this.titleURI)).thenReturn(this.game);

		String path = this.baseURI + "/" + this.titleURI;
		RequestBuilder request = MockMvcRequestBuilders.get(path);

		this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(this.gameJson));

		verify(this.gameService).getGame(this.titleURI);
	}

	/**
	 * Tests the {@link RestGetControllerMvc} {@code getGame} method when passed a
	 * {@code titleURL} that does not match an existing {@link Game} object.
	 * <p>
	 * Test performs the appropriate {@code GET} request to call the {@code getGame}
	 * endpoint and expects the response status to be {@code NOT_FOUND}. Test then
	 * verifies that the {@link GameService} {@code getGame} method was called.
	 * 
	 * @throws Exception
	 */
	@Test
	void getGameTest_GameDoesNotExist() throws Exception {

		when(this.gameService.getGame("invalid")).thenThrow(NoSuchElementException.class);

		String path = this.baseURI + "/invalid";
		RequestBuilder request = MockMvcRequestBuilders.get(path);

		this.mockMvc.perform(request).andExpect(status().isNotFound());

		verify(this.gameService).getGame("invalid");
	}

	/**
	 * Tests the {@link RestGetControllerMvc} {@code getAnimal} method when passed a
	 * {@code titleURL} that matches an existing {@link Game} object and a
	 * {@code name} that matches a related {@link Animal} object.
	 * <p>
	 * Test performs the appropriate {@code GET} request to call the
	 * {@code getAnimal} endpoint, expects the response status to be {@code OK} and
	 * that the returned {@code JSON} matches what is expected. Test then verifies
	 * that the {@link GameService} {@code getAnimal} method was called.
	 * 
	 * @throws Exception
	 */
	@Test
	void getAnimalTest_AnimalExists() throws Exception {

		when(this.gameService.getAnimal(this.titleURI, this.animalName)).thenReturn(this.animal);

		String path = this.baseURI + "/" + this.titleURI + "/" + this.animalName;
		RequestBuilder request = MockMvcRequestBuilders.get(path);

		this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(this.animalJson));

		verify(this.gameService).getAnimal(this.titleURI, this.animalName);
	}

	/**
	 * Tests the {@link RestGetControllerMvc} {@code getAnimal} method when passed a
	 * {@code name} of a related {@link Animal} object that does not match in an
	 * existing {@link Game} object.
	 * <p>
	 * Test performs the appropriate {@code GET} request to call the
	 * {@code getAnimal} endpoint and expects the response status to be
	 * {@code NOT_FOUND}. Test then verifies that the {@link GameService}
	 * {@code getAnimal} method was called.
	 * 
	 * @throws Exception
	 */
	@Test
	void getAnimalTest_AnimalDoesNotExist() throws Exception {

		when(this.gameService.getAnimal(this.titleURI, "invalid")).thenThrow(NoSuchElementException.class);

		String path = this.baseURI + "/" + this.titleURI + "/invalid";
		RequestBuilder request = MockMvcRequestBuilders.get(path);

		this.mockMvc.perform(request).andExpect(status().isNotFound());

		verify(this.gameService).getAnimal(this.titleURI, "invalid");
	}

	/**
	 * Tests the {@link RestGetControllerMvc} {@code getAction} method when passed a
	 * {@code titleURL} that matches an existing {@link Game} object and a
	 * {@code name} that matches a related {@link Animal} object and a {@code name}
	 * that matches a related {@link Action} object of the related {@link Animal}
	 * object.
	 * <p>
	 * Test performs the appropriate {@code GET} request to call the
	 * {@code getAction} endpoint, expects the response status to be {@code OK} and
	 * that the returned {@code JSON} matches what is expected. Test then verifies
	 * that the {@link GameService} {@code getAction} method was called.
	 * 
	 * @throws Exception
	 */
	@Test
	void getActionTest_ActionExists() throws Exception {

		when(this.gameService.getAction(this.titleURI, this.animalName, this.actionName)).thenReturn(this.action);

		String path = this.baseURI + "/" + this.titleURI + "/" + this.animalName + "/" + this.actionName;
		RequestBuilder request = MockMvcRequestBuilders.get(path);

		this.mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(this.actionJson));

		verify(this.gameService).getAction(this.titleURI, this.animalName, this.actionName);
	}

	/**
	 * Tests the {@link RestGetControllerMvc} {@code getAction} method when passed a
	 * {@code name} of a related {@link Action} of a related {@link Animal} object
	 * that does not match in an existing {@link Game} object.
	 * <p>
	 * Test performs the appropriate {@code GET} request to call the
	 * {@code getAAction} endpoint and expects the response status to be
	 * {@code NOT_FOUND}. Test then verifies that the {@link GameService}
	 * {@code getAction} method was called.
	 * 
	 * @throws Exception
	 */
	@Test
	void getActionTest_ActionDoesNotExist() throws Exception {

		when(this.gameService.getAction(this.titleURI, this.animalName, "invalid"))
				.thenThrow(NoSuchElementException.class);

		String path = this.baseURI + "/" + this.titleURI + "/" + this.animalName + "/invalid";
		RequestBuilder request = MockMvcRequestBuilders.get(path);

		this.mockMvc.perform(request).andExpect(status().isNotFound());

		verify(this.gameService).getAction(this.titleURI, this.animalName, "invalid");
	}
}
