package services;

import models.*;
import utils.IOFileUtils;

import java.time.Instant;
import java.util.*;

public class EmployeeServices implements IEmployeeServices {
    private String pathEmployees = "datas/employees.csv";
    private static EmployeeServices instance;
    public EmployeeServices(){}
    public static EmployeeServices getInstance(){
        if (instance == null){
            instance = new EmployeeServices();
        }
        return instance;
    }
    @Override
    public List<Employee> employeesList() {
        List<Employee> employeeList = new ArrayList<>();
        List<String> stringEmployeeList = IOFileUtils.readFile(pathEmployees);
        for (String stringEmployee : stringEmployeeList){
            employeeList.add(Employee.parserEmployee(stringEmployee));
        }
        return employeeList;
    }
    @Override
    public boolean isExistID(long idEmployee) {
        List<Employee> employeeList = employeesList();
        for (Employee employee : employeeList){
            if (employee.getIdEmployee() == idEmployee)
                return true;
        }
        return false;
    }
    @Override
    public Employee findEmployeeByID(long idEmployee) {
        List<Employee> employeeList = employeesList();
        for (Employee employee : employeeList){
            if (employee.getIdEmployee() == idEmployee){
                switch (employee.getEmployeeType()){
                    case EXPERIENCE:
                        Experience experience = (Experience) employee;
                        return experience;
                    case FRESHER:
                        Fresher fresher = (Fresher) employee;
                        return fresher;
                    case INTERN:
                        Intern intern = (Intern) employee;
                        return intern;
                }
            }
        }
        return null;
    }
    @Override
    public void addEmployee(Employee employee) {
        List<Employee> employeeList = employeesList();
        EmployeeTypes employeeTypes = employee.getEmployeeType();
        switch (employeeTypes){
            case INTERN:
                Intern intern = (Intern) employee;
                employeeList.add(intern);
                break;
            case FRESHER:
                Fresher fresher = (Fresher) employee;
                employeeList.add(fresher);
                break;
            case EXPERIENCE:
                Experience experience = (Experience) employee;
                employeeList.add(experience);
                break;
        }
        IOFileUtils.writeFile(employeeList,pathEmployees);
    }
    @Override
    public void editEmployee(Employee newEmployee) {
        List<Employee> employeeList = employeesList();
        for (Employee employee : employeeList){
            if (employee.getIdEmployee() == newEmployee.getIdEmployee()){
                Instant atUpdated = Instant.now();
                //tạo lại thời gian cập nhật thông tin
                String fullName = newEmployee.getFullName();
                if (fullName != null && !fullName.isEmpty()){
                    employee.setFullName(fullName);
                    employee.setAtUpdated(atUpdated);
                }
                String birthDay = newEmployee.getBrithDay();
                if (birthDay!=null&& !birthDay.isEmpty()){
                    employee.setBrithDay(birthDay);
                    employee.setAtUpdated(atUpdated);
                }
                String phoneNumber = newEmployee.getPhoneNumbers();
                if (phoneNumber!=null && !phoneNumber.isEmpty()){
                    employee.setPhoneNumbers(phoneNumber);
                    employee.setAtUpdated(atUpdated);
                }
                String email = newEmployee.getEmail();
                if (email!=null && !email.isEmpty()){
                    employee.setEmail(email);
                    employee.setAtUpdated(atUpdated);
                }
                EmployeeTypes employeeTypes = newEmployee.getEmployeeType();
                if (employeeTypes.getValue()<employee.getEmployeeType().getValue()) {
                    employee.setEmployeeType(employeeTypes);
                }
                switch (employeeTypes){
                    case EXPERIENCE:
                        //(float exYears, String skills)
                        Experience newExperience = (Experience) newEmployee;
                        Experience oldExperience = (Experience) employee;
                        float exYears = newExperience.getExYears();
                        if ((exYears!=0&&exYears<=0) || exYears>=oldExperience.getExYears()){
                            oldExperience.setExYears(exYears);
                            oldExperience.setAtUpdated(atUpdated);
                        }
                        String skills = newExperience.getSkills();
                        if (skills!=null && !skills.isEmpty()){
                            oldExperience.setAtUpdated(atUpdated);
                            oldExperience.setSkills(skills );
                        }
                        break;
                    case FRESHER:
                        Fresher newFresher = (Fresher) newEmployee;
                        Fresher oldFresher = (Fresher) employee;
                        //(String graduationDate, String graduationRank, String education)
                        String graduationDate = newFresher.getGraduationDate();
                        if (graduationDate!=null && !graduationDate.isEmpty()){
                            oldFresher.setGraduationDate(graduationDate);
                            oldFresher.setAtUpdated(atUpdated);
                        }
                        String graduationRank = newFresher.getGraduationRank();
                        if (graduationRank!=null && !graduationRank.isEmpty()){
                            oldFresher.setGraduationRank(graduationRank);
                            oldFresher.setAtUpdated(atUpdated);
                        }
                        String education = newFresher.getEducation();
                        if (education!=null && !education.isEmpty()){
                            oldFresher.setEducation(education);
                            oldFresher.setAtUpdated(atUpdated);
                        }
                        break;
                    case INTERN:
//                        (String majors, String semester, String universityName)
                        Intern newIntern = (Intern) newEmployee;
                        Intern oldIntern = (Intern) employee;
                        String majors = newIntern.getMajors();
                        if (majors!=null && !majors.isEmpty()){
                            oldIntern.setMajors(majors);
                            oldIntern.setAtUpdated(atUpdated);
                        }
                        String semester = newIntern.getSemester();
                        if (semester!=null && !semester.isEmpty()){
                            oldIntern.setSemester(semester);
                            oldIntern.setAtUpdated(atUpdated);
                        }
                        String universityName = newIntern.getUniversityName();
                        if (universityName!=null && !universityName.isEmpty()){
                            oldIntern.setUniversityName(universityName);
                            oldIntern.setAtUpdated(atUpdated);
                        }
                        break;
                }
                IOFileUtils.writeFile(employeeList,pathEmployees);
                break;
            }
        }
    }
    @Override
    public void removeEmployee(long idEmployee) {
        List<Employee> employeeList = employeesList();
        for (Employee employee : employeeList){
            if (employee.getIdEmployee() == idEmployee){
                employeeList.remove(employee);
                break;
            }
        }
        IOFileUtils.writeFile(employeeList,pathEmployees);
    }
    @Override
    public List<Employee> sortByNameAToZ() {
        List<Employee> employeeList = employeesList();
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee employees1, Employee employees2) {
                if (employees1.getFullName().compareTo(employees2.getFullName()) > 0)
                    return 1;
                else if (employees1.getFullName().compareTo(employees2.getFullName()) == 0)
                    return 0;
                else
                    return -1;
            }
        });
        return employeeList;
    }
    @Override
    public List<Employee> sortByNameZToA() {
        List<Employee> employeeList = employeesList();
        Collections.sort(employeeList,new Comparator<Employee>(){
            @Override
            public int compare(Employee employee1, Employee employee2) {
                if (employee1.getFullName().compareTo(employee2.getFullName()) < 0)
                    return 1;
                else if (employee1.getFullName().compareTo(employee2.getFullName()) == 0)
                    return 0;
                else
                    return -1;
            }
        });
        return employeeList;
    }
}
