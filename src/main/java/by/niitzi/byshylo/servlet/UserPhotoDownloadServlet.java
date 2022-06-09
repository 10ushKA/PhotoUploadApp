package by.niitzi.byshylo.servlet;

import by.niitzi.byshylo.entity.UserPhoto;
import by.niitzi.byshylo.exception.ServiceException;
import by.niitzi.byshylo.service.UserPhotoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

//@WebServlet(urlPatterns = "/downloadServlet")
public class UserPhotoDownloadServlet extends HttpServlet {
//    private UserPhotoService userPhotoService = UserPhotoService.getInstance();
//
//    Map<String, Object> attributes;
//    String page;
//
//
//    public void addAttributes(String name, Object attribute){
//        attributes.put(name, attribute);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/download-table.jsp");
//        requestDispatcher.forward(req,resp);
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        try {
//            List<UserPhoto> allUserPhoto = userPhotoService.showAllToDownloadPhoto();
//            addAttributes("users", allUserPhoto);
//            req.getRequestDispatcher("/WEB-INF/download-table.jsp").forward(req,resp);
//
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
        //добавить атрибут "users" и связать с оллюзерспхото и с jsp страничкой
        //прописать что-то типо
        // ...чтобы тоже выводило Message
        //только определиться ifPresents what? в данном случае
    }
//}
