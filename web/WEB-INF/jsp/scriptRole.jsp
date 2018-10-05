<!-- el tag es para que funcione el foreach -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>FormServerController</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.css">  
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
        <style>

            .panel-heading {
                background-color: #00bfff !important;
            }



        </style>
    </head>

    <script>
        //$('#Productos').dataTable();
        $(document).ready(function () {
            $('#Administrador').dataTable();
        });
    </script>
    <script>
        function messageAlert(){
            //formScriptRoleSubmit
            var tramiteTXT = document.getElementById("tramite");
            var nameTXT = document.getElementById("name");
            
            var action = confirm("Esta seguro de que desea "+tramiteTXT.value+" a "+nameTXT.value);
            if(action === true){
                var formEx = document.getElementById("formScriptRoleSubmit");
                formEx.submit();
            }  
        }
        function Eliminar1(i) {
            var idTXT = document.getElementById("id");
            var nameTXT = document.getElementById("name");
            var descriptionTXT = document.getElementById("description");
            var tramiteTXT = document.getElementById("tramite");
            var tramiteChild = i;
            tramiteTXT.value = tramiteChild.innerHTML;

            if (i.innerHTML === "Insertar Role") {
                descriptionTXT.readOnly = false;
                nameTXT.readOnly = false;
                descriptionTXT.value = "";
                nameTXT.value = "";
            } else {


                var y = i.parentNode.parentNode;
                var idChild = y.firstElementChild;
                var nameChild = idChild.nextElementSibling;
                var descriptionChild = nameChild.nextElementSibling;




                idTXT.value = idChild.innerHTML;
                nameTXT.value = nameChild.innerHTML;
                descriptionTXT.value = descriptionChild.innerHTML;


                if (i.innerHTML === "Eliminar") {
                    nameTXT.readOnly = true;
                    descriptionTXT.readOnly = true;
                } else {
                    nameTXT.readOnly = false;
                    descriptionTXT.readOnly = false;
                }
            }
        }
    </script>

    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="panel-heading" ><h2>Bienvenidos al FormServerController</h2></div>
                    <div class="panel panel-primary">

                    </div>
                    <div class="panel panel-primary">
                        <div class="panel-heading" ><h2>Gesti&oacute;n de los roles de la aplicaci&oacute;n</h2></div>
                        <div class="panel-body">
                            <div class="jumbotron">
                                <p class="lead">Ir a</p>
                                <li><a href="script.htm">Gesti&oacute;n de usuarios</a></li>
                                <li><a href="index.htm">P&aacute;gina Principal</a></li>
                            </div>
                            <table class="table table-striped table-bordered table-hover" id="Administrador" cellspacing="0" width="100%">
                                <thead >
                                    <tr>
                                        <th>Id</th>
                                        <th>Nombre</th>
                                        <th>Descripci&oacute;n</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>


                                <c:forEach items="${listRoles}" var="dato" >
                                    <tr id="fila">

                                        <td>${dato.id}</td>
                                        <td>${dato.nameRole}</td>
                                        <td>${dato.descriptionRole}</td>
                                        <td align="center">

                                            <button class="btn btn-info" onclick="Eliminar1(this)">Editar</button> 

                                        </td>
                                        <td align="center">

                                            <button class="btn btn-info" onclick="Eliminar1(this)">Eliminar</button> 

                                        </td>

                                    </tr>
                                </c:forEach>

                            </table>
                            <div class="form-group">
                                <button class="btn btn-info" onclick="Eliminar1(this)">Insertar Role</button>

                            </div>
                            <form id="formScriptRoleSubmit" action="scriptRoleSubmit" method="post" >
                                <div class="form-group">
                                    <label for="id">Id</label>
                                    <input type="text" class="form-control" id="id" name="id" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="name">Nombre</label>
                                    <input type="text" class="form-control" id="name" name="name" value="" >
                                </div>
                                <div class="form-group">
                                    <label for="description">Descripci&oacute;n</label>
                                    <input type="text" class="form-control" id="description" name="description" value="">
                                </div>
                                <div class="form-group">
                                    <label for="tramite">Tramite</label>
                                    <input type="text" class="form-control" id="tramite" name="tramite" value="Insertar Role" readonly>
                                </div>
                                </form> 
                                <div class="form-group">
                                    <button  class="btn btn-warning" onclick="messageAlert()">Salvar cambios</button>

                                </div>
                            
                        </div>
                    </div>
                </div>

            </div>

    </body>
</html>

