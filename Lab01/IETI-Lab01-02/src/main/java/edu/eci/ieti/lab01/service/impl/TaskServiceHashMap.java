package edu.eci.ieti.lab01.service.impl;

import edu.eci.ieti.lab01.data.Task;
import edu.eci.ieti.lab01.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceHashMap implements TaskService {

    private HashMap<String, Task> tasks = new HashMap<String, Task>();
    private Integer current = 1;

    @Override
    public Task create(Task task) {
        task.setId(current.toString());
        task.setCreated(java.time.LocalDate.now().toString());
        tasks.put(task.getId(), task);
        current++;
        return tasks.get(current.toString());
    }

    @Override
    public Task findById(String id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> getAll() {
        List<Task> ret = new ArrayList<Task>();
        for (String key : tasks.keySet()){
            ret.add(tasks.get(key));
        }
        return ret;
    }

    @Override
    public boolean deleteById(String id) {
        boolean deleted;
        try{
            tasks.remove(id);
            deleted = true;
        }catch(Exception e){
            deleted = false;
        }
        return deleted;
    }

    @Override
    public Task update(Task task, String id) {
        return tasks.put(id, task);
    }
}
