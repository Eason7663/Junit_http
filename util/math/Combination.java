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
    //从字符串数组中第begin个字符开始挑选number个字符加入list中  
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
        String chs[]={"大盘","中盘","小盘","高市盈","中市盈","低市盈","大波动","中波动","低波动"};  
        combiantion(chs);  
    }  
}