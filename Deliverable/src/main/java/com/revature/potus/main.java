package com.revature.potus;

import com.revature.potus.Util.ConnectionUtil;
import com.revature.potus.models.AppUser;
import daos.UserDao;
import daos.UserDaoPostgres;

import java.sql.SQLOutput;

public class main {

    public static void main(String[] args) {

        System.out.println(ConnectionUtil.getConnection());

        UserDaoPostgres userDao = new UserDaoPostgres();


        //Creates new user
//        AppUser puser = new AppUser(0,"John","forth");
//        userDao.createUser(puser);
//        System.out.println(puser);


        AppUser abuser = userDao.getUserById(2);
        System.out.println(abuser);





    }
}
