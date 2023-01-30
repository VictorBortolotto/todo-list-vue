package br.com.my.trello.api.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.my.trello.api.backend.model.Frame;
import br.com.my.trello.api.backend.model.TaskList;
import br.com.my.trello.api.backend.repository.FrameRepository;
import br.com.my.trello.api.backend.responses.ResponseModel;

@Service
public class FrameService {
    
    private FrameRepository frameRepository;

    @Autowired
    public FrameService(FrameRepository frameRepository) {
        this.frameRepository = frameRepository;
    }

    public Frame save(Frame frame){
        return frameRepository.save(frame);
    }

    public ResponseModel upadateFrameName(long id, String name){
        return frameRepository.findById(id).map(result -> {
            result.setName(name);
            Frame frame = frameRepository.save(result);
            return new ResponseModel("Frame updated with success", 200, frame);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't update your frame!", 400));
    }

    public ResponseModel upadateFrameDescription(long id, String description){
        return frameRepository.findById(id).map(result -> {
            result.setDescription(description);
            Frame frame = frameRepository.save(result);
            return new ResponseModel("Frame updated with success", 200, frame);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't update your frame!", 400));
    }

    public ResponseModel upadateFrameTaskList(long id, List<TaskList> taskList){
        return frameRepository.findById(id).map(result -> {
            result.setTasksLists(taskList);
            Frame frame = frameRepository.save(result);
            return new ResponseModel("Frame updated with success", 200, frame);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't update your frame!", 400));
    }

    public ResponseModel delete(long id){
        return frameRepository.findById(id).map(result -> {
            frameRepository.deleteById(id);
            return new ResponseModel("Frame deleted with success!", 200);
        }).orElse(new ResponseModel("Ooops, something goes wrong and we can't delete your frame!", 400));
    }
    
}