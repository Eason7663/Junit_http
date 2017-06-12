package blackHorse;

import blackHorse.UserSetPreferGetResponse.Data;

public class UserSetPreferCommonResponse {
	private String Qid;
	private Integer Err;
	private Integer Counter;
	private Data Data;
	public class Data{
		private Integer code;
		private String desc;
		public Integer getCode() {
			return code;
		}
		public String getDesc() {
			return desc;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public void setDesc(String desc) {
			this.desc = desc;
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
