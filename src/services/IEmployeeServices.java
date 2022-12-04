package services;

import models.Employee;

import java.util.List;

public interface IEmployeeServices<T> {
    List<Employee> employeesList();
    boolean isExistID(long idEmployee);
    Employee findEmployeeByID(long idEmployee);
    void addEmployee(Employee employee);
    void editEmployee(Employee employee);
    void removeEmployee(long idEmployee);
    List<models.Employee> sortByNameAToZ();
    List<models.Employee> sortByNameZToA();
}
