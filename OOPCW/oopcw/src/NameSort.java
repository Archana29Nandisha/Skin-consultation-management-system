import javax.print.Doc;
import java.util.Comparator;

public class NameSort implements Comparator<Doctor> {
    public int compare(Doctor doc1, Doctor doc2){
        return doc1.getSurName().compareTo(doc2.getSurName());
    }
}
