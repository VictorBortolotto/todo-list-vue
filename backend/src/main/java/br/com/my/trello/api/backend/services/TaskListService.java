package br.com.my.trello.api.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.my.trello.api.backend.model.TaskList;
import br.com.my.trello.api.backend.model.Tasks;
import br.com.my.trello.api.backend.repository.TaskListRepository;
import br.com.my.trello.api.backend.responses.ResponseModel;

@Service
public class TaskListService {

    private TaskListRepository taskListRepository;

    @Autowired
    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    public TaskList save(TaskList taskList){
        return taskListRepository.save(taskList);
    }

    public TaskList findTaskListById(long id){
        return taskListRepository.findTaskListById(id);
    }

    public List<TaskList> findAllTaskList(){
        return taskListRepository.findAll();
    }

    public ResponseModel updateTaskListName(long id, TaskList tasksList){
        return taskListRepository.findById(id).map(result -> {
            result.setName(tasksList.getName());
            TaskList updatedTaskList = taskListRepository.save(result);
            return new ResponseModel("Task list updated with success!", 200, updatedTaskList);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't update your task list!", 400));
    }

    public ResponseModel updateTaskListTask(long id, List<Tasks> tasks){
        return taskListRepository.findById(id).map(result -> {
            result.setTasks(tasks);
            TaskList newTaskList = taskListRepository.save(result);
            return new ResponseModel("Task list updated with success!", 200, newTaskList);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't update your task list!", 400));
    }

    public ResponseModel delete(long id){
        return taskListRepository.findById(id).map(result -> {
            taskListRepository.deleteById(id);
            return new ResponseModel("Task list deleted with success!", 200);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't delete your task list!", 400));
    }

}