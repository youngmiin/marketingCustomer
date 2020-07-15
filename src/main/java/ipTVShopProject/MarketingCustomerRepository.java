package ipTVShopProject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarketingCustomerRepository extends CrudRepository<MarketingCustomer, Long> {

    List<MarketingCustomer> findByOrderId(Long orderId);

        void deleteByOrderId(Long orderId);
}