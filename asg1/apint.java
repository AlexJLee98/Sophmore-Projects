//Created: Alexander J. Lee 4/15/18

import java.io.*;
import java.util.*;
import java.math.*;
import java.util.ArrayList;

//apint class
class apint 
{
    public String strSign;
    public String strVal;
    public boolean isPos;
    public ArrayList <Integer> arrL;
    
    //Default constructor
    public apint()
    {
        init("", "");
    }
    
    //Creates apint given an integer
    public apint(int input)
    {      
        String val = Integer.toString(input);
        if (input < 0) 
        {
            val = val.substring(1);
            init("-", val); 
        } else 
        {
            init("+", val);
        }
    }
    
    //Creates apint given a double
    public apint(double input)
    {
        
        long inputLong = (long)input;
        Long l = new Long(inputLong);
        String val = l.toString();
        if (input < 0) {
            val = val.substring(1);
            init("-", val);
        } else {
            init("+", val);
        }
    }
    
    //Creates apint given a string
    public apint(String val) {
        init("+", val);
    }
    
    //Initializes apint
    public apint (String sign, String val) 
    {
        init(sign, val);    
    }
    
    //apint ADT
    public void init (String sign, String val)
    {
        this.arrL = new ArrayList <Integer> (sign.length()); //ArrayList to store int val
        this.strSign = sign; //Store sign
        this.strVal = val; //Store val
        this.isPos = isPos; //Store sign
        
        if (strSign == "-") 
        {
            this.isPos = false;
        } else 
        {
            this.isPos = true;
        }
        
        //Convert char string to int
        for (int i = 0; i < val.length(); i++) 
        {
            int x = Character.getNumericValue(strVal.charAt(i));
            arrL.add(x);
        }
    }
    
    //Print arraylist
    public void print() 
    {
        System.out.println();
        if (isPos == false) 
        {
            System.out.print('-');
        }
        for (int i = 0; i < arrL.size(); i++) 
        {
            System.out.print(arrL.get(i).toString());
        }
        System.out.println();
    } 
    
    //Shift arraylist if length is not equal
    public ArrayList <Integer> shift(int numShift, ArrayList <Integer> arrL) 
    {
        //Initialize new arraylist 
        ArrayList <Integer> shiftedL = new ArrayList <Integer> (Collections.nCopies(numShift + arrL.size(), 0));
    
        for (int i = 0; i < arrL.size(); i++) 
        {
            shiftedL.set(i + numShift, arrL.get(i));
        }
        
        return shiftedL;
    }
    
