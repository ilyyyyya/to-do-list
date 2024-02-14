import java.util.ArrayList;
import java.util.List;


public class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void deleteTask(int taskNumber){
        tasks.remove(taskNumber);
    }
    public List<Task> getTasks(){
        return tasks;
    }

    public void markTaskAsDone(int taskNumber){
        tasks.get(taskNumber).setDone(true);
    }
    public void showTasks(){
        for (Task task : tasks){
            System.out.println(task);
        }
    }
    public void exit(){
        System.out.println("До свидания");
        System.exit(0);
    }
}