package org.example.retrofitVebinar.service;
import org.example.retrofitVebinar.DTO.GetCategoryResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoryService {
    @GET("categories/{id}")
    Call<GetCategoryResponse> getCategory(@Path("id") int id);

}
