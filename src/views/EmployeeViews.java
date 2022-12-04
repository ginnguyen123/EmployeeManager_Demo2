package views;

import models.*;
import services.CertificatesServices;
import services.EmployeeServices;
import services.IEmployeeServices;
import utils.DateUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static models.EmployeeTypes.INTERN;

public class EmployeeViews {
    private IEmployeeServices employeeServices;
    private CertificatesServices certificatesServices;
    public EmployeeViews(){
        this.employeeServices = EmployeeServices.getInstance();
        this.certificatesServices = CertificatesServices.getInstance();
    }
    public Scanner scanner = new Scanner(System.in);
    public void menuEmployee(){
        System.out.println(">Quản lý nhân viên.");
        System.out.println("1.Hiển thị danh sách nhân viên.");
        System.out.println("2.Hiển thì danh sách nhân viên Experience");
        System.out.println("3.Hiển thì danh sách nhân viên Fresher");
        System.out.println("4.Hiển thì danh sách nhân viên Intern");
        System.out.println("5.Sắp xếp danh sách nhân viên theo full name A -> Z.");
        System.out.println("6.Sắp xếp danh sách nhân viên theo full name A -> Z.");
        System.out.println("7.Thêm nhân viên.");
        System.out.println("8.Sửa thông tin nhân viên.");
        System.out.println("9.Xóa thông tin nhân viên.");
        System.out.println("10.Tìm kiếm thông tin nhân viên.");
        System.out.println("0.Thoát chương trình.");
        System.out.print(">Chọn chức năng: ");
        boolean checkChoice = false;
        do {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    showEmployees();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    addEmployeeViews();
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 0:
                    System.exit(5);
                    break;
                default:
                    System.out.println(">Chọn sai chức năng. Kiểm tra lại.");
                    System.out.print(">Chọn lại chức năng: ");
                    checkChoice = true;
                    break;
            }
        }while (checkChoice);
    }
    public void showEmployees(){
        System.out.println(">Hiển thị danh sách nhân viên.");
        System.out.println();
        List<Employee> employeeList = employeeServices.employeesList();
        for (Employee employee : employeeList){
            //(long idEmployee, String fullName, String brithDay, String phoneNumbers, String email,
            //                    Instant atCreated, Instant atUpdated, EmployeeTypes employeeType)
            System.out.printf("||  %d  ||  %s  || %s  ||  %s  ||  %s  ||  %s  ||  %s  ||  %s  ||\n",
                    employee.getIdEmployee(),employee.getFullName(),employee.getBrithDay(),employee.getPhoneNumbers(),
                    employee.getEmail(),employee.getEmployeeType(), DateUtils.instantToString(employee.getAtCreated()),
                    DateUtils.instantToString(employee.getAtUpdated()));
        }
    }
    public void addEmployeeViews(){
        System.out.println(">Thêm thông tin nhân viên.");
        System.out.println(">Chọn kiểu nhân viên: ");
        EmployeeTypes employeeTypes = INTERN;
        System.out.println("1. Experience.");
        System.out.println("2. Fresher.");
        System.out.println("3. Intern.");
        System.out.println("0. Quay lại.");
        System.out.print(">Chọn chức năng: ");
        int choice = Integer.parseInt(scanner.nextLine());
        boolean checkChoice = false;
        do {
            switch (choice){
                case 1:
                    employeeTypes = EmployeeTypes.EXPERIENCE;
                    break;
                case 2:
                    employeeTypes = EmployeeTypes.FRESHER;
                    break;
                case 3:
                   employeeTypes = INTERN;
                    break;
                case 0:
                    menuEmployee();
                    break;
                default:
                    boolean checkChoiceRetry = false;
                    do {
                        System.out.println(">Chọn sai chức năng. Kiểm tra lại.");
                        System.out.println("1.Nhập lại.");
                        System.out.println("0.Quay lại.");
                        int choiceRetry = Integer.parseInt(scanner.nextLine());
                        switch (choiceRetry){
                            case 1:
                                addEmployeeViews();
                                break;
                            case 0:
                                menuEmployee();
                                break;
                            default:
                                checkChoiceRetry = true;
                                break;
                        }
                    }while (checkChoiceRetry);

                    break;
            }
        }while (checkChoice);

        long idEmployee = System.currentTimeMillis()%100000000;
        System.out.print("Nhập họ và tên nhân viên: ");
        String fullName = scanner.nextLine();
        System.out.print("Nhập ngày tháng năm sinh: ");
        String brithDay = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phoneNumbers = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        boolean checkCertificates = false;
        do {
            long idCertificates = System.currentTimeMillis()%100000000;
            System.out.print("Nhập tên chứng chỉ: ");
            String certificateName = scanner.nextLine();
            System.out.print("Nhập xếp loại: ");
            String certificateRank = scanner.nextLine();
            System.out.print("Nhập ngày cấp: ");
            String certificateDate = scanner.nextLine();
            //(employeeID, certificatedID, certificateName, certificateRank, certificatedDate)
            Certificates certificates = new Certificates(idEmployee,idCertificates,certificateName,certificateRank,certificateDate);
            certificatesServices.addCertificates(certificates);
            System.out.println("Đã cập nhật thông tin thành công!");
            boolean checkChoices = false;
            do {
                System.out.println("Bạn có muốn nhập tiếp tục?");
                System.out.println("1.Yes.");
                System.out.println("2.No.");
                System.out.print(">Nhập chức năng: ");
                int choices = Integer.parseInt(scanner.nextLine());
                switch (choices){
                    case 1:
                        checkCertificates = true;
                        break;
                    case 2:
                        checkCertificates = false;
                        break;
                    default:
                        System.out.println(">Chọn sai chức năng. Kiếm tra lại!");
                        checkChoices = true;
                        break;
                }
            }while (checkChoices);
        }while (checkCertificates);
        Instant atCreated = Instant.now();
        Instant atUpdated = Instant.now();
        //(long idEmployee, String fullName, String brithDay, String phoneNumbers, String email,
        //                            Instant atCreated, Instant atUpdated, EmployeeTypes employeeType)
        switch (employeeTypes){
            case INTERN:

                //(String majors, String semester, String universityName)
                System.out.println("Nhập trường đại học: ");
                String universityName = scanner.nextLine();
                System.out.println("Nhập chuyên ngành: ");
                String majors = scanner.nextLine();
                System.out.println("Nhập học kì đang học: ");
                String semester = scanner.nextLine();
                Intern newIntern = new Intern(idEmployee, fullName, brithDay, phoneNumbers, email, atCreated, atUpdated,
                        employeeTypes, majors, semester, universityName);
                employeeServices.addEmployee(newIntern);
                break;
            case FRESHER:
                //(String graduationDate, String graduationRank, String education)
                System.out.println("Nhập chuyên ngành: ");
                String education = scanner.nextLine();
                System.out.println("Nhập loại tốt nghiệp: ");
                String graduationRank = scanner.nextLine();
                System.out.println("Nhập ngày tốt nghiệp: ");
                String graduationDate = scanner.nextLine();
                Fresher newFresher = new Fresher(idEmployee, fullName,brithDay, phoneNumbers, email,atCreated, atUpdated,
                        employeeTypes, graduationDate, graduationRank, education);
                employeeServices.addEmployee(newFresher);
                break;
            case EXPERIENCE:
                //(float exYears, String skills)
                System.out.println("Nhập số năm kinh nghiệm: ");
                float exYears = Float.parseFloat(scanner.nextLine());
                System.out.println("Nhập kĩ năng: ");
                String skills = scanner.nextLine();
                Experience newExperience = new Experience(idEmployee, fullName, brithDay, phoneNumbers, email, atCreated, atUpdated,
                        employeeTypes, exYears, skills);
                employeeServices.addEmployee(newExperience);
                break;
        }
        System.out.println("Đã cập nhật thông tin thành công.");
    }
    public void showExperienceEmployees(){
        System.out.println(">Hiển thị danh sách nhân viên Experiences.");
        System.out.println();
        List<Experience> experienceList = employeeServices.employeesList();
        for (Employee employee : experienceList){
            if (employee.getEmployeeType().equals(EmployeeTypes.EXPERIENCE)){
                //System.out.println();
            }
        }
    }
}
