package org.jooqDemo.service;

import org.jooqDemo.entity.User;

import java.util.List;

public interface UserService {

	User fetchUser(Integer userId);

	int createUser(User user);

	List<User> fetchUsersList();

	int deleteUser(Integer userId);

	boolean isUserExistsById(Integer userId);

    int updateUserDetails(User user);
}
