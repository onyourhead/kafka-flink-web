package edu.ncut.kafkaflinkweb.controller;

import edu.ncut.kafkaflinkweb.entity.EchartData1;
import edu.ncut.kafkaflinkweb.service.ConsumeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    @Autowired
    ConsumeDataService consumeDataService;
    @RequestMapping("/getData")
    public EchartData1 getData() {
        return consumeDataService.consume();
    }
}
