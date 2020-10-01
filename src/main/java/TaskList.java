import java.util.ArrayList;
import java.util.Iterator;

public class TaskList implements Iterable<Task> {

    private ArrayList<Task> tasks;
    private int size;

    public TaskList(){
        tasks = new ArrayList<>();
        size = 0;
    }

    public Task get(int index){
        return tasks.get(index);
    }

    public void remove(int index){
        tasks.remove(index);
    }

    public int size(){
        return size;
    }

    public void add(int index, Task task){
        tasks.add(index, task);
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }
}
