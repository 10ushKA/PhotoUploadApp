<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 22.04.2022
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Success massage</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<%--    <link--%>
<%--            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"--%>
<%--            rel="stylesheet"--%>
<%--            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"--%>
<%--            crossorigin="anonymous">--%>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>

    <script type="text/javascript">
        function showAlert(){
            alert("Uploaded successfully");
        }
    </script>
</head>
<body>
<form method="post" class="form-group" action="upload?command=upload_photo" enctype="multipart/form-data">
<script>
    $("#submit").click(function (){
        showAlert()
    })
</script>

<center>
<%--    <div class="alert alert-success">--%>
<%--        <strong><%=request.getAttribute("Message")%></strong>--%>
<%--    </div>--%>
    <a href = "home?command=to_home">Home</a>

<%--    ???????? ????? ??????? upload/?? upload ??????? ?????? ???? ? ???????? ???? ?????? ajax ? ???????????--%>
</center>
<script>
    // let form = new FormData(this);
    // $.ajax({
    // url: "",
    // type: 'POST',
    // data: form,
    // success: function (data, textStatus, jqXHR){
    // //success
    // console.log(data);
    // },
    // error: function (jqXHR, textStatus, errorThrown){
    //     //error
    // },
    // processData: false,
    // contentType: false})
    $("#submit").click(function (){

        let firstName = $("#firstName").val();
        let lastName = $("#lastName").val();
        let photoName = $("#photoName").val();
        let photo = $("#photo").val();

        if(firstName == '' || lastName == '' || photoName == '' || photo == ''){
            swal({
               title: "EMPTY",
               text: "!!Please fill in All the fields!! tnx;)",
                icon: "warning",
            });
        }else {
            swal({
                title: "UPLOADED SUCCESSFULLY",
                icon: "success",
            });
        }
    })
</script>
</form>
</body>
</html>
