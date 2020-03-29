package com.example.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity(name="HardwareStore")
public class HardwareStore {
    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer store_id;

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    private String store_name;

    public List<Hardware> getHardware_items() {
        return HardwareStore_Hardware;
    }

    public void setHardware_items(List<Hardware> hardware_items) {
        this.HardwareStore_Hardware = hardware_items;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "HardwareStore_Hardware",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List <Hardware> HardwareStore_Hardware;
}
