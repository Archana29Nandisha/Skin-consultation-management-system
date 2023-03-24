import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class WestminsterSkinConsultationManager implements SkinConsultationManager {

    ArrayList<Doctor> doctorObject = new ArrayList<>();

    public void saveFile() {
        try {
            File f1 = new File("archana.txt");
            f1.createNewFile();

            FileOutputStream fos = new FileOutputStream(f1);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Doctor d : doctorObject){
                oos.writeObject(d);
            }

            oos.close();
            fos.close();
        } catch (IOException e) {

        }

    }

    public void readData() {
        try {
            FileInputStream fis = new FileInputStream("archana.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            boolean eof = true;
            while (eof){
                try{
                    Doctor doc = (Doctor) ois.readObject();
                    doctorObject.add(doc);
                }catch (EOFException e){
                    eof = false;
                }

            }


        } catch (ClassNotFoundException | IOException e) {

        }

    }

    public void sort() {
        Collections.sort(doctorObject, new NameSort());

        for (Doctor doc : doctorObject) {
            System.out.println("Doctor " + (doctorObject.indexOf(doc) + 1));
            System.out.println();
            System.out.println("Name : " + doc.getName());
            System.out.println("Surname :" + doc.getSurName());
            System.out.println("Medical Licence Number : " + doc.getLicenceNumber());
            System.out.println("Mobile Number : " + doc.getMobileNumber());
            System.out.println("Specialisation : " + doc.getSpecialisation());
            System.out.println();
        }

    }

    public void delete() {
        boolean flag = checkSizeDelete();
        if (flag) {
            getMedicalNumber();
            System.out.println("Available doctors : " + doctorObject.size());
        }
    }

    public void getMedicalNumber() {
        int medicalNumber = fixErrorMedicalNumber();
        for (Doctor doc : doctorObject) {
            if (doc.getLicenceNumber() == medicalNumber) {
                doctorObject.remove(doc);
                System.out.println(doc.getName());
                System.out.println(doc.getSurName());
                System.out.println(doc.getLicenceNumber());
                System.out.println(doc.getMobileNumber());
                System.out.println(doc.getSpecialisation());
                System.out.println("Deleted successfully");
                return;
            }
        }

    }

    public boolean checkSizeDelete() {
        if (doctorObject.size() == 0) {
            System.out.println("Can't delete.Doctor list is empty");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkSizeAdd() {
        if (doctorObject.size() == 10) {
            System.out.println("Can't Add");
            return false;
        } else {
            return true;
        }
    }

    public void addDoctor() {
        boolean flag = checkSizeAdd();
        if (flag) {
            doctorObject.add(getInput());
        }
    }

    public Doctor getInput() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the Name : ");
        String name = scn.nextLine();
        System.out.println("Enter the Surname : ");
        String surname = scn.nextLine();
        int medicalNumber = fixErrorMedicalNumber();
        System.out.println("Enter the specialisation : ");
        String specialisation = scn.nextLine();
        System.out.println("Enter the date of birth : ");
        String date = scn.nextLine();
        int mobileNumber = fixErrorMobileNumber();
        Doctor dr = new Doctor(name, surname, date, mobileNumber, medicalNumber, specialisation);
        return dr;
    }

    public int fixErrorMedicalNumber() {
        while (true) {
            try {
                Scanner scn1 = new Scanner(System.in);
                System.out.println("Enter medical licence number : ");
                int medicalNumber = scn1.nextInt();
                return medicalNumber;
            } catch (Exception e) {
                System.out.println("Enter the valid input :(");
            }
        }
    }


    public int fixErrorMobileNumber() {
        while (true) {
            try {
                System.out.println("Enter the Mobile Number : ");
                Scanner scn1 = new Scanner(System.in);
                int mobile = scn1.nextInt();
                return mobile;
            } catch (Exception e) {
                System.out.println("Enter the valid input :(");
            }
        }
    }

    public DefaultTableModel getTable(){
        Object [][] tableValues = new Object[doctorObject.size()][4];

        for(int i = 0; i < doctorObject.size(); i++){
            tableValues[i][0] = doctorObject.get(i).getName() + " " + doctorObject.get(i).getSurName();
            tableValues[i][1] = doctorObject.get(i).getLicenceNumber();
            tableValues[i][2] = doctorObject.get(i).getSpecialisation();
            tableValues[i][3] = doctorObject.get(i).getMobileNumber();
        }

        Object [] columns = new Object[]{"Name","Licence Number", "Specialization", "MobileNumber"};

        return new DefaultTableModel(tableValues,columns);
    }

    public String [] getDoctorArrString(){
        String [] doctorArrString = new String[doctorObject.size()];

        int i = 0;
        for (Doctor d : doctorObject){
            doctorArrString[i] = doctorObject.get(i).getName() + "-" + doctorObject.get(i).getLicenceNumber();
            i++;
        }

        return doctorArrString;
    }

    public Doctor getDoctor(int id){
        for(Doctor d : doctorObject){
            if(d.getLicenceNumber() == id)return d;
        }
        return null;
    }

    public ArrayList<Doctor> getDocList() {
        return this.doctorObject;
    }
}





