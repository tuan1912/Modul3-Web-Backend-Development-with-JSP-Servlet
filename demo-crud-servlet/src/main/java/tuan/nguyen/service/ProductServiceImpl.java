package tuan.nguyen.service;

import tuan.nguyen.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    List<Product> products = new ArrayList<>();
    public ProductServiceImpl() {
        products.add(new Product(1,"IP",300));
        products.add(new Product(2,"SS",400));
        products.add(new Product(3,"Xi",500));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
    products.add(product);
    }

    @Override
    public int getIndexByProductId(int productId) {
        int NOT_EXIST_ID = -1;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId()==productId) return i;
        }
        return NOT_EXIST_ID;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public void update(int id, Product product) {
        products.set(id,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);

    }

    @Override
    public Product findById(int id) {
        for (Product p: products) {
            if (p.getId()== id) return p;
        }
        return null;
    }
}
