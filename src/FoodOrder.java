import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
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
 *  Actual Implementation of the Ordering process. 
 * 
 *  @author Armaan
 *  @version Nov 8, 2026
 */
public class FoodOrder
    implements Order
{

    private String customerName;
    private String recipe;
    private boolean isPriority;
    private Instant startTime;
    private Duration elapsedTime;


    // ----------------------------------------------------------
    /**
     * Create a new FoodOrder object.
     * @param customerName for customer name
     * @param recipe for recipe of name
     * @param isPriority for what is a priority of the line.
     */
    public FoodOrder(String customerName, String recipe, boolean isPriority)
    {
        this.customerName = customerName;
        this.recipe = recipe;
        this.isPriority = isPriority;
        this.startTime = Instant.now();
    }


    // ----------------------------------------------------------
    /**
     * Adds the order by customer name and the recipe to the order.
     * 
     * @param customerName the name of the customer placing the order
     * @param recipe the recipe or food items associated with the order
     */
    @Override
    public void addOrder(String customerName, String recipe)
    {
        this.customerName = customerName;
        this.recipe = recipe;
    }


    // ----------------------------------------------------------
    /**
     * Follows the action of adding the order so the order can be finished 
     * and the queue can move on.
     * 
     * @return true if the order was successfully served, false otherwise
     */
    @Override
    public boolean serveOrder()
    {
        return true;
    }


    // ----------------------------------------------------------
    /**
     * Gets the order name and order recipe centered at the chosen index.
     * 
     * @param index the position in the collection to retrieve
     * @return a String description of the order at the specified index
     */
    @Override
    public String getOrder(int index)
    {
        return "Customer: " + customerName + ", Recipe: " + recipe;
    }


    // ----------------------------------------------------------
    /**
     * Sets the order name and the recipe of the order to the back.
     * 
     * @param customerName the updated or back-positioned customer name
     * @param recipe the updated recipe string
     */
    @Override
    public void setOrder(String customerName, String recipe)
    {
        this.customerName = customerName;
        this.recipe = recipe;
    }


    // ----------------------------------------------------------
    /**
     * Removes the order values at the specific index and returns 
     * the queue shortened by one index.
     * 
     * @param index the index of the order to remove
     * @return the Order object that was removed
     */
    @Override
    public Order removeOrder(int index)
    {
        //You can only remove an order in Main or outside the class. 
        return this;
    }


    // ----------------------------------------------------------
    /**
     * Shows the customer name for the order.
     * 
     * @return String representing the customer's name
     */
    @Override
    public String getCustomerName()
    {
        return this.customerName;
    }


    // ----------------------------------------------------------
    /**
     * Returns the recipe associated with the order.
     * 
     * @return a String of the recipe.
     */
    @Override
    public String getRecipe()
    {
        return this.recipe;
    }


    // ----------------------------------------------------------
    /**
     * Shows the time for the order using java.time.Duration.
     * 
     * @return a Duration object representing the remaining time
     */
    @Override
    public Duration getTime()
    {
        elapsedTime = Duration.between(startTime, Instant.now());
        return elapsedTime;
    }

    // ----------------------------------------------------------
    /**
     * Determines if the particular order needs to be made first or if it 
     * can wait.
     * 
     * @return true if it's a priority order, false otherwise
     */
    @Override
    public boolean isPriority()
    {
        return this.isPriority;
    }


    // ----------------------------------------------------------
    /**
     * Implements Comparable to allow the Priority Queue to sort and prioritize 
     * orders.
     * 
     * @param other the other Order object to compare against
     * @return a negative integer, zero, or a positive integer as this order is 
     * less than, equal to, or greater than the specified order
     */
    @Override
    public int compareTo(Order other)
    {
        if (this.isPriority() && !other.isPriority()){
            return -1;
        }
        else if (!this.isPriority() && other.isPriority()){
            return 1;
        }
        return this.customerName.compareTo(other.getCustomerName());
    }
 // ----------------------------------------------------------
    /**
     * Implements the order as a whole string. 
     * 
     * @return string of the order as a whole string.
     */
    @Override
    public String toString() {
        return "FoodOrder [Customer=" + customerName + ", Recipe=" + recipe + 
               ", Priority=" + isPriority() + "]";
    }
    

}
