package br.com.my.trello.api.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.my.trello.api.backend.model.TaskList;
import br.com.my.trello.api.backend.model.Tasks;
import br.com.my.trello.api.backend.responses.ResponseModel;
import br.com.my.trello.api.backend.services.TaskListService;

@RestController
@RequestMapping("/task-list")
public class TaskListController {
    
    private TaskListService taskListService;

    @Autowired
    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @PostMapping(path = "/new")
    public ResponseModel save(@RequestBody TaskList taskList){
        TaskList newTaskList = taskListService.save(taskList);

        if(newTaskList == null){
            return new ResponseModel("Ooops, something goes wrong and we can't create your list!", 400);
        }

        return new ResponseModel("List created with success!", 200, newTaskList);
    }

    @GetMapping(path = "/{id}")
    public TaskList getById(@PathVariable("id") long id){
        return taskListService.findTaskListById(id);
    } 

    @PatchMapping(path = "update-task-in-list/{id}")
    public ResponseModel updateTaskInList(@PathVariable("id") long id, @RequestBody List<Tasks> tasks){
        return taskListService.updateTaskListTask(id, tasks);
    }

}
