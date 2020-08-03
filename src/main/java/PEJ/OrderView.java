package PEJ;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="OrderView_table")
public class OrderView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String orderId;
        private String orderStatus;
        private String prdId;
        private Integer prdQty;
        private String deliveryId;
        private String deliveryStatus;
        private String prdNm;
        private Integer prdPrice;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }
        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
        public String getPrdId() {
            return prdId;
        }

        public void setPrdId(String prdId) {
            this.prdId = prdId;
        }
        public Integer getPrdQty() {
            return prdQty;
        }

        public void setPrdQty(Integer prdQty) {
            this.prdQty = prdQty;
        }
        public String getDeliveryId() {
            return deliveryId;
        }

        public void setDeliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
        }
        public String getDeliveryStatus() {
            return deliveryStatus;
        }

        public void setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }
        public String getPrdNm() {
            return prdNm;
        }

        public void setPrdNm(String prdNm) {
            this.prdNm = prdNm;
        }
        public Integer getPrdPrice() {
            return prdPrice;
        }

        public void setPrdPrice(Integer prdPrice) {
            this.prdPrice = prdPrice;
        }

}
