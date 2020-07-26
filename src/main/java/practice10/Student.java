package practice10;

public class Student extends Person {
    private Klass klass;

    public Student(int id,String name, int age,Klass klass) {
        super(id,name, age);
        this.klass=klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }
    public String introduce(){
        if(this.klass.getLeader()!=null&&this.id==this.klass.getLeader().getId()){
            return  super.introduce()+String.format(" I am a Student. I am Leader of Class %s.",this.klass.getNumber());
        }else{
            return  super.introduce()+String.format(" I am a Student. I am at Class %s.",this.klass.getNumber());
        }
    }
}

