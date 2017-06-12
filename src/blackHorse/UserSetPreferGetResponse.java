package blackHorse;


import java.util.List;

import blackHorse.UserSetPreferCommonResponse.Data;

public class UserSetPreferGetResponse {
	private String Qid;
	private Integer Err;
	private Integer Counter;
	private Data Data;
	public class Data{
		private Integer ID;
		private List<RepDataPoolUserPreferInfo> RepDataPoolUserPreferInfo;
		public class RepDataPoolUserPreferInfo{
			private String Prefer;

			public String getPrefer() {
				return Prefer;
			}

			public void setPrefer(String prefer) {
				Prefer = prefer;
			}
		}
		public Integer getID() {
			return ID;
		}
		public List<RepDataPoolUserPreferInfo> getRepDataPoolUserPreferInfo() {
			return RepDataPoolUserPreferInfo;
		}
		public void setID(Integer iD) {
			ID = iD;
		}
		public void setRepDataPoolUserPreferInfo(List<RepDataPoolUserPreferInfo> repDataPoolUserPreferInfo) {
			RepDataPoolUserPreferInfo = repDataPoolUserPreferInfo;
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
