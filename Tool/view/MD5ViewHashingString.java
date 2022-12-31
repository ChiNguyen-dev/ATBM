package com.Tool.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.MD5;

import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;

public class MD5ViewHashingString extends JFrame {

    private JPanel contentPane;
    private JTextArea textArea_Input;
    private JButton bt_Genergate;
    private JTextArea textArea_Ketqua;
    private JMenuBar menuBar;
    private JMenu mnMd;
    private JMenu mnRsa;
    private JMenuItem mntmHashingstring;
    private JMenuItem mntmHashingfile;
    private JMenuItem mntmRsa;
    private JMenu mnXcNhn;
    private JMenuItem muneItem_cofirm;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MD5ViewHashingString frame = new MD5ViewHashingString();
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
    public MD5ViewHashingString() {
        setBackground(new Color(192, 192, 192));
        setTitle("MD5-Hashing String");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 499, 371);

        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(75, 154, 180));
        menuBar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        setJMenuBar(menuBar);

        mnMd = new JMenu("Hashing");
        mnMd.setFont(new Font("Times New Roman", Font.BOLD, 15));
        menuBar.add(mnMd);

        mntmHashingstring = new JMenuItem("Hashing String");
        mntmHashingstring.setBackground(new Color(75, 154, 180));
        mntmHashingstring.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        mnMd.add(mntmHashingstring);

        mntmHashingfile = new JMenuItem("Hashing File");
        mntmHashingfile.setBackground(new Color(75, 154, 180));
        mntmHashingfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_mntmHashingfile_actionPerformed(e);
            }
        });
        mntmHashingfile.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        mnMd.add(mntmHashingfile);

        mnRsa = new JMenu("Ký Tên");
        mnRsa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_mnRsa_actionPerformed(e);
            }
        });
        mnRsa.setFont(new Font("Times New Roman", Font.BOLD, 15));
        menuBar.add(mnRsa);

        mntmRsa = new JMenuItem("Tạo chữ ký điện tử");
        mntmRsa.setBackground(new Color(75, 154, 180));
        mntmRsa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_mntmRsa_actionPerformed(e);
            }
        });
        mntmRsa.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        mnRsa.add(mntmRsa);

        mnXcNhn = new JMenu("Xác Nhận");
        mnXcNhn.setFont(new Font("Times New Roman", Font.BOLD, 15));
        menuBar.add(mnXcNhn);

        muneItem_cofirm = new JMenuItem("Xác nhận");
        muneItem_cofirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_muneItem_cofirm_actionPerformed(e);
            }
        });

        muneItem_cofirm.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        mnXcNhn.add(muneItem_cofirm);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.controlHighlight);
        panel.setBounds(10, 20, 461, 282);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel label_Input = new JLabel("INPUT TEXT");
        label_Input.setFont(new Font("Times New Roman", Font.BOLD, 13));
        label_Input.setBounds(38, 28, 84, 23);
        panel.add(label_Input);

        textArea_Input = new JTextArea();
        textArea_Input.setWrapStyleWord(true);
        textArea_Input.setLineWrap(true);
        textArea_Input.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_Input.setBounds(152, 10, 299, 100);
        panel.add(textArea_Input);

        bt_Genergate = new JButton("GENERGATE >>");
        bt_Genergate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    do_bt_Genergate_actionPerformed(e);
                } catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        bt_Genergate.setForeground(new Color(98, 157, 109));
        bt_Genergate.setFont(new Font("Times New Roman", Font.BOLD, 14));
        bt_Genergate.setBounds(26, 130, 163, 23);
        panel.add(bt_Genergate);

        JLabel label_Ketqua = new JLabel("KẾT QUẢ");
        label_Ketqua.setFont(new Font("Times New Roman", Font.BOLD, 13));
        label_Ketqua.setBounds(38, 175, 84, 23);
        panel.add(label_Ketqua);

        textArea_Ketqua = new JTextArea();
        textArea_Ketqua.setWrapStyleWord(true);
        textArea_Ketqua.setLineWrap(true);
        textArea_Ketqua.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_Ketqua.setBounds(152, 176, 299, 100);
        panel.add(textArea_Ketqua);
    }
    protected void do_bt_Genergate_actionPerformed(ActionEvent e) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MD5 md5 = new MD5();
        String srcText = textArea_Input.getText();
        String enrText = md5.encrypt(srcText);
        textArea_Ketqua.setText(enrText);

    }
    protected void do_mntmHashingfile_actionPerformed(ActionEvent e) {
        MD5ViewHashingFile md5HashFile = new MD5ViewHashingFile();
        md5HashFile.setVisible(true);
        this.setVisible(false);
    }
    protected void do_mnRsa_actionPerformed(ActionEvent e) {
        SignView signView = new SignView();
        signView.setVisible(true);
        this.setVisible(false);
    }
    protected void do_mntmRsa_actionPerformed(ActionEvent e) {
        SignView signView = new SignView();
        signView.setVisible(true);
        this.setVisible(false);

    }

    protected void do_muneItem_cofirm_actionPerformed(ActionEvent e) {
        ConfirmView confirmView = new ConfirmView();
        confirmView.setVisible(true);
        this.setVisible(false);
    }
}
