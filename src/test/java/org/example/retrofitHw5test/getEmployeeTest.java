package org.example.retrofitHw5test;

import lombok.SneakyThrows;
import org.example.retrofitHw5.DTO.GetEmployeeResponse;
import org.example.retrofitHw5.service.EmployeeService;
import org.example.retrofitHw5.utils.RetrofitUtilsE;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class getEmployeeTest {
static EmployeeService employeeService;
@BeforeAll
    static void beforeAll() {
    employeeService = RetrofitUtilsE.getRetrofit().create(EmployeeService.class);

}
   // @SneakyThrows
   /* @Test
    void getAllEmployees () {
        Response<GetEmployeeResponse> response = employeeService.getEmployee().execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(),equalTo(200));
        assertThat(response.body().getStatus(), equalTo("success"));
        response.body().getDataAllEmployees().forEach(dataAllEmployees ->
        assertThat(dataAllEmployees.getEmployee_name(),notNullValue()));
    }*/
    @SneakyThrows
    @Test
    void getEmployeeById () {
        Response<GetEmployeeResponse> response = employeeService.getEmployee(1).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(),equalTo(200));
        assert response.body() != null;
        assertThat(response.body().getStatus(), equalTo("success"));
        assertThat(response.body().getDataEmployee().getEmployee_name(), equalTo("Tiger Nixon"));
    }

}
