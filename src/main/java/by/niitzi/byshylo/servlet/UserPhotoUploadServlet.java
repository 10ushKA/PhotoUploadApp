package by.niitzi.byshylo.servlet;

import by.niitzi.byshylo.db.ConnectionPool;
import by.niitzi.byshylo.entity.UserPhoto;
import by.niitzi.byshylo.exception.ServiceException;
import by.niitzi.byshylo.service.UserPhotoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Optional;

//@WebServlet(urlPatterns = "/uploadServlet")
@MultipartConfig(
        maxFileSize = 16177215//16 MB
)
public class UserPhotoUploadServlet extends HttpServlet {

//    private final UserPhotoService userPhotoService = UserPhotoService.getInstance();
//
//    @Override
//    public void destroy() {
//        try{
//            ConnectionPool.CONNECTION_POOL.closeAll();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        System.out.println("Destroyed");
//    }
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        try{
//            ConnectionPool.CONNECTION_POOL.init();
//        }catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        System.out.println("Init");
//    }
//
//
//
//
//
//    //СНИЗУ ТО ЧТО РАБОТАЛО
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/upload-file.jsp");
//        requestDispatcher.forward(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");
//        String photoName = req.getParameter("photoName");
//
//
//        InputStream inputStream = null;
//
//        String message = null;
//
//        Part filePart = req.getPart("photo");
//        //String photoName = filePart.getSubmittedFileName();
//        if(filePart != null){
//            //for debugging
//            System.out.println(filePart.getName());
//            System.out.println(filePart.getSize());
//            System.out.println(filePart.getContentType());
//        }
//        //obtain input stream of the upload file
//        inputStream = filePart.getInputStream();
//
//
//        //User user = new User(firstName, lastName, inputStream);
//       ////// fileUploadDAO.uploadPhotoFile(user);
//        //int row = fileUploadDAO.uploadFile(firstName, lastName, inputStream);
//        //Optional<User> client = clientService.findClientToLogin(userName);
//        //Optional<UserPhoto> user =  userPhotoUploadDAO.uploadPhotoFile(new UserPhoto(firstName, lastName, inputStream));
//        Optional<UserPhoto> user = null;
//        try {
//            user = userPhotoService.uploadPhotoFile(new UserPhoto(firstName, lastName, photoName, inputStream));
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//
//        if(user.isPresent()){
//            message = "File " + photoName +" uploaded successfully and saved to DB";
//        }
//        req.setAttribute("Message", message);
//        getServletContext().getRequestDispatcher("/WEB-INF/message.jsp").forward(req,resp);
//    }
}

///сравнить этот сервлет с аналогом в  формате command, там походу отсутствует использование метода
//user = userPhotoService.uploadPhotoFile(new UserPhoto(firstName, lastName, photoName, inputStream));