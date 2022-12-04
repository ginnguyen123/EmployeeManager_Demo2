package models;

import utils.DateUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    public static long employeeCounts = 0;
    private long idEmployee;
    private String fullName;
    private String brithDay;
    private String phoneNumbers;
    private String email;
    private Instant atCreated;
    private Instant atUpdated;
    private List<Certificates> certificates = new ArrayList<>();
    private EmployeeTypes employeeType; // 1 - 2 -3

    public Employee(){}
    public Employee(long idEmployee, String fullName, String brithDay, String phoneNumbers, String email,
                    Instant atCreated, Instant atUpdated, EmployeeTypes employeeType){
        this.idEmployee = idEmployee;
        this.fullName = fullName;
        this.brithDay = brithDay;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
        this.atCreated = atCreated;
        this.atUpdated = atUpdated;
        this.certificates = certificates;
        this.employeeType = employeeType;
    }
    public Employee(String[] fields){
        //this.idEmployee,this.fullName,this.brithDay,this.phoneNumbers,
        //                this.email,this.employeeType,stringAtCreated,stringAtUpdated
        idEmployee = Long.parseLong(fields[0]);
        fullName = fields[1];
        brithDay = fields[2];
        phoneNumbers = fields[3];
        email = fields[4];
        employeeType = EmployeeTypes.getEmplyeeType(Integer.parseInt(fields[5]));
        atCreated = Instant.parse(fields[6]);
        atUpdated = Instant.parse(fields[7]);
    }
    public static Employee parserEmployee(String raw){
        String[] fields = raw.split(",");
        EmployeeTypes employeeTypes = EmployeeTypes.getEmplyeeType(Integer.parseInt(fields[5]));
        switch (employeeTypes){
            case INTERN:
                Intern intern = new Intern(fields);
                return intern;
            case FRESHER:
                Fresher fresher = new Fresher(fields);
                return fresher;
            case EXPERIENCE:
                Experience experience = new Experience(fields);
                return experience;
        }
        return null;
    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBrithDay() {
        return brithDay;
    }

    public void setBrithDay(String brithDay) {
        this.brithDay = brithDay;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getAtCreated() {
        return atCreated;
    }

    public void setAtCreated(Instant atCreated) {
        this.atCreated = atCreated;
    }

    public Instant getAtUpdated() {
        return atUpdated;
    }

    public void setAtUpdated(Instant atUpdated) {
        this.atUpdated = atUpdated;
    }

    public List<Certificates> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificates> certificates) {
        this.certificates = certificates;
    }

    public EmployeeTypes getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeTypes employeeType) {
        this.employeeType = employeeType;
    }
    public String toString(){
//        String stringAtCreated = DateUtils.instantToString(atCreated);
//        String stringAtUpdated = DateUtils.instantToString(atUpdated);
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                this.idEmployee,this.fullName,this.brithDay,this.phoneNumbers,
                this.email,this.employeeType.getValue(),atCreated,atUpdated);
    }
}
