import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIpart1 extends JFrame implements ActionListener {
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;

    private JTable doctorTable;
    private WestminsterSkinConsultationManager west;
    private Supporter controller;

    public GUIpart1(WestminsterSkinConsultationManager west) {
        this.controller = new Supporter(west.getDocList());
        this.west = west;

        controller.loadFile();

        this.setSize(1000,800);
        this.getContentPane().setLayout(null);

        doctorTable = new JTable(west.getTable());
        JScrollPane doctorTableScrollPane = new JScrollPane(doctorTable);
        doctorTableScrollPane.setBounds(30,20,600,550);

        button_1 = new JButton("Sort Table");
        button_1.setBounds(750,200,190,50);
        button_1.setBackground(Color.black);
        button_1.setForeground(Color.white);
        button_1.setFont(new Font("sansSerif",Font.BOLD,16));

        button_2 = new JButton("Add Consultation");
        button_2.setBounds(750,280,190,50);
        button_2.setBackground(Color.black);
        button_2.setForeground(Color.white);
        button_2.setFont(new Font("sansSerif",Font.BOLD,16));

        button_3 = new JButton("Review Consultation");
        button_3.setBounds(750,360,190,50);
        button_3.setBackground(Color.black);
        button_3.setForeground(Color.white);
        button_3.setFont(new Font("sansSerif",Font.BOLD,16));

        button_4 = new JButton("Save Data");
        button_4.setBounds(750,440,190,50);
        button_4.setBackground(Color.black);
        button_4.setForeground(Color.white);
        button_4.setFont(new Font("sansSerif",Font.BOLD,16));



        button_1.addActionListener(this);
        button_2.addActionListener(this);
        button_3.addActionListener(this);
        button_4.addActionListener(this);

        this.add(doctorTableScrollPane);
        this.add(button_1);
        this.add(button_2);
        this.add(button_3);
        this.add(button_4);
        this.setTitle("Westminster Skin Care Center");
        this.setBackground(Color.black);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button_2){
            new GUIpart2(this.west,this.controller);
        }

        if(e.getSource() == button_3){
            new GUIpart3(this.controller);
        }

        if(e.getSource() == button_4){
            controller.saveToFile();
        }

        if(e.getSource() == button_1){

            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(doctorTable.getModel());
            doctorTable.setRowSorter(sorter);

            ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));//set column 1 as sort key and ascending order
            sorter.setSortKeys(sortKeys);
            doctorTable.repaint();//refresh the table after sorting
            JOptionPane.showMessageDialog(null, "Successfully sorted the doctors table according to their names", "westminster",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
