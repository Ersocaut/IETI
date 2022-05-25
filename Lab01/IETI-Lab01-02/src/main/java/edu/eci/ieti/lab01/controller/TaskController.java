package edu.eci.ieti.lab01.controller;

import edu.eci.ieti.lab01.data.Task;
import edu.eci.ieti.lab01.dto.TaskDto;
import edu.eci.ieti.lab01.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController (@Autowired TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> create ( @RequestBody TaskDto taskDto ){
        try{
            Task task = new Task("",taskDto.getName(), taskDto.getDescription(), taskDto.getStatus(), taskDto.getAssignedTo(), taskDto.getDueDate(), "");
            taskService.create(task);
            return ResponseEntity.ok().body(task);
        }catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById ( @PathVariable String id ){
        try{
            return ResponseEntity.ok().body(taskService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll (){
        try{
            return ResponseEntity.ok().body(taskService.getAll());
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById ( @PathVariable String id ){
        return ResponseEntity.ok().body(taskService.deleteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update ( @RequestBody TaskDto taskDto, @PathVariable String id ){
        try{
            Task task = taskService.findById(id);
            task.setName(taskDto.getName());
            task.setDescription(taskDto.getDescription());
            task.setStatus(taskDto.getStatus());
            task.setAssignedTo(taskDto.getAssignedTo());
            task.setDueDate(taskDto.getDueDate());
            taskService.update(task, id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }
}
