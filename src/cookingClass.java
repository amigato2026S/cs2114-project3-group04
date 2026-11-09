// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Nicholas Song
 *  @version Nov 9, 2026
 */
public class cookingClass
{
    //~ Fields ................................................................

    private Order currentOrder;
    private boolean isBusy;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a new Cooking object with no active order and isBusy set to false.
     */
    public cookingClass()
    {
        this.currentOrder = null;
        this.isBusy = false;
    }


    //~Public  Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Pulls the highest priority order from the queue and sets it as the
     * active currentOrder, changing isBusy to true.
     * 
     * @param queue the priority queue of pending orders
     */
    public void cookNextOrder(PQueue<Order> queue)
    {
        if (queue == null || queue.isEmpty())
        {
            return;
        }

        Order nextOrder = queue.poll();
        if (nextOrder != null)
        {
            this.currentOrder = nextOrder;
            this.isBusy = true;
        }
    }


    // ----------------------------------------------------------
    /**
     * Completes the current order, returns the finished Order object,
     * sets currentOrder to null, and sets isBusy back to false.
     * 
     * @return the completed Order object, or null if no order was active
     */
    public Order finishOrder()
    {
        Order finished = this.currentOrder;
        this.currentOrder = null;
        this.isBusy = false;
        return finished;
    }


    // ----------------------------------------------------------
    /**
     * Returns the current boolean value of isBusy to let the system know
     * if the kitchen can take a new order.
     * 
     * @return true if the kitchen is busy cooking an order, false otherwise
     */
    public boolean checkStatus()
    {
        return this.isBusy;
    }


    // ----------------------------------------------------------
    /**
     * Returns the currently active order being cooked in the kitchen.
     * 
     * @return the current Order, or null if the kitchen is idle
     */
    public Order getCurrentOrder()
    {
        return this.currentOrder;
    }

}