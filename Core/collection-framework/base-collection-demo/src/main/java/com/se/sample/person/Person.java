package com.se.sample.person;
import java.util.Date;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String email;
    private Date createdOn;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d}", name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person p) {
        return name.compareTo(p.getName());
    }
}

/*

Sort by created date ascending

Collections.sort(users, new Comparator<User>() {
  @Override
  public int compare(User u1, User u2) {
    return u1.getCreatedOn().compareTo(u2.getCreatedOn());
  }
});


users.sort(Comparator.comparing(User::getCreatedOn));

Option 4: Stream interface sorted() [Java 8]

List<User> sortedUsers = users.stream()
  .sorted(Comparator.comparing(User::getCreatedOn))
  .collect(Collectors.toList());



 */
