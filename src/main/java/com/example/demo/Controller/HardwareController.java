package com.example.demo.Controller;

import com.example.demo.Model.Hardware;
import com.example.demo.Repository.HardwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/service/api/hardware")
public class HardwareController {
    @Autowired
    private HardwareRepository hardwareRepository;

    @PostMapping("/add")
    @ResponseBody
    public Hardware add(@RequestBody Hardware hardwareModel){
        hardwareRepository.save(hardwareModel);
        return hardwareModel;
    }
    @GetMapping("/view/all")
    @ResponseBody
    public Iterable<Hardware> viewAll(){
        return hardwareRepository.findAll();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Hardware updateId(@RequestBody Hardware hardwareModel, @PathVariable Integer id){
        if(hardwareRepository.findById(id).isPresent()){
            Hardware existingHardware = hardwareRepository.findById(id).get();
            existingHardware.setName(hardwareModel.getName());
            existingHardware.setPrice(hardwareModel.getPrice());
            existingHardware.setProduct_kind(hardwareModel.getProduct_kind());
            existingHardware.setDescription(hardwareModel.getDescription());

            Hardware updatedHardware = hardwareRepository.save(existingHardware);
            return new Hardware(updatedHardware.getName(), updatedHardware.getPrice(),
                    updatedHardware.getProduct_kind(), updatedHardware.getDescription());
        }
        else{
            return null;
        }
    }
}
