package practice11;

import java.util.LinkedList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    protected List<JoinListener> joinListeners=new LinkedList<>();

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
            notifyObservers(student);
        }

    }

    public void appendMember(Student student){
        student.setKlass(this);
        notifyObservers(student);
    }

    public boolean isIn(Student student){
        if(student.getKlass().number==this.number){
            return true;
        }else {
            return false;
        }
    }
    public void notifyObservers(Student student){
        for (JoinListener joinListener:joinListeners){
            joinListener.update(student);
        }
    }
}
