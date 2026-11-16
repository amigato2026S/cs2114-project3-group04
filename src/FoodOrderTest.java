// Virginia Tech Honor Code Pledge:


//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- Armaan Ali (amali052024)
//
// LLM Statement:
// I have not used any assistance for the assignment beyond course 
// resources and staff.

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *  This is the testing class that tests all the methods for order class.
 * 
 *  @author Armaan
 *  @version Nov 8, 2026
 */
class FoodOrderTest
{
    //~ Fields ................................................................
        private FoodOrder order1;


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp()
        throws Exception
    {
        order1 = new FoodOrder("Carl", "rice", false);
    }
    
    /**
     * Test method for FoodOrder}.
     */
    @Test
    void testFoodOrder()
    {
        assertEquals("Carl", order1.getCustomerName());
        assertEquals("rice", order1.getRecipe());
        assertEquals(false, order1.isPriority());
    }


    /**
     * Test method for Adding the order. 
     */
    @Test
    void testAddOrder()
    {
        order1.addOrder("Bob", "Bacon Burger");
        assertEquals("Bob", order1.getCustomerName());
        assertEquals("Bacon Burger", order1.getRecipe());
    }


    /**
     * Test method for serving the order.
     */
    @Test
    void testServeOrder()
    {
        order1.addOrder("Bob", "Bacon Burger");
        assertEquals(true, order1.serveOrder());
    }


    /**
     * Test method for getting the order .
     */
    @Test
    void testGetOrder()
    {
        order1.addOrder("Bob", "Bacon Burger");
        order1.addOrder("Tim", "Cheese Burger");
        assertEquals("Customer: Tim, Recipe: Cheese Burger",
            order1.getOrder(1));
    }


    /**
     * Test method for setting the order.
     */
    @Test
    void testSetOrder()
    {
        order1.setOrder("Charlie", "Veggie Burger");
        assertEquals("Charlie", order1.getCustomerName());
        assertEquals("Veggie Burger", order1.getRecipe());
    }


    /**
     * Test method for removing the order.
     */
    @Test
    void testRemoveOrder()
    {
        order1.addOrder("Tim", "Cheese Burger");
        assertEquals(order1, order1.removeOrder(0));
    }


    /**
     * Test method for getting the customer name.
     */
    @Test
    void testGetCustomerName()
    {
        order1.setOrder("Charlie", "Veggie Burger");
        assertEquals("Charlie", order1.getCustomerName());
        order1.setOrder("Tyrese", "Cheese Burger");
        assertEquals("Tyrese", order1.getCustomerName());
    }

    /**
     * Test method for getting the time left. 
     */
    @Test
    void testGetTime()
    {
        
        FoodOrder order = new FoodOrder("Alice", "Cheeseburger", false);

        Duration timeElapsed = order.getTime();

        assertEquals(false, timeElapsed.toSeconds() > 0);
            
    }


    /**
     * Test method for finding out if it goes in priority queue.
     */
    @Test
    void testIsPriority()
    {
        FoodOrder order = new FoodOrder("Alice", "Cheeseburger", true);
        assertEquals(true, order.isPriority());
    }


    /**
     * Test method for comparing orders.
     */
    @Test
    void testCompareTo()
    {
        FoodOrder order2 = new FoodOrder("Alex", "Truffle", true);
        assertEquals(false, order1.compareTo(order2) < 0); 
        assertEquals(false, order2.compareTo(order1) > 0); 
        assertEquals(2, order1.compareTo(new FoodOrder("Alice", "Salad", false)));
    }
    /**
     * Test method for toString.
     */
    @Test
    void testToString()
    {
        FoodOrder order2 = new FoodOrder("Alex", "Truffle", true);
        assertEquals("FoodOrder [Customer=Alex, Recipe=Truffle, Priority=true]" 
            , order2.toString()); 
    }


}
