/**
 * 
 */
package com.mcawful.canyoupet.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mcawful.canyoupet.daos.Action;
import com.mcawful.canyoupet.daos.Animal;
import com.mcawful.canyoupet.daos.Game;
import com.mcawful.canyoupet.repos.GameRepo;

/**
 * Tests for the {@link GameServiceImpl} methods.
 * 
 * @author Michael McAuliffe
 *
 */
@SpringBootTest
class GameServiceImplTest {

	@Autowired
	private GameServiceImpl gameService;

	@MockBean
	private GameRepo gameRepo;

	private Game game;

	private Animal animal;

	private Action action;

	private String titleURI;

	private String animalName;

	private String actionName;

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
	 * Sets up the required objects for the tests.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		this.titleURI = "test_game";
		this.animalName = "dog";
		this.actionName = "pet";

		this.action = new Action(this.actionName, true, "http://test.url");
		this.animal = new Animal(this.animalName, Arrays.asList(this.action));
		this.game = new Game(this.titleURI, "Test Game", Arrays.asList(this.animal));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test asserts that the {@link GameServiceImpl} has been instantiated.
	 * 
	 * @throws Exception
	 */
	@Test
	void contextLoads() throws Exception {

		assertThat(this.gameService).isNotNull();
	}

	/**
	 * Tests the {@link GameServiceImpl} {@code getAllGames} method.
	 * <p>
	 * Test verifies that the mocked {@link GameRepo} {@code findAll} method was
	 * called and asserts that the {@link List} of {@link Game} objects matches what
	 * is expected.
	 * 
	 * @throws Exception
	 */
	@Test
	void getAllGamesTest_Success() throws Exception {

		when(this.gameRepo.findAll()).thenReturn(Arrays.asList(game));

		List<Game> returnedGames = this.gameService.getAllGames();

		verify(this.gameRepo).findAll();

		assertEquals(Arrays.asList(game), returnedGames);
	}

	/**
	 * Tests the {@link GameServiceImpl} {@code getGame} method when passed a
	 * {@code titleURI} {@link String} that matches a {@link Game} object.
	 * <p>
	 * Test verifies that the mocked {@link GameRepo} {@code findByTitleURI} method
	 * was called and asserts that the returned {@link Game} object matches what is
	 * expected.
	 * 
	 * @throws Exception
	 */
	@Test
	void getGameTest_GameExists() throws Exception {

		when(this.gameRepo.findByTitleURI(this.titleURI)).thenReturn(Optional.of(game));

		Game returned = this.gameService.getGame(this.titleURI);

		verify(this.gameRepo).findByTitleURI(this.titleURI);

		assertEquals(game, returned);
	}

	/**
	 * Tests the {@link GameServiceImpl} {@code getGame} method when passed a
	 * {@code titleURI} {@link String} that does not match a {@link Game} object.
	 * <p>
	 * Test verifies that the mocked {@link GameRepo} {@code findByTitleURI} method
	 * was called and asserts that a {@link EntityNotFoundException} was thrown.
	 * 
	 * @throws Exception
	 */
	@Test
	void getGameTest_GameDoesNotExists() throws Exception {

		when(this.gameRepo.findByTitleURI("invalid")).thenThrow(EntityNotFoundException.class);

		assertThrows(EntityNotFoundException.class, () -> this.gameService.getGame("invalid"));

		verify(this.gameRepo).findByTitleURI("invalid");
	}

	/**
	 * Tests the {@link GameServiceImpl} {@code getAnimal} method when passed a
	 * {@code titleURI} {@link String} that matches a {@link Game} object and a
	 * {@code name} {@link String} that matches a related {@link Animal} object.
	 * <p>
	 * Test verifies that the mocked {@link GameRepo}
	 * {@code findByTitleURIAndAnimals_Name} method was called and asserts that the
	 * returned {@link Game} object matches what is expected.
	 * 
	 * @throws Exception
	 */
	@Test
	void getAnimalTest_GameExists() throws Exception {

		when(this.gameRepo.findByTitleURIAndAnimals_Name(this.titleURI, this.animalName)).thenReturn(Optional.of(game));

		Animal returned = this.gameService.getAnimal(this.titleURI, this.animalName);

		verify(this.gameRepo).findByTitleURIAndAnimals_Name(this.titleURI, this.animalName);

		assertEquals(this.animal, returned);
	}

	/**
	 * Tests the {@link GameServiceImpl} {@code getAnimal} method when passed a
	 * {@code name} {@link String} that does not match a related {@link Animal}
	 * object to the matching {@link Game} object.
	 * <p>
	 * Test verifies that the mocked {@link GameRepo}
	 * {@code findByTitleURIAndAnimals_Name} method was called and asserts that a
	 * {@link EntityNotFoundException} was thrown.
	 * 
	 * @throws Exception
	 */
	@Test
	void getAnimalTest_GameDoesNotExists() throws Exception {

		when(this.gameRepo.findByTitleURIAndAnimals_Name(this.titleURI, "invalid"))
				.thenThrow(EntityNotFoundException.class);

		assertThrows(EntityNotFoundException.class, () -> this.gameService.getAnimal(this.titleURI, "invalid"));

		verify(this.gameRepo).findByTitleURIAndAnimals_Name(this.titleURI, "invalid");
	}

	/**
	 * Tests the {@link GameServiceImpl} {@code getAction} method when passed a
	 * {@code titleURI} {@link String} that matches a {@link Game} object and a
	 * {@code name} {@link String} that matches a related {@link Animal} object and
	 * a {@code name} {@link String} that matches a related {@link Action} object to
	 * the related {@link Animal} object.
	 * <p>
	 * Test verifies that the mocked {@link GameRepo}
	 * {@code findByTitleURIAndAnimals_NameAndAnimals_Actions_Name} method was
	 * called and asserts that the returned {@link Game} object matches what is
	 * expected.
	 * 
	 * @throws Exception
	 */
	@Test
	void getActionTest_GameExists() throws Exception {

		when(this.gameRepo.findByTitleURIAndAnimals_NameAndAnimals_Actions_Name(this.titleURI, this.animalName,
				this.actionName)).thenReturn(Optional.of(game));

		Action returned = this.gameService.getAction(this.titleURI, this.animalName, this.actionName);

		verify(this.gameRepo).findByTitleURIAndAnimals_NameAndAnimals_Actions_Name(this.titleURI, this.animalName,
				this.actionName);

		assertEquals(this.action, returned);
	}

	/**
	 * Tests the {@link GameServiceImpl} {@code getAction} method when passed a
	 * {@code name} {@link String} that does not match a related {@link Action}
	 * object to the matching {@link Animal} object to the matching {@link Game}
	 * object.
	 * <p>
	 * Test verifies that the mocked {@link GameRepo}
	 * {@code findByTitleURIAndAnimals_NameAndAnimals_Actions_Name} method was
	 * called and asserts that a {@link EntityNotFoundException} was thrown.
	 * 
	 * @throws Exception
	 */
	@Test
	void getActionTest_GameDoesNotExists() throws Exception {

		when(this.gameRepo.findByTitleURIAndAnimals_NameAndAnimals_Actions_Name(this.titleURI, this.animalName,
				"invalid")).thenThrow(EntityNotFoundException.class);

		assertThrows(EntityNotFoundException.class,
				() -> this.gameService.getAction(this.titleURI, this.animalName, "invalid"));

		verify(this.gameRepo).findByTitleURIAndAnimals_NameAndAnimals_Actions_Name(this.titleURI, this.animalName,
				"invalid");
	}
}
