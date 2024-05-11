/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author feloa
 */
public class printBill extends Bills{

      public  String Field;
      public  Date date = new Date();

      public printBill(){
          createConnection();
      }
      
      public String setBill(printBill bill) {
       bill.Field =
                
            "                  Electricity Billing System"+"\n"+
            "=================================="+"\n"+
//            "Customer Name : "+ bill. + "\n" +
//                    "\n" +
//                "=================================="+"\n"+
            "Bill ID : '"+ bill_id + "'\n" +
                    "\n" +
                "=================================="+"\n"+
            "Bill Month : '"+ month + "'\n" +
                    "\n" +
                "=================================="+"\n"+
            "Bill Year : '"+ year + "'\n" +
                    "\n" +
                "=================================="+"\n"+
            "Meter ID : '"+ meter_id + "'\n" +
                    "\n" +
                "=================================="+"\n"+
            "Consumption : '"+ consumption + "'\n" +
                    "\n" +
                "=================================="+"\n"+
            "Total Pill : '"+ total_bill + "'\n" +
                    "\n" +
                "-----------------------------------------------------------"+"\n"+
            "Billing Date : '" +date.toString()+"'\n"+
            "************************************************"+"\n"+
            "          • Thanks For Using Our Service • "+"\n"
            +"\n"
            +"   Contact : electricityhelwan4@Gmail.com";
   
  return Field;
    }


}



