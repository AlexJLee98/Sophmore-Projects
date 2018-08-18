//Created Alexnader J. Lee 4/22/18

import java.io.*;
import java.util.*;
import java.math.*;
import java.util.ArrayList;

//Runs the tests listed on the PDF
class test {
    public static void main (String args[]) {
        //apint test
        System.out.println("apint test");
        apint addA = new apint();
        apint subA = new apint();
        apint mulA = new apint();
        apint divA = new apint();
        apint a1 = new apint();                      //Test 1
        apint a2 = new apint("", "2147483999");      //Test 2
        apint a3 = new apint(1250925675);            //Test 3
        apint a4 = new apint(3491456103.541);        //Test 4
        apint a5 = new apint("+", "12878978901");    //Test 5
        apint a6 = new apint("+", "17345678902");
        a2.print();                                  
        addA = a2.add(a3);                           //Addition test
        addA.print();
        subA = a4.sub(a3);                           //Subtraction test
        subA.print();                                   
        mulA = a5.mul(a6);                           //Multiplication test
        mulA.print();                                
        divA = a4.div(a3);                           //Division test
        divA.print();
        
        //aprat test
        System.out.println();
        System.out.println("aprat test");
        aprat addAP = new aprat();
        aprat subAP = new aprat();
        aprat mulAP = new aprat();
        aprat divAP = new aprat();
        aprat a7 = new aprat();                          //Test 1
        aprat a8 = new aprat("", "986543", "94374");     //Test 2
        aprat a9 = new aprat(20865);                     //Test 3
        aprat a10 = new aprat(9060.1);                   //Test 4
        aprat a11 = new aprat("+", "6590843", "9822");
        aprat a12 = new aprat(4937094.543);
        aprat a13 = new aprat("-", "54938", "659437");
        aprat a14 = new aprat(539286.634);
        aprat a15 = new aprat(-9599827);
        a10.print();    
        addAP = a8.addAPRAT(a9);                        //Addition test
        addAP.print();
        subAP = a10.subAPRAT(a11);                      //Subtraction test
        subAP.print();
        mulAP = a12.mulAPRAT(a13);                      //Multiplication test
        mulAP.print();
        divAP = a14.divAPRAT(a15);                      //Division test
        divAP.print();
    }
}

