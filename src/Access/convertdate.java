/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

/**
 *
 * @author phong
 */
public class convertdate {
    public String convert(int serial){
        if (serial == 60)
        {
        
        return "29/02/1900";
        }
        else if (serial < 60)
        {
            // Because of the 29-02-1900 bug, any serial date 
            // under 60 is one off... Compensate.
            serial++;
        }
       
        int l=serial+68569+2415019;
        
        int n = (int)(( 4 * l ) / 146097);
        l = l - (int)(( 146097 * n + 3 ) / 4);
        int i = (int)(( 4000 * ( l + 1 ) ) / 1461001);
        l = l - (int)(( 1461 * i ) / 4) + 31;
        int j = (int)(( 80 * l ) / 2447);
        String nDay = String.valueOf(l - (int)(( 2447 * j ) / 80));
        l = (int)(j / 11);
        String nMonth = String.valueOf(j + 2 - ( 12 * l ));
        String nYear = String.valueOf(100 * ( n - 49 ) + i + l);
        if(nDay.length()==1)nDay="0"+nDay;
        if(nMonth.length()==1)nMonth="0"+nMonth;
        String date=""+nDay+"/"+nMonth+"/"+nYear;
        
        return  date;
    }
    public static void main(String[] args) {
        convertdate c=new convertdate();
        System.out.println(c.convert(44231));
    }
}
