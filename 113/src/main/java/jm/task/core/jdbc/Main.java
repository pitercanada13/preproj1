package jm.task.core.jdbc;



import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        // 1. Создание таблицы
        userService.createUsersTable();

        // 2. Добавление пользователей
        userService.saveUser("Иван", "Никитин", (byte)25);
        userService.saveUser("Петр", "Красильников", (byte)30);
        userService.saveUser("Анна", "Васильева", (byte)22);
        userService.saveUser("Олег", "Корсаков", (byte)28);

        // 3. Получение всех пользователей
        List<User> users = userService.getAllUsers();

        for (User user : users) {
            System.out.println(user);
        }

        // 4. Очистка таблицы
        userService.cleanUsersTable();

        // 5. Удаление таблицы
        userService.dropUsersTable();
    }
}

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import jm.task.core.jdbc.util.Util;

//public class Main {
//    public static void main(String[] args) {

//        try (Connection conn = Util.getConnection()) {
//
//            System.out.println("Соединение PostgreSQL!");
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT version()");
//
//            while (rs.next()) {
//                System.out.println("PostgreSQL версия: " + rs.getString(1));
//            }
//            /*ResultSet*/
//            rs = stmt.executeQuery("SELECT * FROM users");
//
//            while (rs.next()) {
//                System.out.println(
//                        rs.getInt("id") + " " +
//                                rs.getString("name") + " " +
//                                rs.getString("last_name" ) + " "+
//                                rs.getString("age")
//                );
//            }
//
//        } catch (Exception e) {
//            //noinspection CallToPrintStackTrace
//            e.printStackTrace();
//        }
//
//    }
//}







