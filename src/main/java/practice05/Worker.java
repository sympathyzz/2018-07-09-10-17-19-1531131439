package practice05;

public class Worker extends Person{
    public Worker(String name, int age) {
        super(name, age);
    }

    public String introduce(){
        return "My name is "+this.name+". I am "+this.age+" years old. I am a Worker. I have a job.";
    }
}
