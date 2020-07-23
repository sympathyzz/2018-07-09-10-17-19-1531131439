package practice11;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Teacher extends Person implements JoinListener{
    private Collection<Klass> classes;
    HashSet<Integer> classNumberSet=new HashSet<>();

    public Teacher(int id,String name, int age,Collection<Klass> classes) {
        super(id,name, age);
        this.classes=classes;
        classes.forEach(klass -> {
            klass.joinListeners.add(this);
        });
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
        if(this.classes!=null&&!this.classes.isEmpty()) {
            classes.forEach(klass -> {
                if(klass.getLeader()!=null&&klass.getLeader().id == student.id){
                    System.out.print(String.format("I am %s. I know %s become Leader of Class %s.\n", this.name, student.name, klass.getNumber()));
                }else{
                    System.out.print(String.format("I am %s. I know %s has joined Class %s.\n", this.name, student.name, klass.getNumber()));
                }
            });
        }
    }
}
