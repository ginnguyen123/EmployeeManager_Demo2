package models;

public enum EmployeeTypes {
    EXPERIENCE(1),
    FRESHER(2),
    INTERN(3);
    //(number: 0 || 1 || 2) là giá trị(value) number truyền vào, lấy ra theo phương thức .values
    private int value;

    // Modifier của constructor enum luôn là private
    // Nếu không khai báo private, java cũng sẽ hiểu là private.
    // constructor này chỉ dùng trong nội bộ Enum
    EmployeeTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    //viết một static method lấy ra WeekDay theo value.
    public static EmployeeTypes getEmplyeeType(int value) {
        for (EmployeeTypes employeeType : EmployeeTypes.values()) {
            if (employeeType.value == value) {
                return employeeType;
            }
        }
        return null;
    }
}
