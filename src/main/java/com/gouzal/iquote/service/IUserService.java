package com.gouzal.iquote.service;

import com.gouzal.iquote.model.User;

public interface IUserService extends Operation<User> {
    User findFirstByLogin(String login);
}
