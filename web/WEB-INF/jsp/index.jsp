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

    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="panel-heading" ><h2>Bienvenidos al FormServerController</h2></div>
                    <div class="panel panel-primary">
                        <div class="panel-heading" ><h2>Informaci&oacute;n general</h2></div>
                        <div class="panel-body">
                            
                                <div class="jumbotron">
                                    <p class="lead">P&aacute;gina de logeo y mantenimiento al sistema controlador m&oacute;vil de servidores.</p>
                                </div>
                                <div class="form-group"> 
                                    <li><a href="script.htm">Gesti&oacute;n de usuarios</a></li>
                                </div>
                                <div class="form-group"> 
                                    <li><a href="scriptRole.htm">Gesti&oacute;n de roles</a></li>
                                </div>
                            
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>

    </body>
</html>

