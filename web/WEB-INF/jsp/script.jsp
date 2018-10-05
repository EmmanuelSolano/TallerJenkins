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
            $('#cbOpciones').change(function () {
                var selection = $('#cbOpciones option:selected').val();
                $('#role').val(selection);
            });


        });
    </script>
    <script>
        function Eliminar1(i) {
            var idTXT = document.getElementById("id");
            var nombreTXT = document.getElementById("nombre");
            var primerATXT = document.getElementById("primerA");
            var segundoATXT = document.getElementById("segundoA");
            var roleTXT = document.getElementById("role");
            var correoTXT = document.getElementById("correo");
            var tramiteTXT = document.getElementById("tramite");
            var contrasenaTXT = document.getElementById("contrasena");
            var tramiteChild = i;
            tramiteTXT.value = tramiteChild.innerHTML;

            if (i.innerHTML === "Ingresar Usuario") {
                nombreTXT.readOnly = false;
                primerATXT.readOnly = false;
                segundoATXT.readOnly = false;
                roleTXT.readOnly = false;
                correoTXT.readOnly = false;
                contrasenaTXT.readOnly = false;
                contrasenaTXT.value = "";
                nombreTXT.value = "";
                primerATXT.value = "";
                segundoATXT.value = "";
                roleTXT.value = "";
                correoTXT.value = "";
            } else {


                var y = i.parentNode.parentNode;
                var idChild = y.firstElementChild;
                var nombreChild = idChild.nextElementSibling;
                var primerAChild = nombreChild.nextElementSibling;
                var segundoAChild = primerAChild.nextElementSibling;
                var contrasenaChild = segundoAChild.nextElementSibling;
                var roleChild = contrasenaChild.nextElementSibling;
                var correoChild = roleChild.nextElementSibling;




                nombreTXT.value = nombreChild.innerHTML;
                primerATXT.value = primerAChild.innerHTML;
                segundoATXT.value = segundoAChild.innerHTML;
                roleTXT.value = roleChild.innerHTML;
                correoTXT.value = correoChild.innerHTML;
                contrasenaTXT.value = contrasenaChild.innerHTML;
                idTXT.value = idChild.innerHTML;
                if (i.innerHTML === "Eliminar") {
                    nombreTXT.readOnly = true;
                    primerATXT.readOnly = true;
                    segundoATXT.readOnly = true;
                    roleTXT.readOnly = true;
                    correoTXT.readOnly = true;
                    contrasenaTXT.readOnly = true;
                } else {
                    nombreTXT.readOnly = false;
                    primerATXT.readOnly = false;
                    segundoATXT.readOnly = false;
                    roleTXT.readOnly = false;
                    correoTXT.readOnly = false;
                    contrasenaTXT.readOnly = false;
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
                        <div class="panel-heading" ><h2>Gesti&oacute;n de los usuarios de la aplicaci&oacute;n</h2></div>
                        <div class="panel-body">
                            <div class="jumbotron">
                                 <p class="lead">Ir a</p>
                                <li><a href="scriptRole.htm">Gesti&oacute;n de roles</a></li>
                                <li><a href="index.htm">P&aacute;gina Principal</a></li>
                            </div>
                            <table class="table table-striped table-bordered table-hover" id="Administrador" cellspacing="0" width="100%">
                                <thead >
                                    <tr>
                                        <th>id</th>
                                        <th>Nombre</th>
                                        <th>Primer Apellido</th>
                                        <th>Segundo Apellido</th>
                                        <th>Contrase&ntilde;a</th>
                                        <th>Role</th>
                                        <th>Correo</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>


                                <c:forEach items="${lists.listWithUsers}" var="dato" >
                                    <tr id="fila">
                                        <td>${dato.id}</td>
                                        <td>${dato.nombre}</td>
                                        <td>${dato.primerApellido}</td>
                                        <td>${dato.segundoApellido}</td>
                                        <td>${dato.contrasena}</td>
                                        <td>${dato.roleEnLaApp}</td>
                                        <td>${dato.correo}</td>
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
                                <button class="btn btn-info" onclick="Eliminar1(this)">Ingresar Usuario</button>
                            </div>
                            <form action="scriptSubmit" method="post" >
                                <div class="form-group">
                                    <label for="id">Id</label>
                                    <input type="text" class="form-control" id="id" name="id" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" class="form-control" id="nombre" name="nombre" value="">
                                </div>
                                <div class="form-group">
                                    <label for="primerA">Primer Apellido</label>
                                    <input type="text" class="form-control" id="primerA" name="primerA" value="" >
                                </div>
                                <div class="form-group">
                                    <label for="segundoA">Segundo Apellido</label>
                                    <input type="text" class="form-control" id="segundoA" name="segundoA" value="" >
                                </div>
                                <div class="form-group">
                                    <label for="role">Role</label>
                                    <div class="form-group" id="cbOpciones">
                                        <select>
                                            <option>--Seleccionar opción--</option>
                                            <c:forEach items="${lists.listWithRoles}" var="dato" >

                                                
                                                <option>${dato.nameRole}</option>

                                            </c:forEach>
                                        </select>
                                        <input type="text" class="form-control" id="role" name="role" value="" >
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="correo">Correo</label>
                                    <input type="email" class="form-control" id="correo" name="correo" value="" >
                                </div> 
                                <div class="form-group">
                                    <label for="contrasena">Contrase&ntilde;a</label>
                                    <input type="text" class="form-control" id="contrasena" name="contrasena" value="" >
                                </div> 
                                <div class="form-group">
                                    <label for="tramite">Tramite</label>
                                    <input type="text" class="form-control" id="tramite" name="tramite" value="Ingresar Usuario" readonly>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-warning">Salvar cambios</button>

                                </div>
                            </form> 
                        </div>
                    </div>
                </div>

            </div>

    </body>
</html>

