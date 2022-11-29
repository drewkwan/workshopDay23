package vttp.workshopDay23.day23Workshop.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.workshopDay23.day23Workshop.models.ProductOrder;
import static vttp.workshopDay23.day23Workshop.repositories.Queries.*;

@Repository
public class OrdersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ProductOrder> getOrdersByOrderId(int customerId) {

        //perform the query
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_ORDERS_BY_ORDER_ID, customerId);
        
        final List<ProductOrder> orders = new LinkedList<>();

        //Scan through rowset
        while (rs.next()) {
            orders.add(ProductOrder.create(rs));
        }

        return orders;
        
    }

    
}
