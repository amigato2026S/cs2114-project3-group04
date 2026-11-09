import java.util.Scanner;

public class Main {
    private static final int MAX_CAPACITY = 10;
    private PQueue<Order> orderQueue;
    private cookingClass cookingView;
    private Scanner scanner;
    private boolean isRunning;

    public Main() {
        this.orderQueue = new PQueue<>();
        this.cookingView = new cookingClass();
        this.scanner = new Scanner(System.in);
        this.isRunning = true;
    }

    public void start() {
        System.out.println("=== Welcome to Burgeria Simulation ===");

        while (isRunning) {
            System.out.println("------------------------------------");
            System.out.println("1. Add Regular Order");
            System.out.println("2. Add Priority Order");
            System.out.println("3. Cook / Serve Next Order");
            System.out.println("4. Check Kitchen Status");
            System.out.println("5. Exit");
            System.out.print("Enter choice (1-5): ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    promptOrderInput(false);
                    break;
                case "2":
                    promptOrderInput(true);
                    break;
                case "3":
                    handleServeOrder();
                    break;
                case "4":
                    boolean isBusy = cookingView.checkStatus();
                    System.out.println("Kitchen Station Status: " + (isBusy ? "BUSY" : "READY"));
                    System.out.println("Pending orders in queue: " + orderQueue.size());
                    break;
                case "5":
                    System.out.println("Exiting Burgeria. Thanks for playing!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid command. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }

    private void promptOrderInput(boolean isPriority) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter burger recipe (e.g., Cheeseburger): ");
        String recipe = scanner.nextLine();

        if (isPriority) {
            handlePriorityOrder(name, recipe);
        } else {
            handleAddOrder(name, recipe);
        }
    }

    public boolean handleAddOrder(String customerName, String recipe) {
        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Please enter a valid customer name.");
            return false;
        }

        if (recipe == null || recipe.trim().isEmpty()) {
            recipe = "Standard Burger";
        }

        if (orderQueue.size() >= MAX_CAPACITY) {
            System.out.println("Kitchen is full! Please wait before adding more orders.");
            return false;
        }

        FoodOrder newOrder = new FoodOrder();
        newOrder.addOrder(customerName.trim(), recipe.trim());
        boolean enqueued = orderQueue.offer(newOrder);

        if (!enqueued) {
            System.out.println("Kitchen is full! Please wait before adding more orders.");
            return false;
        }

        System.out.println("Order added successfully for " + customerName.trim() + " (" + recipe.trim() + ").");
        return true;
    }

    public void handlePriorityOrder(String customerName, String recipe) {
        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Please enter a valid customer name.");
            return;
        }

        if (recipe == null || recipe.trim().isEmpty()) {
            recipe = "Priority Deluxe Burger";
        }

        if (orderQueue.size() >= MAX_CAPACITY) {
            System.out.println("Kitchen is full! Please wait before adding more orders.");
            return;
        }

        FoodOrder priorityOrder = new FoodOrder();
        priorityOrder.addOrder(customerName.trim(), recipe.trim());
        boolean enqueued = orderQueue.offer(priorityOrder);

        if (!enqueued) {
            System.out.println("Kitchen is full! Please wait before adding more orders.");
            return;
        }

        System.out.println("[PRIORITY] Rush order added for " + customerName.trim() + "!");
    }

    public void handleServeOrder() {
        if (orderQueue.isEmpty() || orderQueue.size() == 0) {
            System.out.println("No orders currently in line.");
            return;
        }

        Order nextOrder = orderQueue.peek();

        if (nextOrder == null) {
            System.out.println("This order is not at the front of the line. Work on current order.");
            return;
        }

        cookingView.cookNextOrder(orderQueue);
        Order finished = cookingView.finishOrder();
        if (finished != null) {
            finished.serveOrder();
        }

        System.out.println("Order served and completed successfully.");
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
}