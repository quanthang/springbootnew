package com.example.t2009mt1demo.seeder;
import com.example.t2009mt1demo.util.NumberHelper;
import com.github.javafaker.Faker;
import com.example.t2009mt1demo.entity.Product;
import com.example.t2009mt1demo.reponsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@Component
public class ProductSeeder implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;
    private static final int NUMBER_OF_PRODUCT = 1000;
    public static ArrayList<Product> products;

    public void generate() {
        ArrayList<String> color = new ArrayList<>();
        color.add("red");
        color.add("white");
        color.add("yellow");
        color.add("blue");
        color.add("green");
        ArrayList<String> sizes = new ArrayList<>();
        sizes.add("XL");
        sizes.add("S");
        sizes.add("M");
        ArrayList<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("FeMale");
        genders.add("Other");
        Random random = new Random();
        Faker faker = new Faker();
        products = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PRODUCT; i++) {
            Product obj = Product.builder()
                    .name(faker.name().name())
                    .description(faker.name().title())
                    .gender(genders.get(NumberHelper.numberRandom(0, genders.size() - 1)))
                    .color(color.get(NumberHelper.numberRandom(0, color.size() - 1)))
                    .size(sizes.get(NumberHelper.numberRandom(0, sizes.size() - 1)))
                    .price(NumberHelper.numberRandom(10000, 100000))
                    .status(NumberHelper.numberRandom(0, 1))
                    .createdAt(LocalDateTime.now().minusDays(NumberHelper.numberRandom(1, 30)))
                    .build();
            products.add(obj);
        }
        productRepository.saveAll(products);
    }


    public void run(String... args) throws Exception {
        generate();
    }
}