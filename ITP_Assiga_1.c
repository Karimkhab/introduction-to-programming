#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    // read input file and write answer to output file
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    // reading lines in input file
    int N;
    char S[100000],A[1000000];
    scanf("%d\n",&N);
    gets(S);
    gets(A);

    // creating two arrays for writing numbers and their calculus system
    char *arr_S[N],*arr_A[N];
    int kol_s=0,kol_a=0;

    // divide strings into numbers separated by spaces and write our numbers into arrays arr_S and arr_A
    char *element_S = strtok(S," ");
    while (element_S!=0){
        arr_S[kol_s]=element_S;
        element_S = strtok(0," ");
        kol_s++;
    }
    char *element_A = strtok(A," ");
    while (element_A!=0){
        arr_A[kol_a]=element_A;
        element_A = strtok(0," ");
        kol_a++;
    }

    // cycle for checking and reading sum
    int sum=0,check=1;
    for (int index=0;index<N;index++) {
        char (*ptrCheckTranslateDecimalSys_S), (*ptrCheckTranslateDecimalSys_A);
        // convert number from arr_A to integers and make a check for the correctness of the input
        int number_A = strtol(arr_A[index], &ptrCheckTranslateDecimalSys_A, 10);
        if (*ptrCheckTranslateDecimalSys_A != '\0') {
            check = 0;
            break;
        }
        // convert number from the arr_S to decimal and make a check for the correctness of the translation
        int number_S = strtol(arr_S[index], &ptrCheckTranslateDecimalSys_S, number_A);
        if (*ptrCheckTranslateDecimalSys_S == '\0' && (number_A == 2 || number_A == 8 || number_A == 10 || number_A == 16)) {
            sum+=number_S;
        }
        else {
            check=0;
        }
    }
    // checking for task condition
    check &= (1 <= N && N <= 40);
    // output our result
    if (check==1) {
        // calculate sum, because if condition is about adding the number 10 to odd index and subtracting 10 to even index
        if (N%2==0) {
            printf("%d\n",sum);
        }
        else {
            printf("%d\n",sum-10);
        }
    }
    else{
        printf("Invalid inputs\n");
    }
    return 0;
}
