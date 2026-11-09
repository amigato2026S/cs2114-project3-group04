import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;

public class CookingTest {

    private Cooking cooking;
    private PQueue queue;
    private Order highPriorityOrder;
    private Order regularOrder;

    /**
     * Simple stub implementation of the Order interface for testing.
     * You can replace TestOrder with your concrete Order class if preferred.
     */
    private static class TestOrder implements Order {
        private final String name;
        private final boolean priority;
        private final Duration timeLeft;

        public TestOrder(String name, boolean priority, Duration timeLeft) {
            this.name = name;
            this.priority = priority;
            this.timeLeft = timeLeft;
        }

        @Override
        public boolean isPriority() {
            return this.priority;
        }

        public Duration getTimeLeft() {
            return this.timeLeft;
        }

        @Override
        public int compareTo(Order other) {
            if (this.isPriority() != other.isPriority()) {
                return this.isPriority() ? -1 : 1;
            }
            return 0;
        }
    }

    @BeforeEach
    public void setUp() {
        cooking = new Cooking();
        queue = new PQueue();
        highPriorityOrder = new TestOrder("VIP Burger", true, Duration.ofMinutes(5));
        regularOrder = new TestOrder("Fries", false, Duration.ofMinutes(10));
    }

    // -------------------------------------------------------------------------
    // cookNextOrder(PQueue queue) Tests
    // -------------------------------------------------------------------------

    @Test
    public void testCookNextOrderSetsCurrentOrderAndBusyToTrue() {
        // Replace .add() if your PQueue uses insert(), enqueue(), or offer()
        queue.add(regularOrder);
        queue.add(highPriorityOrder);

        cooking.cookNextOrder(queue);

        // 1. Make sure currentOrder correctly matches the polled item from the queue
        assertEquals(highPriorityOrder, cooking.getCurrentOrder(),
                "currentOrder should match the highest-priority polled item from the queue.");

        // 2. Make sure isBusy updates to true
        assertTrue(cooking.checkStatus(),
                "isBusy should update to true after pulling an order.");
    }

    @Test
    public void testCookNextOrderWithEmptyQueue() {
        // 3. Correct handling when the passed queue is empty
        cooking.cookNextOrder(queue);

        assertNull(cooking.getCurrentOrder(),
                "currentOrder should remain null when cooking from an empty queue.");
        assertFalse(cooking.checkStatus(),
                "isBusy should remain false when the passed queue is empty.");
    }

    // -------------------------------------------------------------------------
    // finishOrder() Tests
    // -------------------------------------------------------------------------

    @Test
    public void testFinishOrderReturnsOrderAndResetsState() {
        queue.add(highPriorityOrder);
        cooking.cookNextOrder(queue);

        Order finished = cooking.finishOrder();

        // 1. Make sure the returned order matches the currentOrder
        assertEquals(highPriorityOrder, finished,
                "finishOrder() should return the order that was being cooked.");

        // 2. Make sure currentOrder is set to null afterward
        assertNull(cooking.getCurrentOrder(),
                "currentOrder should be set to null after finishing the order.");

        // 3. Make sure isBusy updates to false
        assertFalse(cooking.checkStatus(),
                "isBusy should update to false after finishing the order.");
    }

    // -------------------------------------------------------------------------
    // checkStatus() Tests
    // -------------------------------------------------------------------------

    @Test
    public void testCheckStatusTrueAndFalseCases() {
        // False case: Initially not busy
        assertFalse(cooking.checkStatus(),
                "checkStatus() should return false when no order is active.");

        // True case: Busy while cooking an order
        queue.add(regularOrder);
        cooking.cookNextOrder(queue);
        assertTrue(cooking.checkStatus(),
                "checkStatus() should return true while an order is being cooked.");

        // False case: Back to false after finishing the order
        cooking.finishOrder();
        assertFalse(cooking.checkStatus(),
                "checkStatus() should return false after the current order is finished.");
    }
}
