package ipTVShopProject;

import ipTVShopProject.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MarketingCustomerViewHandler {


    @Autowired
    private MarketingCustomerRepository marketingCustomerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenInfoRegistrated_then_CREATE_ (@Payload InfoRegistrated infoRegistrated) {
        try {
            if (infoRegistrated.isMe()) {
                // view 객체 생성
                MarketingCustomer marketingCustomer = new MarketingCustomer();
                // view 객체에 이벤트의 Value 를 set 함
                marketingCustomer.setOrderId(infoRegistrated.getOrderId());
                marketingCustomer.setCustomerId(infoRegistrated.getCustomerId());
                // view 레파지 토리에 save
                marketingCustomerRepository.save(marketingCustomer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenRecommended_then_UPDATE_(@Payload Recommended recommended) {
        try {
            if (recommended.isMe()) {
                // view 객체 조회
                List<MarketingCustomer> marketingCustomerList = marketingCustomerRepository.findByOrderId(recommended.getOrderId());
                for(MarketingCustomer marketingCustomer : marketingCustomerList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    marketingCustomer.setLastRecommendDate(recommended.getLastRecommendDate());
                    // view 레파지 토리에 save
                    marketingCustomerRepository.save(marketingCustomer);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    @StreamListener(KafkaProcessor.INPUT)
    public void whenInfoDeleted_then_DELETE_(@Payload InfoDeleted infoDeleted) {
        try {
            if (infoDeleted.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                marketingCustomerRepository.deleteByOrderId(infoDeleted.getOrderId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}