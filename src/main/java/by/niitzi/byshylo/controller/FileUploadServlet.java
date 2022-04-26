package by.niitzi.byshylo.controller;

import by.niitzi.byshylo.dao.FileUploadDAO;
import by.niitzi.byshylo.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

@WebServlet(urlPatterns = "/uploadServlet")
@MultipartConfig(
        maxFileSize = 16177215//16 MB
)
public class FileUploadServlet extends HttpServlet {

    private FileUploadDAO fileUploadDAO;

    @Override
    public void init() throws ServletException {
        fileUploadDAO = new FileUploadDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/upload-file.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");


        InputStream inputStream = null;

        String message = null;

        Part filePart = req.getPart("photo");

        if(filePart != null){
            //for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
        }
        //obtain input stream of the upload file
        inputStream = filePart.getInputStream();


        /////User user = new User(firstName, lastName, inputStream);
        //////User user =  new User(firstName, lastName, photo);

        //int row = fileUploadDAO.uploadFile(fileName, lastName,inputStream);
       ////// fileUploadDAO.uploadPhotoFile(user);
        int row = fileUploadDAO.uploadFile(firstName, lastName, inputStream);
        if(row > 0){
            message = "File uploaded successfully and saved to DB";
        }
        req.setAttribute("Message", message);
        ////req.setAttribute("Message", "File uploaded successfully and saved to DB");
        getServletContext().getRequestDispatcher("/WEB-INF/message.jsp").forward(req,resp);
    }
}
