package org.jooqDemo.service.impl;

import org.jooq.DSLContext;
import org.jooqDemo.constants.APIConstants;
import org.jooqDemo.entity.User;
import org.jooqDemo.exception.NotFoundException;
import org.jooqDemo.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static com.jooq.Tables.USER_MASTER;

@Transactional
@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    DSLContext dslContext;

    @Override
    public int createUser(final User user) {
        return dslContext.insertInto(USER_MASTER)
                .set(USER_MASTER.FIRST_NAME, user.getFirstName())
                .set(USER_MASTER.LAST_NAME, user.getLastName())
                .set(USER_MASTER.USER_NAME, user.getUserName())
                .set(USER_MASTER.PASSWORD, user.getPassword())
                .returning(USER_MASTER.USER_ID)
                .fetchOne().getUserId();
    }

    @Override
    public User fetchUser(final Integer userId) {
        return dslContext.select().from(USER_MASTER).where(USER_MASTER.USER_ID.eq(userId)).fetchOptional().orElseThrow(() -> new NotFoundException(APIConstants.ERROR_USER_NOT_FOUND)).into(User.class);
    }

    @Override
    public List<User> fetchUsersList() {
        return dslContext.select().from(USER_MASTER).fetch().into(User.class);
    }

    @Override
    public int deleteUser(final Integer userId) {
        return dslContext.deleteFrom(USER_MASTER).where(USER_MASTER.USER_ID.eq(userId)).execute();
    }

    @Override
    public boolean isUserExistsById(final Integer userId) {
        return dslContext.fetchExists(dslContext.selectOne().from(USER_MASTER).where(USER_MASTER.USER_ID.eq(userId)));
    }

    @Override
    public int updateUserDetails(final User user) {
        return dslContext.update(USER_MASTER)
                .set(USER_MASTER.FIRST_NAME, user.getFirstName())
                .set(USER_MASTER.LAST_NAME, user.getLastName())
                .set(USER_MASTER.USER_NAME, user.getUserName())
                .set(USER_MASTER.PASSWORD, user.getPassword())
                .where(USER_MASTER.USER_ID.eq(user.getUserId()))
                .execute();
    }
}
