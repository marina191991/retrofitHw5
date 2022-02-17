package org.example.retrofitVebinartest;


import lombok.SneakyThrows;
import org.example.retrofitVebinar.DTO.Product;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import retrofit2.Response;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateProductTest extends AbstractTest{



@Test
@SneakyThrows
    void createsNewProduct () {
   product =new Product()
            .withTitle(faker.food().ingredient())
            .withPrice((int) (Math.random() * 10000))
            .withCategoryTitle("Food");
    Response<Product> response = productService.createProduct(product).execute();

    id= response.body().getId();
       assertThat(response.isSuccessful(), CoreMatchers.is(true));
}



}
