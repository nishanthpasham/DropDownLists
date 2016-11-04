package com.book.chap3.AnimalShelter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AnimalShelterTest {
	
	AnimalShelter<Animal> animalShelter = null;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
//	new RuntimeException("No more Dogs in the Animal Shelter!");
//	public RuntimeException noCatException = new RuntimeException("No more Cats in the Animal Shelter!");

	@Before
	public void setUp() throws Exception {
		animalShelter = new AnimalShelter<>();
		
		/*for(int i=0; i<10; i++) {
			Random random = new Random();
			animalShelter.enqueue(random.nextBoolean() ? new Dog() : new Cat());
			random.nextBoolean();
		}*/
		animalShelter.enqueue(new Dog());
		animalShelter.enqueue(new Dog());
		animalShelter.enqueue(new Cat());
		animalShelter.enqueue(new Dog());
		animalShelter.enqueue(new Cat());
		animalShelter.enqueue(new Cat());
		animalShelter.enqueue(new Dog());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEnqueue() {
		assertEquals(animalShelter.dequeueAny().getClass(), Dog.class);
		assertEquals(animalShelter.dequeueAny().getClass(), Dog.class);
		assertEquals(animalShelter.dequeueAny().getClass(), Cat.class);
	}

	@Test
	public void testDequeueAny() {
		assertEquals(animalShelter.dequeueAny().getClass(), Dog.class);
		assertEquals(animalShelter.dequeueAny().getClass(), Dog.class);
		assertEquals(animalShelter.dequeueAny().getClass(), Cat.class);
		assertEquals(animalShelter.dequeueAny().getClass(), Dog.class);
		assertEquals(animalShelter.dequeueAny().getClass(), Cat.class);
		assertEquals(animalShelter.dequeueAny().getClass(), Cat.class);
		assertEquals(animalShelter.dequeueAny().getClass(), Dog.class);
	}

	@Test
	public void testDequeueDog() {
		assertEquals(animalShelter.dequeueDog().getClass(), Dog.class);
		assertEquals(animalShelter.dequeueDog().getClass(), Dog.class);
		assertEquals(animalShelter.dequeueDog().getClass(), Dog.class);
		assertEquals(animalShelter.dequeueDog().getClass(), Dog.class);
	}

	@Test
	public void testDequeueCat() {
		assertEquals(animalShelter.dequeueCat().getClass(), Cat.class);
		assertEquals(animalShelter.dequeueCat().getClass(), Cat.class);
		assertEquals(animalShelter.dequeueCat().getClass(), Cat.class);
	}
	
	@Test
	public void testShouldThrowDogNotFoundError() throws Exception {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("No more Dogs in the Animal Shelter!");
		
		animalShelter.dequeueDog();
		animalShelter.dequeueDog();
		animalShelter.dequeueDog();
		animalShelter.dequeueDog();
		animalShelter.dequeueDog();
	}
	
	@Test
	public void testShouldThrowCatNotFoundError() throws Exception {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("No more Cats in the Animal Shelter!");
		
		animalShelter.dequeueCat();
		animalShelter.dequeueCat();
		animalShelter.dequeueCat();
		animalShelter.dequeueCat();
		
	}

}
