package org.example.retrofitHw5.utils;


import lombok.experimental.UtilityClass;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
@UtilityClass
public class RetrofitUtilsE {
public String baseUrl="http://dummy.restapiexample.com/api/v1/";

       public Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create()) //указывает через какую библиотеку реализуется сериализацияб,десериализация
                .build();

    }

}
