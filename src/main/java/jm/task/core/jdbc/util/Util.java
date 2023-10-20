package jm.task.core.jdbc.util;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/simple";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Util() {
    }

    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(UserService userService) {
        UserServiceImpl userService1 = (UserServiceImpl) userService;
        UserDaoJDBCImpl userDaoJDBC = (UserDaoJDBCImpl) userService1.getUserDaoJDBC();
        try {
            userDaoJDBC.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
