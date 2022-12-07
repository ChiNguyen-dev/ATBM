package com.watch.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.watch.model.Cart;
import com.watch.model.User;
import com.watch.services.Email;
import com.watch.services.IOrderService;
import com.watch.services.Imp.Hash;
import com.watch.services.Imp.OrderServiceImp;
import com.watch.services.Imp.RSA;

@WebServlet("/place-order")
public class PlaceOrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IOrderService oService;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        oService = new OrderServiceImp();
        String hoten = request.getParameter("hoten");
        String email = request.getParameter("email");
        String sdt = request.getParameter("sdt");
        String diachi = request.getParameter("diachi");
        String thanhpho = request.getParameter("thanhpho");
        String signature = request.getParameter("signature");


        HttpSession ss = request.getSession();
        User user = (User) ss.getAttribute("user");
        Cart cart = (Cart) ss.getAttribute("cart");

        if (hoten == null || hoten.equals("") || email == null || email.equals("") || diachi == null || diachi.equals("")
                || thanhpho == null || thanhpho.equals("") || sdt == null || sdt.equals("")) {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Infomation is required');");
            out.println("location='/Project_CuoiKy/view/client/checkout.jsp'");
            out.println("</script>");
        } else {
            try {
                RSA rsa = new RSA();
                String stringPubKey = user.getPubicKey();
                byte[] byteKey = Base64.getDecoder().decode(stringPubKey);
                X509EncodedKeySpec X509publicKey = new X509EncodedKeySpec(byteKey);
                KeyFactory kf = KeyFactory.getInstance("RSA");
                PublicKey pubKey = kf.generatePublic(X509publicKey);
                rsa.publicKey = pubKey;
                String sntHashcode = rsa.decrypt(signature);
                String hashcode = (String) ss.getAttribute("hashcode");
                if (sntHashcode.equals(hashcode)) {
                    String orderId = oService.insertOrder(cart, user, hoten, email, diachi, thanhpho, sdt);
                    Hash hash = Hash.getInstance("MD5");
                    String hashFilePdf = hash.hashFile("src/mau-don-xin-xac-nhan-don-hang.pdf");
                    System.out.println("file hash: " + hashFilePdf);
//                    String fileHash = new String(rsa.encrypt(hashFilePdf));
//                    System.out.println(hashFilePdf);
//                    Email.sendMail(email, "src/mau-don-xin-xac-nhan-don-hang.pdf", fileHash);
                    Email.sendMail(email);
                    request.setAttribute("orderId", orderId);
                    request.getRequestDispatcher("/order").forward(request, response);
                } else {
                    request.getRequestDispatcher("/view/client/checkout.jsp").forward(request, response);
                }

            } catch (Exception e) {
                request.getRequestDispatcher("/view/client/checkout.jsp").forward(request, response);
                e.printStackTrace();
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
