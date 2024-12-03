package org.codegym.shoequeen.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderModel {

    private Connection connection;

    public OrderModel() {
        connection = Database.getConnection();
    }


    public ResultSet getAllOrder() throws SQLException {
        String sql = "SELECT * FROM orders JOIN customers ON orders.customer_id = customers.customer_id";
        PreparedStatement ps = connection.prepareStatement(sql);
        // thu hien truy van
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }

    public int getTotalOrder() throws SQLException {
        // viet sql
        String sql = "SELECT COUNT(*) as totalOrder FROM orders";
        // dua cau lenh truy van
        PreparedStatement ps = connection.prepareStatement(sql);
        // thu hien truy van
        ResultSet resultSet = ps.executeQuery();
        int totalOrder = 0;
        while (resultSet.next()) {
            totalOrder = resultSet.getInt("totalOrder");
        }
        return totalOrder;
    }

    public ResultSet findOrderByCustomerName(String name) throws SQLException {
        // viet sql
        String sql = "select *, customers.customer_name from orders join customers on customers.customer_id=orders.customer_id where customers.customer_name like ?";
        // dua cau lenh truy van
        PreparedStatement ps = connection.prepareStatement(sql);
        // thay the id vao cau lenh
        ps.setString(1, "%" + name + "%");
        // thu hien truy van
        return ps.executeQuery();
    }

//    public ResultSet findOrderByOrderDate(String orderDate ) throws SQLException {
//        // viet sql
//        String sql = "select *, customers.customer_name from orders join customers on customers.customer_id=orders.customer_id where order_date  like ?";
//        // dua cau lenh truy van
//        PreparedStatement ps = connection.prepareStatement(sql);
//        // thay the id vao cau lenh
//        ps.setString(1,orderDate);
//        // thu hien truy van
//        return ps.executeQuery();
//   }
public ResultSet findOrdersByDateRange(String startDate, String endDate) throws SQLException {
    // Viết SQL
    String sql = "SELECT *, customers.customer_name FROM orders " +
            "JOIN customers ON customers.customer_id = orders.customer_id " +
            "WHERE order_date BETWEEN ? AND ?";

    // Tạo PreparedStatement
    PreparedStatement ps = connection.prepareStatement(sql);

    // Thay thế giá trị vào câu lệnh
    ps.setString(1, startDate); // Ngày bắt đầu (yyyy-MM-dd)
    ps.setString(2, endDate);   // Ngày kết thúc (yyyy-MM-dd)

    // Thực hiện truy vấn
    return ps.executeQuery();
}

    public ResultSet findOrdersSortedByTotalAmountAsc() throws SQLException {
        String sql = "SELECT *, customers.customer_name FROM orders " +
                "JOIN customers ON customers.customer_id = orders.customer_id " +
                "ORDER BY total_amount ASC";

        PreparedStatement ps = connection.prepareStatement(sql);
        return ps.executeQuery();
    }

    public ResultSet findOrdersSortedByTotalAmountDesc() throws SQLException {
        String sql = "SELECT *, customers.customer_name FROM orders " +
                "JOIN customers ON customers.customer_id = orders.customer_id " +
                "ORDER BY total_amount DESC";

        PreparedStatement ps = connection.prepareStatement(sql);
        return ps.executeQuery();
    }



}
