package org.codegym.shoequeen.services;

import org.codegym.shoequeen.enties.Customer;
import org.codegym.shoequeen.enties.Order;
import org.codegym.shoequeen.models.OrderModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {
    private OrderModel orderModel;

    public OrderService() {
        orderModel = new OrderModel();
    }


    public void showPageListOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String keyword = request.getParameter("keyword");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String sort = request.getParameter("sort");
        ResultSet data = null;

        if (startDate != null && endDate != null &&
                startDate.matches("\\d{4}-\\d{2}-\\d{2}") &&
                endDate.matches("\\d{4}-\\d{2}-\\d{2}")) {

            // Tìm kiếm đơn hàng trong khoảng thời gian
            data = orderModel.findOrdersByDateRange(startDate, endDate);
        } else {
            // Lấy tất cả đơn hàng nếu không có từ khóa
            data = orderModel.getAllOrder();
        }



        if (keyword != null && !keyword.isEmpty()) {
            // Nếu có từ khóa tìm kiếm theo tên khách hàng
            data = orderModel.findOrderByCustomerName(keyword);
        }


        if (startDate != null && endDate != null &&
                startDate.matches("\\d{4}-\\d{2}-\\d{2}") &&
                endDate.matches("\\d{4}-\\d{2}-\\d{2}")) {

            // Lọc theo khoảng thời gian
            data = orderModel.findOrdersByDateRange(startDate, endDate);

            // Kiểm tra nếu có yêu cầu sắp xếp
            if (sort != null) {
                if (sort.equals("asc")) {
                    data = orderModel.findOrdersSortedByTotalAmountAsc(); // Sắp xếp tăng dần
                } else if (sort.equals("desc")) {
                    data = orderModel.findOrdersSortedByTotalAmountDesc(); // Sắp xếp giảm dần
                }
            }

        } else if (keyword != null && !keyword.isEmpty()) {
            // Nếu không có bộ lọc theo ngày và có từ khóa tìm kiếm theo tên khách hàng

            // Lọc theo tên khách hàng
            data = orderModel.findOrderByCustomerName(keyword);

            // Kiểm tra nếu có yêu cầu sắp xếp
            if (sort != null) {
                if (sort.equals("asc")) {
                    data = orderModel.findOrdersSortedByTotalAmountAsc(); // Sắp xếp tăng dần
                } else if (sort.equals("desc")) {
                    data = orderModel.findOrdersSortedByTotalAmountDesc(); // Sắp xếp giảm dần
                }
            }

        } else {
            // Nếu không có bộ lọc theo ngày và không có từ khóa tìm kiếm, lấy tất cả đơn hàng

            // Kiểm tra nếu có yêu cầu sắp xếp
            if (sort != null) {
                if (sort.equals("asc")) {
                    data = orderModel.findOrdersSortedByTotalAmountAsc(); // Sắp xếp tăng dần
                } else if (sort.equals("desc")) {
                    data = orderModel.findOrdersSortedByTotalAmountDesc(); // Sắp xếp giảm dần
                }
            } else {
                // Lấy tất cả đơn hàng nếu không có yêu cầu sắp xếp
                data = orderModel.getAllOrder();
            }
        }

        List<Order> listOrder = new ArrayList<>();
        // ORM
        while (data.next()) {
            int orderId = data.getInt("order_id");
            String customerName = data.getString("customer_name");
            int customerId = data.getInt("customer_id");
            Date orderDate = data.getDate("order_date");
            double totalAmount = data.getDouble("total_amount");
            String email = data.getString("email");
            String phone = data.getString("phone");
            String address = data.getString("address");

            Customer customer = new Customer(customerName, email, phone, address);
            customer.setId(customerId);

            Order order = new Order(customer, orderDate, totalAmount);
            order.setId(orderId);

            listOrder.add(order);
        }


        request.setAttribute("listOrder", listOrder);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/orders/list.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}