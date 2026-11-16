import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;

// -------------------------------------------------------------------------
/**
 * Test class for cookingClass and its interactive console features.
 * 
 * @author Nicholas Song
 * @version Nov 9, 2026
 */
public class CookingTest
{
    private cookingClass kitchen;
    private PQueue<Order> queue;
    private Order order1;
    private Order order2;

    @Before
    public void setUp()
    {
        kitchen = new cookingClass();
        queue = new PQueue<Order>();
        // Using FoodOrder concrete implementation
        order1 = new FoodOrder("Burger", 1);
        order2 = new FoodOrder("Steak", 5);
    }

    @Test
    public void testInitialState()
    {
        assertFalse(kitchen.checkStatus());
        assertNull(kitchen.getCurrentOrder());
    }

    @Test
    public void testCookNextOrder()
    {
        queue.add(order1);
        queue.add(order2);

        kitchen.cookNextOrder(queue);
        assertTrue(kitchen.checkStatus());
        assertEquals(order1, kitchen.getCurrentOrder());
    }

    @Test
    public void testFinishOrder()
    {
        queue.add(order1);
        kitchen.cookNextOrder(queue);

        Order finished = kitchen.finishOrder();
        assertEquals(order1, finished);
        assertFalse(kitchen.checkStatus());
        assertNull(kitchen.getCurrentOrder());
    }

    @Test
    public void testCookWithEmptyQueue()
    {
        kitchen.cookNextOrder(queue);
        assertFalse(kitchen.checkStatus());
        assertNull(kitchen.getCurrentOrder());
    }

    @Test
    public void testInteractiveSessionAddAndCheckStatus()
    {
        String simulatedInput = "1\n4\nSalad\n2\n1\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        kitchen.runInteractiveSession(queue);

        assertFalse(queue.isEmpty());
    }
}