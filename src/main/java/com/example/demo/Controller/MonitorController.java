package com.example.demo.Controller;

import com.example.demo.Model.Monitor;
import com.example.demo.Repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/service/api/monitor")
public class MonitorController {
    @Autowired
    private MonitorRepository monitorRepository;

    @PostMapping("/add")
    @ResponseBody
    public Monitor add(@RequestBody Monitor monitorModel){
        monitorRepository.save(monitorModel);
        return monitorModel;
    }
    @GetMapping("/view/all")
    @ResponseBody
    public  Iterable<Monitor> viewAll(){
        return monitorRepository.findAll();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Monitor updateId(@RequestBody Monitor monitorModel, @PathVariable Integer id){
        if (monitorRepository.findById(id).isPresent()){
            Monitor existingMonitor = monitorRepository.findById(id).get();
            existingMonitor.setName(monitorModel.getName());
            existingMonitor.setPrice(monitorModel.getPrice());
            existingMonitor.setProduct_kind(monitorModel.getProduct_kind());
            existingMonitor.setDescription(monitorModel.getDescription());
            existingMonitor.setBrightness(monitorModel.getBrightness());
            existingMonitor.setColour(monitorModel.getColour());
            existingMonitor.setSize(monitorModel.getSize());

            Monitor updatedMonitor = monitorRepository.save(existingMonitor);
            return new Monitor(updatedMonitor.getName(), updatedMonitor.getPrice(),
                    updatedMonitor.getProduct_kind(), updatedMonitor.getDescription(),
                    updatedMonitor.getBrightness(), updatedMonitor.getColour(), updatedMonitor.getSize());
        }
        else return  null;
    }
}