    public apint add(apint num2) 
    {
        
        apint newVal = new apint ("", "");
        int addLength;
        int l1;
        int l2;
        int sum;
        boolean tempBool;
        int temp;
        String temp2;
        String temp3;
        
        l1 = arrL.size();
        l2 = num2.arrL.size();
        addLength = Math.max(l1, l2);
        sum = 0;
        tempBool = true;
        temp = 0;
        temp2 = "";
        temp3 = "";
        
        //Initialize new val arrL
        for (int z = 0; z < addLength; z++) 
        {
            newVal.arrL.add(0);
        }
        
        //Addition given 2 numbers with same sign
        if (num2.isPos == isPos) 
        {
            newVal.isPos = isPos;
        
            //Shift shorter arrL if length is not equal
            if (l1 != l2) 
            {
                if (l1 < l2) 
                {
                    arrL = shift(Math.abs(l1-l2), arrL);
                } else 
                {
                    num2.arrL = shift(Math.abs(l1-l2), num2.arrL);
                }
            }
            
            //Add all digits but last
            for (int i = addLength - 1; i > 0; i--) 
            {
                sum = arrL.get(i) + num2.arrL.get(i);
                newVal.arrL.set(i, Math.abs(sum) % 10);
                // Carry digit if sum >= 10
                if (sum >= 10) 
                {
                    arrL.set(i - 1, arrL.get(i - 1) + 1);
                }
            }
            
            //Don't need to carry end
            sum = arrL.get(0) + num2.arrL.get(0);
            newVal.arrL.set(0, Math.abs(sum));
            
            //Shift all values to right if last digit is greater than 10
            if (sum >= 10) 
            {
                newVal.arrL.add(0);
                for (int x = newVal.arrL.size() - 1; x > 0; x--) 
                {
                    newVal.arrL.set(x, newVal.arrL.get(x - 1));
                }
                 newVal.arrL.set(1, newVal.arrL.get(0) % 10);
                 newVal.arrL.set(0, Integer.parseInt(Integer.toString(sum).substring(0, 1)));
            }
            
        } else 
        {
            //Addition given 2 numbers with different signs
            ArrayList <Integer> tempList = new ArrayList <Integer> (Collections.nCopies(addLength, 0));
            
            //Shift array if length not equal
            if (l1 != l2) 
            {
                if (l1 < l2) 
                {
                    arrL = shift(Math.abs(l1-l2), arrL);
                } else 
                {
                    num2.arrL = shift(Math.abs(l1-l2), num2.arrL);
                }
            }
            
            //Swap arraylist if arrL is less than num2
            if (arrL.get(0) < num2.arrL.get(0)) 
            {
                tempList = arrL;
                tempBool = isPos;
                arrL = num2.arrL;
                isPos = num2.isPos;
                num2.arrL = tempList;
                num2.isPos = tempBool;
            } else if (arrL.get(0) == num2.arrL.get(0)) 
            {
                for (int q = 0; q < arrL.size(); q++) 
                {
                    if (arrL.get(q) < num2.arrL.get(q)) 
                    {
                        tempList = arrL;
                        tempBool = isPos;
                        arrL = num2.arrL;
                        isPos = num2.isPos;
                        num2.arrL = tempList;
                        num2.isPos = tempBool;
                        break;
                    } else if (arrL.get(q) > num2.arrL.get(q)) 
                    {
                        break;
                    }
                }
            }
            
            //Set sign
            if (arrL.get(0) > num2.arrL.get(0)) 
            {
                if (isPos == true) 
                {
                    newVal.isPos = true;
                } else 
                {
                    newVal.isPos = false;
                }
            } else if (arrL.get(0) < num2.arrL.get(0)) 
            {
                if (num2.isPos == true) 
                {
                    newVal.isPos = false;
                } else 
                {
                    newVal.isPos = true;
                }
            } else if (arrL.get(0) == num2.arrL.get(0)) 
            {
                for (int v = 1; v < arrL.size(); v++) 
                {
                    if (arrL.get(v) > (num2.arrL.get(v))) 
                    {
                        newVal.isPos = isPos;
                        break;
                    } else if (arrL.get(v) < (num2.arrL.get(v))) 
                    {
                        newVal.isPos = num2.isPos;
                        break;
                    } else 
                    {
                        newVal.isPos = true;
                    }
                }
            }
            
            //Subtract the two numbers
            for (int j = addLength - 1; j >= 0; j--) 
            {
                if (arrL.get(j) < num2.arrL.get(j) && j != 0) 
                {
                    //Borrowing
                    arrL.set(j, arrL.get(j) + 10);
                    arrL.set(j - 1, arrL.get(j - 1) - 1);
                }
                sum = arrL.get(j) - num2.arrL.get(j);
                newVal.arrL.set(j, Math.abs(sum) % 10);
            }
        }
        //Set sign of newVal
        if (newVal.isPos == false) 
        {
            newVal.strSign = "-";
        } else 
        {
            newVal.strSign = "+";
        }
        
        //Set strVal of newVal
        for (int k = 0; k < newVal.arrL.size(); k++) 
        {
            temp = newVal.arrL.get(k);
            temp2 = Integer.toString(temp);
            temp3 = temp3.concat(temp2); 
        }
        newVal.strVal = temp3;
        return newVal;
    }
    
