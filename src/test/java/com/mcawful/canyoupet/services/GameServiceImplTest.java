/**
 * 
 */
package com.mcawful.canyoupet.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
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
	 * Sets up the {@link Game} object to be used in the tests. The {@link Game}
	 * object takes in a {@link List} of {@link Animal} objects which in turn takes
	 * in a {@link List} of {@link Action} objects, all of which are initialized in
	 * the setup.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		this.titleURI = "test_game";

		this.action = new Action("pet", true, "http://test.url");
		this.animal = new Animal("dog", Arrays.asList(this.action));
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
	 * Tests the {@link GameServiceImpl} {@code findByTitleURI} when passed a
	 * {@code titleURI} {@link String} that matches a {@link Game} object. Test
	 * verifies that the {@link GameRepo} {@code findByTitleURI} method was called
	 * and asserts that the returned {@link Game} object matches what is expected.
	 */
	@Test
	void retrieveGameByTitleURITest_GameExists() {

		when(this.gameRepo.findByTitleURI(this.titleURI)).thenReturn(Optional.of(game));

		Game returned = this.gameService.retrieveGameByTitleURI(this.titleURI);

		verify(this.gameRepo).findByTitleURI(this.titleURI);

		assertEquals(game.toString(), returned.toString());
	}

	/**
	 * Tests the {@link GameServiceImpl} {@code findByTitleURI} when passed a
	 * {@code titleURI} {@link String} that does not match a {@link Game} object.
	 * Test verifies that the {@link GameRepo} {@code findByTitleURI} method was
	 * called and asserts that a {@link EntityNotFoundException} was thrown.
	 */
	@Test
	void retrieveGameByTitleURITest_GameDoesNotExists() {

		when(this.gameRepo.findByTitleURI("invalid")).thenThrow(EntityNotFoundException.class);

		assertThrows(EntityNotFoundException.class, () -> this.gameService.retrieveGameByTitleURI("invalid"));

		verify(this.gameRepo).findByTitleURI("invalid");
	}

}
