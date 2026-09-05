# Java Learning Path

A hands-on roadmap for going from "basic Java" to "I can build a small application."
Each module is runnable on its own and gets progressively harder. Read the code,
run it, then do the `TODO` exercises at the bottom of each file before moving on.

## How to use this

```bash
cd java-learning-path
mvn compile               # compiles everything
mvn -q exec:java -Dexec.mainClass="com.learningpath.basics.Basics01_VariablesAndTypes"
mvn test                  # runs the capstone's JUnit tests
```

Or just open any file in your IDE and run its `main` method directly.

## Roadmap

1. **basics** — variables, types, control flow, methods
   (`Basics01_VariablesAndTypes`, `Basics02_ControlFlow`, `Basics03_Methods`)
2. **oop** — classes, inheritance, interfaces, polymorphism
   (`Shape`/`Circle`/`Rectangle`, `Animal`/`Dog`/`Cat`, `OopDemo`)
3. **collections** — `List`, `Map`, `Set`, and the Streams API
   (`CollectionsDemo`)
4. **exceptions** — checked vs. unchecked exceptions, custom exceptions,
   try/catch/finally (`ExceptionsDemo`)
5. **fileio** — reading and writing text files, `try-with-resources`
   (`FileIoDemo`)
6. **capstone/taskmanager** — a small console Task Manager application that
   ties all of the above together: OOP model, a collection-backed store,
   file persistence, exception handling, and a JUnit test suite
   (`Task`, `TaskManager`, `TaskManagerApp`, `TaskManagerTest`)

## Suggested order

Work top to bottom. Don't skip the `TODO` exercises — reading code teaches
recognition, writing code teaches recall. Once you finish the capstone, try
extending it yourself (see "Next steps" in that package) before starting a
brand-new application idea.

## Next application ideas (after the capstone)

Once `TaskManager` feels comfortable, apply the same pattern (model class +
manager/service class + console or file/database persistence) to something
of your own choosing, for example:
- A contact book (add/search/delete contacts, save to CSV)
- A simple expense tracker (categories, totals, monthly summary)
- A quiz game that reads questions from a file

The skills transfer directly: classes and interfaces for the model,
collections to hold data in memory, streams to query/summarize it,
exceptions to handle bad input, and file I/O to persist it between runs.
