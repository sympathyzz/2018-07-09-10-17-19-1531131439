package practice07;


public class Teacher extends Person {
    private Klass klass;

    public Teacher(String name, int age,Klass klass) {
        super(name, age);
        this.klass=klass;
    }

    public Teacher(String name, int age) {
        super(name, age);

    }

    public Klass getKlass() {
        return klass;
    }
    public String introduce(){
        if(this.klass!=null){
            return String.format("My name is %s. I am %s years old. I am a Teacher. I teach Class %s.",this.name,this.age,this.klass.getNumber());
        }else{
            return String.format("My name is %s. I am %s years old. I am a Teacher. I teach No Class.",this.name,this.age);
        }

    }
    public String introduceWith(Student student){
        if(student.getKlass().getNumber()==this.klass.getNumber()){
            return String.format("My name is %s. I am %s years old. I am a Teacher. I teach %s.",this.name,this.age,student.name);
        }else{
            return String.format("My name is %s. I am %s years old. I am a Teacher. I don't teach %s.",this.name,this.age,student.name);
        }
    }
}

