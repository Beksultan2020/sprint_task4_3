package db;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/news_SPT3",
                    "postgres", "beka asd2020");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addUser(User user){
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO users (email,password,full_name,role_id) " +
                            "VALUES (?,?,?,2)");
            stmt.setString(1,user.getEmail());
            stmt.setString(2,user.getPassword());
            stmt.setString(3,user.getFull_name());
            stmt.executeUpdate();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void updateUser(User user){
        try {
            PreparedStatement stmt=connection.prepareStatement("UPDATE users SET full_name=?,password=? " +
                    "WHERE id=?");
            stmt.setString(1,user.getFull_name());
            stmt.setString(2, user.getPassword());
            stmt.setLong(3,user.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static User getUserByEmail(String email) {
        User user = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM users WHERE email=?");
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(email);
                user.setPassword(resultSet.getString("password"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setRole_id(resultSet.getInt("role_id"));
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public static User getUserById(Long id) {
        User user = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE id=?");
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(id);
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setRole_id(resultSet.getInt("role_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public static List<News> getAllNews() {
        List<News> news = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM news ORDER BY postdate DESC");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                News news1 = new News();
                news1.setId(resultSet.getLong("id"));
                news1.setTitle(resultSet.getString("title"));
                news1.setContent(resultSet.getString("content"));
                news1.setPostDate(resultSet.getObject("postdate", LocalDateTime.class));
                Long userId = resultSet.getLong("user_id");
                news1.setUser(getUserById(userId));
                news.add(news1);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return news;
    }

    public static void addNews(News news) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO news(title,content,postdate,user_id) " +
                            "VALUES (?,?,CURRENT_TIMESTAMP,?)");
            stmt.setString(1, news.getTitle());
            stmt.setString(2, news.getContent());
            stmt.setLong(3, news.getUser().getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static News getNewsById(Long id) {
        News news = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT n.*,u.email,u.password,u.full_name, u.role_id FROM news n " +
                            "INNER JOIN  users u ON n.user_id=u.id " +
                            "WHERE n.id=?");
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                news = new News();
                news.setId(id);
                news.setTitle(resultSet.getString("title"));
                news.setContent(resultSet.getString("content"));
                news.setPostDate(resultSet.getObject("postdate", LocalDateTime.class));

                User user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setRole_id(resultSet.getInt("role_id"));
                news.setUser(user);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return news;
    }

    public static void newsUpdate(News news) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE news SET title=?,content=?, user_id=? WHERE id=?");
            stmt.setString(1, news.getTitle());
            stmt.setString(2, news.getContent());
            stmt.setLong(3, news.getUser().getId());
            stmt.setLong(4, news.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteNews(Long id){
        try {
            PreparedStatement stmt=connection.prepareStatement("DELETE FROM news WHERE id=?");
            stmt.setLong(1,id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
