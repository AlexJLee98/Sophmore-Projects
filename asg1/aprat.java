//Created Alexander J. Lee 4/20/18 

import java.io.*;
import java.util.*;
import java.math.*;
import java.util.ArrayList;

//aprat class
class aprat extends apint 
{
    
    String sign;
    apint num;
    apint denom;
    boolean isPos;
    
    //Default constructor
    public aprat() 
    {
        super("", "");
        initAPRAT("", "", "");
    }
    
    //Aprat given an integer
    public aprat(int input) 
    {
        super("", "");
        String val = Integer.toString(input);
        if (input < 0) 
        {
            val = val.substring(1);
            initAPRAT("-", val, "1"); 
        } else 
        {
            initAPRAT("+", val, "1");
        }
    }
    
    //Aprat given a precision
    public aprat(double input) 
    {
        super("", "");
        String s = String.valueOf(input);
        int numDigits = s.length() - 1 - s.indexOf('.');
        int denom = 1;
        for (int i = 0; i < numDigits; i++) {
            input = input * 10;    
            denom = denom * 10;
        }

        int num = (int) Math.round(input);
        String n = Integer.toString(num);
        String d = Integer.toString(denom);
        if (input >= 0) 
        {
            initAPRAT("+", n, d);
        } else 
        {
            initAPRAT("-", n, d);
        }
    }
    
    //Aprat given sign and 2 strings
    public aprat(String sign, String numerator, String denominator) 
    {
        super("", "");
        initAPRAT(sign, numerator, denominator);
    }
    
    //Initializes the aprat type
    public void initAPRAT(String sign, String numerator, String denominator) 
    {
        this.sign = sign;
        this.num = new apint(sign, numerator);
        this.denom = new apint (sign, denominator);
        
        //Initialize sign 
        if (sign == "-") 
        {
            this.isPos = false;
        } else 
        {
            this.isPos = true;
        }
    }
    
    //Print aprat
    public void print() 
    {
        System.out.println();
        if (isPos == false) {
            System.out.print('-');
        }  
        for (int i = 0; i < num.arrL.size(); i++) 
        {
            System.out.print(num.arrL.get(i));
        }
        System.out.print('/');
        for (int j = 0; j < denom.arrL.size(); j++) 
        {
            System.out.print(denom.arrL.get(j));
        }
        System.out.println();
    }
    
    //Simplify fraction
    public void simplifyFrac() {
        
    }
    
    //Adds 2 aprats
    public aprat addAPRAT(aprat num2) 
    {
        aprat sum = new aprat("", "", "");
        boolean bool1;
        boolean bool2;
        //Copy val into temp
        apint temp = new apint (denom.strSign, denom.strVal);
        apint temp2 = new apint (num2.denom.strSign, num2.denom.strVal);
        bool1 = num.isPos;
        bool2 = num2.num.isPos;
        //Adding algorithm
        if (denom.strVal != num2.denom.strVal) 
        {
            num = num.mul(num2.denom);
            num2.num = num2.num.mul(denom);
            sum.denom = temp.mul(temp2);
            sum.isPos = isPos;
        } else 
        {
            sum.denom = denom;
        }
        num.isPos = bool1;
        num2.num.isPos = bool2;
        sum.num = num.add(num2.num);
        sum.isPos = isPos;
        return sum;
    }
    
    //Subtracts 2 aprats
    public aprat subAPRAT(aprat num2) 
    {
        boolean bool1;
        boolean bool2;
        aprat difference = new aprat("", "", "");
        //Copy val into temp
        bool1 = num.isPos;
        bool2 = num2.isPos;
        apint temp = new apint (denom.strSign, denom.strVal);
        apint temp2 = new apint (num2.denom.strSign, num2.denom.strVal);
    
        //Identical denominator
        if (denom.strVal != num2.denom.strVal) 
        {
            num = num.mul(num2.denom);
            num2.num = num2.num.mul(denom);
            difference.denom = temp.mul(temp2);
        } else 
        {
            difference.denom = denom;
        }
        num.isPos = bool1;
        num2.num.isPos = bool2;
        //Subtraction algorithm
        if (isPos == num2.isPos) 
        {
            difference.num = num.sub(num2.num); 
        } else if (num.isPos == true && num2.isPos == false) 
        {
            num2.num.isPos = true;
            difference.num = num.add(num2.num);
            difference.isPos = true;
        } else if (num.isPos == false && num2.isPos == true) 
        {
            num.isPos = true;
            difference.num = num.add(num2.num);
            difference.isPos = false;
        }
        return difference;
    }
    
    //Multiplies 2 aprats
    public aprat mulAPRAT(aprat num2) 
    {
        aprat product = new aprat("", "", "");

        //Set sign
        if (isPos != num2.isPos) 
        {
            product.isPos = false;
        } else 
        {
            product.isPos = true;
        }
        //Multiplication algorithm
        product.num = num.mul(num2.num);
        product.denom = denom.mul(num2.denom);
        return product;
    }
    
    //Divides 2 aprats
    public aprat divAPRAT(aprat num2) 
    {
        aprat quotient = new aprat("", "", "");
        
        //Set sign
        if (isPos != num2.isPos) 
        {
            quotient.isPos = false;
        } else 
        {
            quotient.isPos = true;
        }
        //Division algorithm via multiplying inverse
        quotient.num = num.mul(num2.denom);
        quotient.denom = denom.mul(num2.num);
        return quotient;
    }
}

