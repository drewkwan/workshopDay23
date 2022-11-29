package vttp.workshopDay23.day23Workshop.repositories;

public class Queries {
    public static final String SQL_GET_ORDERS_BY_ORDER_ID ="SELECT o.id, o.order_date, o.customer_id, od.quantity*od.unit_price as total, od.quantity*p.standard_cost as cost_price FROM orders o JOIN customers c ON o.customer_id = c.id JOIN order_details od ON od.order_id = o.id JOIN products p ON od.product_id=p.id WHERE order_id=?;";
}
