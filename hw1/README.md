[![Work in Repl.it](https://classroom.github.com/assets/work-in-replit-14baed9a392b3a25080506f3b7b6d57f295ec2978f6f33ec97e36a161684cbe9.svg)](https://classroom.github.com/online_ide?assignment_repo_id=3940207&assignment_repo_type=AssignmentRepo)
# HW1: Pseudocode and Recursion

## Instructions
The goal of this homework is to practice what we covered in Lecture 2 as well
as the [Extra Recursion Lecture](https://youtu.be/KB-gtexjTTo). Please review
both lectures (especially the one on Recursion) in order to have the context to
solve these problems.

**This assignment is due on January 28, 2021 at 11:59PM Eastern Time.**

### Submitting This Assignment
In order to complete the coding portions of this assignment, you must make
commits of your code to the `main` branch of this repository. We will take the
latest commit as your "final submission". **Any commits made after the due date
will cause the entire assignment to be [considered
late](https://csc4520.org/syllabus/#late-work).**

**If you are unsure how to make commits using Git and GitHub, check out the
[video on Piazza](https://piazza.com/class/kjkot7wwgl53ya?cid=16) from HW0
demonstrating how to use Repl.it to submit your work.**

### Grading and Corrections
We've provided some examples inputs and outputs to help you test your code and
check your work. Producing the correct output for these examples is necessary
but not sufficient for receiving full credit. There may be other test cases
that we use in grading--you should consider writing your own examples.

This assignment will be graded out of 10 points. The point values of each
problem is listed in the title. We will use automated systems + manual
inspection to assign points in a fair, standardized way.

*If you miss points on this as assignment,* there will be an opportunity to earn
them back by doing homework corrections, so don't panic if you're having a tough
time on some of the questions. More info will be posted on Piazza soon.

### Showing Your Work
There are three ways of showing your work. Any of these ways will help you earn
earn ["effort"](https://csc4520.org/syllabus/#assignment-breakdown) credit.
Following these practices will also help us verify that your work is your own.
This helps you avoid being falsely accused of academic dishonesty.

1. You should add comments that explain the key ideas behind your approach.
We've added placeholders in `HW1.java` where you can do this.
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
Piazza to see if anyone else has had a similar issue. The "hw1" tag  on the top
will show only posts relevant to HW1. If you don't find any posts relevant to
you, you can make your own Piazza post.

You can also make an appointment with Andrew or a TA via the [staff
page](https://csc4520.org/staff/) if you want 1-on-1 help.

A Homework Party will be announced on Piazza as well. Attend in order to get
hints and guidance on how to solve the trickier problems.


### Q1: Find Missing Number (2 points)
Convert the following pseudocode algorithm into Java. You'll find example tests
within the `main` method to ensure you're headed in the right direction. **Make
sure you understand each example.**
```
algorithm findMissing
  Input: integer array A of length N where each element is distinct
    and in the range [0, N]
  Output: integer x where x is in the range [0, N], but not in A

  s = the sum of all numbers in A
  return (N(N+1))/2 - s
```

### Q2: TwoSum (Fast) (3 points)
Convert the following code into Pseudocode and put it in `twosum.txt`. **Hint:**
for _some_ loops, you _should_ describe what it does in English. **There are no
tests for this problem, so be sure double check and test your translation
manually, similar to how we did in lecture.**

```java
  public static int[] twoSumFast(int[] arr, int target) {
    HashSet<Integer> seen = new HashSet<>();
    for (int j = 0; j < arr.length; j++) {
      int otherAddend = target - arr[j];
      if (seen.contains(otherAddend)) {
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == otherAddend)  {
            return new int[] {i, j};
          }
        }
      } else {
        seen.add(arr[j]);
      }
    }
    return new int[] {-1, -1};
  }
```

### Q3: countFives (2 points)
Write `countFives`, which takes in an integer and returns the number of times
5 appears as a digit within the number. Examples:
```
  countFives(123467890) // should output 0
  countFives(555555)    // should output 6
  countFives(15354)     // should output 2
```
**In order to receive full credit for this problem, you must use recursion.**
I.e. using `=`, `for`, `while`, etc. is prohibited.

Hint: recall the `%` and `/` operators:
```
  123 % 10 // evaluates to 3
  123 / 10 // evalutes to 12
```

### Q4: pickTrees (3 points)
You build homes out of wood and you need material from a nearby forest. However,
you want to avoid deforestation, so you decide for each tree you cut down,
you'll leave its neighbors alone, giving the forest time to recover. However,
you still need as much wood as possible, so you have to be careful about which
trees you pick to cut down.

Write `pickTrees`, which takes in an array of N trees `arr` where `arr[i]`
represents how much wood you can harvest by cutting down tree `i`. It should
return the max amount of wood you can harvest while following the rule of
skipping neighbors:

```
    // Pick tree 0, tree 2, and tree 5 => 1 + 3 + 5 = 9 wood total
    int testResult5 = pickTrees(new int[] {1, 2, 3, 4, 5});
    System.out.println(testResult5); // should output 9

    // Pick tree 1 and tree 3 => 3 + 3 = 6 wood total
    int testResult6 = pickTrees(new int[] {1, 3, 4, 3});
    System.out.println(testResult6); // should output 6

    // Pick tree 0 and tree 3 => 5 + 9 = 14 wood total
    int testResult7 = pickTrees(new int[] {5, 1, 4, 9});
    System.out.println(testResult7); // should output 14 
```

**In order to receive full credit for this problem, you must use recursion.**
I.e. using `=`, `for`, `while`, etc. is prohibited.


