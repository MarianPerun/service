package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/service/api/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    @ResponseBody
    public Product add(@RequestBody Product productModel){
        productRepository.save(productModel);
        return productModel;
    }

    @GetMapping("/view/all")
    @ResponseBody
    public Iterable<Product> viewAll(){
        return productRepository.findAll();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Product updateId(@RequestBody Product productModel, @PathVariable Integer id){
        if(productRepository.findById(id).isPresent()){
            Product existingProduct = productRepository.findById(id).get();

            existingProduct.setName(productModel.getName());
            existingProduct.setPrice(productModel.getPrice());
            existingProduct.setProduct_kind(productModel.getProduct_kind());

            Product updatedProduct = productRepository.save(existingProduct);
            return new Product(updatedProduct.getName(), updatedProduct.getPrice(), updatedProduct.getProduct_kind());
        }
        else return null;
    }
}
