package by.niitzi.byshylo.command.impl;

import by.niitzi.byshylo.command.Command;
import by.niitzi.byshylo.command.CommandResult;
import by.niitzi.byshylo.entity.UserPhoto;
import by.niitzi.byshylo.exception.ServiceException;
import by.niitzi.byshylo.service.UserPhotoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Optional;

@MultipartConfig(
        maxFileSize = 16177215//16 MB
)
public class UploadPhotoCommand implements Command {

    private UserPhotoService userPhotoService = UserPhotoService.getInstance();

    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException, ServletException, IOException, ServletException, IOException {
        String firstName = servletRequest.getParameter("firstName");
        String lastName = servletRequest.getParameter("lastName");
        String photoName = servletRequest.getParameter("photoName");


        Part filePart = servletRequest.getPart("photo");
        //String photoName = filePart.getSubmittedFileName();
        if(filePart != null){
            //for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
        }
        //obtain input stream of the upload file
        InputStream inputStream = filePart.getInputStream();


        Optional<UserPhoto> user = null;

        try {
            user = userPhotoService.uploadPhotoFile(new UserPhoto(firstName, lastName, photoName, inputStream));
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        //user = Optional.of(new UserPhoto(firstName, lastName, photoName, inputStream));

        //String message = null;

        if(user.isPresent()){
//            message = "File " + photoName +" uploaded successfully and saved to DB";
            return new CommandResult("home?command=to_home", CommandResult.ResponseType.REDIRECT);

        }
        //servletRequest.setAttribute("Message", message);
        //CommandResult.ResponseType.valueOf("/WEB-INF/message.jsp");
        //CommandResult("src/main/webapp/index.jsp", CommandResult.ResponseType.FORWARD);
        //getServletContext().getRequestDispatcher("/WEB-INF/message.jsp").forward(req,resp);
        return null;
    }
    }








    /*@WebServlet(urlPatterns = "/uploadServlet")
@MultipartConfig(
        maxFileSize = 16177215//16 MB
)
public class UserPhotoUploadServlet extends HttpServlet {

    private final UserPhotoService userPhotoService = UserPhotoService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/upload-file.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String photoName = req.getParameter("photoname");


        InputStream inputStream = null;

        String message = null;

        Part filePart = req.getPart("photo");
        //String photoName = filePart.getSubmittedFileName();
        if(filePart != null){
            //for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
        }
        //obtain input stream of the upload file
        inputStream = filePart.getInputStream();


        //User user = new User(firstName, lastName, inputStream);
       ////// fileUploadDAO.uploadPhotoFile(user);
        //int row = fileUploadDAO.uploadFile(firstName, lastName, inputStream);
        //Optional<User> client = clientService.findClientToLogin(userName);
        //Optional<UserPhoto> user =  userPhotoUploadDAO.uploadPhotoFile(new UserPhoto(firstName, lastName, inputStream));
        Optional<UserPhoto> user = null;
        try {
            user = userPhotoService.uploadPhotoFile(new UserPhoto(firstName, lastName, photoName, inputStream));
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        if(user.isPresent()){
            message = "File " + photoName +" uploaded successfully and saved to DB";
        }
        req.setAttribute("Message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/message.jsp").forward(req,resp);
    }
}
*/

