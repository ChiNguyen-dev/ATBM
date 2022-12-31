package com.Tool.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.RSA;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;

public class SignView extends JFrame {

    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu menuMD5;
    private JMenu menuRSA;
    private JMenuItem mntmHashingString;
    private JMenuItem menuItem_hashingFile;
    private JMenuItem mntmRsa;
    private JLabel lblToChK;
    private JLabel lblMiNgiDng;
    private JTextArea textArea_plainText;
    private JTextArea textArea_privateKey;
    private JTextArea textArea_sign;
    private JButton btn_sign;
    private JScrollPane scrollPane_privateKey;
    private JScrollPane scrollPane_sign;
    private JScrollPane scrollPane_textPlain;
    private JMenu menuItem_cofirm;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignView frame = new SignView();
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
    public SignView() {
        setBackground(new Color(192, 192, 192));
        setTitle("TOOL HỖ TRỢ KÝ TÊN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 385);

        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(75, 154, 180));
        setJMenuBar(menuBar);

        menuMD5 = new JMenu("Hashing");
        menuMD5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_menuMD5_actionPerformed(e);
            }
        });
        menuMD5.setFont(new Font("Times New Roman", Font.BOLD, 15));
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

        menuRSA = new JMenu("Ký Tên");
        menuRSA.setFont(new Font("Times New Roman", Font.BOLD, 15));
        menuBar.add(menuRSA);

        mntmRsa = new JMenuItem("Tạo chữ ký điện tử");
        mntmRsa.setBackground(new Color(75, 154, 180));
        mntmRsa.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        menuRSA.add(mntmRsa);

        menuItem_cofirm = new JMenu("Xác Nhận");
        menuItem_cofirm.setFont(new Font("Times New Roman", Font.BOLD, 15));
        menuBar.add(menuItem_cofirm);

        JMenuItem munuItem_confirn = new JMenuItem("Xác nhận");
        munuItem_confirn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_munuItem_confirn_actionPerformed(e);
            }
        });
        munuItem_confirn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        menuItem_cofirm.add(munuItem_confirn);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(26, 10, 449, 295);
        contentPane.add(panel);
        panel.setLayout(null);

        lblToChK = new JLabel("Tạo chữ ký ở đây");
        lblToChK.setBounds(147, 10, 163, 27);
        panel.add(lblToChK);
        lblToChK.setFont(new Font("Times New Roman", Font.BOLD, 20));

        lblMiNgiDng = new JLabel("Mời người dùng nhập");
        lblMiNgiDng.setBounds(10, 47, 141, 17);
        panel.add(lblMiNgiDng);
        lblMiNgiDng.setFont(new Font("Times New Roman", Font.BOLD, 15));

        JLabel lblPlaintext = new JLabel("PlainText");
        lblPlaintext.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblPlaintext.setBounds(35, 74, 85, 27);
        panel.add(lblPlaintext);

        JLabel label_privateKey = new JLabel("Private Key");
        label_privateKey.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label_privateKey.setBounds(35, 121, 85, 27);
        panel.add(label_privateKey);

        textArea_plainText = new JTextArea();
        textArea_plainText.setLineWrap(true);
        textArea_plainText.setWrapStyleWord(true);
        textArea_plainText.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_plainText.setBounds(147, 74, 280, 40);
        panel.add(textArea_plainText);

        textArea_privateKey = new JTextArea();
        textArea_privateKey.setLineWrap(true);
        textArea_privateKey.setWrapStyleWord(true);
        textArea_privateKey.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_privateKey.setBounds(147, 123, 280, 80);
        panel.add(textArea_privateKey);

        textArea_sign = new JTextArea();
        textArea_sign.setLineWrap(true);
        textArea_sign.setWrapStyleWord(true);
        textArea_sign.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_sign.setBounds(147, 213, 280, 60);
        panel.add(textArea_sign);

        btn_sign = new JButton("Sign");
        btn_sign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    do_btn_sign_actionPerformed(e);
                } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
                         | IllegalBlockSizeException | BadPaddingException | InvalidKeySpecException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btn_sign.setForeground(new Color(0, 0, 0));
        btn_sign.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btn_sign.setBounds(35, 213, 85, 21);
        panel.add(btn_sign);


        scrollPane_privateKey = new JScrollPane(textArea_privateKey);
        scrollPane_privateKey.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane_privateKey.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_privateKey.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
        scrollPane_privateKey.setBounds(147, 121, 280, 82);
        panel.add(scrollPane_privateKey);


        scrollPane_sign = new JScrollPane(textArea_sign);
        scrollPane_sign.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
        scrollPane_sign.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_sign.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane_sign.setBounds(147, 213, 280, 60);
        panel.add(scrollPane_sign);

        scrollPane_textPlain = new JScrollPane(textArea_plainText);
        scrollPane_textPlain.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
        scrollPane_textPlain.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane_textPlain.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_textPlain.setBounds(147, 74, 280, 40);
        panel.add(scrollPane_textPlain);


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
    protected void do_btn_sign_actionPerformed(ActionEvent e) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        RSA rsa = new RSA();
        String plainText = textArea_plainText.getText();
        String privateKey = textArea_privateKey.getText();
        String sign = rsa.enscrypt(plainText, privateKey);
        textArea_sign.setText(sign);
    }
    protected void do_munuItem_confirn_actionPerformed(ActionEvent e) {
        ConfirmView confirmView = new ConfirmView();
        confirmView.setVisible(true);
        this.setVisible(false);
    }
}
