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
    //从字符串数组中第begin个字符开始挑选number个字符加入list中  
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
        String chs[]={"大盘","中盘","小盘","高市盈","中市盈","低市盈","大波动","中波动","低波动"};  
        Set result = new HashSet<>();
        result = Combination.combination(chs);
        for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object.toString());
		}
    }  
}