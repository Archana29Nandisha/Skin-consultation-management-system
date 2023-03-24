import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

public class GUIpart2 extends JFrame implements ActionListener {
    private JTextField name_F1;

    private JTextField name_F2;
    private JTextField name_F3;
    private JTextField name_F4;
    private JTextField name_F5;
    private JTextField name_F6;
    private JTextField name_F7;
    private JTextField name_F8;
    private JTextField name_F9;
    private JTextArea name_F10;


    private JButton button_5;
    private JButton button_6;
    private JButton button_7;
    ImageIcon image;

    private JComboBox doctorsDropDown;

    private WestminsterSkinConsultationManager west;
    private Supporter controller;

    public GUIpart2(WestminsterSkinConsultationManager west, Supporter controller){

        this.west = west;
        this.controller = controller;

        //labels and text fields

        //add doctor
        JLabel name_1 = new JLabel("Add a doctor:");
        name_1.setFont(new Font("Times new roman",Font.BOLD,16));
        name_1.setBounds(70,10,250,30);

        name_F1= new JTextField();

        doctorsDropDown = new JComboBox<>(west.getDoctorArrString());
        doctorsDropDown.setBounds(340,15,300,30);

        //consultation date
        JLabel name_2 = new JLabel("Enter consultation date:");
        name_2.setFont(new Font("Times new roman",Font.BOLD,16));
        name_2.setBounds(70,50,250,30);

        name_F2= new JTextField();
        name_F2.setBounds(340,55,200,30);

        //consultation time
        JLabel name_3 = new JLabel("Enter consultation time :");
        name_3.setFont(new Font("Times new roman",Font.BOLD,16));
        name_3.setBounds(70,90,250,30);

        name_F3= new JTextField();
        name_F3.setBounds(340,95,200,30);

        //number of hours
        JLabel name_4 = new JLabel("Enter number of hours :");
        name_4.setFont(new Font("Times new roman",Font.BOLD,16));
        name_4.setBounds(70,130,250,30);

        name_F4= new JTextField();
        name_F4.setBounds(340,135,200,30);

        //patient's name
        JLabel name_5 = new JLabel("Enter patient's name :");
        name_5.setFont(new Font("Times new roman",Font.BOLD,16));
        name_5.setBounds(70,230,150,30);

        name_F5= new JTextField();
        name_F5.setBounds(340,230,400,30);

        //patient's surname
        JLabel name_6 = new JLabel("Enter patient's Surname :");
        name_6.setFont(new Font("Times new roman",Font.BOLD,16));
        name_6.setBounds(70,270,250,30);

        name_F6= new JTextField();
        name_F6.setBounds(340,270,400,30);

        //patient's DOB
        JLabel name_7 = new JLabel("Enter patient's DOB :");
        name_7.setFont(new Font("Times new roman",Font.BOLD,16));
        name_7.setBounds(70,310,180,30);

        name_F7 = new JTextField();
        name_F7.setBounds(340,310,180,30);

        //patient's mobile number
        JLabel name_8 = new JLabel("Enter patient's Mobile number :");
        name_8.setFont(new Font("Times new roman",Font.BOLD,16));
        name_8.setBounds(70,350,250,30);

        name_F8 = new JTextField();
        name_F8.setBounds(340,350,180,30);

        //patient's ID
        JLabel name_9 = new JLabel("Enter patient's ID :");
        name_9.setFont(new Font("Times new roman",Font.BOLD,16));
        name_9.setBounds(70,390,250,30);

        name_F9 = new JTextField();
        name_F9.setBounds(340,390,180,30);

        //add notes
        JLabel name_10 = new JLabel("Add notes  :");
        name_10.setFont(new Font("Times new roman",Font.BOLD,16));
        name_10.setBounds(70,430,250,30);

        name_F10 = new JTextArea();
        name_F10.setBounds(340,430,350,100);

        //add image
        JLabel name_11 = new JLabel("Add image  :");
        name_11.setFont(new Font("Times new roman",Font.BOLD,16));
        name_11.setBounds(70,540,250,30);


        // buttons



        //add consultation
        button_5 = new JButton("Add consultation");
        button_5.setBounds(620,580,200,25);
        button_5.setBackground(Color.black);
        button_5.setForeground(Color.white);
        button_5.setFont(new Font("sansSerif",Font.BOLD,14));
        button_5.addActionListener(this);

        //check availability
        button_6 = new JButton("Check availability");
        button_6.setBounds(620,180,200,25);
        button_6.setBackground(Color.black);
        button_6.setForeground(Color.white);
        button_6.setFont(new Font("sansSerif",Font.BOLD,14));

        //add image
        button_7 = new JButton("Add Image");
        button_7.setBounds(340,540,200,30);
        button_7.setBackground(Color.lightGray);
        button_7.setForeground(Color.black);
        button_7.setFont(new Font("sansSerif",Font.BOLD,14));
        button_7.addActionListener(this);



        this.add(name_1);
        this.add(name_2);
        this.add(name_3);
        this.add(name_4);
        this.add(name_5);
        this.add(name_6);
        this.add(name_7);
        this.add(name_8);
        this.add(name_9);
        this.add(name_10);
        this.add(name_11);

        this.add(name_F1);
        this.add(name_F2);
        this.add(name_F3);
        this.add(name_F4);
        this.add(name_F9);
        this.add(name_F5);
        this.add(name_F6);
        this.add(name_F7);
        this.add(name_F8);
        this.add(name_F10);


        this.add(button_5);
        this.add(button_6);
        this.add(button_7);
        this.add(doctorsDropDown);


        this.setTitle("Westminster Skin Care Center");
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        String path;
        File selectedFile;

        if(e.getSource() == button_5){

            //consultation date
            String [] conDate = name_F2.getText().split("\\.");
            LocalDate lConsultationDate = LocalDate.of(Integer.parseInt(conDate[0]),Integer.parseInt(conDate[1]),Integer.parseInt(conDate[2]));

            String [] timeL = name_F3.getText().split("\\.");
            LocalTime lLocalTime = LocalTime.of(Integer.parseInt(timeL[0]), Integer.parseInt(timeL[1]));

            //Get the selected doctor
            int idOfSelectedDoctor = Integer.parseInt(doctorsDropDown.getSelectedItem().toString().split("-")[1]);
            Doctor tempDoctor = west.getDoctor(idOfSelectedDoctor);

            Patient tempPatient = new Patient(name_F5.getText(),name_F6.getText(),name_F7.getText(),Integer.parseInt(name_F8.getText()),name_F9.getText());

            int id = controller.addConsultation(tempDoctor,tempPatient,name_F10.getText(),lLocalTime,Integer.parseInt(name_F4.getText()),lConsultationDate,image);

            if(id< 0 ){
                JOptionPane.showMessageDialog(null, "No doctors available to add", "westminster",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Successfully added your id is : " + id, "westminster",JOptionPane.INFORMATION_MESSAGE);
            }
        }


        if(e.getSource() == button_7){

            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("user.home"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","jpg","gif","png");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);

            if(result == JFileChooser.APPROVE_OPTION){
                selectedFile = file.getSelectedFile();
                path = selectedFile.getAbsolutePath();
                image = resizeImage(path);

            } else if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("None selected");
            }
        }


    }
    private ImageIcon resizeImage(String imagePath){
        ImageIcon MyImage = new ImageIcon(imagePath);
        Image image = MyImage.getImage();
        Image newImage = image.getScaledInstance(450,400, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }
}