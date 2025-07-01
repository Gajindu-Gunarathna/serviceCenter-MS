package com.project.serviceCenter.service;

import com.project.serviceCenter.data.Vehicle;
import com.project.serviceCenter.data.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepo;

    public List<Vehicle> getAllVehicles(){
        return vehicleRepo.findAll();
    }

    public Vehicle getVehicleById(int id){
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        if(vehicle.isPresent()){
            return vehicle.get();
        }
        return null;
    }

    public Vehicle createVehicle(Vehicle vehicle){
        return vehicleRepo.save(vehicle);
    }

    public Vehicle updateVehicle(Vehicle vehicle){
        return vehicleRepo.save(vehicle);
    }

    public Vehicle deleteVehicleById(int id) {
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        if (vehicle.isPresent()) {
            vehicleRepo.deleteById(id);
            return vehicle.get();
        } else {
            return null;
        }
    }


}
