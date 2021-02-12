/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.androidpath.library.rxjava.dao;

//import com.example.android.observability.UserDataSource;

import androidx.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * Using the Room database as a data source.
 */
public class LocalUserDataSource implements UserDataSource {

    private final UserDao mUserDao;

    public LocalUserDataSource(UserDao userDao) {
        mUserDao = userDao;
    }

    @Override
    public Flowable<User> getUser() {
        return mUserDao.getUser();
    }

    @Override
    public LiveData<List<User>> getUsers() {
        return mUserDao.getUsers();
    }

    @Override
    public List<User> getUsers2() {
        return mUserDao.getUsers2();
    }

    @Override
    public Completable insertOrUpdateUser(User user) {
        return mUserDao.insertUser(user);
    }

    @Override
    public void deleteAllUsers() {
        mUserDao.deleteAllUsers();
    }
}
