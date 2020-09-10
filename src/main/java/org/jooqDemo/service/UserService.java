package org.jooqDemo.service;

import org.jooqDemo.model.User;

import java.util.List;

public interface UserService {

	User fetchUser(Integer userId);

	int createUser(User user);

	List<User> fetchUsersList();

	int deleteUser(Integer userId);

    int updateUserDetails(User user);

	boolean isUserExists(Integer userId);
}
