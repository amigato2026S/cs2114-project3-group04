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

/**
 *  This is the order class that arranged the food and stores them in an order
 *  to be used by the priority queue. 
 * 
 *  @author Armaan
 *  @version Nov 8, 2026
 */
import java.time.Duration;

import java.util.ArrayList;

/**
 * Order interface with explicitly scoped public methods 
 * matching the project specification tables.
 */
public interface Order extends Comparable<Order> {

    /**
     * Adds the order by customer name and the recipe to the order.
     * 
     * @param customerName the name of the customer placing the order
     * @param recipe the recipe or food items associated with the order
     */
    public void addOrder(String customerName, String recipe);

    /**
     * Follows the action of adding the order so the order can be finished 
     * and the queue can move on.
     * 
     * @return true if the order was successfully served, false otherwise
     */
    public boolean serveOrder();

    /**
     * Gets the order name and order recipe centered at the chosen index.
     * 
     * @param index the position in the collection to retrieve
     * @return a String description of the order at the specified index
     */
    public String getOrder(int index);

    /**
     * Sets the order name and the recipe of the order to the back.
     * 
     * @param customerName the updated or back-positioned customer name
     * @param recipe the updated recipe string
     */
    public void setOrder(String customerName, String recipe);

    /**
     * Removes the order values at the specific index and returns 
     * the queue shortened by one index.
     * 
     * @param index the index of the order to remove
     * @return the Order object that was removed
     */
    public Order removeOrder(int index);

    /**
     * Shows the customer name for the order.
     * 
     * @return String representing the customer's name
     */
    public String getCustomerName();

    /**
     * Returns the list of items/toppings associated with the order.
     * 
     * @return an ArrayList of String items
     */
    public ArrayList<String> getOrderList();

    /**
     * Shows the time left for the order using java.time.Duration.
     * 
     * @return a Duration object representing the remaining time
     */
    public Duration getTimeLeft();

    /**
     * Determines if the particular order needs to be made first or if it 
     * can wait.
     * 
     * @return true if it's a priority order, false otherwise
     */
    public boolean isPriority();

    /**
     * Implements Comparable to allow the Priority Queue to sort and prioritize 
     * orders.
     * 
     * @param other the other Order object to compare against
     * @return a negative integer, zero, or a positive integer as this order is 
     * less than, equal to, or greater than the specified order
     */
    @Override
    public int compareTo(Order other);
}
