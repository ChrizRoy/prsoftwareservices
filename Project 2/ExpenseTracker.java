import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTracker {
    private static final Map<String, Double> expenses = new HashMap<>();
    private static final Map<String, Double> budgets = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Log Expense");
            System.out.println("2. Set Budget");
            System.out.println("3. View Expenses");
            System.out.println("4. View Budgets");
            System.out.println("5. Set Reminder");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    logExpense();
                    break;
                case 2:
                    setBudget();
                    break;
                case 3:
                    viewExpenses();
                    break;
                case 4:
                    viewBudgets();
                    break;
                case 5:
                    setReminder();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void logExpense() {
        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();

        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        expenses.put(category, expenses.getOrDefault(category, 0.0) + amount);
        System.out.println("Expense logged successfully.");
    }

    private static void setBudget() {
        System.out.print("Enter budget category: ");
        String category = scanner.nextLine();

        System.out.print("Enter budget amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        budgets.put(category, amount);
        System.out.println("Budget set successfully.");
    }

    private static void viewExpenses() {
        System.out.println("Expense History:");
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Amount: Rs" + entry.getValue());
        }
    }

    private static void viewBudgets() {
        System.out.println("Budgets:");
        for (Map.Entry<String, Double> entry : budgets.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Budget: Rs" + entry.getValue());
        }
    }

    private static void setReminder() {
        System.out.print("Enter reminder message: ");
        String reminder = scanner.nextLine();

        System.out.print("Enter date for the reminder: ");
        String date = scanner.nextLine();

        System.out.println("Reminder set successfully for " + date + ": " + reminder);
    }
}
