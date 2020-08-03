package PEJ;

import PEJ.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderViewViewHandler {


    @Autowired
    private OrderViewRepository orderViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {
            if (ordered.isMe()) {
                // view 객체 생성
                OrderView orderView = new OrderView();
                // view 객체에 이벤트의 Value 를 set 함
                orderView.setOrderId(ordered.getOrderId());
                orderView.setOrderStatus(ordered.getOrderStatus());
                orderView.setPrdId(ordered.getPrdId());
                orderView.setPrdQty(ordered.getPrdQty());
                orderView.setPrdNm(ordered.getPrdNm());
                orderView.setPrdPrice(ordered.getPrdPrice());
                // view 레파지 토리에 save
                orderViewRepository.save(orderView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenShipped_then_UPDATE_1(@Payload Shipped shipped) {
        try {
            if (shipped.isMe()) {
                // view 객체 조회
                List<OrderView> orderViewList = orderViewRepository.findByOrderId(shipped.getOrderId());
                for(OrderView orderView : orderViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderView.setOrderStatus(shipped.getDeliveryStatus());
                    orderView.setDeliveryStatus(shipped.getDeliveryStatus());
                    // view 레파지 토리에 save
                    orderViewRepository.save(orderView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCanceled_then_UPDATE_2(@Payload DeliveryCanceled deliveryCanceled) {
        try {
            if (deliveryCanceled.isMe()) {
                // view 객체 조회
                List<OrderView> orderViewList = orderViewRepository.findByOrderId(deliveryCanceled.getOrderId());
                for(OrderView orderView : orderViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderView.setOrderStatus(deliveryCanceled.getDeliveryStatus());
                    orderView.setDeliveryStatus(deliveryCanceled.getDeliveryStatus());
                    // view 레파지 토리에 save
                    orderViewRepository.save(orderView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}