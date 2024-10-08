package com.ekart.easy_connect.service.user;

import com.ekart.easy_connect.dto.UserDto;
import com.ekart.easy_connect.model.User;
import com.ekart.easy_connect.request.CreateUserRequest;
import com.ekart.easy_connect.request.UserUpdateRequest;

public interface UserServiceImpl {

    User getUserById(Long userId);
    User createUser(CreateUserRequest user);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);

    User getAuthenticatedUser();
}
