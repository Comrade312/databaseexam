package com.database;

import java.sql.*;
import java.sql.SQLException;

public class Main {

    private final static String INSERT_Q = "INSERT INTO users VALUES(?,?,?)";

    public static void main(String[] args){

        DBWorker worker = new DBWorker();
        String query = "select * from users";

        ResultSet resultSet = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;

        try {
            statement = worker.getConnection().createStatement();
            preparedStatement = statement.getConnection().prepareStatement(INSERT_Q);
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));

                System.out.println(user);
            }

            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "pas123");
            preparedStatement.setString(3, "userLog");
            preparedStatement.execute();

            statement.execute("INSERT INTO animal(anim_name, anim_desc) VALUES('name','desc');");
            statement.executeUpdate("UPDATE animal SET anim_name='sobaken' WHERE id = 4;");
            statement.executeUpdate("DELETE FROM animal WHERE id = 5;");
            statement.executeQuery("SELECT * FROM animal;");
            statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('Gosha', 'Borisov');");
            statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('Artem', 'Gomel');");
            statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('Victor', 'Minsk');");
            statement.executeBatch();
            statement.clearBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(statement.isClosed()){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
