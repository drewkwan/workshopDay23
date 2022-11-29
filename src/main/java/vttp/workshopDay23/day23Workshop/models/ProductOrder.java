package vttp.workshopDay23.day23Workshop.models;

import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class ProductOrder {
    private int id;
    private String orderDate;
    private int custId;
    private Float total;
    private Float costPrice;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public int getCustId() {
        return custId;
    }
    public void setCustId(int custId) {
        this.custId = custId;
    }
    public Float getTotal() {
        return total;
    }
    public void setTotal(Float total) {
        this.total = total;
    }
    public Float getCostPrice() {
        return costPrice;
    }
    public void setCostPrice(Float costPrice) {
        this.costPrice = costPrice;
    }

    public static ProductOrder create(SqlRowSet rs) {
        ProductOrder p =new ProductOrder();
        p.setId(rs.getInt("id"));
        p.setOrderDate(rs.getString("order_date"));
        p.setCustId(rs.getInt("customer_id"));
        p.setTotal(rs.getFloat("total"));
        p.setCostPrice(rs.getFloat("cost_price"));

        return p;
    }

}
