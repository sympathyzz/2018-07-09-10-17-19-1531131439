package practice06;


public class Student extends Person {
    private int klass;

    public Student(String name, int age,int klass) {
        super(name, age);
        this.klass=klass;
    }


    public int getKlass() {
        return klass;
    }
    public String introduce(){
        return "My name is "+this.name+". I am "+this.age+" years old. I am a Student. I am at Class "+this.klass+".";
    }
}
