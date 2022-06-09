package by.niitzi.byshylo.command.impl;

import by.niitzi.byshylo.command.Command;
import by.niitzi.byshylo.command.CommandResult;
import by.niitzi.byshylo.exception.ServiceException;
import by.niitzi.byshylo.service.UserPhotoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@MultipartConfig(
        maxFileSize = 16177215//16 MB
)
public class DownloadPhotoCommand implements Command {
//    private UserPhotoService userPhotoService = UserPhotoService.getInstance();
//
    @Override
    public CommandResult execute(HttpServletRequest servletRequest) throws ServiceException, ServletException, IOException {
//
//        String id = servletRequest.getParameter("id");
//        HttpServletResponse servletResponse = null;
//        PrintWriter out = servletResponse.getWriter();
//
//        try{
//            String photoName = String.valueOf(userPhotoService.getDbFileInputStreamById(id));
//            if(photoName == null){
//                System.out.println("File not found");
//            }
//
//            String resContentType = "image/png";//"APPLICATION/OCTET-STREAM"
//            servletResponse.setContentType(resContentType);
//
//            String headerKey = "Content-Disposition";
//            String headerValue = String.format("attachment; filename=\"%s\"", photoName);
//            servletResponse.setHeader(headerKey, headerValue);
//
//            InputStream is = userPhotoService.getDbFileInputStreamById(id);
//
//            if(is == null){
//                System.out.println("File not found according to Id");
//            }
//            for (int i = is.read(); i != -1 ; i = is.read()) {
//                out.write(i);
//            }
//
//            is.close();
//            out.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Problem occurs");
//        }
//new CommandResult("client?command=to_client_home", CommandResult.ResponseType.REDIRECT)

        return null;

    }
}

//за отображение таблицы отвечает ToDownloadCommand...
//НО как-то надо прописать чтобы при нажатии на Download осуществлялось скачивание
//посмотреть в git-e

//1.изучить DownloadServlet из гита файла
/*
* -создание переменной для пути
* ? как определить путь файла из БД(работать по id)
*
* как это и где это связать с jsp чтоб при нажатии это делалось
* мб теперь сравни этот пример с гитовым
* или мб отдельно окружить поле где Download <from action="" class="download_photo"
* ВОПРОС ВЕКА
* ПОЧЕМУ servletRequest НЕ getит параметры, показывает налл и Все...собака....
*
*
* ЕСЛИ УЖЕ ПРЯМ ВООБЩЕ КРАЙНЯК, перепиши уже тогда даунлоадкомманд под аналогичный сервлет и протести его
* чтоб можно было проверить хотя бы верность алгоритма*/