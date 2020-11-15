package ru.geekbrains.spring.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope ("prototype")
public class CartService {

    private ProductRepository productRepository;
    private List<Product> cartProducts = new ArrayList<>();

    public CartService(){}

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(long idProduct){
        cartProducts.add(productRepository.getProduct(idProduct));
    }

    public void removeProduct(long idProduct){
        cartProducts.remove(productRepository.getProduct(idProduct));
    }

    public double getCartPrice(){
        return cartProducts.stream().mapToDouble(Product::getPrice).sum();
    }
}
