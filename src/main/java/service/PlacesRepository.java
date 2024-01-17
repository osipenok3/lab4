package service;

import model.Place;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlacesRepository {

    public List<Place> getALLPlaces() {
        List<Place> places = new ArrayList<>();
        DataBaseService dataBaseService = new DataBaseService();
        String sql =
                "SELECT * from places;";
        ResultSet resultSet = dataBaseService.select(sql);
        try {
            while (resultSet.next()) {
                Place place = new Place(
                        resultSet.getInt("id"),
                        resultSet.getInt("row"),
                        resultSet.getInt("place"),
                        resultSet.getInt("category"),
                        resultSet.getInt("id_hall")
                );
                places.add(place);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return places;
    }

    public boolean create(int id, int row, int place, int category, int id_hall){
        boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "INSERT INTO places (id,row, place, category, id_hall)" +
                "VALUES ('"+id+"', '"+row+"', '"+place+"','"+category+"','"+id_hall+"')";
        if(dataBaseService.insert(sql)){
            // логика на успех
            isSuccess =true;
        }  // ошибка


        return isSuccess;
    }

    public boolean delete(int id){
        boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "DELETE FROM places WHERE id="+id+";";
        if(dataBaseService.insert(sql)){
            // логика на успех
            isSuccess =true;
        }  // ошибка


        return isSuccess;
    }


}
