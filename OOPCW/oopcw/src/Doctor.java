import java.io.Serializable;

public class Doctor extends Person implements Serializable{
    private int licenceNumber;
    private String specialisation;

    public Doctor(String name, String surname, String dateOfBirth, int mobile_number, int licenceNumber, String specialisation) {
        super(name, surname, dateOfBirth, mobile_number);
        this.licenceNumber = licenceNumber;
        this.specialisation = specialisation;
    }

    public int getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(int licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
