#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

//declaring 3 structures, enum and union
typedef enum {
    WRITTEN,
    DIGITAL,
}ExamType;

typedef union {
    int duration;
    char software[21];
}ExamInfo;

typedef struct {
    int student_id;
    char name[200];
    char faculty[300];
}Student;

typedef struct {
    int exam_id;
    ExamType exam_type;
    ExamInfo exam_info;
    int check;
}Exam;

typedef struct {
    int exam_id;
    int student_id;
    int grade;
}ExamGrade;

//checking for the type of exam
ExamType EXAMTYPE(const char* enumtype) {
    if (strcmp(enumtype, "WRITTEN") == 0) return 0;
    if (strcmp(enumtype, "DIGITAL") == 0) return 1;
    return -1;
}

//function to check that a string contains only letters
int CHECKSTR(char a[200]) {
    int check=1;
    for (int i = 0; i < strlen(a); i++) {
        if (!isalpha(a[i])) {
            check = 0;
        }
    }
    if (check==1) {
        return 1;
    }
    return 0;
}

//function for checking: ADD_STUDENT
int ADD_STUDENT(int id, char name[20],char faculty[30],char* ptr,int check) {
    //checking for function return
    int ch = 0;
    //checks on printf
    if (check==0) {
        printf("Student: %d already exists\n",id);
        ch=1;
    }else if (!(0<id && id<1000) || (*ptr!= '\0')) {
        printf("Invalid student id\n");
        ch=1;
    }else if (!(1 < strlen(name) && strlen(name) < 20) || CHECKSTR(name)==0) {
        printf("Invalid name\n");
        ch=1;
    }else if (!(4 < strlen(faculty) && strlen(faculty) < 30) || CHECKSTR(faculty)==0) {
        printf("Invalid faculty\n");
        ch=1;
    }else {
        printf("Student: %d added\n",id);
    }
    return ch;
}

//function for checking: ADD_EXAM
int ADD_EXAM(int id,int type,int intfo, char info[100],char* ptr,int check,char *ptr1) {
    //checking for function return
    int ch=0;
    //checks on printf
    if (check==0) {
        printf("Exam: %d already exists\n",id);
        ch=1;
    }else if (!(0<id && id<500) || (*ptr!= '\0')) {
        printf("Invalid exam id\n");
        ch=1;
    }else if (!((type==0) || (type==1))) {
        printf("Invalid exam type\n");
        ch=1;
    }else if ((type==0) && ((!(40<=intfo && intfo<=180)) || (*ptr1!= '\0'))) {
        printf("Invalid duration\n");
        ch=1;
    }else if ((type==1) && (CHECKSTR(info)==0) && (2<strlen(info) && strlen(info)<20)) {
        printf("Invalid software\n");
        ch=1;
    }else{
        printf("Exam: %d added\n",id);
    }
    return ch;
}

//function for checking: ADD_GRADE
int ADD_GRADE(int exam_id,int student_id,int grade,int checkex,int checkst,char *ptrex,char *ptrst, char *ptrgr) {
    //checking for function return
    int ch=0;
    //checks on printf
    if (checkex==0) {
        printf("Exam not found\n");
        ch=1;
    }else if ((*ptrex!= '\0') || !(0<exam_id && exam_id<500)) {
        printf("Invalid exam id\n");
        ch=1;
    }else if (checkst==0) {
        printf("Student not found\n");
        ch=1;
    }else if ((*ptrst!= '\0') || !(0<student_id && student_id<1000)) {
        printf("Invalid student id\n");
        ch=1;
    }else if ((*ptrgr!= '\0') || !(0<=grade && grade<=100)) {
        printf("Invalid grade\n");
        ch=1;
    }else {
        printf("Grade %d added for the student: %d\n",grade,student_id);
    }
    return ch;
}

