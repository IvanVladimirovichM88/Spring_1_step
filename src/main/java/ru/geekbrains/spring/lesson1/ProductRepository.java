package ru.geekbrains.spring.lesson1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList = new ArrayList<>();

    public ProductRepository() {
    }

    @PostConstruct
    public void init() {
        productList.add(new Product(1l, "apple",50.0));
        productList.add(new Product(2l, "lemon",25.0));
        productList.add(new Product(3l, "orange",75.0));
        productList.add(new Product(4l, "lime",20.0));
        productList.add(new Product(5l, "fig",5.0));
    }

    public Product getProduct(long id) {
        return productList.stream().filter(x->x.getId() == id).findAny().get();
    }

    public List<Product> getAllProducts(){
        return Collections.unmodifiableList(productList);
    }

}
