import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PQueueTest
{
    private PQueue<Integer> queue;

    @BeforeEach
    public void setUp()
    {
        queue = new PQueue<>();
    }


    @Test
    void newQueueIsEmpty()
    {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }


    @Test
    void peekAndPollOnEmptyReturnNull()
    {
        assertNull(queue.peek());
        assertNull(queue.poll());
    }


    @Test
    void offerReturnsTrueWhenThereIsRoom()
    {
        assertTrue(queue.offer(5));
        assertEquals(1, queue.size());
    }


    @Test
    void peekReturnsSmallestWithoutRemoving()
    {
        queue.offer(5);
        queue.offer(1);
        queue.offer(3);

        assertEquals(1, queue.peek());
        assertEquals(3, queue.size());
    }


    @Test
    void pollReturnsItemsInSortedOrder()
    {
        queue.offer(5);
        queue.offer(1);
        queue.offer(8);
        queue.offer(3);

        assertEquals(1, queue.poll());
        assertEquals(3, queue.poll());
        assertEquals(5, queue.poll());
        assertEquals(8, queue.poll());
        assertNull(queue.poll());
        assertTrue(queue.isEmpty());
    }


    @Test
    void pollRemovesTheItem()
    {
        queue.offer(2);
        queue.offer(4);

        queue.poll();

        assertEquals(1, queue.size());
        assertEquals(4, queue.peek());
    }

    @Test
    void defaultCapacityIsTen()
    {
        for (int i = 0; i < 10; i++)
        {
            assertTrue(queue.offer(i));
        }
        assertFalse(queue.offer(99));
        assertEquals(10, queue.size());
    }


    @Test
    void canOfferAgainAfterPollMakesRoom()
    {
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }
        assertFalse(queue.offer(99));
 
        queue.poll();
 
        assertTrue(queue.offer(99));
        assertEquals(10, queue.size());
    }

    @Test
    void removeTakesOutASpecificItem()
    {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        assertTrue(queue.remove(2));

        assertEquals(2, queue.size());
        assertEquals(1, queue.poll());
        assertEquals(3, queue.poll());
    }

    @Test
    void removeReturnsFalseWhenItemNotPresent()
    {
        queue.offer(1);

        assertFalse(queue.remove(42));
        assertEquals(1, queue.size());
    }

    @Test
    void clearEmptiesTheQueueAndKeepsCapacity()
    {
        queue.offer(1);
        queue.offer(2);

        queue.clear();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertNull(queue.peek());
        for (int i = 0; i < 10; i++)
        {
            assertTrue(queue.offer(i));
        }
    }

}
