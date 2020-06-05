package org.jooqDemo.service.impl;

import gensrc.Tables;
import org.jooq.DSLContext;
import org.jooqDemo.constants.APIConstants;
import org.jooqDemo.entity.User;
import org.jooqDemo.exception.ResourceNotFoundException;
import org.jooqDemo.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static gensrc.Tables.USER_MASTER;

@Transactional
@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    DSLContext dslContext;

    @Override
    public int createUser(final User user) {
        return dslContext.newRecord(USER_MASTER, user).insert();
    }

    @Override
    public User fetchUser(final Integer userId) {
        return dslContext.select().from(USER_MASTER).where(USER_MASTER.USER_ID.eq(userId).and(USER_MASTER.IS_DELETED.eq(false))).fetchOptional().orElseThrow(() -> new ResourceNotFoundException(APIConstants.ERROR_USER_NOT_FOUND)).into(User.class);
    }

    @Override
    public List<User> fetchUsersList() {
        return dslContext.select().from(USER_MASTER).where(USER_MASTER.IS_DELETED.eq(false)).fetch().into(User.class);
    }

    @Override
    public int deleteUser(final Integer userId) {
        return dslContext.update(USER_MASTER).set(USER_MASTER.IS_DELETED, true).where(USER_MASTER.USER_ID.eq(userId)).execute();
    }

    @Override
    public boolean isUserExistsById(final Integer userId) {
        return dslContext.fetchExists(dslContext.selectOne().from(USER_MASTER).where(USER_MASTER.USER_ID.eq(userId).and(USER_MASTER.IS_DELETED.eq(false))));
    }

    @Override
    public int updateUserDetails(final User user) {
        user.setUpdatedOn(new Date(System.currentTimeMillis()));
        return dslContext.newRecord(USER_MASTER, user).update();
    }
}
