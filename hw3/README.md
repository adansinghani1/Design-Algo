[![Work in Repl.it](https://classroom.github.com/assets/work-in-replit-14baed9a392b3a25080506f3b7b6d57f295ec2978f6f33ec97e36a161684cbe9.svg)](https://classroom.github.com/online_ide?assignment_repo_id=4123252&assignment_repo_type=AssignmentRepo)
# Divide and Conquer

## Instructions
The goal of this homework is to practice what we've covered in lectures 6 and 7.
**This assignment is due on February 18, 2021 at 11:59PM Eastern Time.**

**This homework requires you to input your PantherID as a string in the
`pantherID` method in `HW3.java`.**

### Grading and Corrections
This assignment will be graded out of 10 points. The point values of each
problem is listed in the title. We will use automated systems + manual
inspection to assign points in a fair, standardized way.

On commit, your answers run through an autograder, which will assign you part of
your grade. The written portions will be manually reviewed by the staff.

*If you miss points on this assignment,* there will be an opportunity to earn
them back by doing homework corrections, so don't panic if you're having a tough
time on some of the questions. Check Piazza for details.


### Academic Integrity
Remember that you can consult outside resources and work with other students as
long as you write up your own solutions and cite any links or people you
received help from within `citations.txt`. See
[syllabus/collaboration](https://csc4520.org/syllabus/#collaboration) for
details.


### Getting Help
If you have any trouble with any aspects of the homework, please first check
Piazza to see if anyone else has had a similar issue. The "hw3" tag  on the top
will show only posts relevant to HW3. If you don't find any posts relevant to
you, you can make your own Piazza post.

You can also make an appointment with Andrew or a TA via the [staff
page](https://csc4520.org/staff/) if you want 1-on-1 help.


## Deep Mystery (10 points)
Given the Pseudocode of mystery, answer the following questions.
```
algorithm mystery
  Input: list of integers lst of size N >= 1,
         integer k between 0 and N-1 inclusive
  Output: ???

  if lst.size() < 2
    return lst.get(0)
  pivot = lst.get(0)
  left = new list of integers
  middle = new list of integers
  right = new list of integers
  for each element el in lst
    if el < pivot
      left.add(el)
    else if el = pivot
      middle.add(el)
    else
      right.add(el)
  if k < left.size()
    return mystery(left, k)
  else if k < left.size() + middle.size()
    return middle.get(0)
  else
    return mystery(right, k-left.size()-middle.size())
```

**Q1.** What are the recursive calls that will be made when calling mystery on
your array and k = 5? Remember to input your PantherID and hit "run" to get your
array. List all the recursive calls within `callsToMystery` in HW3.java.

**Q2.** What's the best case runtime of mystery? Define N, provide an example,
and justify your answer. Put your answer in `mystery.txt`.

**Q3.** What's the worst case runtime of mystery? Define N, provide an example,
and justify your answer. Put your answer in `mystery.txt`

**Q4.** Average case? Define N, provide an example, and justify your answer. Put
your answer in `mystery.txt`. **You must explain in your own words.**

Hint, it's similar to the argument made for QuickSort's average case.

**Q5.** What's the space complexity?  Define N and justify your answer. Put
your answer in `mystery.txt`.

**Q6.** What does mystery do? Put your answer in `mystery.txt`. Specify the
output as precisely as possible.

