//CREATED: ALEXANDER J. LEE 5/1/2018

# include <stdio.h>
# include <stdlib.h>
# include <stdbool.h>
# include "apint.h"

int main() 
{
    printf("Default constructor test \n");
    apint *ans = newapint();
    apint *num1 = newapint();                     // Test 1
    print(num1);
    printf("String constructor test \n");
    apint *num2 = newapintSTR("643996950734");    // Test 2
    print(num2);
    printf("\n");
    printf("Integer constructor test \n");
    apint *num3 = newapintINT(594083);            // Test 3
    print(num3);
    printf("\n");
    apint *num4 = init("+", "649503809215");
    apint *num5 = newapintINT(64389);
    apint *num6 = newapintSTR("29499453999");
    apint *num7 = newapintSTR("543982190985");
    printf("Addition test \n");                   // Test 4
    printOp(num2, num4, "+");
    ans = addapint(num2, num4);
    print(ans);
    printf("\n");
    printf("Subtraction test 1\n");               // Test 5
    printOp(num3, num5, "-");
    ans = subapint(num3, num5);
    print(ans);
    printf("\n");
    printf("Subraction test 2 \n");               // Test 6
    printOp(num6, num7, "-");
    ans = subapint(num6, num7);
    print(ans);
    printf("\n");
    printf("Multiplication test \n");             // Test 7
    apint *num8 = init("+","6943899");
    apint *num9 = init("+", "96493");
    printOp(num8, num9, "*");
    mulapint(num8 , num9);
    return 0;
}
