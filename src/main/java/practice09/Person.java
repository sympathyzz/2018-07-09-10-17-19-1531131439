package practice09;

import java.util.Objects;

public class Person {
    protected String name;
    protected int age;
    protected int id;

    public Person(int id,String name,int age) {
        this.name = name;
        this.age=age;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String introduce(){
        return String.format("My name is %s. I am %s years old.",this.name,this.age);
    }

}
