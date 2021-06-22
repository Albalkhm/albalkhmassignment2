package Sheridan.albalkhm.assigment2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class DeleteRecords
{
    private JFrame frame;
    private JTextField petNameField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteRecords window = new DeleteRecords();
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
    public DeleteRecords() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
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
        chckbxNewCheckBox.setBounds(101, 202, 129, 23);
        frame.getContentPane().add(chckbxNewCheckBox);

        petNameField = new JTextField();
        petNameField.setBounds(97, 84, 86, 20);
        frame.getContentPane().add(petNameField);
        petNameField.setColumns(10);

        JButton Delete = new JButton("Delete Entry");
        Delete.setBounds(321, 202, 103, 23);
        frame.getContentPane().add(Delete);

        JButton MainPage = new JButton("Main Page");
        MainPage.setBounds(10, 11, 103, 23);
        frame.getContentPane().add(MainPage);
        MainPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new PetSystem();

            }
        });

        JButton btnViewRecords = new JButton("View Records");
        btnViewRecords.setBounds(321, 11, 103, 23);
        frame.getContentPane().add(btnViewRecords);
        btnViewRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Records();

            }
        });

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("src\\img.jpeg"));
        lblNewLabel.setBounds(0, 0, 434, 261);
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
    }
}