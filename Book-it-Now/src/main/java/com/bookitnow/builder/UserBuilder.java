package com.bookitnow.builder;

import com.bookitnow.dto.Userdto;
import com.bookitnow.model.User;

public class UserBuilder {
    public static User userDtoToUser(Userdto addUser){
        return User.builder()
                .userName(addUser.getUserName())
                .userMobileNumber(addUser.getUserMobileNumber())
                .userEmailId(addUser.getUserEmailId())
                .userAddress(addUser.getUserAddress())
                .userAge(addUser.getUserAge())
                .userGender(addUser.getUserGender())
                .build();
    }
}
