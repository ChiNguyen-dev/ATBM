package com.Tool.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Tool.model.MD5;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MD5ViewHashingFile extends JFrame {

    private JPanel contentPane;
    private JTextArea textArea_Url;
    private JButton bt_OpenFile;
    private JTextArea textArea_Ketqua;
    private JButton bt_Genergate;
    private JMenuBar menuBar;
    private JMenu menuMD5;
    private JMenuItem mntmHashingString;
    private JMenuItem mntmHashingfile;
    private JMenu menuRSA;
    private JMenuItem mntmRsa;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MD5ViewHashingFile frame = new MD5ViewHashingFile();
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
    public MD5ViewHashingFile() {
        setBackground(new Color(192, 192, 192));
        setTitle("MD5-Hashing File");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 499, 371);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(10, 42, 461, 282);
        contentPane.add(panel);
        panel.setLayout(null);

        textArea_Url = new JTextArea();
        textArea_Url.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_Url.setBounds(152, 10, 299, 66);
        panel.add(textArea_Url);

        bt_Genergate = new JButton("GENERGATE >>");
        bt_Genergate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_bt_Genergate_actionPerformed(e);
            }
        });
        bt_Genergate.setForeground(new Color(98, 157, 109));
        bt_Genergate.setFont(new Font("Times New Roman", Font.BOLD, 14));
        bt_Genergate.setBounds(37, 112, 141, 23);
        panel.add(bt_Genergate);

        JLabel label_Ketqua = new JLabel("KẾT QUẢ");
        label_Ketqua.setFont(new Font("Times New Roman", Font.BOLD, 13));
        label_Ketqua.setBounds(37, 159, 84, 23);
        panel.add(label_Ketqua);

        textArea_Ketqua = new JTextArea();
        textArea_Ketqua.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_Ketqua.setBounds(152, 160, 299, 100);
        panel.add(textArea_Ketqua);

        bt_OpenFile = new JButton("OPEN FILE");
        bt_OpenFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_bt_OpenFile_actionPerformed(e);
            }
        });
        bt_OpenFile.setFont(new Font("Times New Roman", Font.BOLD, 13));
        bt_OpenFile.setBounds(37, 29, 105, 21);
        panel.add(bt_OpenFile);

        menuBar = new JMenuBar();
        menuBar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        menuBar.setBackground(new Color(75, 154, 180));
        menuBar.setBounds(0, 0, 485, 22);
        contentPane.add(menuBar);

        menuMD5 = new JMenu("MD5");
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

        mntmHashingfile = new JMenuItem("Hashing File");
        mntmHashingfile.setBackground(new Color(75, 154, 180));
        mntmHashingfile.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        menuMD5.add(mntmHashingfile);

        menuRSA = new JMenu("RSA");
        menuRSA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuRSA_actionPerformed(e);
            }
        });
        menuRSA.setFont(new Font("Times New Roman", Font.BOLD, 13));
        menuBar.add(menuRSA);

        mntmRsa = new JMenuItem("RSA");
        mntmRsa.setBackground(new Color(75, 154, 180));
        mntmRsa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_mntmRsa_actionPerformed(e);
            }
        });
        mntmRsa.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        menuRSA.add(mntmRsa);
    }
    protected void do_bt_OpenFile_actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int status = fileChooser.showOpenDialog(null);
        if(status == fileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            textArea_Url.setText(file.getAbsolutePath());
        }
    }
    protected void do_bt_Genergate_actionPerformed(ActionEvent e) {
        MD5 md5 = new MD5();
        File file = new File(textArea_Url.getText());
        String result = md5.getMD5(file);
        textArea_Ketqua.setText(result);

    }
    protected void do_mntmHashingString_actionPerformed(ActionEvent e) {
        MD5ViewHashingString md5HashStr = new MD5ViewHashingString();
        md5HashStr.setVisible(true);
        this.setVisible(false);
    }
    protected void do_menuRSA_actionPerformed(ActionEvent e) {
        RSAView rsaView = new RSAView();
        rsaView.setVisible(true);
        this.setVisible(false);
    }
    protected void do_mntmRsa_actionPerformed(ActionEvent e) {
        RSAView rsaView = new RSAView();
        rsaView.setVisible(true);
        this.setVisible(false);
    }
}
