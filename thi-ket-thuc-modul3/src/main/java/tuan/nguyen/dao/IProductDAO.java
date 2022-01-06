package tuan.nguyen.dao;

import tuan.nguyen.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    void insertProduct(Product product) throws SQLException;
    List<Product> selectAllProducts();
    Product selectProduct(int id);
    boolean updateProduct(Product product)throws SQLException;
    boolean deleteProduct(int id) throws SQLException;
}
