import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIpart3 extends JFrame implements ActionListener {

    private JButton button_8 ;
    private JButton button_9;
    private JTextField field;

    private JLabel consultationID_L;
    private JLabel patientName_L;
    private JLabel doctorName_L;
    private JLabel date_L;
    private JLabel time_L;
    private JLabel noOfHours_L;
    private JLabel cost_L;
    private JLabel notes_L;
    private JLabel image_L;
    private Supporter controller;
    public GUIpart3(Supporter controller){

        this.controller = controller;

        this.setSize(900,760);
        this.getContentPane().setLayout(null);

        //entering consultation id
        JLabel label = new JLabel("Enter consultation ID :");
        label.setFont(new Font("Times new roman",Font.BOLD,16));
        label.setBounds(20,20,250,25);

        field = new JTextField();
        field.setBounds(185,20,150,30);

        //check
        button_8 = new JButton("Check");
        button_8.setBounds(300,70,120,23);
        button_8.setBackground(Color.black);
        button_8.setForeground(Color.white);
        button_8.setFont(new Font("sansSerif",Font.BOLD,14));

        //back
        button_9 = new JButton("Go Back");
        button_9.setBounds(300,110,120,23);
        button_9.setBackground(Color.black);
        button_9.setForeground(Color.white);
        button_9.setFont(new Font("sansSerif",Font.BOLD,14));

        button_8.addActionListener(this);
        button_9.addActionListener(this);

        image_L = new JLabel();
        consultationID_L = new JLabel();
        patientName_L = new JLabel();
        doctorName_L = new JLabel();
        date_L = new JLabel();
        time_L = new JLabel();
        noOfHours_L = new JLabel();
        cost_L = new JLabel();
        notes_L = new JLabel();

        JPanel reviewData = new JPanel(new GridLayout(10,1,0,2));
        reviewData.setBounds(160,200,600,500);

        reviewData.add(image_L);
        reviewData.add(consultationID_L);
        reviewData.add(patientName_L);
        reviewData.add(doctorName_L);
        reviewData.add(date_L);
        reviewData.add(time_L);
        reviewData.add(noOfHours_L);
        reviewData.add(cost_L);
        reviewData.add(notes_L);

        this.add(label);
        this.add(field);
        this.add(button_8);
        this.add(button_9);
        this.add(reviewData);

        this.setTitle("Westminster Skin Care Center");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button_8){
            Consultation consultation = controller.getConsultation(Integer.parseInt(field.getText()));
            if (consultation != null) {
                String[] consultationInformation = consultation.toStringArray();

                try {
                    image_L.setIcon(consultation.getImage());
                }
                catch (Exception r){
                    image_L.setText("None selected");
                }
                image_L.setIcon(consultation.getImage());
                consultationID_L.setText(consultationInformation[0]);
                patientName_L.setText(consultationInformation[1]);
                doctorName_L.setText(consultationInformation[2]);
                date_L.setText(consultationInformation[3]);
                time_L.setText(consultationInformation[4]);
                noOfHours_L.setText(consultationInformation[5]);
                cost_L.setText(consultationInformation[6]);
                notes_L.setText(consultationInformation[7]);
            }
            else {
                System.out.println("Invalid ID.Please enter a valid ID");
            }
        }
    }

}
