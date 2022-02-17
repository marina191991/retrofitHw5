package org.example.retrofitHw5.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GetEmployeeResponse {
    @JsonProperty ("status")
    private String status;
    @JsonProperty ("data")
    private List<DataAllEmployees> dataAllEmployees = new ArrayList<>();
    @JsonProperty ("data")
    private DataEmployee dataEmployee;


    @Data
    public static class DataAllEmployees {
        @JsonProperty ("id")
        private String id;
        @JsonProperty ("employee_name")
        private String employee_name;
        @JsonProperty ("employee_salary")
        private String employee_salary;
        @JsonProperty ("employee_age")
        private String employee_age;
        @JsonProperty ("profile_image")
        private String profile_image;

    }
    @Data
    public static class DataEmployee {
        @JsonProperty ("id")
        private String id;
        @JsonProperty ("employee_name")
        private String employee_name;
        @JsonProperty ("employee_salary")
        private String employee_salary;
        @JsonProperty ("employee_age")
        private String employee_age;
        @JsonProperty ("profile_image")
        private String profile_image;
    }
}
