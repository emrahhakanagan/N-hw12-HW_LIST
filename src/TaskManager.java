import java.util.*;

public class TaskManager {
    private int id = 1;

    private List<Task> taskList = new LinkedList<>();
    private List<Task> taskListDeleted = new ArrayList<>();

    public void addNewTask(String newTask) {
        boolean flag = false;

        flag = this.taskList.add(new Task(this.id++, newTask));

        if (flag) {
            System.out.println("Добавлено!\n");
        } else {
            System.out.println("Не добавлено!\n");
        }
    }

    public void printTasks() {
        System.out.println("Ваш список дел:");

        if (!taskList.isEmpty()) {
            for (Task task : taskList) {
                System.out.printf("%2d.  %s \n", task.getId(), task.getName());
            }
        } else {
            System.out.println("Список пока пуст!");
        }
    }

    public void printTasksDeleted() {
        System.out.println("Ваш список удаленных дел:");

        if (!taskListDeleted.isEmpty()) {
            for (Task task : taskListDeleted) {
                System.out.printf("%2d.  %s \n", task.getId(), task.getName());
            }
        } else {
            System.out.println("Список пока пуст!");
        }
    }

    public void removeById(int id) {
        boolean flag = false;
        Task taskRemoved;

        for (Task task : taskList) {
            if (task.getId() == id) {
                taskRemoved = task;
                flag = taskList.remove(task);
                taskListDeleted.add(taskRemoved);
                break;
            }
        }

        if (flag) {
            System.out.println("Удалено!\n");
        } else {
            System.out.println("Не удалено!\n");
        }
    }

    public void removeByName(String name) {
        boolean flag = false;
        Task taskRemoved;

        for (Task task : taskList) {
            if (task.getName().equals(name)) {
                taskRemoved = task;
                flag = taskList.remove(task);
                taskListDeleted.add(taskRemoved);
                break;
            }
        }

        if (flag) {
            System.out.println("Удалено!\n");
        } else {
            System.out.println("Не удалено\n");
        }
    }

    public void removeByKeyWord(String name) {
        boolean flag = false;
        int count = 0;

        for (Iterator<Task> iterator = taskList.iterator(); iterator.hasNext();) {
            Task t = iterator.next();
            if (t.getName().contains(name)) {
                iterator.remove();
                flag = true;
                count++;
                taskListDeleted.add(t);
            }
        }

        if (flag) {
            System.out.println(count + " шт. записи удалено!\n");
        } else {
            System.out.println("Не удалено\n");
        }
    }

}
