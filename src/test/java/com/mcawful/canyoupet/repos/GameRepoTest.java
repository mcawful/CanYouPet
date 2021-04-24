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
import com.mcawful.canyoupet.views.ActionView;
import com.mcawful.canyoupet.views.AnimalView;
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
	 * Sets up the required objects for the tests and saves the {@link Game} object
	 * to the mocked repository.
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

		assertEquals(this.game, returned);
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
	 * Test asserts that the {@code getByAnimalName} method of the
	 * {@link AnimalView} object from the returned {@link Optional} returns the
	 * expected {@link Animal} object and that the {@link Optional} does not throw a
	 * {@link NoSuchElementException}.
	 * 
	 * @throws Exception
	 */
	@Test
	void findByTitleURIAndAnimals_NameTest_GameExists() throws Exception {
		Animal returned = new Animal();

		try {
			returned = this.gameRepo.findByTitleURIAndAnimals_Name(this.titleURI, this.animalName)
					.orElseThrow(NoSuchElementException::new).getAnimalByName(animalName);

		} catch (NoSuchElementException e) {
			fail("A NoSuchElementException was thrown when no exception was expected to be thrown");
		}

		assertEquals(this.animal, returned);
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
		Optional<AnimalView> returned = this.gameRepo.findByTitleURIAndAnimals_Name(this.titleURI, "invalid");

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
	 * Test asserts that the {@code getActionByAnimalNameAndActionName} method of
	 * the {@link ActionView} object from the returned {@link Optional} returns the
	 * expected {@link Action} object and that the {@link Optional} does not throw a
	 * {@link NoSuchElementException}.
	 * 
	 * @throws Exception
	 */
	@Test
	void findByTitleURIAndAnimals_NameAndAnimals_Actions_NameTest_GameExists() throws Exception {
		Action returned = new Action();

		try {
			returned = this.gameRepo
					.findByTitleURIAndAnimals_NameAndAnimals_Actions_Name(this.titleURI, this.animalName,
							this.actionName)
					.orElseThrow(NoSuchElementException::new)
					.getActionByAnimalNameAndActionName(animalName, actionName);

		} catch (NoSuchElementException e) {
			fail("A NoSuchElementException was thrown when no exception was expected to be thrown");
		}

		assertEquals(this.action, returned);
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
		Optional<ActionView> returned = this.gameRepo
				.findByTitleURIAndAnimals_NameAndAnimals_Actions_Name(this.titleURI, this.animalName, "invalid");

		assertThrows(NoSuchElementException.class, () -> returned.orElseThrow(NoSuchElementException::new));
	}
}
