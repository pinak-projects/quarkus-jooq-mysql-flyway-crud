package org.jooqDemo.service;

import org.jooqDemo.model.user.User;
import org.jooqDemo.model.user.UserDetails;

import java.util.List;

public interface UserService {

	UserDetails fetchUser(Integer userId);

	int createUser(User user);

	List<User> fetchUsersList();

	int deleteUser(Integer userId);

    int updateUserDetails(User user);

	boolean isUserExists(Integer userId);
}
