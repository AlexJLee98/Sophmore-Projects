//CREATED: ALEXANDER J. LEE 5/1/2018

# include <stdio.h>
# include <stdlib.h>
# include <stdbool.h>
# include <string.h>
# include <ctype.h>
# include "apint.h"

//Initialize apint ADT
apint *init(char * sign, char * val) 
{
    //Initialize array and convert to int
    apint *myapint = calloc(1, sizeof(apint));
    myapint->val = calloc(1000, sizeof(int));
    int x = 0;
    int y = 0; 
    int length = 0;
    fflush(stdin);
    
    //Set sign
    if (sign[0] == '-') 
    {
        myapint->isPos = 0;
    } else 
    {
        myapint->isPos = 1;
    }
    //Convert char * to int *
    while (val[y] != '\0') 
    {
        if (isdigit(val[y])) 
        {
            myapint->val[x++] = val[y++]-'0';
            length++;
        }
        else y++;
    }
    //Keep track of length of *
    myapint->length = length;
    return myapint;
}

//Default "constructor"
apint *newapint() 
{
    apint *myapint = init("", "");
    return myapint;
}

//Only string input
apint *newapintSTR(char * val) 
{
    apint *myapint = init ("+", val);
    return myapint;
}

//Only integer input
apint *newapintINT(int val) 
{
    char * apintVal = malloc(16); 
    sprintf(apintVal, "%d", val);
    //Initialize apint 
    if (val >= 0) 
    {
        apint *myapint = init("+", apintVal);  
        return myapint;
    } else 
    {
        apint *myapint = init("-", apintVal);
        return myapint;
    }
}

//Shifts array if not equal
int * shift (apint * myapint, int numShift) 
{
    int * shifted = calloc(myapint->length + numShift, sizeof(int));
    for (int i = 0; i < myapint->length + numShift; i++) 
    {
        shifted[i + numShift] = myapint->val[i];
    }
    return shifted;
}

//Print ADT
void print(apint *myapint) 
{
    if (myapint->isPos == false) 
    {
        printf("-");
    }
    for (int i = 0; i < myapint->length; i++) 
    {
        printf("%d", myapint->val[i]);
    }
}

//Prints arithmetic that you are doing
void printOp(apint * n1, apint * n2, char * op) 
{
    print(n1);
    printf(" %c ", op[0]);
    print(n2);
    printf(" = ");
}

//Additing 2 apints
apint *addapint(apint * numOne, apint * numTwo) 
{
    int addLength;
    int sum;
    
    apint *ans = init("", "");

    //Scenario +-
    if (numOne->isPos == 1 && numTwo->isPos == 0) 
    {
        numTwo->isPos = 1;
        ans = subapint(numOne, numTwo); //Subtract if first num is + and second is - 
        return ans;
    }
    //Scenario -+
    if (numOne->isPos == 0 && numTwo->isPos == 1) 
    {
        numTwo->isPos = 0;
        ans = subapint(numOne, numTwo); //Subtract if first num is - and second is +
        return ans;
    } 
    //Find add length and shift shorter array if length not equal
    if (numOne->length > numTwo->length) 
    {
        addLength = numOne->length;
        numTwo->val = shift(numTwo, numOne->length - numTwo->length);
        numTwo->length = addLength;
    } else if (numOne->length < numTwo->length) 
    {
        addLength = numTwo->length;
        numOne->val = shift(numOne, numTwo->length - numOne->length);
        numOne->length = addLength;
    } else 
    {
        addLength = numOne->length;
    }
    
    //Scenario ++ --
    for (int i = addLength - 1; i > 0; i--) 
    {
        sum = numOne->val[i] + numTwo->val[i];
        ans->val[i] = abs(sum % 10);
        //Carry if sum >= 10
        if (sum >= 10) 
        {
            numOne->val[i - 1] += 1;    
        }
    }
    //Don't need to carry last digits added
    sum = numOne->val[0] + numTwo->val[0];
    ans->val[0] = sum;
    //Shift digits to the right by 1 if final digit greater than 10
    if (ans->val[0] >= 10) 
    {
        for (int j = numOne->length; j > 0; j--) {
            ans->val[j + 1] = ans->val[j];
        }
        ans->val[1] = ans->val[0] % 10;
        ans->val[0] = (ans->val[0]/10) % 10;
        ans->length = numOne->length + 1;    
    } else 
    {
        ans->length = numOne->length;    
    }
    return ans;
}

//Subtracting 2 apints
apint *subapint(apint * numOne, apint * numTwo) 
{
    apint *ans = init("", "");
    //Scenario +-
    if (numOne->isPos == 1 && numTwo->isPos == 0) 
    {
        numTwo->isPos = 1;
        ans = addapint(numOne, numTwo); //Add two numbers if first num is + and second is - 
        return ans;
    }
    //Scenario -+
    if (numOne->isPos == 0 && numTwo->isPos == 1) 
    {
        numTwo->isPos = 0;
        ans = addapint(numOne, numTwo); //Add two numbers if first num is - and second is +
        return ans;
    }
    //Initialize variables
    int subLength;
    int diff;
    int * temp;
    
    //Find sub length (length of number of numbers we subtract)
    if (numOne->length > numTwo->length) 
    {
        subLength = numOne->length;
        numTwo->val = shift(numTwo, numOne->length - numTwo->length);
    } else if (numOne->length < numTwo->length) 
    {
        //Exchange arrays if first number is greater than second
        subLength = numTwo->length;
        numOne->val = shift(numOne, numTwo->length - numOne->length);
        temp = numOne->val;
        numOne->val = numTwo->val;
        numTwo->val = temp;
        ans->isPos = 0;
    } else 
    {
        for (int j = 0; j < numOne->length; j++) 
        {
            if (numOne->val[j] < numTwo->val[j]) 
            {
                //Exchange arrays if first number is greater than second
                subLength = numTwo->length;
                numOne->val = shift(numOne, numTwo->length - numOne->length);
                temp = numOne->val;
                numOne->val = numTwo->val;
                numTwo->val = temp;
                ans->isPos = 0;
                break;
            } else if (numOne->val[j] > numTwo->val[j]) 
            {
                subLength = numOne->length;
                break;
            }
        }
        subLength = numOne->length;
    }
    //Subtraction algorithm
    for (int i = subLength - 1; i >= 0; i--) 
    {
        if (numOne->val[i] < numTwo->val[i] && i != 0) 
        {
            //Borrowing
            numOne->val[i] = numOne->val[i] + 10;
            numOne->val[i - 1] = numOne->val[i - 1] - 1;
        }
        diff = numOne->val[i] - numTwo->val[i];
        ans->val[i] = diff % 10;
    }    
    ans->length = subLength;
    //Shift to left if first digit is 0
    int shiftNum = 0;
    
    if (ans->val[0] == 0) 
    {
        for (int i = 0; i < ans->length; i++) 
        {
            if (ans->val[i] == 0) 
            {
                shiftNum++;
            } else 
            {
                break;
            }
        }
        ans->length = ans->length - (shiftNum - 1);
        for (int j = 0; j < ans->length; j++) 
        {
            ans->val[j] = ans->val[j + (shiftNum - 1)];
        }
    }
    return ans;
}
//Multiplying 2 apints
void mulapint(apint * numOne, apint * numTwo) 
{
    apint *one = init ("+", "1");
    apint *product = init("", "");
    //Add numOne->val to itself numTwo->val times
    while (numTwo->isPos == 1) 
    {
        product = addapint(product, numOne);
        numTwo = subapint(numTwo, one);
        one->val[0] = 1;
    }
    product = subapint(product, numOne);
    print(product);
}
    
