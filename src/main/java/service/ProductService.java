package service;

import model.Product;

import java.sql.SQLException;

public interface ProductService {
    public Product getProductPriceByLibelle(String lib) throws SQLException;
    public void showProductData() throws SQLException;
}
