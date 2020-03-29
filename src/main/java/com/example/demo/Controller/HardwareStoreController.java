package com.example.demo.Controller;


import com.example.demo.Model.Hardware;
import com.example.demo.Model.HardwareStore;
import com.example.demo.Repository.HardwareRepository;
import com.example.demo.Repository.HardwareStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/service/api/hardwarestore")
public class HardwareStoreController {

    @Autowired
    private HardwareStoreRepository hardwareStoreRepository;
    @Autowired
    private HardwareRepository hardwareRepository;

    @PostMapping("/add")
    @ResponseBody
    public HardwareStore add(@RequestBody HardwareStore hardwareStore){
        hardwareStoreRepository.save(hardwareStore);
        return hardwareStore;
    }

    @GetMapping("/view/all")
    @ResponseBody
    public Iterable<HardwareStore> view(){
        return hardwareStoreRepository.findAll();
    }

    @PostMapping("/relation/id/{store_id}/{product_id}")
    @ResponseBody
    public void addHardwareToStore(@PathVariable Integer store_id, @PathVariable Integer product_id){
        Optional<HardwareStore> hardwareStore = hardwareStoreRepository.findById(store_id);
        Optional<Hardware> hardware = hardwareRepository.findById(product_id);
        if(hardwareStore.isPresent()){
            if(hardware.isPresent()){
                Hardware foundHardware = hardware.get();
                HardwareStore foundStore = hardwareStore.get();

                if(!foundStore.getHardware_items().contains(foundHardware)){
                    foundStore.getHardware_items().add(foundHardware);
                    hardwareStoreRepository.save(foundStore);
                }
            }
        }
    }
}
