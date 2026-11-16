import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Nicholas Song
 *  @version Nov 9, 2026
 */
class CookingTest
{
    //~ Fields ................................................................

    private cookingClass cooking;
    private PQueue<Order> queue;
    private Order firstOrder;
    private Order secondOrder;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture before each test method.
     * 
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp()
        throws Exception
    {
        cooking = new cookingClass();
        queue = new PQueue<>();

        firstOrder = new FoodOrder();
        firstOrder.addOrder("Alice", "Cheeseburger");

        secondOrder = new FoodOrder();
        secondOrder.addOrder("Bob", "Deluxe Burger");
    }


    //~Public  Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Test method for {@link Cooking#cookNextOrder(PQueue)}.
     * Verifies that currentOrder matches the polled item from the queue
     * and that isBusy updates to true.
     */
    @Test
    void testCookNextOrder()
    {
        queue.offer(firstOrder);
        queue.offer(secondOrder);

        Order expectedOrder = queue.peek();
        cooking.cookNextOrder(queue);

        assertEquals(expectedOrder, cooking.getCurrentOrder());
        assertTrue(cooking.checkStatus());
        assertEquals(1, queue.size());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link Cooking#cookNextOrder(PQueue)}.
     * Verifies correct handling when the passed queue is empty or null.
     */
    @Test
    void testCookNextOrderEmptyQueue()
    {
        cooking.cookNextOrder(queue);

        assertNull(cooking.getCurrentOrder());
        assertFalse(cooking.checkStatus());

        cooking.cookNextOrder(null);

        assertNull(cooking.getCurrentOrder());
        assertFalse(cooking.checkStatus());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link Cooking#finishOrder()}.
     * Verifies that the returned order matches currentOrder, currentOrder
     * is set to null afterward, and isBusy updates to false.
     */
    @Test
    void testFinishOrder()
    {
        queue.offer(firstOrder);
        cooking.cookNextOrder(queue);

        Order finished = cooking.finishOrder();

        assertEquals(firstOrder, finished);
        assertNull(cooking.getCurrentOrder());
        assertFalse(cooking.checkStatus());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link Cooking#checkStatus()}.
     * Checks both true and false cases for the kitchen status.
     */
    @Test
    void testCheckStatus()
    {
        assertFalse(cooking.checkStatus());

        queue.offer(firstOrder);
        cooking.cookNextOrder(queue);
        assertTrue(cooking.checkStatus());

        cooking.finishOrder();
        assertFalse(cooking.checkStatus());
    }

}
