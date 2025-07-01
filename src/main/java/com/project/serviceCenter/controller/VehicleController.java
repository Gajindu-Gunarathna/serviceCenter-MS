package com.project.serviceCenter.controller;


import com.project.serviceCenter.data.User;
import com.project.serviceCenter.data.Vehicle;
import com.project.serviceCenter.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(path = "/vehicles")
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @GetMapping(path = "/vehicles/{id}")
    public Vehicle getVehicleById(@PathVariable int id){
        return vehicleService.getVehicleById(id);
    }

    @PostMapping(path = "/vehicles")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.createVehicle(vehicle);
    }

    @PutMapping(path = "/vehicles")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.updateVehicle(vehicle);
    }

    @DeleteMapping(path = "/vehicles/{id}")
    public Vehicle deleteVehicleById(@PathVariable int id){
        return vehicleService.deleteVehicleById(id);
    }


}
