package practice11;

import java.util.LinkedList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<JoinListener> joinListeners=new LinkedList<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public String getDisplayName() {
        return String.format("Class %s",this.number);
    }

    public void assignLeader(Student student){
        if(student.getKlass().number!=this.number){
            System.out.print("It is not one of us.\n");
        }else{
            student.getKlass().leader=student;
        }

    }

    public void appendMember(Student student){
        student.setKlass(this);

        student.getKlass().getNumber()
        register();
        joinListeners.forEach(joinListener -> {
            joinListener.update(student);
        });
    }

    public boolean isIn(Student student){
        if(student.getKlass().number==this.number){
            return true;
        }else {
            return false;
        }
    }
    public void register(Teacher teacher){
        joinListeners.add(teacher);
    }
    public void unregister(Teacher teacher){
        joinListeners.remove(teacher);
    }
    public void notifyObservers(){
        for (JoinListener joinListener:joinListeners){
            joinListener.update();
        }
    }
}
