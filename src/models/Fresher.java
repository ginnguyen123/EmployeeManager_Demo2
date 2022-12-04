package models;

import java.time.Instant;
import java.util.List;

public class Fresher extends Employee{
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String graduationDate, String graduationRank, String education) {
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }
    public Fresher(String[] fields){
        super(fields);
        education = fields[8];
        graduationRank = fields[9];
        graduationDate = fields[10];
    }

    public Fresher(long idEmployee, String fullName, String brithDay, String phoneNumbers, String email, Instant atCreated, Instant atUpdated, EmployeeTypes employeeType, String graduationDate, String graduationRank, String education) {
        super(idEmployee, fullName, brithDay, phoneNumbers, email, atCreated, atUpdated, employeeType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    public String toString(){
        //(String graduationDate, String graduationRank, String education)
        return super.toString() + String.format(",%s,%s,%s",this.education,this.graduationRank,this.graduationDate);
    }
}
