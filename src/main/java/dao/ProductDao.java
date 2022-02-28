package dao;

import connector.DataBase;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private Connection connection ;

    public ProductDao(){
        this.connection = DataBase.connect();
    }

    public int saveProduct(Product product) throws SQLException {
        String query = "INSERT INTO PRODUCT(libelle,price) VALUES(?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,product.getLibelle());
        ps.setDouble(2,product.getPrice());
        int recordsNumber = ps.executeUpdate();
        System.out.println("product saved successfully");
        return recordsNumber;
    }

    public Product getByLibelle(String lib) throws SQLException {
        String query = "SELECT * FROM PRODUCT WHERE LIBELLE=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,lib);
        ResultSet rs = ps.executeQuery();

        /* SHOW DATA */
        /*ResultSetMetaData metaData = rs.getMetaData();
        StringBuffer columns = new StringBuffer();
        for (int i = 1; i <= metaData.getColumnCount();i++){
            columns.append(metaData.getColumnLabel(i)+"\t");
        }
        System.out.println(columns);
        while(rs.next()){
            StringBuffer data = new StringBuffer();
            for (int i = 1; i <= metaData.getColumnCount();i++){
                data.append(rs.getString(i)+"\t");
            }
            System.out.println(data);
            data.delete(0, data.length());;
        }*/

        /* MAPPING DATA */
        Product product = new Product();
        while(rs.next()){
            product.setId(rs.getLong("ID"));
            product.setLibelle(rs.getString("LIBELLE"));
            product.setPrice(rs.getDouble("PRICE"));
        }
        return product;
    }
    public void showDataTable() throws SQLException {
        String query = "SELECT * FROM PRODUCT";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        /* SHOW DATA */
        ResultSetMetaData metaData = rs.getMetaData();
        StringBuffer columns = new StringBuffer();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            columns.append(metaData.getColumnLabel(i) + "\t");
        }
        System.out.println(columns);
        while (rs.next()) {
            StringBuffer data = new StringBuffer();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                data.append(rs.getString(i) + "\t");
            }
            System.out.println(data);
            data.delete(0, data.length());
        }

    }

}
