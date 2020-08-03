package PEJ;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalesViewRepository extends CrudRepository<SalesView, Long> {

    List<SalesView> findByPrdId(String prdId);
    List<SalesView> findByPurchaseId(String purchaseId);

}