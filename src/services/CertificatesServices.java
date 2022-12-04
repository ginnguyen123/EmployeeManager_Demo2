package services;

import models.Certificates;
import models.Employee;
import utils.IOFileUtils;

import java.util.ArrayList;
import java.util.List;

    public class CertificatesServices {
        private String pathCertificates = "datas/certificates.csv";
        private static CertificatesServices instance;
        public CertificatesServices(){}
        public static CertificatesServices getInstance(){
            if (instance == null){
                instance = new CertificatesServices();
            }
            return instance;
        }
        public List<Certificates> certificatesList(){
            List<Certificates> certificatesList = new ArrayList<>();
            List<String> stringsCertificatesList = IOFileUtils.readFile(pathCertificates);
            for (String stringsCertificates : stringsCertificatesList){
                certificatesList.add(Certificates.parseCertificates(stringsCertificates));
            }
            return certificatesList;
        }
        public List<Certificates> certificatesListByIDEmployee(long idEmployee){
            List<Certificates> certificatesList = certificatesList();
            List<Certificates> certificatesListByIDEmployee = new ArrayList<>();
            for (Certificates certificates : certificatesList){
                if (certificates.getEmployeeID() == idEmployee){
                    certificatesListByIDEmployee.add(certificates);
                }
            }
            return certificatesListByIDEmployee;
        }
        public void addCertificates(Certificates certificates){
            List<Certificates> certificatesList = certificatesList();
            certificatesList.add(certificates);
            IOFileUtils.writeFile(certificatesList,pathCertificates);
        }
        public void editCertificates(Certificates newCertificates){
            List<Certificates> certificatesList = certificatesList();
            for (Certificates certificates : certificatesList){
                if (certificates.getCertificatedID() == newCertificates.getCertificatedID()){
                    //(long employeeID, long certificatedID,
                    //                        String certificateName, String certificateRank, String certificatedDate)
                    String certificateName = newCertificates.getCertificateName();
                    if (certificateName!=null && !certificateName.isEmpty()){
                        certificates.setCertificateName(certificateName);
                    }
                    String certificateRank = newCertificates.getCertificateRank();
                    if (certificateRank!=null && !certificateRank.isEmpty())
                        certificates.setCertificateRank(certificateRank);
                    String certificatedDate = newCertificates.getCertificatedDate();
                    if (certificatedDate!=null && !certificatedDate.isEmpty())
                        certificates.setCertificatedDate(certificatedDate);
                }
            }
        }
        public void removeCertificates(long idCertificates){
            List<Certificates> certificatesList = certificatesList();
            for (Certificates certificates : certificatesList){
                if (certificates.getCertificatedID() == idCertificates){
                    certificatesList.remove(certificates);
                    break;
                }
            }
            IOFileUtils.writeFile(certificatesList,pathCertificates);
        }
}
