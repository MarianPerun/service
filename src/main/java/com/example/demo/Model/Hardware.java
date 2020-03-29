package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Entity(name = "Hardware")
@PrimaryKeyJoinColumn(name="item_id")
public class Hardware extends Product {

    public Hardware(){
        super();
    }

    public Hardware(String name, int price, String product_kind, String description){
        super(name, price, product_kind);
        this.setDescription(description);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    @ManyToMany(mappedBy = "HardwareStore_Hardware")
    private List<HardwareStore> hardware_stores;

}
