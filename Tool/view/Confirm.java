package com.Tool.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.RSA;

public class ConfirmView extends JFrame {

    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu menuMD5;
    private JMenu menuRSA;
    private JMenuItem mntmHashingString;
    private JMenuItem menuItem_hashingFile;
    private JMenuItem mntmRsa;
    private JLabel label_confim;
    private JLabel lblMiNgiDng;
    private JTextArea textArea_plainText;
    private JTextArea textArea_publicKey;
    private JTextArea textArea_confirm;
    private JButton btn_confirm;
    private JScrollPane scrollPane_publicKey;
    private JScrollPane scrollPane_confirm;
    private JScrollPane scrollPane_textPlain;
    private JMenu menuItem_cofirm;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConfirmView frame = new ConfirmView();
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
    public ConfirmView() {
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
        mntmRsa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_mntmRsa_actionPerformed(e);
            }
        });
        mntmRsa.setBackground(new Color(75, 154, 180));
        mntmRsa.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        menuRSA.add(mntmRsa);

        menuItem_cofirm = new JMenu("Xác Nhận");
        menuItem_cofirm.setFont(new Font("Times New Roman", Font.BOLD, 15));
        menuBar.add(menuItem_cofirm);

        JMenuItem munuItem_confirn = new JMenuItem("Xác nhận người dùng");
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

        label_confim = new JLabel("Xác Nhận");
        label_confim.setBounds(168, 9, 109, 27);
        panel.add(label_confim);
        label_confim.setFont(new Font("Times New Roman", Font.BOLD, 20));

        lblMiNgiDng = new JLabel("Mời nhập dữ liệu");
        lblMiNgiDng.setBounds(10, 47, 141, 17);
        panel.add(lblMiNgiDng);
        lblMiNgiDng.setFont(new Font("Times New Roman", Font.BOLD, 15));

        JLabel lblPlaintext = new JLabel("PlainText");
        lblPlaintext.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblPlaintext.setBounds(35, 74, 85, 27);
        panel.add(lblPlaintext);

        JLabel lblPublicKey = new JLabel("Public key");
        lblPublicKey.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblPublicKey.setBounds(35, 121, 85, 27);
        panel.add(lblPublicKey);

        textArea_plainText = new JTextArea();
        textArea_plainText.setLineWrap(true);
        textArea_plainText.setWrapStyleWord(true);
        textArea_plainText.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_plainText.setBounds(147, 74, 280, 40);
        panel.add(textArea_plainText);

        textArea_publicKey = new JTextArea();
        textArea_publicKey.setLineWrap(true);
        textArea_publicKey.setWrapStyleWord(true);
        textArea_publicKey.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_publicKey.setBounds(147, 123, 280, 80);
        panel.add(textArea_publicKey);

        textArea_confirm = new JTextArea();
        textArea_confirm.setLineWrap(true);
        textArea_confirm.setWrapStyleWord(true);
        textArea_confirm.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        textArea_confirm.setBounds(147, 213, 280, 60);
        panel.add(textArea_confirm);

        btn_confirm = new JButton("Confirm");
        btn_confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    do_btn_confirm_actionPerformed(e);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btn_confirm.setForeground(new Color(0, 0, 0));
        btn_confirm.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btn_confirm.setBounds(35, 213, 102, 21);
        panel.add(btn_confirm);

        scrollPane_publicKey = new JScrollPane(textArea_publicKey);
        scrollPane_publicKey.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane_publicKey.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_publicKey.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
        scrollPane_publicKey.setBounds(147, 121, 280, 82);
        panel.add(scrollPane_publicKey);

        scrollPane_confirm = new JScrollPane(textArea_confirm);
        scrollPane_confirm.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
        scrollPane_confirm.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_confirm.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane_confirm.setBounds(147, 213, 280, 60);
        panel.add(scrollPane_confirm);

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

    protected void do_btn_confirm_actionPerformed(ActionEvent e) throws Exception {
        RSA rsa = new RSA();
        String plainText = textArea_plainText.getText();
        String publicKey = textArea_publicKey.getText();
        String confirm = rsa.descrypt(plainText, publicKey);
        textArea_confirm.setText(confirm);
    }
    protected void do_mntmRsa_actionPerformed(ActionEvent e) {
        SignView signView = new SignView();
        signView.setVisible(true);
        this.setVisible(false);
    }
}