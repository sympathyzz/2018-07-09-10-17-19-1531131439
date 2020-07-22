package practice08;

public class Student extends Person {
    private Klass klass;

    public Student(int id,String name, int age,Klass klass) {
        super(id,name, age);
        this.klass=klass;
    }


    public Klass getKlass() {
        return klass;
    }
    public String introduce(){
        if(this.klass.getLeader()!=null && this.name.equals(this.klass.getLeader().name)){
            return  String.format("My name is %s. I am %s years old. I am a Student. I am Leader of Class %s.",this.name,this.age,this.klass.getNumber());
        }else{
            return  String.format("My name is %s. I am %s years old. I am a Student. I am at Class %s.",this.name,this.age,this.klass.getNumber());
        }
    }
}