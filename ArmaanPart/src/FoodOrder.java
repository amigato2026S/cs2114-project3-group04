package burgers;
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

import java.time.Duration;

import java.util.ArrayList;

/**
 *  Actual Implementation of the Ordering process. 
 * 
 *  @author Armaan
 *  @version Nov 8, 2026
 */
public class FoodOrder
    implements Order
{

    // ----------------------------------------------------------
    /**
     * Create a new FoodOrder object.
     */
    public FoodOrder()
    {
        // TODO Auto-generated constructor stub
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public void addOrder(String customerName, String recipe)
    {
        // TODO Auto-generated method stub

    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean serveOrder()
    {
        // TODO Auto-generated method stub
        return false;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public String getOrder(int index)
    {
        // TODO Auto-generated method stub
        return null;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public void setOrder(String customerName, String recipe)
    {
        // TODO Auto-generated method stub

    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public Order removeOrder(int index)
    {
        // TODO Auto-generated method stub
        return null;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public String getCustomerName()
    {
        // TODO Auto-generated method stub
        return null;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<String> getOrderList()
    {
        // TODO Auto-generated method stub
        return null;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public Duration getTimeLeft()
    {
        // TODO Auto-generated method stub
        return null;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPriority()
    {
        // TODO Auto-generated method stub
        return false;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Order other)
    {
        // TODO Auto-generated method stub
        return 0;
    }
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}
