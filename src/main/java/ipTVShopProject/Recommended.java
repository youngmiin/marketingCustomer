package ipTVShopProject;

public class Recommended extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long customerId;
    private String lastRecommendDate;

    public Recommended(){
        super();
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
