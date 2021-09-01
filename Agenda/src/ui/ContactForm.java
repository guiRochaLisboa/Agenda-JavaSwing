package ui;

import Business.ContactBusiness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private JPanel rootPanel;
    private JTextField textName;
    private JTextField textPhone;
    private JButton buttonSave;
    private JButton buttonCancel;
    private JTextField textField1;

    private ContactBusiness mContatcBusiness;

    public ContactForm(){

        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimension.width / 2 - getSize().width / 2,dimension.height / 2 - getSize().height / 2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mContatcBusiness = new ContactBusiness();

        setListener();
    }

    private void setListener(){

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {


                    String name = textName.getText();
                    String phone = textPhone.getText();

                    mContatcBusiness.save(name, phone);
                    new MainForm();
                    dispose();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(new JFrame(),ex.getMessage());
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm();
                dispose();
            }
        });
    }
}
