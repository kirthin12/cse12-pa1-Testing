package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BasketTest {

	public static Collection<Object[]> BAGNUMS =
			Arrays.asList(new Object[][] { {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12} });
	private int bagType;

	public BasketTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Basket{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}
	
	private Basket makeBasket() {
		switch(this.bagType) {
			case 0: return new Basket0();
			case 1: return new Basket1();
			case 2: return new Basket2();
			case 3: return new Basket3();
			case 4: return new Basket4();
			case 5: return new Basket5();
			case 6: return new Basket6();
			case 7: return new Basket7();
			case 8: return new Basket8();
			case 9: return new Basket9();
			case 10: return new Basket10();
			case 11: return new Basket11();
			case 12: return new Basket12();
		}
		return null;
	}
	
	@Test
	public void addedHasCount1() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		assertEquals(1, basketToTest.count());
	}

	@Test
	public void costChecker ()
	{
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo",5);
		basketToTest.addToBasket(i);

		Item j = new Item ("conditioner", 18);
		basketToTest.addToBasket(j);

		Item k = new Item ("Soap", 13);
		basketToTest.addToBasket(k);
		
		assertEquals(36, basketToTest.totalCost());
	}

	@Test
	public void removeSingleItem ()
	{
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo",5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);

		Item j = new Item ("conditioner", 18);
		basketToTest.addToBasket(j);

		Item k = new Item ("Soap", 13);
		basketToTest.addToBasket(k);

		basketToTest.removeFromBasket(i);

		assertEquals (4, basketToTest.count());
		assertEquals (2, basketToTest.countItem(i));
	}

	@Test
	public void removeAll ()
	{
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo",5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);

		Item j = new Item ("conditioner", 18);
		basketToTest.addToBasket(j);

		Item k = new Item ("Soap", 13);
		basketToTest.addToBasket(k);

		basketToTest.removeAllFromBasket(i);

		assertEquals (2, basketToTest.count());
		assertEquals (0, basketToTest.countItem(i));
	}

	@Test
	public void emptyBasket ()
	{
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo",5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);

		Item j = new Item ("conditioner", 18);
		basketToTest.addToBasket(j);

		Item k = new Item ("Soap", 13);
		basketToTest.addToBasket(k);

		basketToTest.empty();

		assertEquals (0, basketToTest.count());
	}

	@Test 
	public void negativeItems ()
	{
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo",5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);

		Item j = new Item ("conditioner", 18);
		basketToTest.addToBasket(j);

		Item k = new Item ("Soap", 13);
		basketToTest.addToBasket(k);

		basketToTest.removeAllFromBasket(i);
		basketToTest.removeFromBasket(i);

		assertEquals (0,basketToTest.countItem(i));
	}

	@Test
	public void duplicateCount ()
	{
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo",5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		assertEquals (3,basketToTest.countItem(i));
	}

	@Test 
	public void addingManyItems ()
	{
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo",5);
		basketToTest.addToBasket(i);

		Item j = new Item ("conditioner", 18);
		basketToTest.addToBasket(j);

		Item k = new Item ("Soap", 13);
		basketToTest.addToBasket(k);

		Item l = new Item ("oranges", 22);
		basketToTest.addToBasket(l);

		Item m = new Item ("medicine", 28);
		basketToTest.addToBasket(m);

		Item n = new Item ("water", 3);
		basketToTest.addToBasket(n);

		assertEquals (6, basketToTest.count());
	}

	@Test
	public void addingNullItem ()
	{
		Basket basketToTest = makeBasket();
		Item i = null;
		basketToTest.addToBasket(i);
		assertEquals (0,basketToTest.count());
	}

	@Test
	public void emptyString ()
	{
		Basket basketToTest = makeBasket();
		Item i = new Item ("", 0);
		basketToTest.addToBasket (i);
		assertEquals(0, basketToTest.count());
	}

	@Test
	public void addingAlotOfItems ()
	{
		Basket basketToTest = makeBasket();
		Item j = new Item ("Jeans", 10);

		for (int i = 0; i < 10000; i++)
		{
			basketToTest.addToBasket(j);
		}
		assertEquals(10000, basketToTest.count());
	}

	@Test
	public void addingManyDuplicates ()
	{
		Basket basketToTest = makeBasket();
		Item j = new Item ("Jeans", 10);
		for (int i = 0; i < 4; i++)
		{
			basketToTest.addToBasket(j);
		}

		Item k = new Item ("Soap", 13);
		basketToTest.addToBasket(k);

		Item l = new Item ("oranges", 22);
		basketToTest.addToBasket(l);

		Item m = new Item ("medicine", 28);
		basketToTest.addToBasket(m);

		Item n = new Item ("water", 3);
		basketToTest.addToBasket(n);

		assertEquals(8, basketToTest.count());
	}

	@Test
	public void testCountItem()
	{
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo",5);
		basketToTest.addToBasket(i);

		Item j = new Item ("conditioner", 18);
		basketToTest.addToBasket(j);

		Item k = new Item ("Soap", 13);
		basketToTest.addToBasket(k);

		Item l = new Item ("oranges", 22);
		basketToTest.addToBasket(l);
		basketToTest.addToBasket(l);
		basketToTest.addToBasket(l);
		basketToTest.addToBasket(l);
		basketToTest.addToBasket(l);

		Item m = new Item ("medicine", 28);
		basketToTest.addToBasket(m);
		basketToTest.addToBasket(m);
		basketToTest.addToBasket(m);

		Item n = new Item ("water", 3);
		basketToTest.addToBasket(n);

		assertEquals(5, basketToTest.countItem(l));
	}

	@Test
	public void testCount ()
	{
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo",5);
		basketToTest.addToBasket(i);

		Item j = new Item ("conditioner", 18);
		basketToTest.addToBasket(j);

		Item k = new Item ("Soap", 13);
		basketToTest.addToBasket(k);

		Item l = new Item ("oranges", 22);
		basketToTest.addToBasket(l);
		basketToTest.addToBasket(l);
		basketToTest.addToBasket(l);
		basketToTest.addToBasket(l);
		basketToTest.addToBasket(l);

		Item m = new Item ("medicine", 28);
		basketToTest.addToBasket(m);
		basketToTest.addToBasket(m);
		basketToTest.addToBasket(m);

		Item n = new Item ("water", 3);
		basketToTest.addToBasket(n);

		assertEquals(12, basketToTest.count());
	}


}
