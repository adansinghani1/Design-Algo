[![Work in Repl.it](https://classroom.github.com/assets/work-in-replit-14baed9a392b3a25080506f3b7b6d57f295ec2978f6f33ec97e36a161684cbe9.svg)](https://classroom.github.com/online_ide?assignment_repo_id=4166763&assignment_repo_type=AssignmentRepo)
# Homework 4: Trees

## Instructions
The goal of this homework is to practice what we've covered in lecture 10--i.e.
writing algorithms on Trees with arbitrary number of children. **This assignment
is due on February 25, 2021.**

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

## Autocomplete
We want to create an autocomplete program, where we can provide a string
`prefix`, and output a list of possible words that start with `prefix`. We do
this by designing a Tree where each value is a `Character`, and traversing
through the Tree spells out words by collecting each character and forming
strings as you traverse **depth-first**. Here is an example of one such tree:

![example of autocomplete tree](trie.png)

* This tree spells out "ace", "acne", "and", "andrew", "beam",
  "beef", "bees", "cat", "cow", and "cut".
* Notice that the value in the root of the tree should be ignored when making
  words.
* Notice that an extra node with a "$" character denotes when a word has ended.

(The Tree we define here is a very basic version of a
[Trie](https://en.wikipedia.org/wiki/Trie), but the same basic idea we see here
powers your phone's keyboard autocomplete!)

**We'll build out our algorithm by working out 3 parts:**
1. `findNode`, which takes in a TreeNode `node`, the String `prefix`, and an int
`index` into prefix, and outputs the node we need to be at in order
start collecting elements.
2. `collectWords`, which takes in a TreeNode `node`, the String `prefix`, and a
list of Strings `results`, and updates the list with valid words.
3. `candidates`, which takes in a TreeNode `root` and a string `prefix`, and
returns the list of all possible words that can be made starting with the
letters in `prefix`. 

### Q1. `findNode` (3 points)
Our first method, `findNode`, traverses the Tree based on the characters in
prefix and outputs the TreeNode that we end at. If we cannot find a valid node,
we return null. The `index` variable helps us remmeber which character we're at
in prefix.

For example, if our prefix was "acn", we should output the node with 'n' in it
after traversing TreeNode('a') and TreeNode('c'): 
```java
TreeNode<Character> endNode = findNode(example, "acn", 0);
System.out.println(endNode.getValue()) // should output 'n'
System.out.println(endNode.getChildren().get(0).getValue()) // should output 'e'

endNode = findNode(example, "notInTree", 0);
System.out.println(endNode) // should output null
```

### Q2. `collectWords` (3 points)
Our next method is here to actually collect all the words from a given TreeNode.
It also ensures that each word is prepended with prefix.
```java
List<String> exampleList = new ArrayList<>();
collectWords(example.getChildren().get(1), "", exampleList);
System.out.println(exampleList); // should output ["eam", "eef", "ees"]

exampleList.clear();
collectWords(example.getChildren().get(1), "b", exampleList);
System.out.println(exampleList); // should output ["beam", "beef", "bees"]

exampleList.clear();
collectWords(example.getChildren().get(1), "mm", exampleList);
System.out.println(exampleList); // should output ["mmeam", "mmeef", "mmees"]

```

### Q3. `candidates` (2 points)
This is the method that uses the methods from Q1 and Q2 together to return the
actual answer. Examples:

```java
TreeNode example = new TreeNode('*', ...);

System.out.println(candidates(example, "c")); // Outputs ["cat", "cow", "cut"]
System.out.println(candidates(example, "ca")); // Outputs ["cat"]
System.out.println(candidates(example, "an")); // Outputs ["and", "andrew"]

// Outputs ["ace", "acne", "and", "andrew", "beam", "beef", "bees", "cat", "cow", "cut"]
System.out.println(candidates(example, ""));

System.out.println(candidates(example, "deer")); // Outputs []
System.out.println(candidates(example, "bean")); // Outputs []
```

### Q4. Runtime (2 points)
What's the worst-case runtime of `candidates`? Explain your answer within
`runtime.txt`.
* **Hint #1:** which of the examples in Q3 took the most number of steps?
* **Hint #2:** the runtime of adding Strings to Characters is `O(n)` in Java,
where `n` is the length of the String. Java strings are immutable, so you have
to create a brand new String each time you concat a String with Character.
This means you must copy over all `n` letters within the String, hence `O(n)`.

## Q5. Optimization (Optional)
**This question is optional and is worth extra credit.**
Can you do better than your answer in Q4? Ensure that `candidates` method takes
the least amount of steps possible by creating an `Autocomplete2.java` which
re-implements all the methods to be have an overall optimal runtime. Be sure to
provide the new runtime in comments and justify your answer. If your answers to
Q1-3 are already optimal, then simply copy your original implementation over.
**Hint:** you want to use StringBuilder here.
