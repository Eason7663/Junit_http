package blackHorse;

import java.util.List;

public class UserSetStockGetResponse {
	private String Qid;
	private Integer Err;
	private Integer Counter;
	private Data Data;
	public class Data{
		private Integer ID;
		private List<RepDataPoolUserStockInfo> RepDataPoolUserStockInfo;
		public class RepDataPoolUserStockInfo{
			private String Stock;

			public String getStock() {
				return Stock;
			}

			public void setStock(String stock) {
				Stock = stock;
			}
		}
		public Integer getID() {
			return ID;
		}
		public List<RepDataPoolUserStockInfo> getRepDataPoolUserStockInfo() {
			return RepDataPoolUserStockInfo;
		}
		public void setID(Integer iD) {
			ID = iD;
		}
		public void setRepDataPoolUserStockInfo(List<RepDataPoolUserStockInfo> repDataPoolUserStockInfo) {
			RepDataPoolUserStockInfo = repDataPoolUserStockInfo;
		}
	}
	public String getQid() {
		return Qid;
	}
	public Integer getErr() {
		return Err;
	}
	public Integer getCounter() {
		return Counter;
	}
	public Data getData() {
		return Data;
	}
	public void setQid(String qid) {
		Qid = qid;
	}
	public void setErr(Integer err) {
		Err = err;
	}
	public void setCounter(Integer counter) {
		Counter = counter;
	}
	public void setData(Data data) {
		Data = data;
	}
}
