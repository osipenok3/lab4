package service;

import model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    public List<Category> getALLCategory() {
        List<Category> categories = new ArrayList<>();
        DataBaseService dataBaseService = new DataBaseService();
        String sql =
                "SELECT * from price;";
        ResultSet resultSet = dataBaseService.select(sql);
        try {
            while (resultSet.next()) {
                Category category = new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("category"),
                        resultSet.getFloat("price")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }

    public boolean create(int id, String category, float price){
        boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "INSERT INTO price (id,category,price)" +
                "VALUES ('"+id+"', '"+category+"', '"+price+"')";
        if(dataBaseService.insert(sql)){
            // логика на успех
            isSuccess =true;
        }  // ошибка


        return isSuccess;
    }

    public Boolean delete(int id){
        boolean isSuccess = false;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "DELETE FROM price WHERE id="+id+";";
        if(dataBaseService.insert(sql)){
            // логика на успех
            isSuccess =true;
        }  // ошибка


        return isSuccess;
    }
}
