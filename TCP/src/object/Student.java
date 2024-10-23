package object;
import java.io.Serializable;
public class Student implements Serializable {
    private static final long serialVersionUID = 20151107L; // Số phiên bản
    private String code, gpaLetter; 
    private int id;
    private float gpa;
    public Student(String code, int id, float gpa) {
        this.code = code;
        this.id = id;
        this.gpa = gpa;
        if (this.gpa >= 3.7) this.gpaLetter = "A";
        else if (this.gpa >= 3.0) this.gpaLetter = "B";
        else if (this.gpa >= 2.0) this.gpaLetter = "C";
        else if (this.gpa >= 1.0) this.gpaLetter = "D";
        else this.gpaLetter = "F";
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getGpaLetter() {
        return gpaLetter;
    }
    public void setGpaLetter(String gpaLetter) {
        this.gpaLetter = gpaLetter;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getGpa() {
        return gpa;
    }
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    @Override
    public String toString() {
        return "Student{" + "code=" + code + ", gpaLetter=" + gpaLetter + ", id=" + id + ", gpa=" + gpa + '}';
    }
}
