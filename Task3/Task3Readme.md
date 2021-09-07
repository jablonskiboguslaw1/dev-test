It is the third and the most demanding app made for dev-test.
Three methods for handling input, separating non-joint graphs and joining them respectively till all possible non-joint graphs remains.
Separating non-joint graphs is useful to work with large collections. There is simpler solution by recursive joining graphs in the same collection but evaluation if elements are separate or not is done for the same elements many times.
Because of performance I decided better choice is dividing for disjoint graphs collection and another collection as working area to joint remaining graphs. 
Like other apps waiting for input from standard I/O this one is also launched from IDE(main method) or from command prompt (javac Task3.java , java Task3). Java 9+ is required
Like mentioned below first input line must be positive number n, and n pairs positive integers. Stay focused. No validation nor exception handling or tests(please inform me if you want some or if you find some bugs) . It was not mentioned.  

### Task3
The first line of input contains a positive number `n`, next `n` lines contains pairs of positive integers, where each pair identifies a connection between two vertices in a graph. Please provide a working code that will give us the answer for the following questions: how many separated graphs are in the input.

Sample: 

For the input:

```
3
2 3
1 2
5 6
```

expected output is:

```
2
```

Explanation: first graph contains vertices 1, 2 and 3 while the second one contains 5 and 6.

