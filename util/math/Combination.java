package math;
import java.util.ArrayList;  
import java.util.List;  
import java.util.Queue;

import fileOperator.ExcelOperator;  
public class Combination {  
    public static void combiantion(String chs[]){  
        if(chs==null||chs.length==0){  
            return ;  
        }  
        List<String> list=new ArrayList<String>();  
        for(int i=1;i<=chs.length;i++){  
            combine(chs,0,i,list);  
        }  
    }  
    //���ַ��������е�begin���ַ���ʼ��ѡnumber���ַ�����list��  
    public static void combine(String []cs,int begin,int number,List<String> list){
    	
        if(number==0){  
            System.out.println(list.toString());  
            return ;  
        }  
        if(begin==cs.length){  
            return;  
        }  
        list.add(cs[begin]);  
        combine(cs,begin+1,number-1,list);  
        list.remove((String)cs[begin]);  
        combine(cs,begin+1,number,list);  
    }  
    public static void main(String args[]){  
        String chs[]={"����","����","С��","����ӯ","����ӯ","����ӯ","�󲨶�","�в���","�Ͳ���"};  
        combiantion(chs);  
    }  
}