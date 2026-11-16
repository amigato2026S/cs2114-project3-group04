import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * Manages kitchen order processing and provides an interactive console session for staff.
 * Represents a cooking station abstraction that handles order execution and user interaction.
 * 
 * @author Nicholas Song
 * @version Nov 9, 2026
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


    //~ Public Methods ........................................................

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


    // ----------------------------------------------------------
    /**
     * Interactive console feature allowing a user to manage the kitchen in real-time,
     * view order statuses, cook incoming priority orders, and inject custom rush orders.
     * 
     * @param queue the priority queue of pending orders
     */
    public void runInteractiveSession(PQueue<Order> queue)
    {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Kitchen Control Console Initialized ===");

        while (running)
        {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Kitchen Status");
            System.out.println("2. Cook Next Order");
            System.out.println("3. Finish Current Order");
            System.out.println("4. Add Custom Rush Order");
            System.out.println("5. Exit Console");
            System.out.print("Enter choice (1-5): ");

            if (!scanner.hasNextInt())
            {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice)
            {
                case 1:
                    if (this.isBusy)
                    {
                        System.out.println("Status: BUSY. Currently cooking: " + this.currentOrder);
                    }
                    else
                    {
                        System.out.println("Status: IDLE. Ready for next order.");
                    }
                    break;

                case 2:
                    if (this.isBusy)
                    {
                        System.out.println("Error: Kitchen is currently busy finishing an order!");
                    }
                    else if (queue == null || queue.isEmpty())
                    {
                        System.out.println("Queue is empty! No orders to cook.");
                    }
                    else
                    {
                        cookNextOrder(queue);
                        System.out.println("Started cooking: " + this.currentOrder);
                    }
                    break;

                case 3:
                    if (!this.isBusy)
                    {
                        System.out.println("Error: No active order to finish.");
                    }
                    else
                    {
                        Order completed = finishOrder();
                        System.out.println("Successfully completed order: " + completed);
                    }
                    break;

                case 4:
                    System.out.print("Enter order description/name: ");
                    String details = scanner.nextLine();
                    System.out.print("Enter priority level (integer): ");
                    if (scanner.hasNextInt())
                    {
                        int priority = scanner.nextInt();
                        scanner.nextLine();
                        // Using FoodOrder subclass instead of instantiating abstract/interface Order directly
                        Order newOrder = new FoodOrder(details, priority);
                        if (queue != null)
                        {
                            queue.add(newOrder);
                            System.out.println("Added custom order to queue: " + newOrder);
                        }
                        else
                        {
                            System.out.println("Error: Queue reference is null.");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid priority. Order creation canceled.");
                        scanner.next();
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Kitchen Control Console. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select between 1 and 5.");
                    break;
            }
        }
    }
}