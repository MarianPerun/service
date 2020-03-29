package com.example.demo.Repository;

import com.example.demo.Model.HardwareStore;
import org.springframework.data.repository.CrudRepository;

public interface HardwareStoreRepository extends CrudRepository<HardwareStore, Integer> {
}
