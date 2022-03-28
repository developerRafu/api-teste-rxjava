package com.example.apitestrxjava.repositories;

import com.example.apitestrxjava.models.entities.User;

public class UserRespository {
    public static User getUser() {
        final User user = new User();
        user.setId(1L);
        user.setName("Rafael Henrique");
        user.setCep("66077040");
        user.setIdStarWars(4L);
        return user;
    }
}
