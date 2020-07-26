package practice10;


import java.util.Collection;
import java.util.HashSet;

public class Teacher extends Person {
    private Collection<Klass> classes;
    HashSet<Integer> classNumberSet=new HashSet<>();

    public Teacher(int id,String name, int age,Collection<Klass> classes) {
        super(id,name, age);
        this.classes=classes;
        this.classes.forEach(klass -> classNumberSet.add(klass.getNumber()));
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
            return String.format(" I am a Teacher. I don't teach %s.",student.getName());
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

}
