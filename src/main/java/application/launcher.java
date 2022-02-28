package application;

import dao.ProductDao;
import model.Product;
import service.ProductService;
import service.imp.ProductServiceImpl;

import java.sql.SQLException;

public class launcher {
    public static void main(String[] args) throws SQLException {
        ProductService productService = new ProductServiceImpl();
        /*save new product */
        /*int recordsNumber = productDao.saveProduct(new Product("product1",10));
        System.out.println("we have "+recordsNumber+" records");*/
        /* get a product */
        String label = "product1";
        Product product = productService.getProductPriceByLibelle(label);
        System.out.println("the product price of <<"+label+">> is "+product.getPrice()+"DH");
        /* ALL DATA */
        System.out.println("*****************************ALL PRODUCTS*****************************");
        productService.showProductData();
    }
}
