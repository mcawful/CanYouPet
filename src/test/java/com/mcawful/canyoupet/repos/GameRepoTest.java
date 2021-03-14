/**
 * 
 */
package com.mcawful.canyoupet.repos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mcawful.canyoupet.daos.Game;
import com.mcawful.canyoupet.daos.Action;
import com.mcawful.canyoupet.daos.Animal;

/**
 * Tests for the {@link GameRepo} methods.
 * 
 * @author Michael McAuliffe
 *
 */
@SpringBootTest
class GameRepoTest {

	@Autowired
	private GameRepo gameRepo;

	private Game game;

	private Action action;

	private Animal animal;

	private String titleURL;

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
	 * Sets up the {@link Game} object to be used in the tests and saves it to the
	 * {@link GameRepo} repository. The {@link Game} object takes in a {@link List}
	 * of {@link Animal} objects which in turn takes in a {@link List} of
	 * {@link Action} objects, all of which are initialized in the setup.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		this.titleURL = "test_game";

		this.action = new Action(0, "pet", "http://test.url", true);
		this.animal = new Animal(0, "dog", Arrays.asList(this.action));
		this.game = new Game(0, this.titleURL, "Test Game", Arrays.asList(this.animal));

		this.gameRepo.save(this.game);
	}

	/**
	 * Removes the {@link Game} object used in testing from the {@link GameRepo}
	 * repository.
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {

		this.gameRepo.delete(this.game);
	}

	/**
	 * Test asserts that the {@link GameRepo} has been instantiated.
	 * 
	 * @throws Exception
	 */
	@Test
	void contextLoads() throws Exception {

		assertThat(this.gameRepo).isNotNull();
	}

	/**
	 * Tests the {@link GameRepo} <code>findByTitleURL</code> method when passed a
	 * <code>titleURL</code> {@link String} that matches a {@link Game} object in
	 * the repository. Test asserts that the {@link Game} object from the returned
	 * {@link Optional} equals what is expected and that the {@link Optional} does
	 * not throw a {@link NoSuchElementException}.
	 */
	@Test
	void findByTitleURLTest_GameExists() {

		Game returned = this.gameRepo.findByTitleURL(this.titleURL).orElseThrow(NoSuchElementException::new);

		assertEquals(this.game.toString(), returned.toString());
	}

	/**
	 * Tests the {@link GameRepo} <code>findByTitleURL</code> method when passed a
	 * <code>titleURL</code> {@link String} that does not match a {@link Game}
	 * object in the repository. Test asserts that a {@link NoSuchElementException}
	 * is thrown from the returned {@link Optional}.
	 */
	@Test
	void findByTitleURLTest_GameDoesNotExist() {

		Optional<Game> returned = this.gameRepo.findByTitleURL("invalid");

		assertThrows(NoSuchElementException.class, () -> returned.orElseThrow(NoSuchElementException::new));

	}
}
