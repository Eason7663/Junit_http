package fileOperator;

import com.google.gson.Gson;

/**
 * @ClassName: GsonUtil 
 * @Description: ��һ��Json����ת��Ϊ����
 * @author Eason 
 * @date 2017��6��11�� ����2:07:16 
 * 
 */
public class GsonUtil {
    // ��Json���ݽ�������Ӧ��ӳ�����
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }
}
