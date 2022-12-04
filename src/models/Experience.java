package models;

import java.time.Instant;
import java.util.List;

public class Experience extends Employee{
    private float exYears;
    private String skills;

    public Experience(float exYears, String skills) {
        this.exYears = exYears;
        this.skills = skills;
    }

    public Experience(long idEmployee, String fullName, String brithDay, String phoneNumbers, String email, Instant atCreated, Instant atUpdated, EmployeeTypes employeeType, float exYears, String skills) {
        super(idEmployee, fullName, brithDay, phoneNumbers, email, atCreated, atUpdated, employeeType);
        this.exYears = exYears;
        this.skills = skills;
    }
    public Experience(String[] fields){
        super(fields);
        exYears = Float.parseFloat(fields[8]);
        skills = fields[9];
    }

    public float getExYears() {
        return exYears;
    }

    public void setExYears(float exYears) {
        this.exYears = exYears;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String toString(){
        return super.toString() + String.format(",%f,%s",this.exYears, this.skills);
    }
}
