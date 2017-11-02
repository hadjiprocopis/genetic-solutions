# genetic-solutions

This is an example of how I use JGAP (genetic algorithms library)
in order to solve a set of equations.

JGAP version must be 3.6.2

How to compile

```
ant clean && ant
```

How to run a test (it assumes that you have
JGAP library in dir 3rdparty/jgap3.6.2/classes
alternatively use a jar and run the
java appropriately) :

```
java -cp 3rdparty/jgap3.6.2/classes:build/classes FindSolutionsToSetOfEquations
```
