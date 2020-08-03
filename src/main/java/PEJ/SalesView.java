package PEJ;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SalesView_table")
public class SalesView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String prdId;
        private Integer prdQty;
        private Integer prdPrice;
        private String prdNm;
        private String purchaseId;
        private String purchaseStatus;
        private Integer purchaseQty;
        private Integer purchaseAmt;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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
        public Integer getPrdPrice() {
            return prdPrice;
        }

        public void setPrdPrice(Integer prdPrice) {
            this.prdPrice = prdPrice;
        }
        public String getPrdNm() {
            return prdNm;
        }

        public void setPrdNm(String prdNm) {
            this.prdNm = prdNm;
        }
        public String getPurchaseId() {
            return purchaseId;
        }

        public void setPurchaseId(String purchaseId) {
            this.purchaseId = purchaseId;
        }
        public String getPurchaseStatus() {
            return purchaseStatus;
        }

        public void setPurchaseStatus(String purchaseStatus) {
            this.purchaseStatus = purchaseStatus;
        }
        public Integer getPurchaseQty() {
            return purchaseQty;
        }

        public void setPurchaseQty(Integer purchaseQty) {
            this.purchaseQty = purchaseQty;
        }
        public Integer getPurchaseAmt() {
            return purchaseAmt;
        }

        public void setPurchaseAmt(Integer purchaseAmt) {
            this.purchaseAmt = purchaseAmt;
        }

}
