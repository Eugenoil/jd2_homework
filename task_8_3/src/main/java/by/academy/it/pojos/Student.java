package by.academy.it.pojos;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student extends Person {
    private static final long serialVersionUID = 4L;
    private String faculty;
    private int mark;

    public Student() {
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "faculty='" + faculty + '\'' +
                ", mark=" + mark + ", name=" + getName() +
                ", surname= " + getSurname() +
                '}';
    }
}
