package org.jooqDemo.service.impl;

import gensrc.Tables;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooqDemo.constants.APIConstants;
import org.jooqDemo.exception.ResourceNotFoundException;
import org.jooqDemo.model.Role;
import org.jooqDemo.model.User;
import org.jooqDemo.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static gensrc.Tables.ROLE_MASTER;
import static gensrc.Tables.USER_MASTER;

@Transactional
@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    DSLContext dslContext;

    @Override
    public int createUser(User user) {
        user.setInitialTimestamps();
        return dslContext.newRecord(USER_MASTER, user).insert();
    }

    @Override
    public User fetchUser(Integer userId) {

        final Record record = dslContext.select(
                USER_MASTER.asterisk(),
                ROLE_MASTER.field(ROLE_MASTER.ROLE)
        )
                 .from(USER_MASTER)
                 .leftJoin(ROLE_MASTER)
                 .on(USER_MASTER.ROLE_ID.eq(ROLE_MASTER.ROLE_ID))
                 .where(USER_MASTER.USER_ID.eq(userId))
                 .and(USER_MASTER.IS_DELETED.eq(false))
                 .fetchOptional()
                 .orElseThrow(() -> new ResourceNotFoundException(APIConstants.ERROR_USER_NOT_FOUND));

                final User userDetails = record.into(USER_MASTER).into(User.class);
                userDetails.setRole(record.into(Tables.ROLE_MASTER).into(Role.class));
                return userDetails;
    }

    @Override
    public List<User> fetchUsersList() {
        return dslContext.select()
                .from(USER_MASTER)
                .where(USER_MASTER.IS_DELETED.eq(false))
                .fetchInto(User.class);
    }

    @Override
    public int deleteUser(Integer userId) {
        return dslContext.update(USER_MASTER)
                .set(USER_MASTER.IS_DELETED, true)
                .where(USER_MASTER.USER_ID.eq(userId))
                .execute();
    }

    @Override
    public boolean isUserExists(Integer userId) {
        return !dslContext.fetchExists(
                dslContext.selectOne()
                        .from(USER_MASTER)
                        .where(USER_MASTER.USER_ID.eq(userId)
                                .and(USER_MASTER.IS_DELETED.eq(false)))
        );
    }

    @Override
    public int updateUserDetails(User user) {
        user.setUpdatedOn(new Date());
        return dslContext.newRecord(USER_MASTER, user)
                .update();
    }
}
