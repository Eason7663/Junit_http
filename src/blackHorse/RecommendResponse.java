package blackHorse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.apache.log4j.Logger;

import blackHorse.BlackHorseRecommendResponse.Data.RepDataBlackHorseRecommend.Strategy.StockInfo;
import fileOperator.FileUtils;
import fileOperator.GsonUtil;

public class BlackHorseRecommendResponse {
	
	private static Logger logger = Logger.getLogger(BlackHorseRecommendResponse.class); 
	
	private String Qid;
	private Integer Err;
	private Integer Counter;
	private Data Data;
	public class Data{
		private Integer ID;
		private List<RepDataBlackHorseRecommend> RepDataBlackHorseRecommend;
		public class RepDataBlackHorseRecommend{
			private Integer Permision;
			private List<Strategy> Strategy;
			public class Strategy{
				private String Name;
				private Integer IsNotice;
				private List<StockInfo> StockInfo;
				public class StockInfo{
					private String StockCode;
					private String StockName;
					private String Time;
					private Float Price;
					private Float Income;
					private Integer IsFollow;
					public String getStockCode() {
						return StockCode;
					}
					public String getStockName() {
						return StockName;
					}
					public String getTime() {
						return Time;
					}
					public Float getPrice() {
						return Price;
					}
					public Float getIncome() {
						return Income;
					}
					public Integer getIsFollow() {
						return IsFollow;
					}
					public void setStockCode(String stockCode) {
						StockCode = stockCode;
					}
					public void setStockName(String stockName) {
						StockName = stockName;
					}
					public void setTime(String time) {
						Time = time;
					}
					public void setPrice(Float price) {
						Price = price;
					}
					public void setIncome(Float income) {
						Income = income;
					}
					public void setIsFollow(Integer isFollow) {
						IsFollow = isFollow;
					}	
				}
				public String getName() {
					return Name;
				}
				public Integer getIsNotice() {
					return IsNotice;
				}
				public List<StockInfo> getStockInfo() {
					return StockInfo;
				}
				public void setName(String name) {
					Name = name;
				}
				public void setIsNotice(Integer isNotice) {
					IsNotice = isNotice;
				}
				public void setStockInfo(List<StockInfo> stockInfo) {
					StockInfo = stockInfo;
				}
			}
			public Integer getPermision() {
				return Permision;
			}
			public List<Strategy> getStrategy() {
				return Strategy;
			}
			public void setPermision(Integer permision) {
				Permision = permision;
			}
			public void setStrategy(List<Strategy> strategy) {
				Strategy = strategy;
			}
		}
		public Integer getID() {
			return ID;
		}
		public List<RepDataBlackHorseRecommend> getRepDataBlackHorseRecommend() {
			return RepDataBlackHorseRecommend;
		}
		public void setID(Integer iD) {
			ID = iD;
		}
		public void setRepDataBlackHorseRecommend(List<RepDataBlackHorseRecommend> repDataBlackHorseRecommend) {
			RepDataBlackHorseRecommend = repDataBlackHorseRecommend;
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



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String strJson = FileUtils.readFile("dat\\result.txt");
			BlackHorseRecommendResponse blackHorseRecommendResponse = GsonUtil.parseJsonWithGson(strJson, 
					BlackHorseRecommendResponse.class);
			List<StockInfo> stockInfoList = blackHorseRecommendResponse.getData().getRepDataBlackHorseRecommend().get(0).getStrategy().get(1).getStockInfo();
			for (StockInfo stockInfo : stockInfoList) {
				System.out.println(stockInfo.getStockCode());
			}
			logger.info("∂¡»°≥…π¶£°");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
