package service.imp;

import dao.ProductDao;
import model.Product;
import service.ProductService;

import java.sql.SQLException;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDao();
    @Override
    public Product getProductPriceByLibelle(String lib) throws SQLException {
        return productDao.getByLibelle(lib);
    }

    @Override
    public void showProductData() throws SQLException {
        productDao.showDataTable();
    }
}
