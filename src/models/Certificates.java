package models;

import utils.DateUtils;

import java.util.Date;

public class Certificates {
    private long certificatedID;
    private long employeeID;
    private String certificateName;
    private String certificateRank;
    private String certificatedDate;

    public Certificates(){}

    public Certificates(long employeeID, long certificatedID,
                        String certificateName, String certificateRank, String certificatedDate){
        this.employeeID = employeeID;
        this.certificatedID = certificatedID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificatedDate = certificatedDate;
    }
    public static Certificates parseCertificates(String certificatesLine){
        String[] fields = certificatesLine.split(",");
        //(int employeeID, long certificatedID,
        //                        String certificateName, String certificateRank, String certificatedDate)
        long employeeID = Long.parseLong(fields[0]);
        long certificatedID = Long.parseLong(fields[1]);
        String certificateName = fields[2];
        String certificateRank = fields[3];
        String certificatedDate = fields[4];
        Certificates certificates = new Certificates(employeeID, certificatedID, certificateName, certificateRank, certificatedDate);
        return certificates;
    }

    public long getCertificatedID() {
        return certificatedID;
    }

    public void setCertificatedID(long certificatedID) {
        this.certificatedID = certificatedID;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public String getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        this.certificatedDate = certificatedDate;
    }
    public String toString(){
        //int employeeID, long certificatedID,
        //                        String certificateName, String certificateRank, Date certificatedDate
        return employeeID + "," +
                certificatedID + "," +
                certificateName + "," +
                certificateRank + "," +
                certificatedDate;
    }
}
