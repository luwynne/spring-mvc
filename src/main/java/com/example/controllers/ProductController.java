package com.example.controllers;

import com.example.domain.Product;
import com.example.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Optional;

@Controller
public class ProductController {

    private ProductService productService;

    // injecting the product service as soon as the application  starts running
    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    // this will return to the view a array called products which are the products from the injected producService on a list format
    @RequestMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id, Model model ){
    	Optional<Product> product = productService.getById(id);
    	
    	if(product.isPresent()) {
    		model.addAttribute("product", product.get());
    	}
    	
        return "product/show";
    }

    // send an empty object for a new product
    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "product/product_form";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String createProduct(Product product){
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/product/" + savedProduct.getId();
    }

    @RequestMapping("product/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/product_form";
    }

    @RequestMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/products";
    }

}
