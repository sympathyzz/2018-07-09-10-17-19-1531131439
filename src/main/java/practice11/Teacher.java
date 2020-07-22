package practice11;

import java.util.Collection;
import java.util.HashSet;

public class Teacher extends Person implements JoinListener{
    private Collection<Klass> classes;
    HashSet<Integer> classNumberSet=new HashSet<>();

    public Teacher(int id,String name, int age,Collection<Klass> classes) {
        super(id,name, age);
        this.classes=classes;
    }

    public Teacher(int id,String name, int age) {
        super(id,name, age);

    }

    public Collection<Klass> getClasses() {
        return classes;
    }

    public String introduce(){
        if(this.classes!=null&&!this.classes.isEmpty()){
            classes.forEach(klass -> classNumberSet.add(klass.getNumber()));
            return String.format("My name is %s. I am %s years old. I am a Teacher. I teach Class %s.",this.name,this.age,this.classNumberSet.toString().substring(1,classNumberSet.toString().length()-1));
        }else{
            return String.format("My name is %s. I am %s years old. I am a Teacher. I teach No Class.",this.name,this.age);
        }

    }

    public String introduceWith(Student student){
        if(this.classes!=null&&!this.classes.isEmpty()){
            classes.forEach(klass -> classNumberSet.add(klass.getNumber()));
            if(classNumberSet.contains(student.getKlass().getNumber())){
                return String.format("My name is %s. I am %s years old. I am a Teacher. I teach %s.",this.name,this.age,student.name);
            }else {
                return String.format("My name is %s. I am %s years old. I am a Teacher. I don't teach %s.",this.name,this.age,student.name);
            }
        }else {
            return String.format("My name is %s. I am %s years old. I am a Teacher. I don't teach %s.",this.name,this.age,student.name);
        }

    }

    public boolean isTeaching(Student student){
        for(Klass klass:classes){
            if(klass.isIn(student)){
                return true;
            }
        }
        return false;

    }

    @Override
    public void update(Student student) {
        classes.forEach( klass -> {
            if(klass.getNumber()==student.getKlass().getNumber()&&klass.getLeader().id==student.id){
                System.out.println(String.format("I am %s. I know %s become Leader of Class %s.",this.name,student.name,klass.getNumber()));
            }else if(klass.getNumber()==student.getKlass().getNumber()){
                System.out.println(String.format("I am %s. I know Jerry has joined Class %s.",this.name,student.name,klass.getNumber()));
            }
                });

    }
}
