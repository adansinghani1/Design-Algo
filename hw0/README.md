[![Work in Repl.it](https://classroom.github.com/assets/work-in-replit-14baed9a392b3a25080506f3b7b6d57f295ec2978f6f33ec97e36a161684cbe9.svg)](https://classroom.github.com/online_ide?assignment_repo_id=3898629&assignment_repo_type=AssignmentRepo)
# HW0: Getting to Know You and Java Practice

## Read Me Before Starting
This is the very first homework in CSC 4520. The goal is to learn more about
you as an individual and explore your knowledge in programming and Java.
**This assignment is due on January 19, 2021 at 11:59PM Eastern Time.**

### Submitting This Assignment
In order to complete the coding portions of this assignment, you must make
commits of your code to the `main` branch of this repository. We will take the
latest commit as your "final submission". **Any commits made after the due date
will cause the entire assignment to be [considered
late](https://csc4520.org/syllabus/#late-work).**

**If you are unsure how to make commits using Git and GitHub, check out the
video on Piazza demonstrating how to use Repl.it to submit your work.**

### Grading and Corrections
We've provided some examples inputs and outputs to help you test your code and
check your work. Producing the correct output for these examples are necessary
but not sufficient for receiving full credit. There may be other test cases
that we use in grading--you should consider writing your own examples.

This assignment will be graded out of 10 points. The point values of each
problem is listed in the title. We will use automated systems + manual inspect
to assign points in a fair, standardized way.

*If you miss points on this as assignment* there will be an opportunity to earn
them back by doing homework corrections, so don't panic if you're having a
tough time on some of the questions. You'll learn more about this next
week.

### Showing Your Work
There are three ways of showing your work. Any of these ways will help you earn
earn ["effort"](https://csc4520.org/syllabus/#assignment-breakdown) credit.
Following these practices will also help us verify that your work is your own.
This helps you avoid being falsely accused of academic dishonesty.

1. You should add comments that explain the key ideas behind your approach.
We've added placeholders in `HW0.java` where you can do this.
2. You should make incremental commits demonstrating your progress over time on
the exercises. If you are unsure how to do this, please check the video on
Piazza.
3. You may also add additional test cases in order to ensure that your code is
100% correct.

Remember that you can consult outside resources and work with other students as
long as you write up your own solutions and cite any links or people you
received help from within `citations.txt`. See
[syllabus/collaboration](https://csc4520.org/syllabus/#collaboration) for
details.

### Getting Help
If you have any trouble with any aspects of the homework, please first check
Piazza to see if anyone else has had a similar issue. The "hw0" tag  on the top
will show only posts relevant to HW0. If you don't find any posts relevant to
you, you can make your own Piazza post.

You can also make an appointment with Andrew via the [staff
page](https://csc4520.org/staff/) if you want 1-on-1 help.

A Homework Party will be announced on Piazza as well. Attend in order to get
hints and guidance on how to solve the trickier problems.


## Q1: Getting to Know You (1 points)
Please fill out this [survey](https://docs.google.com/forms/d/e/1FAIpQLSfIvTOEwUwMgBMU85fWgW_qqUpqG7TFFKT1bBnb9AGsp0SOIQ/viewform?usp=sf_link).

## Q2: maxOfArray (2 points)
Write `maxOfArray`, which takes in an array of integers and returns the largest
integer within the array. If the array is empty, throw an
`IllegalArgumentException`. Some examples:

```
  int testResult1 = maxOfArray(new int[] {1, 3, 4, 5, 2});
  int testResult2 = maxOfArray(new int[] {-1, -3, -4, -5, -2});

  System.out.println(testResult1); // should output 5
  System.out.println(testResult2); // should output -1

  maxOfArray(new int[] {}); // Should throw IllegalArgumentException
```

## Q3: twoSum (3 points)
Write `twoSum`, which takes in an array of integers and a target sum, and
returns a 2-element array that represents two *distinct* indicies of elements
that sum up to the target value. Some examples:
```
  int[] testResult3 = twoSum(new int[] {0, 2, 3, 4, 5}, 6);
  int[] testResult4 = twoSum(new int[] {1, 2, 3, 4, 5}, 10);

  System.out.println(Arrays.toString(testResult3)); // should output [1, 3]
  System.out.println(Arrays.toString(testResult4)); // should output [-1, -1]
```
* In the first example, `arr[1] + arr[3] = 2 + 4 = 6`.
* In the second example, we returned `[-1, -1]` because there are not two
distinct elements within the array that sum to 10 (you can't use 5 twice).

## Q4 (4 points)
Write `add`, which given two nubmers represented as Lists of single-digit
integers, returns their sum as a list of integers. Some examples:
```
  List<Integer> testResult5 = add(Arrays.asList(1, 2, 3), Arrays.asList(2, 4, 2));
  List<Integer> testResult6 = add(Arrays.asList(9, 9, 9), Arrays.asList(1));

  // 123 + 242 = 365
  // [1, 2, 3], [2, 4, 2] => [3, 6, 5]
  System.out.println(testResult5); // should output [3, 6, 5]

  // 999 + 1 = 1000
  // [9, 9, 9], [1] => [1, 0, 0, 0]
  System.out.println(testResult6); // should output [1, 0, 0, 0]
```
