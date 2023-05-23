import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        printMenu();

        try {
            runMenu(scanner, taskManager);
        } catch (InputMismatchException e) {
            System.out.println("Пожалуйста для выбора команду из меню, введите цифру");
        }
    }

    public static void printMenu() {
        System.out.println("\nВыберите операцию:");
        System.out.println("0. Выход из программы");
        System.out.println("1. Добавить дело");
        System.out.println("2. Показать дела");
        System.out.println("3. Удалить дело по номеру");
        System.out.println("4. Удалить дело по названию");
        System.out.println("5. Удалить дело по ключевому слову");
        System.out.println("6. Показать удаленные дела");
    }

    public static void runMenu(Scanner scanner, TaskManager taskManager) {
        while (true) {
            int command = scanner.nextInt();
            String inputNewTask = scanner.nextLine();

            switch (command) {
                case (0):
                    return;

                case (1):
                    System.out.print("Введите название задачи:  ");
                    inputNewTask = scanner.nextLine();
                    taskManager.addNewTask(inputNewTask);
                    taskManager.printTasks();
                    break;
                case (2):
                    taskManager.printTasks();
                    break;
                case (3):
                    System.out.print("Введите номер для удаления:  ");
                    int idTask = scanner.nextInt();
                    taskManager.removeById(idTask);
                    taskManager.printTasks();
                    break;
                case (4):
                    System.out.print("Введите задачу для удаления:  ");
                    String nameTask = scanner.nextLine();
                    taskManager.removeByName(nameTask);
                    taskManager.printTasks();
                    break;
                case (5):
                    System.out.print("Введите ключевое слово для удаления:  ");
                    String keyWord = scanner.nextLine();
                    taskManager.removeByKeyWord(keyWord);
                    taskManager.printTasks();
                    break;
                case (6):
                    taskManager.printTasksDeleted();
                    break;
                default:
                    System.out.println("Такой команды нет!");
                    break;
            }
            printMenu();
        }
    }
}