package org.example.retrofitVebinartest;

import lombok.SneakyThrows;
import org.example.retrofitVebinar.DTO.GetCategoryResponse;
import org.example.retrofitVebinar.service.CategoryService;
import org.example.retrofitVebinar.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetCategoryTest {
    static CategoryService categoryService;
    @BeforeAll
    static void beforeAll() {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);
    }
    @SneakyThrows
    @Test
    void getCategoryByIdTest () {
        Response<GetCategoryResponse> response = categoryService.getCategory(100).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(100));
        assertThat(response.body().getTitle(), equalTo("Clothes"));
        response.body().getProducts().forEach(product ->
                assertThat(product.getCategoryTitle(), equalTo("Clothes")));

    }
}
