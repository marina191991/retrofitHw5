package org.example.retrofitVebinartest;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.example.retrofitVebinar.DTO.Product;
import org.example.retrofitVebinar.service.ProductService;
import org.example.retrofitVebinar.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class AbstractTest {
    static ProductService productService;
    Faker faker = new Faker();
    Product product;
    int id;
        @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }
    @AfterEach
    @SneakyThrows
    void tearDown() {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }
}
