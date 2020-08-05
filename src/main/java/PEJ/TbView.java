package PEJ;

import javax.persistence.*;

@Entity
@Table(name="TbView_table")
public class TbView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long tbId;
        private Long payId;
        private String tbStatus;
        private String payStatus;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getTbId() {
            return tbId;
        }

        public void setTbId(Long tbId) {
            this.tbId = tbId;
        }
        public Long getPayId() {
            return payId;
        }

        public void setPayId(Long payId) {
            this.payId = payId;
        }
        public String getTbStatus() {
            return tbStatus;
        }

        public void setTbStatus(String tbStatus) {
            this.tbStatus = tbStatus;
        }
        public String getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(String payStatus) {
            this.payStatus = payStatus;
        }

}
