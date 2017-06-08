package math;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;  
import java.util.Queue;
import java.util.Set;

import fileOperator.ExcelOperator;  
public class Combination{  
    public static Set<List<String>> combination(String chs[]){  
    	
        if(chs==null||chs.length==0){  
            return null;  
        }  
        List<String> list=new ArrayList<String>();  
        Set<List<String>> result=new HashSet<List<String>>(); 
        for(int i=1;i<=chs.length;i++){  
            combine(chs,0,i,list,result);  
        }
		return result;  
    }  
    //���ַ��������е�begin���ַ���ʼ��ѡnumber���ַ�����list��  
    public static void combine(String []cs,int begin,int number,List<String> list, Set<List<String>> result){
    	
        if(number==0){  
//            System.out.println(list.toString()); 
            result.add(list);
            
            return;  
        }  
        if(begin==cs.length){  
            return;  
        }  
        list.add(cs[begin]);  
        combine(cs,begin+1,number-1,list, result);  
        list.remove((String)cs[begin]);  
        combine(cs,begin+1,number,list,result);  
    }  
    public static void main(String args[]){  
        String chs[]={"����","����","С��","����ӯ","����ӯ","����ӯ","�󲨶�","�в���","�Ͳ���"};  
        Set result = new HashSet<>();
        result = Combination.combination(chs);
        for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object.toString());
		}
    }  
}