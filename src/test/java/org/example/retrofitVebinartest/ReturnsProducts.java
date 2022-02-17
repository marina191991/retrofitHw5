package org.example.retrofitVebinartest;


import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.example.retrofitVebinar.service.ProductService;
import org.example.retrofitVebinar.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class ReturnsProducts  {
    static ProductService productService;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }
    @Test
    @SneakyThrows
    void returnsProducts() {
        Response<ResponseBody> response = productService.getProducts().execute();
        assertThat(response.code(), CoreMatchers.is(500));
    }
}
