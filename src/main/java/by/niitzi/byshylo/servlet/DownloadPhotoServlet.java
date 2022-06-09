package by.niitzi.byshylo.servlet;

import by.niitzi.byshylo.exception.ServiceException;
import by.niitzi.byshylo.service.UserPhotoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@MultipartConfig(
        maxFileSize = 16177215//16 MB
)
@WebServlet(urlPatterns = "/downloadServlet")
public class DownloadPhotoServlet extends HttpServlet {
    public static int BUFFER_SIZE = 1024 * 100;
    public static final String UPLOAD_DIR = "resources";
    private UserPhotoService userPhotoService = UserPhotoService.getInstance();
   // public static String photoName = null;
   // public static String id = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       photoName = req.getParameter("photoName");
//      // photoName = String.valueOf(req.getAttribute(photoName));
//       if(photoName == null || photoName.equals("")){//gonna show message at html page
//           resp.setContentType("text/html");
//           resp.getWriter().println("Photo " + photoName + " is not present");
//       }else{
//           String appPath = getServletContext().getRealPath("");//convert a web content path
//           // (the path in the expanded WAR folder structure on the server's disk file system)
//           //to an absolute disk file system path. (the "/" represents the web content root
//           String downloadPath = appPath + File.separator + UPLOAD_DIR;
//           String photoPath = downloadPath + File.separator + photoName;
//           System.out.println("Photo " + photoName);
//           System.out.println("Path to photo " + photoPath);
//           File file = new File(photoPath);
//           OutputStream outputStream = null;
//           FileInputStream inputStream = null;
//
//           if(file.exists()){
//               String mimeType = "application/octet-stream";
//               resp.setContentType(mimeType);
//
//               String headerKey = "Content-Disposition";
//               String headerValue = String.format("attachment; photoName=\"%s\"", photoName);
//               resp.setHeader(headerKey, headerValue);
//
//               try{
//                   //getting output stream of the response
//                   outputStream = resp.getOutputStream();
//                   inputStream = new FileInputStream(file);
//                   byte[] buffer = new byte[BUFFER_SIZE];
//                   int bytesRead = -1;
//
//                   //writing each byte of data read from InputStream into OutputStream
//                   while ((bytesRead = inputStream.read(buffer)) != -1){
//                       outputStream.write(buffer, 0, bytesRead);//buffer - the data, offset - the start offset of data, bytesRead - the number of bytes to write
//                   }
//               }catch (IOException ioException){
//                   System.out.println("Exception while performing I/O operation");
//               }finally {
//                   if(inputStream != null){
//                       inputStream.close();
//                   }
//                   outputStream.flush();
//                   if(outputStream != null){
//                       outputStream.close();
//                   }
//               }
//           }else{
//               resp.setContentType("text/html");
//               resp.getWriter().println("Photo file " + photoName + " is not present");
//           }
//
//       }



        String id = req.getParameter("id");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try{
            String photo = String.valueOf(userPhotoService.getDbFileInputStreamById(id));
            if(photo == null){
                System.out.println("File not found");
            }

            String resContentType = "image/png";//"APPLICATION/OCTET-STREAM"
            resp.setContentType(resContentType);

            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; photo=\"%s\"", photo);
            resp.setHeader(headerKey, headerValue);

            InputStream is = userPhotoService.getDbFileInputStreamById(id);

            if(is == null){
                System.out.println("File not found according to Id");
            }
            for (int i = is.read(); i != -1 ; i = is.read()) {
                out.write(i);
            }

            is.close();
            out.close();

        } catch (ServiceException e) {
            e.printStackTrace();
            System.out.println("Problem occurs");
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
}
