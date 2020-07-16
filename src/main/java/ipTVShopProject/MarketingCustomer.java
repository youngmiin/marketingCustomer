package ipTVShopProject;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MarketingCustomer_table")
public class MarketingCustomer {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long orderId;
        private Long customerId;
        private String lastRecommendDate;
        private String status;


        public String getStatus() {
        return status;
    }

        public void setStatus(String status) {
        this.status = status;
    }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }
        public Long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Long customerId) {
            this.customerId = customerId;
        }
        public String getLastRecommendDate() {
            return lastRecommendDate;
        }

        public void setLastRecommendDate(String lastRecommendDate) {
            this.lastRecommendDate = lastRecommendDate;
        }

}
