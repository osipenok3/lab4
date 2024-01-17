package service;

import model.Hall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HallRepository {

    public List<Hall> getALLHall() {
        List<Hall> halls = new ArrayList<>();
        DataBaseService dataBaseService = new DataBaseService();
        String sql =
                "SELECT * from halls;";
        ResultSet resultSet = dataBaseService.select(sql);
        try {
            while (resultSet.next()) {
                Hall hall = new Hall(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                halls.add(hall);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return halls;
    }

    public boolean create(int id, String name){
        boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "INSERT INTO halls (id,name)" +
                "VALUES ('"+id+"', '"+name+"')";
        if(dataBaseService.insert(sql)){
            // логика на успех
            isSuccess =true;
        }  // ошибка


        return isSuccess;
    }

    public boolean delete(int id){
        boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "DELETE FROM halls WHERE id="+id+";";
        if(dataBaseService.insert(sql)){
            // логика на успех
            isSuccess =true;
        }  // ошибка


        return isSuccess;
    }
}
