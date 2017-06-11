package fileOperator;

import com.google.gson.Gson;

/**
 * @ClassName: GsonUtil 
 * @Description: 将一个Json数据转换为对象
 * @author Eason 
 * @date 2017年6月11日 上午2:07:16 
 * 
 */
public class GsonUtil {
    // 将Json数据解析成相应的映射对象
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }
}
