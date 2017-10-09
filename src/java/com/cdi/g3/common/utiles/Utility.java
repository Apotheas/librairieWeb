
package com.cdi.g3.common.utiles;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author youssef
 */
public class Utility {
    
    public  static java.sql.Date formatStringToSQLDate(String strDate) throws Exception{

       Date utilDate = new Date(); //DateFormat

       SimpleDateFormat dfFormat = new SimpleDateFormat("yyyy-MM-dd"); // parse string into a DATE format      

       utilDate = dfFormat.parse(strDate); // convert a util.Date to milliseconds via its getTime() method        

       long time = utilDate.getTime(); // get the long value of java.sql.Date

       java.sql.Date sqlDate = new java.sql.Date(time);

       return sqlDate;  

   }
   public static  boolean regexTel(String text){
    
        return text.matches( "(0|0033)[1-9][0-9]{8}");
    
    }
    
    public static  boolean regexEmail(String text){
        return text.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }
    public static  boolean regexNom(String text){
        if(text.isEmpty()){
            return false;
        }else
        return text.matches("[a-zA-Z]*");
    }
    
    public static  boolean regexDate(String text){
        return text.matches("\\d{4}-\\d{2}-\\d{2}");
    }
    public static  boolean regexIsbn(String text){
        return text.matches("(\\d{13})|(\\d{10})");
    }
    public static  boolean regexCp(String text){
        return text.matches("((0[1-9])|([1-8][0-9])|(9[0-8])|(2A)|(2B))[0-9]{3}");
    }
    public static  boolean regexAdresse(String text){
        return text.matches("[0-9]{1,3}(?:(?:[,. ]){1}[-a-zA-Zàâäéèêëïîôöùûüç]+)+");
    } 
     public static  boolean regexFloat(String text){
        return text.matches("");
    }
     
    public static float formatFloatToFloatPrecision (float number, int precesion){
       String strPrecesion = "1";
       for (int i=0 ;i <precesion ; i++ )
           strPrecesion+="0";        
       precesion = Integer.parseInt(strPrecesion);
       
       int intNumber =  (int) (precesion *number);
       float floatNumber = (float) intNumber;
       
       return  floatNumber/ precesion;
       
       
   }
    
}
