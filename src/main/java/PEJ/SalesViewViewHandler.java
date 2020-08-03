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
public class SalesViewViewHandler {


    @Autowired
    private SalesViewRepository salesViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenProductReceived_then_CREATE_1 (@Payload ProductReceived productReceived) {
        try {
            if (productReceived.isMe()) {
                // view 객체 생성
                SalesView salesView = new SalesView();
                // view 객체에 이벤트의 Value 를 set 함
                salesView.setPrdId(productReceived.getPrdId());
                salesView.setPrdQty(productReceived.getPrdQty());
                salesView.setPrdPrice(productReceived.getPrdPrice());
                salesView.setPrdNm(productReceived.getPrdNm());
                // view 레파지 토리에 save
                salesViewRepository.save(salesView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPurchased_then_CREATE_2 (@Payload Purchased purchased) {
        try {
            if (purchased.isMe()) {
                // view 객체 생성
                SalesView salesView = new SalesView();
                // view 객체에 이벤트의 Value 를 set 함
                salesView.setPurchaseId(purchased.getPurchaseId());
                salesView.setPurchaseStatus(purchased.getPurchaseStatus());
                salesView.setPrdId(purchased.getPrdId());
                salesView.setPurchaseQty(purchased.getPurchaseQty());
                salesView.setPurchaseAmt(purchased.getPurchaseAmt());
                // view 레파지 토리에 save
                salesViewRepository.save(salesView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenInventoryChanged_then_UPDATE_1(@Payload InventoryChanged inventoryChanged) {
        try {
            if (inventoryChanged.isMe()) {
                // view 객체 조회
                List<SalesView> salesViewList = salesViewRepository.findByPrdId(inventoryChanged.getPrdId());
                for(SalesView salesView : salesViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    salesView.setPrdQty(inventoryChanged.getPrdQty());
                    // view 레파지 토리에 save
                    salesViewRepository.save(salesView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOutOfStock_then_UPDATE_2(@Payload OutOfStock outOfStock) {
        try {
            if (outOfStock.isMe()) {
                // view 객체 조회
                List<SalesView> salesViewList = salesViewRepository.findByPrdId(outOfStock.getPrdId());
                for(SalesView salesView : salesViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    salesView.setPrdQty(outOfStock.getPrdQty());
                    // view 레파지 토리에 save
                    salesViewRepository.save(salesView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCancelled_then_UPDATE_3(@Payload Cancelled cancelled) {
        try {
            System.out.println("#####START");
            if (cancelled.isMe()) {
                // view 객체 조회
                System.out.println("#####START1 + " + cancelled.getPurchaseId());
                List<SalesView> salesViewList = salesViewRepository.findByPurchaseId(cancelled.getPurchaseId());
                for(SalesView salesView : salesViewList){
                    System.out.println("#####START2 + " + cancelled.getPurchaseStatus());
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    salesView.setPurchaseStatus("취소됨");
                    // view 레파지 토리에 save
                    salesViewRepository.save(salesView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}