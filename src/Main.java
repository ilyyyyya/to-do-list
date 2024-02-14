import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        while(true) {
            showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addTask(toDoList);
                    break;
                case 2:
                    showTasks(toDoList);
                    break;
                case 3:
                    markTaskAsDone(toDoList);
                    break;
                case 4:
                    deleteTask(toDoList);
                    break;
                case 5:
                    toDoList.exit();
                    break;
                default:
                    System.out.println("Неверный номер!");
            }
        }

    }


    private static void showMenu() {
        System.out.println("Добро пожаловать в приложение To-Do List!");
        System.out.println("1. Добавить новую задачу");
        System.out.println("2. Просмотреть список задач");
        System.out.println("3. Отметить задачу как выполненную");
        System.out.println("4. Удалить задачу");
        System.out.println("5. Выход");
        System.out.println("Выберите действие (введите номер): ");
    }


    private static void addTask(ToDoList toDoList) {
        System.out.print("Введите описание задачи: ");
        String description = scanner.next();

        toDoList.addTask(new Task(description));
    }

    private static void showTasks(ToDoList toDoList){
        List<Task> taskList = toDoList.getTasks();

        if(taskList.isEmpty()) {
            System.out.println("Список задач пуст!");
        }
        toDoList.showTasks();
    }

    private static void markTaskAsDone(ToDoList toDoList) {
        System.out.print("Введите номер задачи для отметки как выполненной: ");
        int taskNumber = scanner.nextInt() - 1;

        toDoList.markTaskAsDone(taskNumber);

        System.out.println("Задача \"" + toDoList.getTasks().get(taskNumber).getDescription() + "\" выполнена.");
    }

    private static void deleteTask(ToDoList toDoList) {
        System.out.print("Введите номер задачи для удаления: ");
        int taskNumber = scanner.nextInt() - 1;

        if (!toDoList.getTasks().isEmpty()) {
            String description = toDoList.getTasks().get(taskNumber).getDescription();
            toDoList.deleteTask(taskNumber);

            System.out.println("Задача \"" + description + "\" удалена.");
        } else {
            System.out.println("Список задач пуст.");
        }

    }
}
