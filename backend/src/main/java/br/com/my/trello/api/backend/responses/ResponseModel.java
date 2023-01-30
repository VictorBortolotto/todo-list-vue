package br.com.my.trello.api.backend.responses;

import br.com.my.trello.api.backend.model.Frame;
import br.com.my.trello.api.backend.model.TaskList;
import br.com.my.trello.api.backend.model.Tasks;

public class ResponseModel {
    
    private String message;
    private int statusCode;
    private Frame frame;
    private TaskList taskList;
    private Tasks taskModel;

    public ResponseModel() {
    }

    public ResponseModel(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public ResponseModel(String message, int statusCode, TaskList taskList) {
        this.message = message;
        this.statusCode = statusCode;
        this.taskList = taskList;
    }

    public ResponseModel(String message, int statusCode, Frame frame) {
        this.message = message;
        this.statusCode = statusCode;
        this.frame = frame;
    }

    public ResponseModel(String message, int statusCode, Tasks taskModel) {
        this.message = message;
        this.statusCode = statusCode;
        this.taskModel = taskModel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public Tasks getTaskModel() {
        return taskModel;
    }

    public void setTaskModel(Tasks taskModel) {
        this.taskModel = taskModel;
    }

}
