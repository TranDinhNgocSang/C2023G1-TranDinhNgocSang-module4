package com.example.validate_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto {
    @NotBlank(message = "")
    @Size(min = 5, max = 45, message = "độ dài tối thiểu 5, tối đa 45 ký tự")
    private String firstname;
    @NotBlank(message = "")
    @Size(min = 5, max = 45, message = "độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastname;
    @NotBlank(message = "")
    @Pattern(regexp = "^(0)\\d{9}$", message = "số điện thoại không đúng định dạng")
    private String phonenumber;
    @NotNull(message = "")
    @Min(value = 18, message = "tuổi phải lớn hơn 18")
    private int age;
    @NotBlank(message = "không được để trống")
    @Email(message = "email sai định dạng")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstname, String lastname, String phonenumber, int age, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
