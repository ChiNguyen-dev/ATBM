package com.Tool.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Tool.model.GenerateKeyRSA;
import com.Tool.model.RSA;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class RSAView extends JFrame {

    private JPanel contentPane;
    private JTextField textField_lenghtKey;
    private JTextArea textArea_decrypt;
    private JButton bt_decrypt;
    private JTextArea textArea_encrypt;
    private JButton bt_encrypt;
    private JTextArea textArea_textPlain;
    private JButton btnNewButton;
    private JMenuBar menuBar;
    private JMenu menuMD5;
    private JMenu menuRSA;
    private JMenuItem mntmHashingString;
    private JMenuItem menuItem_hashingFile;
    private JMenuItem mntmRsa;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RSAView frame = new RSAView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public RSAView() {
        setBackground(new Color(192, 192, 192));
        setTitle("RSA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 499, 385);

        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(75, 154, 180));
        setJMenuBar(menuBar);

        menuMD5 = new JMenu("MD5");
        menuMD5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuMD5_actionPerformed(e);
            }
        });
        menuMD5.setFont(new Font("Times New Roman", Font.BOLD, 13));
        menuBar.add(menuMD5);

        mntmHashingString = new JMenuItem("Hashing String");
        mntmHashingString.setBackground(new Color(75, 154, 180));
        mntmHashingString.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_mntmHashingString_actionPerformed(e);
            }
        });
        mntmHashingString.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        menuMD5.add(mntmHashingString);

        menuItem_hashingFile = new JMenuItem("Hashing File");
        menuItem_hashingFile.setBackground(new Color(75, 154, 180));
        menuItem_hashingFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuItem_hashingFile_actionPerformed(e);
            }
        });
        menuItem_hashingFile.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        menuMD5.add(menuItem_hashingFile);

        menuRSA = new JMenu("RSA");
        menuRSA.setFont(new Font("Times New Roman", Font.BOLD, 13));
        menuBar.add(menuRSA);

        mntmRsa = new JMenuItem("RSA");
        mntmRsa.setBackground(new Color(75, 154, 180));
        mntmRsa.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        menuRSA.add(mntmRsa);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnNewButton = new JButton("GenerateKey");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    do_btnNewButton_actionPerformed(e);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
        btnNewButton.setBounds(10, 39, 117, 21);
        contentPane.add(btnNewButton);

        JLabel lblLenghtKey = new JLabel("Lenght Key");
        lblLenghtKey.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblLenghtKey.setBounds(10, 10, 64, 19);
        contentPane.add(lblLenghtKey);

        textField_lenghtKey = new JTextField();
        textField_lenghtKey.setFont(new Font("Times New Roman", Font.BOLD, 13));
        textField_lenghtKey.setBounds(105, 10, 96, 19);
        contentPane.add(textField_lenghtKey);
        textField_lenghtKey.setColumns(10);

        JLabel lblTextplain = new JLabel("TextPlain");
        lblTextplain.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblTextplain.setBounds(10, 84, 64, 21);
        contentPane.add(lblTextplain);

        textArea_textPlain = new JTextArea();
        textArea_textPlain.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_textPlain.setBounds(105, 70, 370, 60);
        contentPane.add(textArea_textPlain);

        bt_encrypt = new JButton("Encrypt");
        bt_encrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    do_bt_encrypt_actionPerformed(e);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        bt_encrypt.setFont(new Font("Times New Roman", Font.BOLD, 13));
        bt_encrypt.setBounds(10, 136, 85, 21);
        contentPane.add(bt_encrypt);

        textArea_encrypt = new JTextArea();
        textArea_encrypt.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_encrypt.setBounds(105, 162, 370, 60);
        contentPane.add(textArea_encrypt);

        textArea_decrypt = new JTextArea();
        textArea_decrypt.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_decrypt.setBounds(105, 249, 370, 60);
        contentPane.add(textArea_decrypt);

        bt_decrypt = new JButton("Decrypt");
        bt_decrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    do_bt_decrypt_actionPerformed(e);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        bt_decrypt.setFont(new Font("Times New Roman", Font.BOLD, 13));
        bt_decrypt.setBounds(10, 229, 85, 21);
        contentPane.add(bt_decrypt);
    }

    protected void do_btnNewButton_actionPerformed(ActionEvent e) throws Exception {
        int lenght = Integer.parseInt(textField_lenghtKey.getText());
        new GenerateKeyRSA(lenght).generateKeyToFile();
    }

    protected void do_bt_encrypt_actionPerformed(ActionEvent e) throws Exception {
        RSA rsa = new RSA();
        String textPlain = textArea_textPlain.getText();
        String textEncrypted = rsa.encrypt(textPlain);
        textArea_encrypt.setText(textEncrypted);
    }

    protected void do_bt_decrypt_actionPerformed(ActionEvent e) throws Exception {
        RSA rsa = new RSA();
        String textEncrypted = textArea_encrypt.getText();
        String textDecrypted = rsa.decrypt(textEncrypted);
        textArea_decrypt.setText(textDecrypted);
    }
    protected void do_menuMD5_actionPerformed(ActionEvent e) {
        MD5ViewHashingString md5HashStr = new MD5ViewHashingString();
        md5HashStr.setVisible(true);
        this.setVisible(false);
    }
    protected void do_mntmHashingString_actionPerformed(ActionEvent e) {
        MD5ViewHashingString md5HashStr = new MD5ViewHashingString();
        md5HashStr.setVisible(true);
        this.setVisible(false);
    }
    protected void do_menuItem_hashingFile_actionPerformed(ActionEvent e) {
        MD5ViewHashingFile md5HashFile = new MD5ViewHashingFile();
        md5HashFile.setVisible(true);
        this.setVisible(false);
    }
}
