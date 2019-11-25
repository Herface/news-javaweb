package org.news.dao;

import org.news.entity.User;

public interface UserDao {

   User findUser(User u);
   void add(User u);
}
