package Sheridan.albalkhm.assigment2;

import com.mysql.jdbc.Statement;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PetSystem
{
    private static String driver = "com.mysql.jdbc.Driver";
    private static String connection = "jdbc:mysql://localhost:3306/jdbc?useSSL=false"; //'milon' is your database name
    private static String user = "root";                  //'root' is username
    private static String password = "root";        //'pass' is password


    private static Connection con = null;
    private static Statement state = null;
    private static ResultSet result;
    private static PreparedStatement pstate;
    private JFrame frame;
    private JTextField petNameField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PetSystem window = new PetSystem();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public PetSystem() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 508, 344);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Welcome to Pet System");
        lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        lblNewLabel.setBounds(50, 31, 337, 20);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Pet Name:");
        lblNewLabel_1.setForeground(SystemColor.textHighlight);
        lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(24, 86, 79, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Pet Kind");
        lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
        lblNewLabel_1_1.setBounds(24, 128, 79, 14);
        frame.getContentPane().add(lblNewLabel_1_1);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dog", "Cat", "Rabbit"}));
        comboBox.setBounds(77, 125, 74, 22);
        frame.getContentPane().add(comboBox);

        JLabel lblNewLabel_1_1_1 = new JLabel("Pet Gender");
        lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
        lblNewLabel_1_1_1.setBounds(24, 167, 79, 14);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Female");
        rdbtnNewRadioButton.setSelected(true);
        rdbtnNewRadioButton.setBounds(97, 164, 74, 23);
        frame.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton rdbtnMale = new JRadioButton("Male");
        rdbtnMale.setBounds(189, 164, 74, 23);
        frame.getContentPane().add(rdbtnMale);

        ButtonGroup bg = new ButtonGroup();

        bg.add(rdbtnNewRadioButton);
        bg.add(rdbtnMale);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Vaccination");
        lblNewLabel_1_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
        lblNewLabel_1_1_1_1.setBounds(24, 205, 79, 14);
        frame.getContentPane().add(lblNewLabel_1_1_1_1);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Is Vaccinated?");
        chckbxNewCheckBox.setBounds(101, 202, 97, 23);
        frame.getContentPane().add(chckbxNewCheckBox);

        petNameField = new JTextField();
        petNameField.setBounds(97, 84, 86, 20);
        frame.getContentPane().add(petNameField);
        petNameField.setColumns(10);

        JButton Enter = new JButton("Insert");
        Enter.setBackground(Color.PINK);
        Enter.setForeground(Color.BLACK);
        Enter.setBounds(24, 250, 89, 23);
        frame.getContentPane().add(Enter);

        Enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Class.forName(driver);
                    con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false", "root", "root");

                    pstate =  con.prepareStatement("insert into PET(pet_name, pet_kind, pet_gender, vaccinated)"+
                            "values(?,?,?,?)");

                    if(petNameField.getText().equals(""))
                        throw new RuntimeException("Kindly Enter Pet name Field");

                    pstate.setString(1, petNameField.getText());
                    pstate.setString(2, comboBox.getSelectedItem().toString());
                    pstate.setString(3, rdbtnNewRadioButton.getText());
                    pstate.setBoolean(4,chckbxNewCheckBox.isSelected() ?true:false );
                    int value = pstate.executeUpdate();
                    con.close();

                }
                catch(Exception e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,e1.getMessage());
                }

            }
        });

        JButton ViewRecord = new JButton("Records");
        ViewRecord.setBounds(323, 86, 136, 23);
        frame.getContentPane().add(ViewRecord);
        ViewRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Records();
            }
        });

        JButton DeleteRecords = new JButton("Delete Records");
        DeleteRecords.setBounds(323, 185, 136, 23);
        frame.getContentPane().add(DeleteRecords);

        DeleteRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new DeleteRecords();
            }
        });

        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon("src\\img.jpeg"));
        lblNewLabel_2.setBounds(0, 0, 490, 303);
        frame.getContentPane().add(lblNewLabel_2);
        frame.setVisible(true);
    }
}