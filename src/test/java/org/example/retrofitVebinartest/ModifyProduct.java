package org.example.retrofitVebinartest;

import lombok.SneakyThrows;
import org.example.retrofitVebinar.DTO.Product;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import static org.hamcrest.MatcherAssert.assertThat;

public class ModifyProduct extends AbstractTest{
    int price;



    @SneakyThrows
    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withPrice((int) (Math.random() * 10000))
                .withCategoryTitle("Food");
        Response<Product> response = productService.createProduct(product).execute();
        id = response.body().getId();
        price = response.body().getPrice();

    }

    @Test
    @SneakyThrows
    void modifyProducts() {
        product = new Product()
                .withId(id)
                .withTitle(faker.food().ingredient())
                .withPrice(price + 1)
                .withCategoryTitle("Food");
        Response<Product> response = productService.modifyProduct(product).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));

    }

    @Test
    @SneakyThrows
    void returnsProductById() {
        Response<Product> response = productService.getProductById(id).execute();
        assertThat(response.code(), CoreMatchers.is(200));
        assertThat(response.body().getId(), CoreMatchers.is(id));
    }


}
