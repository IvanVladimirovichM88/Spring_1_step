package ru.geekbrains.spring.lesson1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);

        System.out.println(productRepository.getAllProducts());
//        System.out.println(productRepository.getProduct(2));

        CartService cartService = context.getBean("cartService", CartService.class);
        cartService.setProductRepository(productRepository);
        cartService.addProduct(1);
        cartService.addProduct(2);
        cartService.addProduct(1);

        System.out.println( "стоимость 1 карзины - " + cartService.getCartPrice());


        CartService cartService1 = context.getBean("cartService", CartService.class);
        cartService1.setProductRepository(productRepository);
        cartService1.addProduct(1);
        cartService1.addProduct(3);
        cartService1.addProduct(3);

        System.out.println("стоимость 2 карзины - " + cartService1.getCartPrice());

        cartService.removeProduct(3);
        cartService1.removeProduct(3);

        System.out.println( "стоимость 1 карзины - " + cartService.getCartPrice());
        System.out.println("стоимость 2 карзины - " + cartService1.getCartPrice());

    }
}
