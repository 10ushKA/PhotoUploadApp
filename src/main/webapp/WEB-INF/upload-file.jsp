<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 22.04.2022
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>File Upload</title>
    <link
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

    <script>
        function showUpload(){
            let firstName = $("#firstName").val();
            let lastName = $("#lastName").val();
            let photoName = $("#photoName").val();
            let photo = $("#photo").val();

            if(firstName === '' || lastName === '' || photoName === ''){
                //event.preventDefault();
                swal({
                    title: "Please fill in ALL the fields",
                    text: "tnx;)",
                    icon: "warning",
                });
            }else if(photo === ''){
                //event.preventDefault();
                swal({
                    title: "Please add Photo to upload",
                    text: "tnx;)",
                    icon: "warning",
                });
            }else {//здесь сослаться на свой кастомизированный алерт, или вместо свал прописать тут же свой
                swal({
                    title: "UPLOADED SUCCESSFULLY",
                    icon: "success",
                }).then(function (){
                    //$('#submit').onclick.submit();
                   // window.onclick = $('#myForm').submit();
                    window.location = "home?command=to_home";

                })
            }
        }
    </script>

    <script>

    </script>

            </head>

            <body>
            <form method="post" class="form-group" id="myForm" action="upload?command=upload_photo" enctype="multipart/form-data" >
            <div class="container col-lg-6">
                <h1 class="text-center">File Upload to Database </h1>
                <div class="card">
                    <div class="card-body">

                            <div class="form-group">
                                <label>First Name: </label> <input type="text" class="form-control" name="firstName" id = "firstName" size="50" />
                            </div>

                            <div class="form-group">
                                <label>Last Name: </label> <input type="text" class="form-control" name="lastName" id = "lastName" size="50" />
                            </div>

                            <div class="form-group">
                                <label>Photo Name: </label> <input type="text" class="form-control" name="photoName" id = "photoName" size="50" />
                            </div>

                            <div class="form-group">
                                <label>Profile Photo:</label> <input type="file" name="photo" id = "photo" size="50" />
                            </div>
                            <input type="button" onclick="showUpload()"  id="submit" value="Save" class="btn btn-success">
                    </div>
                </div>
            </div>



            <%--        $("#submit").click(function (){--%>

<%--            let firstName = $("#firstName").val();--%>
<%--            let lastName = $("#lastName").val();--%>
<%--            let photoName = $("#photoName").val();--%>
<%--            let photo = $("#photo").val();--%>

<%--            if(firstName === '' || lastName === '' || photoName === '' || photo === ''){--%>
<%--                swal({--%>
<%--                    title: "EMPTY",--%>
<%--                    text: "!!Please fill in All the fields!! tnx;)",--%>
<%--                    icon: "warning",--%>
<%--                });--%>
<%--            }else {--%>
<%--                swal({--%>
<%--                    title: "UPLOADED SUCCESSFULLY",--%>
<%--                    icon: "success",--%>
<%--                });--%>
<%--            }--%>
<%--        })--%>
</form>
</body>
</html>
