/**
 * 
 */
package com.mcawful.canyoupet.test.repo;

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
import org.springframework.test.context.ActiveProfiles;

import com.mcawful.canyoupet.dao.Action;
import com.mcawful.canyoupet.dao.Animal;
import com.mcawful.canyoupet.dao.Game;
import com.mcawful.canyoupet.dao.Source;
import com.mcawful.canyoupet.repo.GameRepo;

/**
 * Tests for the {@link GameRepo} methods.
 * 
 * @author Michael McAuliffe
 *
 */
@SpringBootTest
@ActiveProfiles("test")
class GameRepoTest {

	private GameRepo gameRepo;

	private Game game;

	private Animal animal;

	private Action action;

	private String titleURI, animalName, actionName, sourceURL;

	@Autowired
	private GameRepoTest(GameRepo gameRepo) {
		super();
		this.gameRepo = gameRepo;
	}

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
	 * Sets up the required objects and saves the {@link Game} entity to the
	 * repository.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		this.titleURI = "test_game";
		this.animalName = "dog";
		this.actionName = "pet";
		this.sourceURL = "http://test.url";

		this.action = new Action(this.actionName, true, new Source(this.sourceURL));
		this.animal = new Animal(this.animalName, Arrays.asList(this.action));
		this.game = new Game(this.titleURI, "Test Game", Arrays.asList(this.animal));

		this.gameRepo.save(this.game);
	}

	/**
	 * Removes the saved {@link Game} and related entities from the repository.
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {

		this.gameRepo.delete(this.game);
	}

	/**
	 * Test asserts that the {@link Autowired} objects have been instantiated.
	 * 
	 * @throws Exception
	 */
	@Test
	void contextLoads() throws Exception {

		assertThat(this.gameRepo).isNotNull();
	}

	/**
	 * Tests the {@link GameRepo} {@code findByTitleURI} method when passed a
	 * {@code titleURI} {@link String} that matches a {@link Game} object in the
	 * repository.
	 * <p>
	 * Test asserts that the {@link Game} object from the returned {@link Optional}
	 * equals what is expected and that the {@link Optional} does not throw a
	 * {@link NoSuchElementException}.
	 * 
	 * @throws Exception
	 */
	@Test
	void findByTitleURITest_GameExists() throws Exception {

		Game returned = new Game();

		try {
			returned = this.gameRepo.findByTitleURI(this.titleURI).orElseThrow(NoSuchElementException::new);

		} catch (NoSuchElementException e) {
			fail("A NoSuchElementException was thrown when no exception was expected to be thrown");
		}

		assertEquals(this.game.toString(), returned.toString());
	}

	/**
	 * Tests the {@link GameRepo} {@code findByTitleURI} method when passed a
	 * {@code titleURI} {@link String} that does not match a {@link Game} object in
	 * the repository.
	 * <p>
	 * Test asserts that a {@link NoSuchElementException} is thrown from the
	 * returned {@link Optional}.
	 * 
	 * @throws Exception
	 */
	@Test
	void findByTitleURITest_GameDoesNotExist() throws Exception {

		Optional<Game> returned = this.gameRepo.findByTitleURI("invalid");

		assertThrows(NoSuchElementException.class, () -> returned.orElseThrow(NoSuchElementException::new));

	}

	/**
	 * Tests the {@link GameRepo} {@code findByTitleURIAndAnimals_Name} method when
	 * passed a {@code titleURI} {@link String} that matches a {@link Game} object
	 * and a {@code name} {@link String} that matches the related {@link Animal}
	 * object in the repository.
	 * <p>
	 * Test asserts that the {@link Game} object from the returned {@link Optional}
	 * equals what is expected and that the {@link Optional} does not throw a
	 * {@link NoSuchElementException}.
	 * 
	 * @throws Exception
	 */
	@Test
	void findByTitleURIAndAnimals_NameTest_GameExists() throws Exception {

		Game returned = new Game();

		try {
			returned = this.gameRepo.findByTitleURIAndAnimals_Name(this.titleURI, this.animalName)
					.orElseThrow(NoSuchElementException::new);

		} catch (NoSuchElementException e) {
			fail("A NoSuchElementException was thrown when no exception was expected to be thrown");
		}

		assertEquals(this.game.toString(), returned.toString());
	}

	/**
	 * Tests the {@link GameRepo} {@code findByTitleURIAndAnimals_Name} method when
	 * passed a {@code name} {@link String} that does not match an {@link Animal}
	 * object in the related {@link Game} object in the repository.
	 * <p>
	 * Test asserts that a {@link NoSuchElementException} is thrown from the
	 * returned {@link Optional}.
	 * 
	 * @throws Exception
	 */
	@Test
	void findByTitleURIAndAnimals_NameTest_GameDoesNotExist() throws Exception {

		Optional<Game> returned = this.gameRepo.findByTitleURIAndAnimals_Name(this.titleURI, "invalid");

		assertThrows(NoSuchElementException.class, () -> returned.orElseThrow(NoSuchElementException::new));
	}

	/**
	 * Tests the {@link GameRepo}
	 * {@code findByTitleURIAndAnimals_NameAndAnimals_Actions_Name} method when
	 * passed a {@code titleURI} {@link String} that matches a {@link Game} object
	 * and a {@code name} {@link String} that matches the related {@link Animal}
	 * object and a {@code name} {@link String} that matches the related
	 * {@link Animal} object's related {@link Action} object in the repository.
	 * <p>
	 * Test asserts that the {@link Game} object from the returned {@link Optional}
	 * equals what is expected and that the {@link Optional} does not throw a
	 * {@link NoSuchElementException}.
	 * 
	 * @throws Exception
	 */
	@Test
	void findByTitleURIAndAnimals_NameAndAnimals_Actions_NameTest_GameExists() throws Exception {

		Game returned = new Game();

		try {
			returned = this.gameRepo.findByTitleURIAndAnimals_NameAndAnimals_Actions_Name(this.titleURI,
					this.animalName, this.actionName).orElseThrow(NoSuchElementException::new);

		} catch (NoSuchElementException e) {
			fail("A NoSuchElementException was thrown when no exception was expected to be thrown");
		}

		assertEquals(this.game.toString(), returned.toString());
	}

	/**
	 * Tests the {@link GameRepo}
	 * {@code findByTitleURIAndAnimals_NameAndAnimals_Actions_Name} method when
	 * passed a {@code name} {@link String} that does not match an {@link Action}
	 * object in the related {@link Animal} object in the related {@link Game}
	 * object in the repository.
	 * <p>
	 * Test asserts that a {@link NoSuchElementException} is thrown from the
	 * returned {@link Optional}.
	 * 
	 * @throws Exception
	 */
	@Test
	void findByTitleURIAndAnimals_NameAndAnimals_Actions_NameTest_GameDoesNotExist() throws Exception {

		Optional<Game> returned = this.gameRepo.findByTitleURIAndAnimals_NameAndAnimals_Actions_Name(this.titleURI,
				this.animalName, "invalid");

		assertThrows(NoSuchElementException.class, () -> returned.orElseThrow(NoSuchElementException::new));
	}
}
