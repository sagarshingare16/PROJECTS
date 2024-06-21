package com.bookmymovie.builder;


import com.bookmymovie.dto.RequestDtos.AddUserDto;
import com.bookmymovie.dto.ResponseDtos.ReturnUserDto;
import com.bookmymovie.entity.User;

public class UserTransformer {

    public static User userDtoToUser(AddUserDto userEntryDto) {

        return User.builder()
                .name(userEntryDto.getName())
                .age(userEntryDto.getAge())
                .address(userEntryDto.getAddress())
                .gender(userEntryDto.getGender())
                .mobileNo(userEntryDto.getMobileNo())
                .emailId(userEntryDto.getEmailId())
                .build();
    }

    public static ReturnUserDto userToUserDto(User user) {

        return ReturnUserDto.builder()
                .name(user.getName())
                .age(user.getAge())
                .address(user.getAddress())
                .gender(user.getGender())
                .build();
    }
}
