import java.util.ArrayList;
import java.util.Scanner;

public class Todo {

    public static void main(String args[]) {
        int choice = -1;
        Scanner scn = new Scanner(System.in);
        ArrayList<String> todoList = new ArrayList<>();

        while (choice != 0) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Show Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Edit Task");
            System.out.println("0. Logout");

            System.out.print("Enter your choice: ");
            choice = scn.nextInt();
            scn.nextLine(); 

            switch (choice) {
                case 1:
                    ShowTasks(todoList);
                    break;
                case 2:
                    AddTask(todoList, scn);
                    break;
                case 3:
                    DeleteTask(todoList, scn);
                    break;
                case 4:
                    EditTask(todoList, scn);
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scn.close(); 
    }

    
    public static void ShowTasks(ArrayList<String> todoList) {
        if (todoList.isEmpty()) {
            System.out.println("No tasks found! Add some tasks...");
        } else {
            System.out.println("Your To-Do List:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }


    public static void AddTask(ArrayList<String> todoList, Scanner scn) {
        System.out.print("Enter the new task: ");
        String newTask = scn.nextLine();
        todoList.add(newTask);
        System.out.println("Task added successfully.");

        ShowTasks(todoList);
    }

    
    public static void DeleteTask(ArrayList<String> todoList, Scanner scn) {
        if (todoList.isEmpty()) {
            System.out.println("No tasks to delete.");
            return;
        }
        ShowTasks(todoList);
        System.out.print("Enter the task number to delete: ");
        int taskNo = scn.nextInt();
        scn.nextLine(); 

        if (taskNo > 0 && taskNo <= todoList.size()) {
            todoList.remove(taskNo - 1);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task number.");
        }

        ShowTasks(todoList);
    }

    
    public static void EditTask(ArrayList<String> todoList, Scanner scn) {
        if (todoList.isEmpty()) {
            System.out.println("No tasks to edit.");
            return;
        }
        ShowTasks(todoList);
        System.out.print("Enter the task number to edit: ");
        int taskNumber = scn.nextInt();
        scn.nextLine(); 

        if (taskNumber > 0 && taskNumber <= todoList.size()) {
            System.out.print("Enter the new task description: ");
            String newTask = scn.nextLine();
            todoList.set(taskNumber - 1, newTask);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Invalid task number.");
        }

        ShowTasks(todoList);
    }
}
