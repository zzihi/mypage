package PEJ;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderViewRepository extends CrudRepository<OrderView, Long> {

    List<OrderView> findByOrderId(String orderId);

}