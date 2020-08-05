package PEJ;

import PEJ.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbViewViewHandler {


    @Autowired
    private TbViewRepository tbViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenTbordered_then_CREATE_1 (@Payload Tbordered tbordered) {
        try {
            if (tbordered.isMe()) {
                // view 객체 생성
                TbView tbView = new TbView();
                // view 객체에 이벤트의 Value 를 set 함
                tbView.setTbId(tbordered.getTbId());
                tbView.setTbStatus(tbordered.getTbStatus());
                // view 레파지 토리에 save
                tbViewRepository.save(tbView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenTbcancelled_then_UPDATE_1(@Payload Tbcancelled tbcancelled) {
        try {
            if (tbcancelled.isMe()) {
                // view 객체 조회
                List<TbView> tbViewList = tbViewRepository.findByTbId(tbcancelled.getTbId());
                for(TbView tbView : tbViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    tbView.setTbStatus(tbcancelled.getTbStatus());
                    // view 레파지 토리에 save
                    tbViewRepository.save(tbView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayed_then_UPDATE_2(@Payload Payed payed) {
        try {
            if (payed.isMe()) {
                // view 객체 조회
                List<TbView> tbViewList = tbViewRepository.findByPayId(payed.getPayId());

                for(TbView tbView : tbViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    tbView.setPayStatus(payed.getPayStatus());
                    // view 레파지 토리에 save
                    tbViewRepository.save(tbView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaycancelled_then_UPDATE_3(@Payload Paycancelled paycancelled) {
        try {
            if (paycancelled.isMe()) {
                // view 객체 조회
                List<TbView> tbViewList = tbViewRepository.findByPayId(paycancelled.getPayId());
                for(TbView tbView : tbViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    tbView.setPayStatus(paycancelled.getPayStatus());
                    // view 레파지 토리에 save
                    tbViewRepository.save(tbView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}