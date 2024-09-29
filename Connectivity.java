package Game;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.*;
import java.util.UUID;

public class Connectivity {
    private final Connection connection;

    Connectivity() throws SQLException{
        String url="jdbc:mysql://localhost:3306/Players";
        String user="root";
        String pass="#LeviAckerman333#";
        connection = DriverManager.getConnection(url,user,pass);
    }
    public void insertRecord(UUID uid,String name) throws SQLException{
        String insertQuery="INSERT INTO PLAYERDETAILS (PLAYER_UID,PLAYER_NAME) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1,uid.toString());
        preparedStatement.setString(2,name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void updatePoints(String name,int points) throws Exception{
        String updateQuery="UPDATE PLAYERDETAILS SET PLAYER_POINTS = ? WHERE PLAYER_NAME = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setInt(1,points);
        preparedStatement.setString(2,name);
        preparedStatement.executeUpdate();
    }

    public boolean isUserExist(String name) {
        String findQuery="SELECT * FROM PLAYERDETAILS WHERE PLAYER_NAME = ?";
        PreparedStatement preparedStatement;
        ResultSet resultSet ;
        try {
            preparedStatement = connection.prepareStatement(findQuery);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }catch(Exception e){
            return false;
        }
    }

    public String getUserUid(String name) throws Exception{
        String findQuery="SELECT PLAYER_UID FROM PLAYERDETAILS WHERE PLAYER_NAME = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
            return resultSet.getString("PLAYER_UID");
        else
            return null;
    }

    public int getUserPoints(String name) throws Exception{
        String findQuery="SELECT PLAYER_POINTS FROM PLAYERDETAILS WHERE PLAYER_NAME = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData rs = (ResultSetMetaData) resultSet.getMetaData();
        if(resultSet.next())
            return Integer.parseInt(resultSet.getString("PLAYER_POINTS"));
        else
            return 0;
    }
}