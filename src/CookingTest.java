import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

// -------------------------------------------------------------------------
/**
 * Test class for cookingClass and its interactive console features.
 * 
 * @author Nicholas Song
 * @version Nov 9, 2026
 */
class CookingTest
{
    private cookingClass kitchen;
    private PQueue<Order> queue;
    private FoodOrder order1;
    private FoodOrder order2;

    @BeforeEach
    void setUp()
    {
        kitchen = new cookingClass();
        queue = new PQueue<>();
        
        order1 = new FoodOrder("Alice", "Burger", false);
        order2 = new FoodOrder("Bob", "Steak", true);
    }

    @Test
    void testInitialState()
    {
        assertFalse(kitchen.checkStatus());
        assertNull(kitchen.getCurrentOrder());
    }

    @Test
    void testCookNextOrder()
    {
        queue.offer(order1);
        queue.offer(order2);

        kitchen.cookNextOrder(queue);
        assertTrue(kitchen.checkStatus());
        assertEquals(order2, kitchen.getCurrentOrder()); // Priority order comes first in PQueue
    }

    @Test
    void testFinishOrder()
    {
        queue.offer(order1);
        kitchen.cookNextOrder(queue);

        Order finished = kitchen.finishOrder();
        assertEquals(order1, finished);
        assertFalse(kitchen.checkStatus());
        assertNull(kitchen.getCurrentOrder());
    }

    @Test
    void testCookWithEmptyQueue()
    {
        kitchen.cookNextOrder(queue);
        assertFalse(kitchen.checkStatus());
        assertNull(kitchen.getCurrentOrder());
    }

    @Test
    void testInteractiveSessionAddAndCheckStatus()
    {
        // Simulates selecting option 1, then option 4 (adding Charlie, Pasta, false), then option 1, then option 5 (exit)
        String simulatedInput = "1\n4\nCharlie\nPasta\nfalse\n1\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        kitchen.runInteractiveSession(queue);

        assertFalse(queue.isEmpty());
    }
}