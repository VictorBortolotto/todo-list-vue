package br.com.my.trello.api.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.my.trello.api.backend.model.Tasks;
import br.com.my.trello.api.backend.responses.ResponseModel;
import br.com.my.trello.api.backend.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaksController {
    
    private TaskService taskService;

    @Autowired
    public TaksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path = "/new")
    public ResponseModel save(@RequestBody Tasks taskModel){
        Tasks task = taskService.save(taskModel);

        if(task == null){
            return new ResponseModel("Ooops, something goes wrong and we can't create your task!", 500);     
        }

        return new ResponseModel("Task created with Success!", 200, task);
    }

}
