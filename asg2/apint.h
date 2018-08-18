# ifndef _APINT_H
# define _APINT_H
# include <stdint.h>
# include <stdbool.h>

typedef struct apint 
{
    int * val;
    int length;
    int isPos;
} apint;

apint *init(char * sign, char * val);
apint *newapint();
apint *newapintSTR(char * val);
apint *newapintINT(int val);

void print(apint *);

apint *addapint(apint *, apint *);

apint *subapint(apint *, apint *);

void mulapint(apint *, apint *);

void printOp(apint *, apint *, char *);

# endif