    public apint sub(apint num2) 
    {
        
        apint newVal = new apint ("", "");
        int subLength;
        int borrowCount;
        int l1;
        int l2;
        int diff;
        boolean tempBool;
        int temp;
        String temp2;
        String temp3;
        
        
        l1 = arrL.size();
        l2 = num2.arrL.size();
        subLength = Math.max(l1, l2);
        tempBool = true;
        temp = 0;
        temp2 = "";
        temp3 = "";
        
        for (int z = 0; z < subLength; z++) 
        {
            newVal.arrL.add(0);
        }
        
        //Temp list
        ArrayList <Integer> tempList = new ArrayList <Integer> (Collections.nCopies(subLength, 0));
        
        //Subtraction given same sign
        if (isPos == num2.isPos) 
        {
            //Shift array
            if (l1 != l2) 
            {
                if (l1 < l2) 
                {
                    arrL = shift(Math.abs(l1-l2), arrL);
                } else 
                {
                    num2.arrL = shift(Math.abs(l1-l2), num2.arrL);
                }
            }
            
            //Set sign
           if (arrL.get(0) > num2.arrL.get(0)) 
           {
                if (isPos == true) 
                {
                    newVal.isPos = true;
                } else 
                {
                    newVal.isPos = false;
                }
            } else if (arrL.get(0) < num2.arrL.get(0)) 
           {
                if (num2.isPos == true) 
                {
                    newVal.isPos = false;
                } else 
                {
                    newVal.isPos = true;
                }
            } else if (arrL.get(0) == num2.arrL.get(0)) 
           {
                for (int v = 1; v < arrL.size(); v++) 
                {
                    if (arrL.get(v) > (num2.arrL.get(v))) 
                    {
                        newVal.isPos = true;
                        break;
                    } else if (arrL.get(v) < (num2.arrL.get(v))) 
                    {
                        newVal.isPos = false;
                        break;
                    } else 
                    {
                        newVal.isPos = true;
                    }
                }
            }
            
            //Swap arraylist if arrL is less than num2
            if (arrL.get(0) < num2.arrL.get(0)) 
            {
                tempList = arrL;
                tempBool = isPos;
                arrL = num2.arrL;
                isPos = num2.isPos;
                num2.arrL = tempList;
                num2.isPos = tempBool;
            } else if (arrL.get(0) == num2.arrL.get(0)) 
            {
                for (int q = 0; q < arrL.size(); q++) 
                {
                    if (arrL.get(q) < num2.arrL.get(q)) 
                    {
                        tempList = arrL;
                        tempBool = isPos;
                        arrL = num2.arrL;
                        isPos = num2.isPos;
                        num2.arrL = tempList;
                        num2.isPos = tempBool;
                        break;
                    } else if (arrL.get(q) > num2.arrL.get(q)) 
                    {
                        break;
                    }
                }
            }
        
            for (int i = subLength - 1; i >= 0; i--) 
            {
                if (arrL.get(i) < num2.arrL.get(i) && i != 0) 
                {
                    //Borrowing
                    arrL.set(i, arrL.get(i) + 10);
                    arrL.set(i - 1, arrL.get(i - 1) - 1);
                }
                diff = arrL.get(i) - num2.arrL.get(i);
                newVal.arrL.set(i, Math.abs(diff) % 10);
            }
        } else if (isPos == true && num2.isPos == false) 
        {
            num2.isPos = true;
            newVal = add(num2);
            
        } else if (isPos == false && num2.isPos == true) 
        {
            num2.isPos = false;
            newVal = add(num2);
        }
        //Set sign of newVal
        if (newVal.isPos == false) 
        {
            newVal.strSign = "-";
        } else 
        {
            newVal.strSign = "+";
        }
        
        //Set strVal of newVal
        for (int k = 0; k < newVal.arrL.size(); k++) 
        {
            temp = newVal.arrL.get(k);
            temp2 = Integer.toString(temp);
            temp3 = temp3.concat(temp2); 
        }
        newVal.strVal = temp3;
        return newVal;
    }
    
