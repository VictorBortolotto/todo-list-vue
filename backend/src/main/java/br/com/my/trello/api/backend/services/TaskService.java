package br.com.my.trello.api.backend.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.my.trello.api.backend.model.Tasks;
import br.com.my.trello.api.backend.repository.TaskRepository;
import br.com.my.trello.api.backend.responses.ResponseModel;

@Service
public class TaskService {
    
    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Tasks save(Tasks task){
        return taskRepository.save(task);
    }

    public ResponseModel updateTaskName(long id, Tasks tasks){
        return taskRepository.findById(id).map(result -> {
            result.setName(tasks.getName());
            result.setDescription(tasks.getDescription());
            result.setFinished(tasks.isFinished());
            result.setDeadline(tasks.getDeadline());
            Tasks task = taskRepository.save(result);
            return new ResponseModel("Task updated with success!", 200, task);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't update your task!", 400));
    } 

    public ResponseModel updateTaskName(long id, String name){
        return taskRepository.findById(id).map(result -> {
            result.setName(name);
            Tasks task = taskRepository.save(result);
            return new ResponseModel("Task updated with success!", 200, task);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't update your task!", 400));
    }

    public ResponseModel updateTaskDescription(long id, String descritpion){
        return taskRepository.findById(id).map(result -> {
            result.setDescription(descritpion);
            Tasks task = taskRepository.save(result);
            return new ResponseModel("Task updated with success!", 200, task);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't update your task!", 400));
    }

    public ResponseModel updateTaskIsFinished(long id, boolean isFinished){
        return taskRepository.findById(id).map(result -> {
            result.setFinished(isFinished);
            Tasks task = taskRepository.save(result);
            return new ResponseModel("Task updated with success!", 200, task);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't update your task!", 400));
    }

    public ResponseModel updateTaskDeadline(long id, Date deadline){
        return taskRepository.findById(id).map(result -> {
            result.setDeadline(deadline);
            Tasks task = taskRepository.save(result);
            return new ResponseModel("Task updated with success!", 200, task);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't update your task!", 400));
    }

    public ResponseModel delete(long id){
        return taskRepository.findById(id).map(result -> {
            taskRepository.deleteById(id);
            return new ResponseModel("Task deleted with success!", 200);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't delete your task!", 400));
    }

}
