package practice07;

public class Person {
    protected String name;
    protected int age;

    public Person(String name,int age) {
        this.name = name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }



    public String introduce(){
        return String.format("My name is %s. I am %s years old.",this.name,this.age);
    }
}
