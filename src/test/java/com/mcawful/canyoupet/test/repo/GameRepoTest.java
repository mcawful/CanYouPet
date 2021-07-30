/**
 *
 */
package com.mcawful.canyoupet.test.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

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
import com.mcawful.canyoupet.dao.ActionName;
import com.mcawful.canyoupet.dao.Animal;
import com.mcawful.canyoupet.dao.AnimalName;
import com.mcawful.canyoupet.dao.Game;
import com.mcawful.canyoupet.dao.Source;
import com.mcawful.canyoupet.repo.GameRepo;

// TODO: Rewrite Javadocs

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

	private String title, titleURI, animalName, actionName, sourceURL;

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

		this.title = "Test Game";
		this.titleURI = "test_game";
		this.animalName = "dog";
		this.actionName = "pet";
		this.sourceURL = "http://test.url";

		this.action = Action.builder().actionName(ActionName.builder().name(this.actionName).build()).canYou(true)
				.source(Source.builder().url(this.sourceURL).build()).build();
		this.animal = Animal.builder().animalName(AnimalName.builder().name(this.animalName).build())
				.actions(Arrays.asList(this.action)).build();
		this.game = Game.builder().title(this.title).titleURI(this.titleURI).animals(Arrays.asList(this.animal))
				.build();

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
	void findByTitleURITest_EntityExists() throws Exception {

		Game returned = new Game();

		try {
			returned = this.gameRepo.findByTitleURI(this.titleURI) .orElseThrow(NoSuchElementException::new);

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
	void findByTitleURITest_EntityDoesNotExist() throws Exception {

		Optional<Game> returned = this.gameRepo.findByTitleURI("invalid");

		assertThrows(NoSuchElementException.class, () -> returned.orElseThrow(NoSuchElementException::new));

	}

	/**
	 * Tests the {@link GameRepo} {@code findByTitleURIAndAnimalName} method when
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
	void findByTitleURIAndAnimalNameTest_EntityExists() throws Exception {

		Animal returned = new Animal();

		try {
			returned = this.gameRepo.findByTitleURIAndAnimalName(this.titleURI, this.animalName)
					.orElseThrow(NoSuchElementException::new);

		} catch (NoSuchElementException e) {
			fail("A NoSuchElementException was thrown when no exception was expected to be thrown");
		}

		assertEquals(this.animal.toString(), returned.toString());
	}

	/**
	 * Tests the {@link GameRepo} {@code findByTitleURIAndAnimalName} method when
	 * passed a {@code name} {@link String} that does not match an {@link Animal}
	 * object in the related {@link Game} object in the repository.
	 * <p>
	 * Test asserts that a {@link NoSuchElementException} is thrown from the
	 * returned {@link Optional}.
	 *
	 * @throws Exception
	 */
	@Test
	void findByTitleURIAndAnimalNameTest_EntityDoesNotExist() throws Exception {

		Optional<Animal> returned = this.gameRepo.findByTitleURIAndAnimalName(this.titleURI, "invalid");

		assertThrows(NoSuchElementException.class, () -> returned.orElseThrow(NoSuchElementException::new));
	}

	/**
	 * Tests the {@link GameRepo} {@code findByTitleURIAndAnimalNameAndActionName}
	 * method when passed a {@code titleURI} {@link String} that matches a
	 * {@link Game} object and a {@code name} {@link String} that matches the
	 * related {@link Animal} object and a {@code name} {@link String} that matches
	 * the related {@link Animal} object's related {@link Action} object in the
	 * repository.
	 * <p>
	 * Test asserts that the {@link Game} object from the returned {@link Optional}
	 * equals what is expected and that the {@link Optional} does not throw a
	 * {@link NoSuchElementException}.
	 *
	 * @throws Exception
	 */
	@Test
	void findByTitleURIAndAnimalNameAndActionNameTest_EntityExists() throws Exception {

		Action returned = new Action();

		try {
			returned = this.gameRepo
					.findByTitleURIAndAnimalNameAndActionName(this.titleURI, this.animalName, this.actionName)
					.orElseThrow(NoSuchElementException::new);

		} catch (NoSuchElementException e) {
			fail("A NoSuchElementException was thrown when no exception was expected to be thrown");
		}

		assertEquals(this.action.toString(), returned.toString());
	}

	/**
	 * Tests the {@link GameRepo} {@code findByTitleURIAndAnimalNameAndActionName}
	 * method when passed a {@code name} {@link String} that does not match an
	 * {@link Action} object in the related {@link Animal} object in the related
	 * {@link Game} object in the repository.
	 * <p>
	 * Test asserts that a {@link NoSuchElementException} is thrown from the
	 * returned {@link Optional}.
	 *
	 * @throws Exception
	 */
	@Test
	void findByTitleURIAndAnimalAndActionNameTest_EntityDoesNotExist() throws Exception {

		Optional<Action> returned = this.gameRepo.findByTitleURIAndAnimalNameAndActionName(this.titleURI,
				this.animalName, "invalid");

		assertThrows(NoSuchElementException.class, () -> returned.orElseThrow(NoSuchElementException::new));
	}
}
