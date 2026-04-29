We are using DAO interface in our MVC project for a couple of important reasons:

**1. It lets you swap implementations without changing anything else.**

Right now you have `StudentDaoMemoryImpl` — it stores students in an `ArrayList`. That's fine for learning. But imagine later you need a real MySQL database. You'd write a new class:

```java
public class StudentDaoDbImpl implements StudentDao {
    // same methods, but now they use SQL queries
}
```

Then in `App.java`, you change one line:

```java
// Before:
StudentDao dao = new StudentDaoMemoryImpl();

// After:
StudentDao dao = new StudentDaoDbImpl();
```

That's it. The Controller and UI don't change at all because they only know about the `StudentDao` interface — they never knew (or cared) whether data lived in a list or a database.

**2. The Controller depends on the interface, not the implementation.**

Look at the Controller's constructor:

```java
public StudentController(StudentDao dao) {  }
```

It takes `StudentDao` (the interface), not `StudentDaoMemoryImpl` (the specific implementation). This means the Controller is making a promise: "I don't care *how* you store data. Just give me something that can add, get, update, and remove students."

**Could you skip the interface and just use the class directly?** Yes, and it would work fine for a small project. But the moment you need a second implementation, you'd have to go back and rewrite the Controller. The interface costs you almost nothing upfront and saves you a lot of pain later.

This principle is called "coding to an interface" and it's one of the most important habits in Java. Your course is teaching it early so it becomes second nature.