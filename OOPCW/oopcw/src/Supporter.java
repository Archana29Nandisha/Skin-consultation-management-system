import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Supporter {

    List <Consultation> consultations = new ArrayList<>();
    ArrayList<Doctor> doctors;
    private static int id = 10000;
    public Supporter(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    //add consultation
    public int addConsultation(Doctor doctor, Patient patient, String notes, LocalTime consulTime, int noOfHours, LocalDate consulDate, ImageIcon image){

        double cost;

        if(isPatientFirstTime(patient.getPatientID())){
            cost = noOfHours * 25;
        }
        else {
            cost = noOfHours * 15;
        }

        if(isAvailable(consulDate, consulTime, noOfHours,doctor.getLicenceNumber())){
            Consultation c = new Consultation(consulDate, consulTime, noOfHours, cost, notes, image, doctor, patient);
            consultations.add(c);
            return c.getId();
        }
        else {
            for(Doctor d : doctors){
                if(isAvailable(consulDate, consulTime, noOfHours,d.getLicenceNumber())){
                    Consultation c = new Consultation(consulDate, consulTime, noOfHours, cost, notes, image, d, patient);
                    consultations.add(c);
                    return c.getId();
                }
            }
        }

        return -1;
    }

    public boolean isPatientFirstTime(String patientID){
        for(Consultation c: consultations){
            if (c.getPatient().getPatientID().equals(patientID)) {
               return true;
            }
            else {
                return false;
            }
        }
        return false;
    }


    public Consultation getConsultation(int consultId) {
        for (Consultation c : consultations) {
            if (c.getConsultationId() == consultId) {
                return c;
            }
        }
        return null;
        //for(consultaion C :consultation){
        //if(c.getConsultationID
    }
    //save to file
    public void saveToFile() {
        try  {
            FileOutputStream fos = new FileOutputStream("cons.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Consultation c : consultations){
                oos.writeObject(c);
            }
            oos.close();
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
    }
    //available
    public boolean isAvailable(LocalDate consultationDate, LocalTime consultationTime, int noOfHours, int doctorLicenceNumber){

        for (Consultation consultation : consultations){
            if(consultation.getDocLi() == doctorLicenceNumber){
                boolean dateCheck = consultationDate.equals(consultation.getDate());

                //old consultation start time
                LocalTime time1 = consultation.getTime();
                //old consultation end time
                LocalTime time2 = consultation.getTime().plusHours(consultation.getNoOfHours());
                //new consultation start time
                LocalTime time3 = consultationTime;
                //new consultation end time
                LocalTime time4 = consultationTime.plusHours(noOfHours);
                boolean tc_1 = ( time3.isAfter(time1) ) && ( time3.isBefore(time2) );
                boolean tc_2 = ( time4.isAfter(time1) ) && ( time4.isBefore(time2) );
                boolean tc_3 = ( time3.isBefore(time1) && (time4.isAfter(time2)) );
                boolean tc_4 = (time3.equals(time1) || time3.equals(time2) || time4.equals(time1) || time4.equals(time2));
                if( (dateCheck) && ( (tc_1) || (tc_2) || (tc_3) || (tc_4) ) ){
                    return false;
                }
            }
        }
        return true;
    }
    //load file
    public int loadFile() {
        try  {
            FileInputStream fos = new FileInputStream("cons.dat");
            ObjectInputStream oos = new ObjectInputStream(fos);
            boolean eof = false;
            int idCounter=100;
            while (!eof){
                try {
                    Consultation c = (Consultation) oos.readObject();
                    consultations.add(c);
                    idCounter++;
                }catch (EOFException e){
                    eof = true;
                }
                //consultation.setcounter(id)
            }
            Consultation.setCounter(idCounter);
            oos.close();
            return 1;
        } catch (ClassNotFoundException | IOException e) {
            return -1;
        }
    }

}


