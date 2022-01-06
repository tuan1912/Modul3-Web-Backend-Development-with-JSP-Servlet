package tuan.nguyen.dao;

import tuan.nguyen.model.Category;
import tuan.nguyen.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO {
    void insertCategory(Category category) throws SQLException;
    List<Category> selectAllCategory();
    Category selectCategory(int id);
    boolean updateCategory(Category category)throws SQLException;
    boolean deleteCategory(int id) throws SQLException;
}