int main() {
    //read input file and write answer to output file
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    //declaring structures, commands, and indexes for our structures
    Student students[1000];
    Exam exams[1000];
    ExamGrade grades[1000];
    char command[20];
    int i_student=0,i_exam=0,i_grade=0;

    scanf("%s",&command);
    //checking the command that it is not an END
    while (strcmp(command,"END")!=0) {
        //verification for the team: ADD_STUDENT
        if (strcmp(command,"ADD_STUDENT")==0) {
            char student_id_check[100];
            char *ptr;
            scanf("%s %s %s",&student_id_check,&students[i_student].name,&students[i_student].faculty);
            //write our integers in a string and make a check for the correctness of the input
            students[i_student].student_id = strtol(student_id_check,&ptr,10);
            //checking for the existence of an student id before that
            int check=1;
            for (int i=0;i<i_student;i++) {
                if (students[i].student_id==students[i_student].student_id) {
                    check = 0;
                }
            }
            //calling the function for printf and returning a check to see if it was executed or not
            int ch = ADD_STUDENT(students[i_student].student_id, students[i_student].name, students[i_student].faculty,ptr, check);
            if (ch==0) {
                i_student++;
            }
        }
        //verification for the team:ADD_EXAM
        if (strcmp(command,"ADD_EXAM")==0) {
            char enumtype[100],exam_id_check[100],exam_info_check[100];
            char *ptr,*ptr1;
            scanf("%s %s %s",&exam_id_check, &enumtype,&exam_info_check);
            //write our integers in a string and make a check for the correctness of the input
            exams[i_exam].exam_id = strtol(exam_id_check,&ptr,10);
            exams[i_exam].exam_type = EXAMTYPE(enumtype);

            //checking for the existence of an exam id before that
            int check=1,check1=1;
            for (int i=0;i<i_exam;i++) {
                if (exams[i].exam_id==exams[i_exam].exam_id) {
                    check = 0;
                }
            }
            //enter it into our Union depending on (WRITTEN, DIGITAL) in duration or software
            if (exams[i_exam].exam_type==0) {
                exams[i_exam].exam_info.duration = strtol(exam_info_check,&ptr1,10);
            }else {
                strcpy(exams[i_exam].exam_info.software,exam_info_check);
            }
            //calling the function for printf and returning a check to see if it was executed or not
            int ch = ADD_EXAM(exams[i_exam].exam_id,exams[i_exam].exam_type,exams[i_exam].exam_info.duration,exams[i_exam].exam_info.software,ptr,check,ptr1);
            if (ch==0) {
                i_exam++;
            }
        }
        //verification for the team: ADD_GRADE
        if (strcmp(command,"ADD_GRADE")==0) {
            char exam_id_check[100],student_id_check[100],grade_check[100];
            scanf("%s %s %s",&exam_id_check,&student_id_check,&grade_check);
            char *ptrex,*ptrst,*ptrgr;
            //write our integers in a string and make a check for the correctness of the input
            grades[i_grade].exam_id = strtol(exam_id_check,&ptrex,10);
            grades[i_grade].student_id = strtol(student_id_check,&ptrst,10);
            grades[i_grade].grade = strtol(grade_check,&ptrgr,10);
            //checking for the existence of our exam
            int checkex=0;
            for (int i=0;i<i_exam;i++) {
                if (exams[i].exam_id==grades[i_grade].exam_id) {
                    checkex = 1;
                }
            }
            //checking for the existence of our student
            int checkst=0;
            for (int i=0;i<i_student;i++) {
                if (students[i].student_id==grades[i_grade].student_id) {
                    checkst = 1;
                }
            }
            //calling the function for printf and returning a check to see if it was executed or not
            int ch = ADD_GRADE(grades[i_grade].exam_id,grades[i_grade].student_id,grades[i_grade].grade,checkex,checkst,ptrex,ptrst,ptrgr);
            if (ch==0) {
                i_grade++;
            }
        }
        //verification for the team: SEARCH_STUDENT
        if (strcmp(command,"SEARCH_STUDENT")==0) {
            char student_id_check[100];
            char *ptr;
            int student_id,check=1;
            scanf("%s",&student_id_check);
            //write our integers in a string and make a check for the correctness of the input
            student_id = strtol(student_id_check,&ptr,10);
            if (*ptr== '\0') {
                for (int i=0;i<i_student;i++) {
                    //student was found
                    if (students[i].student_id==student_id) {
                        printf("ID: %d, Name: %s, Faculty: %s\n",students[i].student_id,students[i].name,students[i].faculty);
                        check=0;
                        break;
                    }
                }
                //student was not found
                if (check==1) {
                    printf("Student not found\n");
                }
            //incorrect request
            }else {
                printf("Invalid student id\n");
            }

        }
        //verification for the team: SEARCH_GRADE
        if (strcmp(command,"SEARCH_GRADE")==0) {
            char student_id_check[100], exam_id_check[100];
            char *ptr1, *ptr2;
            int student_id, exam_id, check = 1;
            scanf("%s %s", exam_id_check, student_id_check);
            //write our integers in a string and make a check for the correctness of the input
            student_id = strtol(student_id_check, &ptr1, 10);
            exam_id = strtol(exam_id_check, &ptr2, 10);
            if ((*ptr1 == '\0') && (*ptr2 == '\0')) {
                int exam_found = 0;
                int student_found = 0;
                //loop for the strudents structure
                for (int j = 0; j < i_student; j++) {
                    if (students[j].student_id == student_id) {
                        student_found = 1;
                        //loop for the grades structure
                        for (int i = 0; i < i_grade; i++) {
                            if (grades[i].exam_id == exam_id && grades[i].student_id == student_id) {
                                exam_found = 1;
                                //loop for the exams structure
                                for (int n = 0; n < i_exam; n++) {
                                    //if all structures are found for our data, then we output the answer
                                    if (exams[n].exam_id == exam_id && exams[n].exam_type == 0) {  // WRITTEN exam
                                        printf("Exam: %d, Student: %d, Name: %s, Grade: %d, Type: WRITTEN, Info: %d\n",
                                                   grades[i].exam_id, grades[i].student_id, students[j].name,
                                                   grades[i].grade, exams[n].exam_info.duration);
                                    } else if (exams[n].exam_id == exam_id && exams[n].exam_type == 1) {  // DIGITAL exam
                                        printf("Exam: %d, Student: %d, Name: %s, Grade: %d, Type: DIGITAL, Info: %s\n",
                                                   grades[i].exam_id, grades[i].student_id, students[j].name,
                                                   grades[i].grade, exams[n].exam_info.software);
                                    }
                                }
                            }
                        }
                    }
                }

                //if student is not found
                if (!student_found) {
                    printf("Student not found\n");
                }

                //if exam is not found, but student exists
                if (student_found && !exam_found) {
                    printf("Exam not found\n");
                }
            //output for erroneous data
            } else if ((*ptr1 == '\0') && (*ptr2 != '\0')) {
                printf("Invalid exam id\n");
            } else if ((*ptr1 != '\0') && (*ptr2 == '\0')) {
                printf("Invalid student id\n");
            }
        }
        //verification for the team: UPDATE_EXAM
        if (strcmp(command,"UPDATE_EXAM")==0) {
            int exam_id;
            char new_type[50],new_info[50];
            scanf("%d %s %s",&exam_id,&new_type,&new_info);
            for (int i=0;i<i_exam;i++) {
                //looking for exam id in the existing ones
                if (exams[i].exam_id==exam_id) {
                    char *ptr;
                    int intfo,type;
                    //checking for type of exam
                    type = EXAMTYPE(new_type);
                    if (type==0) {
                        intfo = strtol(new_info,&ptr,10);
                    }
                    //checking for errors
                    if (!((type==0) || (type==1))){
                        printf("Invalid exam type\n");
                    }else if ((type==0) && ((!(40<=intfo && intfo<=180)) || (*ptr!= '\0'))) {
                        printf("Invalid duration\n");
                    }else if ((type==1) && (CHECKSTR(new_info)==0)) {
                        printf("Invalid software\n");
                    }else {
                        //depending on type of information being written to the desired union
                        if (type==0) {
                            exams[i].exam_type=0;
                            exams[i].exam_info.duration = intfo;
                        }else {
                            exams[i].exam_type=1;
                            strcpy(exams[i].exam_info.software,new_info);
                        }
                        printf("Exam: %d updated\n",exams[i].exam_id);
                    }
                }
            }
        }
        //verification for the team: UPDATE_GRADE
        if (strcmp(command,"UPDATE_GRADE")==0) {
            int exam_id,student_id,newgrade;
            char grade[50];
            char *ptr;
            scanf("%d %d %s",&exam_id,&student_id,&grade);
            //write our integers in a string and make a check for the correctness of the input
            newgrade = strtol(grade,&ptr,10);
            for (int i=0;i<i_grade;i++) {
                if ((grades[i].exam_id==exam_id) && (grades[i].student_id==student_id)) {
                    //checking for errors
                    if ((*ptr!= '\0') || !(0<=newgrade && newgrade<=100)) {
                        printf("Invalid grade\n");
                    }else {
                        grades[i].grade=newgrade;
                        printf("Grade %d updated for the student: %d\n",grades[i].grade,grades[i].student_id);
                    }
                }
            }
        }
        //verification for the team: DELETE_STUDENT
        if (strcmp(command,"DELETE_STUDENT")==0) {
            int id,index;
            scanf("%d",&id);
            //
            for (int i=0;i<i_student;i++) {
                if (students[i].student_id==id) {
                    index = i;
                    break;
                }
            }
            //find student in structure and delete it by replacing
            for (int i=index;i<i_student;i++) {
                students[i]=students[i+1];
            }
            i_student--;
            //find grade in the structure and delete it by replacing
            for (int i=0;i<i_grade;) {
                if (grades[i].student_id==id) {
                    i_grade--;
                    for (int j = i;j<i_grade;j++) {
                        grades[j]=grades[j+1];
                    }
                } else {
                    i++;
                }
            }

            printf("Student: %d deleted\n",id);
        }
        //verification for the team: LIST_ALL_STUDENTS
        if (strcmp(command,"LIST_ALL_STUDENTS")==0) {
            //go through all students from the structure
            for (int i=0;i<i_student;i++) {
                printf("ID: %d, Name: %s, Faculty: %s\n",students[i].student_id,students[i].name,students[i].faculty);
            }
        }
        //scan the following command
        scanf("%s",&command);
    }
}
