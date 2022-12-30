package com.watch.controller;

import com.watch.dao.IUserDao;
import com.watch.dao.Imp.UserDaoImp;
import com.watch.model.User;
import com.watch.services.Imp.RSA;
import com.watch.services.Imp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@WebServlet({"/create-key","/save-key"})
public class CreateKeyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        KeyPair keyPair = null;
        if (url.contains("create-key")) {
            RSA rsa = new RSA();
            try {
                rsa.createKey();
                keyPair = rsa.keypair;
                request.setAttribute("publicKey", Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
                request.getRequestDispatcher("/view/client/createKey.jsp").forward(request,response);
            } catch (NoSuchAlgorithmException e) {
                request.setAttribute("publicKey", "");
                request.getRequestDispatcher("/view/client/createKey.jsp").forward(request,response);
            }
        } else {
                String publicKey =  request.getParameter("publicKey");
                 System.out.println(publicKey);
                if (publicKey != null) {
                    HttpSession ss = request.getSession();
                    User user = (User) ss.getAttribute("user");
                    user.setPubicKey(publicKey);
                    IUserDao dao = new UserDaoImp();
                    dao.updatePublicKey(publicKey, user.getUserName());

                    request.getRequestDispatcher("/view/client/checkout.jsp").forward(request,response);
                } else{
                    request.getRequestDispatcher("/view/client/createKey.jsp").forward(request,response);
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
