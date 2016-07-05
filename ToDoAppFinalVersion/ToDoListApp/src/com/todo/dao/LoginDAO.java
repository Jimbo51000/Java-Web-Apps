package com.todo.dao;

import com.todo.bean.User;

public interface LoginDAO {
 boolean validateLogin(User user);
}
