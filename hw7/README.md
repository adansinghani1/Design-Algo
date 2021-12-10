[![Work in Repl.it](https://classroom.github.com/assets/work-in-replit-14baed9a392b3a25080506f3b7b6d57f295ec2978f6f33ec97e36a161684cbe9.svg)](https://classroom.github.com/online_ide?assignment_repo_id=4441377&assignment_repo_type=AssignmentRepo)
# Homework 7: Greedy and Kruskal's

## Instructions
The goal of this homework is to practice what we've covered in lecture 17 and
18--i.e. writing and analyzing greedy algorithms. **This assignment is due on
April 2, 2021 at 11:59pm.**

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
Piazza to see if anyone else has had a similar issue. The "hw4" tag  on the top
will show only posts relevant to HW4. If you don't find any posts relevant to
you, you can make your own Piazza post.

You can also make an appointment with Andrew or a TA via the [staff
page](https://csc4520.org/staff/) if you want 1-on-1 help.

A Homework Party will be announced on Piazza as well. Attend in order to get
hints and guidance on how to solve the trickier problems.

## Q1: Treasure Cave (3 points)
Imagine you find a hidden cave filled with with N different types of metal bars
(gold, silver, platinum, steel, etc.) Each type of metal bar has some value
v<sub>i</sub>, and there are x<sub>i</sub> bars of that metal in the cave
(for i = 0, 1, 2, 3, ... N-1). You want to bring back as many bars as of the
treasure as you can, but your bag can only fit W bars. **How do you choose how
many bars of each metal to bring home to maximize the total value?**

For example, if your bag can store 7 bars and you have gold, silver, platinum,
and steel in these quantities:

    [4, 10, 2, 4] // 4 bars of gold, 10 silver, 2 platinum, 4 steel

and these values

    [3, 1, 5, 2]  // gold worth 3 per bar, silver worth 1, platinum 5, steel 2

Then you would want to take this much of each metal

    [4, 0, 2, 1]  // all the gold, no silver, all the platinum, 1 steel bar
                  // for a total value of 24 (4*3 + 2*5 + 1*2)

Write `bestValue()` which takes in an integer W, an array of counts, and an
array of values. It should return the best value you can earn by picking the
bars optimally. **Your code should run in O(nlogn).**

* **Hint #1:** This can be done using a Greedy approach.
* **Hint #2:** We've provided `MetalBars.java` to help you out here. Check the
homework party to see how to use it.

## Q2. Treasure Cave with Fused Bars (2 points)
Now assume that for each type of metal, all of the bars are fused together so
that **you're forced to all the bars of a certain type, or none of them.**

This means that you sometimes should not take the metal that has the highest
value, because it either will not fit all in your bag (since you have to take
all the bars), or other metals of lesser will be worth more overall value when
combined together. **In Q2.txt, explain by counterexample where the greedy
approach you wrote in Q1 won't work for this problem.**

## Q3. Disjoint Sets in Kruskal's (2 points)
In class, we summarized Kruksal's Algorithm as "pick the next cheapest edge that
doesn't cause a cycle." However, the actual pseudocode looks like this:
```
algorithm kruskal(G, w)
  Input: A connected undirected graph G = (V, E) with edge weights w(u, v) for all (u,v) in E
  Output: A minimum spanning tree defined by the edges X

  for all u ∈ V:
    makeset(u)
  X = {}
  Sort the edges E by weight
  for all edges {u, v} ∈ E, in increasing order of weight:
    if find(u) != find(v):
      add edge {u, v} to X
      union(u, v)
  return X
```

To understand how we handle cycle detectiion works here, you need to understand
a data structure called Disjoint Sets. [Disjoint
sets](https://en.wikipedia.org/wiki/Disjoint-set_data_structure) are a way of
tracking which nodes are connected to each other, putting nodes that are
connected in the same "set" as each other. When we find a new path to an
existing node, we'll realize that we're in a cycle because we realize that the
edge we just checked has nodes from the same set. There are three functions
from above that we focus in on:

1. makeset(x), which takes in a node x and modifies it so that it also represents itself as a set
2. find(x), which takes in a node and returns which set it belongs in
3. union(x, y), which takes in two sets, and combines them into one big set

In `Q3.txt`, answer the following questions:
* How many times will we call makeset within kruskal's? Put your answer in terms of |V| and |E|
* How many times will we have to call find within kruskal's? Put your answer in terms of |V| and |E|
* How many times will we call union within kruskals? Put your answer in terms of |V| and |E|
* Describe using your own words why "find(u) != find(v)" is the same as "if this
  edge doesn't cause a cycle". Please include an example. You may find the
  homework party to be helpful here.

## Q4. Union-Find
Now here's the actual code for the functions above:
```
algorithm makeset(x)
  Input: a graph node x
  Output: modify x such that it has a "rank" and a "parent"

  x.rank = 0
  x.parent = x

algorithm find(x)
  Input: a graph node x
  Output: the ancestor

  if x != x.parent
    x.parent = find(x.parent)
  return x.parent

algorithm union(x, y)
  Input: graph nodes x and y
  Output: modify x and y so that they are now connected in the same "set"

  x = find(x)
  y = find(y)

  if x.rank > y.rank
    y.p = x
  else
    x.p = y
    if x.rank == y.rank
      y.rank = y.rank + 1

```

In `Q4.txt`, answer the following questions:
* Find does something called "path compression". How long will find take to run on some node x the first time vs. the second?
* In the absolute worst case, how many times will find need to make a recursive call on a single node when used in kruskal's?
* What does rank signify for each node?

As always, you may use online reference to help you understand this work, but
must use your own words to answer AND you must cite any sources you end up
reading.
