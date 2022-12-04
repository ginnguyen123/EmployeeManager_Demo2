package models;

import java.time.Instant;
import java.util.List;

public class Intern extends Employee{
    private String majors;
    private String semester;
    private String universityName;

    public Intern(String majors, String semester, String universityName) {
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public Intern(long idEmployee, String fullName, String brithDay, String phoneNumbers, String email, Instant atCreated, Instant atUpdated,
                   EmployeeTypes employeeType, String majors, String semester, String universityName) {
        super(idEmployee, fullName, brithDay, phoneNumbers, email, atCreated, atUpdated, employeeType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }
    public Intern(String[] fields){
        super(fields);
        universityName = fields[8];
        majors = fields[9];
        semester = fields[10];

    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    public String toString(){
//        this.majors = majors;
//        this.semester = semester;
//        this.universityName = universityName;
        return super.toString()+
                String.format(",%s,%s,%s"
                        ,this.universityName,this.majors,this.semester);
    }
}
