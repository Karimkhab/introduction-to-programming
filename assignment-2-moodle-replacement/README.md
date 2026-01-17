# Assignment 2: Moodle Replacement

A command-driven course management system. It stores students, exams, and grades with strict validation for IDs, ranges, and string formats. The output is a line-by-line response for each query.

## Key features

- Structs for students, exams, and grades
- Union + enum to model written vs digital exams
- Validation of IDs, ranges, and string fields
- Deleting a student also deletes their stored grades

## Input / Output

- Reads from `input.txt` and writes to `output.txt`.
- Supported commands include: `ADD_STUDENT`, `ADD_EXAM`, `ADD_GRADE`, `UPDATE_EXAM`, `UPDATE_GRADE`, `SEARCH_STUDENT`, `SEARCH_GRADE`, `DELETE_STUDENT`, `LIST_ALL_STUDENTS`, `END`.

## Solution

- C source: `solution.c`
