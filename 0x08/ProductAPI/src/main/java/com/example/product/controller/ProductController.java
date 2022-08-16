package com.example.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import com.example.productapi.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.productapi.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Product API REST")
@RequestMapping(value="/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/addProduct")
    @ApiOperation(value = "Responsável por adicionar um produto.")
    @ApiResponses(value = {@ApiResponse(code = 10, message = "Required fields not informed.")})
    public void addProduct(@RequestBody Product product) {
        productRepository.addProduct(product);
    }

    @GetMapping(path = "/allProducts")
    @ApiOperation(value="Responsável por retornar uma lista de produtos.")
    @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    public ResponseEntity<List<Product>> getAllProducts(){
        try{
            List<Product> prodList = productRepository.getAllProducts();
            if(prodList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(prodList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findProductById/{id}")
    @ApiOperation(value = "Responsável por retornar um produto pelo id.")
    @ApiResponses(value = {@ApiResponse(code = 12, message = "The field id not informed. This information is required.")})
    public Product findProductById(@PathVariable Long id) {
        return productRepository.getProductById(id);
    }

    @DeleteMapping("/removeProduct")
    @ApiOperation(value = "Responsável por remover um produto.")
    @ApiResponses(value = {@ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")})
    public void removeProduct(@RequestBody Product product) {
        productRepository.removeProduct(product);
    }

    @PutMapping(path = "/updateProduct")
    @ApiOperation(value="Responsável por atualizar um produto.")
    @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    public ResponseEntity<Product> updateProduct(@RequestBody Product prod){
        Optional<Product> prodList = Optional.ofNullable((productRepository.getProductById(prod.getId())));
        if (prodList.isPresent()) {
            productRepository.updateProduct(prod);
            return new ResponseEntity<>(productRepository.getProductById(prod.getId()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/welcome")
    @ApiOperation(value="Responsável por retornar uma mensagem de boas vindas.")
    public String msgBoasVindas(){
        return "BEM VINDO À PRODUCT REST API.";
    }
}
