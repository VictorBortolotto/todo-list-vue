package br.com.my.trello.api.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.my.trello.api.backend.model.Frame;
import br.com.my.trello.api.backend.responses.ResponseModel;
import br.com.my.trello.api.backend.services.FrameService;

@RestController
@RequestMapping("/frame")
public class FrameController {
    
    private FrameService frameService;

    @Autowired
    public FrameController(FrameService frameService) {
        this.frameService = frameService;
    }

    @PostMapping(path = "new")
    public ResponseModel save(@RequestBody Frame frame){
        Frame newFrame = frameService.save(frame);

        if(newFrame == null){
            return new ResponseModel("Ooops, something goes wrong and we can't create your frame!", 500);
        }

        return new ResponseModel("Frame created with success!", 200, newFrame);
    }

}
