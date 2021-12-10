[![Work in Repl.it](https://classroom.github.com/assets/work-in-replit-14baed9a392b3a25080506f3b7b6d57f295ec2978f6f33ec97e36a161684cbe9.svg)](https://classroom.github.com/online_ide?assignment_repo_id=4497869&assignment_repo_type=AssignmentRepo)
# Homework 8: Dynamic Programming

## Instructions
The goal of this homework is to practice what we've covered in lecture 19 and
20--i.e. writing and analyzing dynamic programming algorithms. **This assignment
is due on April 9, 2021 at 11:59pm.**

### Submitting This Assignment
In order to complete this assignment, you must make commits of your code to the
`main` branch of this repository. We will take the latest commit as your "final
submission". **Any commits made after the due date will cause the entire
assignment to be [considered late](https://csc4520.org/syllabus/#late-work).**

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
time on some of the questions.

### Showing Your Work
There are three ways of showing your work. Any of these ways will help you earn
earn ["effort"](https://csc4520.org/syllabus/#assignment-breakdown) credit.
Following these practices will also help us verify that your work is your own.
This helps you avoid being falsely accused of academic dishonesty.

1. You should add comments that explain the key ideas behind your approach.
We've added placeholders in `Autocomplete.java` where you can do this.
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
Piazza to see if anyone else has had a similar issue. The "hw8" tag  on the top
will show only posts relevant to HW8. If you don't find any posts relevant to
you, you can make your own Piazza post.

You can also make an appointment with Andrew or a TA via the [staff
page](https://csc4520.org/staff/) if you want 1-on-1 help.

A Homework Party will be announced on Piazza as well. Attend in order to get
hints and guidance on how to solve the trickier problems.

## Q1: Treasure Cave with Fused Bars--Recursive
Recall the set up for HW7 Q2: 
> Now assume that for each type of metal, all of the bars are fused together so
> that **you're forced to all the bars of a certain type, or none of them.**

> This means that you sometimes should not take the metal that has the highest
> value, because it either will not fit all in your bag (since you have to take
> all the bars), or other metals of lesser will be worth more overall value when
> combined together.

Write `bestValueForFused`, which takes in the the size of your bag, the counts
of all metals, and the value of all metals, and returns the **value of the best
picks possible.** Your code must use recursion and should run in O(2^N) where N
is the total number of metals (aka counts.length and values.length).

```
bestValueForFused(4, [], []) // 0 (the cave is empty)
bestValueForFused(4, [4, 10, 2], [3, 1, 5]) // 12 (take metal 0, even though metal 2 is worth more per bar)
bestValueForFused(4, [4, 2, 2], [3, 2, 5]) // 14 (take metal 1 and metal 2)
bestValueForFused(6, [4, 2, 1], [3, 3, 5]) // 18 (take metal 0 and metal 1)
```

## Q2. Treasure Cave with Fused Bars--Dynamic Programming
Now write `bestValueForFusedDP`, which should use dynamic programming and should
run in O(B\*N) where B is the size of your bag and N is the total number of
metals (aka counts.length and values.length).

## Q3. Bellman Ford -- analysis
Given the following pseudocode for Bellman-Ford, answer the following questions.
```
algorithm Bellman-Ford(G, s)
  Input:
    Graph G = (V, E) with weights l(u, v) for each (u, v) in E
    Starting node s
  Output:
    array dist, where dist[u] is the shortest paths from s to u
    array prev, where prev[u] is the node before u along the shortest path

  for each vertex v in G
    dist[v] = inf
    prev[v] = null
  dist[s] = 0

  Repeat |V| times
    for each edge (u, v) in E
      temp = dist[u] + l(u, v)
      if temp < dist[v]
        dist[v] = temp
        prev[v] = u

  for each edge (u, v) in G
    if dist[u] + l(u, v) < dist[u]
      throw error("Negative Cycle Exists")

  return dist, prev
```

* In your own words, explain why Bellman-Ford will take O(|V|\*|E|).
* If you replace "Repeat |V| times" with "Repeat |V|-1" times, will the
  algorithm still work on graphs with all postive edges? Why or why not?
* In your own words, explain why the last for loop in the pseudocode can detect
 a negative cycle in the graph. Recall, a negative cycle is a cycle within the
 graph whose net total weight is negative.

Hint: consider watching the videos on [the Piazza post on Bellman-Ford](https://piazza.com/class/kjkot7wwgl53ya?cid=905).

As always, you may use online reference to help you understand this work, but
must use your own words to answer AND you must cite any sources you end up
reading.



