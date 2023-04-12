package id.co.bca.spring.NanoCustomer.datasource;

import id.co.bca.spring.NanoCustomer.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class NanoCustDataSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(NanoCustDataSource.class.getPackageName());

    public static final String JDBC_URL =  "jdbc:mysql://localhost:3306/customer_directory";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "";
    public static final String STM_CREATE = "INSERT INTO customer (cust_name, cust_email) VALUES (?,?)";
    public static final String STM_UPDATE = "UPDATE customer SET cust_name=?, cust_email=? WHERE id=?";
    public static final String STM_DELETE = "DELETE FROM customer WHERE id=?";
    public static final String STM_RETRIEVE_ALL = "SELECT * FROM customer";
    public static final String STM_RETRIEVE_BY_ID = "SELECT * FROM customer WHERE id=? ";

    public NanoCustDataSource(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            LOGGER.info("Connection successful");
        } catch (SQLException e){
            e.printStackTrace();
            LOGGER.info("Connection unsuccessful");
        } finally {
            try { if (connection!=null)  connection.close();} catch (Exception e){};
        }
    }

    public void insertCustomer(Customer customer){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
            ps = connection.prepareStatement(STM_CREATE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getCustName());
            ps.setString(2, customer.getCustEmail());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()){
                int id = rs.getInt(1);
                LOGGER.info("Successful insert data with id "+String.valueOf(id));
            }
        }catch (SQLException e){
            LOGGER.info("Unsuccessful insert data");
            e.printStackTrace();
        }finally {
            try {if (rs != null) rs.close();} catch (Exception e){};
            try {if (ps != null) ps.close();} catch (Exception e){};
            try {if (connection != null) connection.close();} catch (Exception e){};
        }
    }

    public void updateCustomer(Customer customer){
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
            ps = connection.prepareStatement(STM_UPDATE);
            ps.setInt(3, customer.getId());
            ps.setString(1, customer.getCustName());
            ps.setString(2, customer.getCustEmail());
            ps.execute();
            LOGGER.info("Successful update data");
        }catch (SQLException e){
            LOGGER.info("Unsuccessful update data");
            e.printStackTrace();
        }finally {
            try {if (ps != null) ps.close();} catch (Exception e){};
            try {if (connection != null) connection.close();} catch (Exception e){};
        }
    }

    public void deleteCustomer(Customer customer){
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
            ps = connection.prepareStatement(STM_DELETE);
            ps.setInt(1, customer.getId());
            ps.execute();
            LOGGER.info("Successful delete data");
        }catch (SQLException e){
            LOGGER.info("Unsuccessful delete data");
            e.printStackTrace();
        }finally {
            try {if (ps != null) ps.close();} catch (Exception e){};
            try {if (connection != null) connection.close();} catch (Exception e){};
        }
    }

    public List<Customer> getAllCustomer(){
        List<Customer> customers = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try{
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
            statement = connection.createStatement();
            rs = statement.executeQuery(STM_RETRIEVE_ALL);
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setCustName(rs.getString("cust_name"));
                customer.setCustEmail(rs.getString("cust_email"));
                customers.add(customer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {if (rs != null) rs.close();} catch (Exception e){};
            try {if (connection != null) connection.close();} catch (Exception e){};
            try {if (statement != null) statement.close();} catch (Exception e){};///
        }
        return customers;
    }

    public Customer getSpesificCustomer(Customer customer){
        Customer cust = new Customer();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
            ps = connection.prepareStatement(STM_RETRIEVE_BY_ID);
            ps.setInt(1, customer.getId());
            rs = ps.executeQuery();
            if (rs.next()){
                rs = ps.getResultSet();

                cust.setId(rs.getInt(1));
                cust.setCustName(rs.getString(2));
                cust.setCustEmail(rs.getString(3));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {if (rs != null) rs.close();} catch (Exception e){};
            try {if (connection != null) connection.close();} catch (Exception e){};
            try {if (ps != null) ps.close();} catch (Exception e){};
        }
        return cust;
    }
}
