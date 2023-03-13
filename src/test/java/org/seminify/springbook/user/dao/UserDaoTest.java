package org.seminify.springbook.user.dao;

import org.seminify.springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");
        userDao.add(user);
        System.out.println(user.getId() + " 등록 성공");
        User user2 = userDao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");
    }
}
