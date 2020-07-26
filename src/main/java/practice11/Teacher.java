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
        if(this.classes!=null&&this.classes.size()>0){
            this.classes.forEach(klass -> classNumberSet.add(klass.getNumber()));
            classes.forEach(klass -> {
                klass.getJoinListeners().add(this);
            });
        }
    }

    public Teacher(int id,String name, int age) {
        super(id,name, age);
    }

    public Collection<Klass> getClasses() {
        return classes;
    }

    public String introduce(){
        if(this.classes!=null&&!this.classes.isEmpty()){
            return super.introduce()+String.format(" I am a Teacher. I teach Class %s.",this.classNumberSet.toString().substring(1,classNumberSet.toString().length()-1));
        }else{
            return super.introduce()+" I am a Teacher. I teach No Class.";
        }

    }

    public String introduceWith(Student student){
        if(this.classes!=null&&!this.classes.isEmpty()){
            if(classNumberSet.contains(student.getKlass().getNumber())){
                return super.introduce()+String.format(" I am a Teacher. I teach %s.",student.getName());
            }else {
                return super.introduce()+String.format(" I am a Teacher. I don't teach %s.",student.getName());
            }
        }else {
            return super.introduce()+String.format(" I am a Teacher. I don't teach %s.",student.getName());
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
            classes.forEach(klass -> {
                if(klass.getLeader()!=null&&klass.getLeader().getId() == student.getId()){
                    System.out.print(String.format("I am %s. I know %s become Leader of Class %s.\n", this.name, student.getName(), klass.getNumber()));
                }else{
                    System.out.print(String.format("I am %s. I know %s has joined Class %s.\n", this.name, student.getName(), klass.getNumber()));
                }
            });

    }
}