    public apint mul(apint num2) 
    {
        apint newVal = new apint ("+", "");
        apint tempVal = new apint ("+" , "");
        int mulLength;
        int l1;
        int l2;
        int product;
        int carry;
        int counter;
        int temp;
        String temp2;
        String temp3;
        
        temp = 0;
        temp2 = "";
        temp3 = "";
        carry = 0;
        l1 = strVal.length();
        l2 = num2.strVal.length();
        mulLength = Math.min(l1, l2);
        product = 0;
        
        //Temp list
        ArrayList <Integer> tempList = new ArrayList <Integer> (Collections.nCopies(mulLength, 0));
        
        for (int z = 0; z < Math.max(l1,l2); z++) 
        {
            tempVal.arrL.add(0);
        }
        
        for (int y = 0; y < Math.max(l1,l2); y++) 
        {
            newVal.arrL.add(0);
        }
        
        //Shift shorter arrL if length is not equal
        if (l1 != l2) 
        {
            if (l1 < l2) 
            {
                arrL = shift(Math.abs(l1-l2), arrL);
            } else {
                num2.arrL = shift(Math.abs(l1-l2), num2.arrL);
            }
        }
        
        counter = arrL.size() - 1;
        
        //Set sign of answer
        newVal.isPos = true;
        
        //Swap if length different
        if (arrL.get(0) < num2.arrL.get(0)) 
        {
            tempList = arrL;
            arrL = num2.arrL;
            num2.arrL = tempList;
        }

        //Multiplication algorithm    
        for (int i = mulLength - 1; i >= 0; i--) 
        {
            if (i != mulLength - 1 && product < 10) 
            {
                tempVal.arrL.add(0);
            }
            for (int j = arrL.size() - 1; j >= 0; j--) 
            {
                product = num2.arrL.get(Math.abs(counter)) * arrL.get(j);
                product = product + carry;
                carry = 0;
                //Carry
                if (product >= 10 && j > 0) 
                {
                    carry = Integer.parseInt(Integer.toString(product).substring(0, 1));
                }
               
                //No carry needed if last number multiplied
                if (j > 0) 
                {
                    tempVal.arrL.set(j, Math.abs(product % 10));
                } else 
                {    
                    tempVal.arrL.set(j, Math.abs(product));        
                }
            }
            counter--;
            //Shift array if product >= 10 NOT THE PROBLEM!!!
            if (product >= 10) 
            {
                tempVal.arrL.add(0);
                for (int x = tempVal.arrL.size() - 1; x > 0; x--) 
                {
                    tempVal.arrL.set(x, tempVal.arrL.get(x - 1));
                }
                tempVal.arrL.set(1, tempVal.arrL.get(0) % 10);
                tempVal.arrL.set(0, Integer.parseInt(Integer.toString(product).substring(0, 1)));
            }
            newVal = newVal.add(tempVal);
            for (int c = 0; c < tempVal.arrL.size(); c++) 
            {
                tempVal.arrL.set(c, 0);
            }
        }
        if (isPos != num2.isPos) 
        {
            newVal.strSign = "-";
            newVal.isPos = false;
        }
        //Set sign of newVal
        if (newVal.isPos == false) 
        {
            newVal.strSign = "-";
        } else 
        {
            newVal.strSign = "+";
        }
        
        //Set strVal of newVal
        for (int k = 0; k < newVal.arrL.size(); k++) 
        {
            temp = newVal.arrL.get(k);
            temp2 = Integer.toString(temp);
            temp3 = temp3.concat(temp2); 
        }
        newVal.strVal = temp3;
        return newVal;
    }
    
    public apint div(apint num2) 
    {
        apint result = new apint ("" , "");
        apint tempVal = new apint ("+" , "");
        int l1;
        int l2;
        int counter;
        int temp;
        boolean neg;
        
        l1 = strVal.length();
        l2 = num2.strVal.length();
        counter = 0;
        temp = 0;
        neg = false;
        
        if (num2.strVal == "0") 
        {
         System.out.println("undefined");
         return result;
        }
        
        if (l2 > l1) 
        {
            result.strSign = "+";
            result.strVal = "0";
            result.isPos = true;
            result.arrL.add(0,0);
            result.print();
            return result;
        }
        
        if (isPos != num2.isPos) 
        {
            neg = true;
        }
        
        //Shift shorter arrL if length is not equal
        if (l1 != l2) 
        {
            if (l1 < l2) 
            {
                arrL = shift(Math.abs(l1-l2), arrL);
            } else 
            {
                num2.arrL = shift(Math.abs(l1-l2), num2.arrL);
            }
        }
        
        isPos = true;
        num2.isPos = true;
        tempVal.isPos = isPos;
        tempVal.strSign = strSign; 
        tempVal.strVal = strVal; 
        tempVal.arrL = arrL;
        
        //Subtract until negative
        while (tempVal.isPos == true) 
        {
            tempVal = tempVal.sub(num2);
            if (tempVal.isPos == true) 
            {
                counter++;
            }
        }
        
        //Set sign of result
        if (neg == true) 
        {
            result.isPos = false;
            result.strSign = "-";       
        } else 
        {
            result.isPos = true;
            result.strSign = "+";
        }
        
        //Set result in array
        result.strVal = Integer.toString(counter);
        for (int i = 0; i < result.strVal.length(); i++) 
        {
            temp = Character.getNumericValue(result.strVal.charAt(i));
            result.arrL.add(temp);
        }
        return result;
    }
}
    
