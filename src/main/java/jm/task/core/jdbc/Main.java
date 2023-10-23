package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 18);
        userService.saveUser("Petr", "Petrov", (byte) 20);
        userService.saveUser("Petr1", "Petrov1", (byte) 120);
        userService.saveUser("Sveta", "Svetikova", (byte) 22);
        userService.saveUser("Name", "LastName", (byte) 24);

        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

        Util.closeConnection();

    }
}
