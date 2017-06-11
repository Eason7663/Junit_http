package fileOperator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * @ClassName: FileUtils 
 * @Description: TODO 
 * @author Eason 
 * @date 2017��6��11�� ����1:49:03 
 * 
 */
public class FileUtils {	
    /**
     * ���ı��ļ��е����ݶ��뵽buffer��
     * @param buffer buffer
     * @param filePath �ļ�·��
     * @throws IOException �쳣
     * @author cn.outofmemory
     * @date 2013-1-7
     */
    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // ��������ÿ�ж�ȡ������
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // ��ȡ��һ��
        while (line != null) { // ��� line Ϊ��˵��������
            buffer.append(line); // ���������������ӵ� buffer ��
            buffer.append("\n"); // ���ӻ��з�
            line = reader.readLine(); // ��ȡ��һ��
        }
        reader.close();
        is.close();
    }

    /**
     * ��ȡ�ı��ļ�����
     * @param filePath �ļ�����·��
     * @return �ı�����
     * @throws IOException �쳣
     * @author cn.outofmemory
     * @date 2013-1-7
     */
    public static String readFile(String filePath) throws IOException {
        StringBuffer sb = new StringBuffer();
        FileUtils.readToBuffer(sb, filePath);
        return sb.toString();
    }
}