/*
 * This file is generated by jOOQ.
 */
package com.jooq.tables.daos;


import com.jooq.tables.UserMaster;
import com.jooq.tables.records.UserMasterRecord;

import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserMasterDao extends DAOImpl<UserMasterRecord, com.jooq.tables.pojos.UserMaster, Integer> {

    /**
     * Create a new UserMasterDao without any configuration
     */
    public UserMasterDao() {
        super(UserMaster.USER_MASTER, com.jooq.tables.pojos.UserMaster.class);
    }

    /**
     * Create a new UserMasterDao with an attached configuration
     */
    public UserMasterDao(Configuration configuration) {
        super(UserMaster.USER_MASTER, com.jooq.tables.pojos.UserMaster.class, configuration);
    }

    @Override
    public Integer getId(com.jooq.tables.pojos.UserMaster object) {
        return object.getUserId();
    }

    /**
     * Fetch records that have <code>user_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.jooq.tables.pojos.UserMaster> fetchRangeOfUserId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(UserMaster.USER_MASTER.USER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<com.jooq.tables.pojos.UserMaster> fetchByUserId(Integer... values) {
        return fetch(UserMaster.USER_MASTER.USER_ID, values);
    }

    /**
     * Fetch a unique record that has <code>user_id = value</code>
     */
    public com.jooq.tables.pojos.UserMaster fetchOneByUserId(Integer value) {
        return fetchOne(UserMaster.USER_MASTER.USER_ID, value);
    }

    /**
     * Fetch records that have <code>first_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.jooq.tables.pojos.UserMaster> fetchRangeOfFirstName(String lowerInclusive, String upperInclusive) {
        return fetchRange(UserMaster.USER_MASTER.FIRST_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>first_name IN (values)</code>
     */
    public List<com.jooq.tables.pojos.UserMaster> fetchByFirstName(String... values) {
        return fetch(UserMaster.USER_MASTER.FIRST_NAME, values);
    }

    /**
     * Fetch records that have <code>last_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.jooq.tables.pojos.UserMaster> fetchRangeOfLastName(String lowerInclusive, String upperInclusive) {
        return fetchRange(UserMaster.USER_MASTER.LAST_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>last_name IN (values)</code>
     */
    public List<com.jooq.tables.pojos.UserMaster> fetchByLastName(String... values) {
        return fetch(UserMaster.USER_MASTER.LAST_NAME, values);
    }

    /**
     * Fetch records that have <code>user_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.jooq.tables.pojos.UserMaster> fetchRangeOfUserName(String lowerInclusive, String upperInclusive) {
        return fetchRange(UserMaster.USER_MASTER.USER_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>user_name IN (values)</code>
     */
    public List<com.jooq.tables.pojos.UserMaster> fetchByUserName(String... values) {
        return fetch(UserMaster.USER_MASTER.USER_NAME, values);
    }

    /**
     * Fetch records that have <code>password BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.jooq.tables.pojos.UserMaster> fetchRangeOfPassword(String lowerInclusive, String upperInclusive) {
        return fetchRange(UserMaster.USER_MASTER.PASSWORD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<com.jooq.tables.pojos.UserMaster> fetchByPassword(String... values) {
        return fetch(UserMaster.USER_MASTER.PASSWORD, values);
    }
}