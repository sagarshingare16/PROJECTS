package com.bookmymovie.dto.RequestDtos;


import com.bookmymovie.enums.Gender;
import lombok.Data;

@Data
public class AddUserDto {

    private String name;
    private Integer age;
    private String address;
    private String mobileNo;
    private String emailId;
    private Gender gender;
}
