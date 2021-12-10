[![Work in Repl.it](https://classroom.github.com/assets/work-in-replit-14baed9a392b3a25080506f3b7b6d57f295ec2978f6f33ec97e36a161684cbe9.svg)](https://classroom.github.com/online_ide?assignment_repo_id=3998667&assignment_repo_type=AssignmentRepo)
# HW2: Runtime and QuickSort

## Instructions
The goal of this homework is to practice what we covered in Lecture 3, 4, and 5.
**This assignment is due on February 4, 2021 at 11:59PM Eastern Time.**

Most of this homework does not require coding, but instead, expects you to
analyze existing code. Please read each question carefully.  **We've provided an
example question and ideal answer in `example.txt` to help you get started on
the runtime analysis questions.**

### Submitting This Assignment
In order to complete this assignment, you must make commits of your work to the
`main` branch of this repository. We will take the latest commit as your "final
submission". **Any commits made after the due date will cause the entire
assignment to be [considered late](https://csc4520.org/syllabus/#late-work).**

**If you are unsure how to make commits using Git and GitHub, check out the
[video on Piazza](https://piazza.com/class/kjkot7wwgl53ya?cid=16) from HW0
demonstrating how to use Repl.it to submit your work.**

### Grading and Corrections
**Since this is a written assignment, There are no tests or examples.** You'll
need to check out the practice and review problems posted on Piazza in order to
ensure you have the skills needed to do well on this homework.

This assignment will be graded out of 10 points. The point values of each
problem is listed in the title. We will use manual inspection and written
rubrics to assign points in a fair, standardized way.

*If you miss points on this as assignment,* there will be an opportunity to earn
them back by doing homework corrections, so don't panic if you're having a tough
time on some of the questions. More info will be posted on Piazza soooon.

### Academic Integrity
Remember that you can consult outside resources and work with other students as
long as you write up your own solutions and cite any links or people you
received help from within `citations.txt`. See
[syllabus/collaboration](https://csc4520.org/syllabus/#collaboration) for
details.

## Q1 Mysterious Function (2 point)
What's the worst case runtime of the following function? Please remember to
define n, provide a tight upper bound, and justify your answer in `answers.txt`. 

```
  public static void mystery1(int z) {
    System.out.println(z);
    if (z >= 10) {
      mystery1(z/10);
      System.out.println(z);
    }
  }
```

## Q2 Mysteries Continue (2 point)
What's the worst case runtime of the following function? Please remember to
define n, provide a tight upper bound, and justify your answer in `answers.txt`. 

```
  public static String mystery2(int n) {
    if (n % 7 == 0) {
      return "Bzzzt!";
    }
    return mystery2(n-1);
  }
```

## Q3 Exponentiation (Fast?) (4 points)
* What’s the best case, worst case, and average case runtime of `pow`? **Assume
 n = power**. Please remember to define n, provide a tight upper bound, and
 justify your answer in `answers.txt`. 
* What one-line change could you make to improve the worst case? Describe the
 change in `answers.txt`. You must provide a written explanation of why your 
 change works in order to receive full credit.

```
algorithm pow
  Input: positive integer b, non-negative integer p
  Output: computing b^p (i.e. b raised to power of p)

  if p = 0
    return 1
  else if p = 1
    return b
  else if p is even
    temp = pow(b, p / 2)
    return temp * temp
  else
    return b * b * pow(b, p-2)
```

## Q4 QuickSort Shenanigans (2 point)
Given the QuickSort implementation from class, provide an 18-element list in
`Q4.java` that will take the **least** number of recursive calls of QuickSort
to complete. As a **counter-example**, here is a list that will cause QuickSort
to make the **MOST** number of recursive calls:
```
  public static List<Integer> input() {
    return Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  }
```

And here’s the QuickSort algorithm, for convenience:

```
algorithm QuickSort
  Input: lists of integers lst of size N
  Output: new list with the elements of lst in sorted order

  if N < 2
    return lst
  pivot = lst[N-1]
  left = new empty list
  right = new empty list
  for index i = 0, 1, 2, ... N-2
    if lst[i] <= pivot
      left.add(lst[i])
    else
      right.add(lst[i])
  return QuickSort(left) + [pivot] + QuickSort(right)
```
