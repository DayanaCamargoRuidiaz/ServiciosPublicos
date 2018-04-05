<%-- 
    Document   : Subsidy
    Created on : 5/11/2017, 01:09:03 PM
    Author     : Jeison
--%>


<%@page import="java.util.List"%>
<%@page import="Entidades.EntSubsidies"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String info = request.getAttribute("info") != null ? request.getAttribute("info").toString() :  null;
    List<EntSubsidies> list = (List<EntSubsidies>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Subsidios</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="iconMoon/fonts/style.css">
        <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
    </head>
    <body>
        <!-- Header -->
        <header class="w3-container w3-teal w3-padding" id="myHeader">
           <a href="index.jsp" class="hoverable"><button class="w3-btn w3-xlarge w3-theme-dark w3-hover-teal"><span class="icon-arrow-left2"> </span>
                </button></a> 
            <div class="w3-center">
                <h1 class="w3-xxxlarge w3-animate-bottom">SUBSIDIOS</h1>
            </div>
        </header>
        <form action="./SubsidiosServlet" method="post">
            <br>
            <div class="col-xs-12 col-sm-8 col-sm-offset-2">
                <%if (info != null && !info.isEmpty()) {%>
                    <%if (info.indexOf("¡¡Bien!!") != -1) {%>     
                        <div class="alert alert-success alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <%=info%>
                        </div>
                    <% } else if (info.indexOf("Advertencia : ") != -1) { %>
                        <div class="alert alert-warning alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <%=info%>
                        </div>
                    <% } else { %>
                        <div class="alert alert-danger alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <%=info%>
                        </div>
                    <% } %>
                <% } %>
            </div>
            <br>
            <div class="col-xs-12 col-sm-offset-3 col-sm-6">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-group"></i></span>
                    <input class="form-control" id = "search" name="search" placeholder="Buscar subsidio por nombre o descripción ..." type="text">
                    <span class="input-group-btn"><button class="btn btn-primary" type="submit" name="action" value="Buscar">Buscar</button></span>
                </div>
                <br>
                <button type="button" name="action" class="btn btn-sm btn-primary" onclick="cargarFormulario('', '', '', '', '', '', '', '', '');">Nuevo</button>
                <br><br>
            </div>
            <%if (list != null && !list.isEmpty()) {%> 
            <div class="form-group col-lg-6 col-sm-offset-3">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NOMBRE</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (EntSubsidies subsidy : list) {%>
                            <tr onclick="cargarFormulario('<%=subsidy.getIdSybsudy()%>', '<%=subsidy.getName()%>', '<%=subsidy.getDescription()%>', '<%=subsidy.getStartDate()%>', '<%=subsidy.getEndDate()%>', '<%=subsidy.getExpectedWaterValue()%>', '<%=subsidy.getExpectedNaturalGasValue()%>', '<%=subsidy.getExpectedEnergyValue()%>')">
                                <td><%=subsidy.getIdSybsudy()%></td>
                                <td><%=subsidy.getName()%></td>                      
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
            <%} else {%>
            NO SE ENCONTRARON REGISTROS PARA MOSTRAR
            <%}%>

            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">×</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel"><Center><strong>Subsidio</strong></Center></h4>
                        </div>

                        <!-- Modal Body -->
                        <div class="modal-body">
                            <p class="statusMsg"></p>

                            <div class="form-group">
                                <input name="idSybsudy" type="number" class="form-control" id="idSybsudy"  placeholder="Código de subsidio " readonly />
                            </div>
                            <div class="form-group">
                                <label for="name">Nombre : </label>
                                <input name="name" class="w3-input" type="text" id="name" placeholder="Nombre.."/>
                            </div>
                            <div class="form-group">
                                <label for="description" >Descripción : </label>
                                <textarea class="w3-input"  name="description" id="description" placeholder="Descripción.."></textarea>
                            </div>
                            <div class="form-group">
                                <label for="startDate">Fecha de inicio : </label>
                                <input name="startDate" type="date" class="w3-input" id="startDate"/>
                            </div>
                            <div class="form-group">
                                <label for="endDate">Fecha fin : </label>
                                <input name="endDate" type="date" class="w3-input" id="endDate"/>
                            </div>
                            <div class="form-group">
                                <label for="expectedNaturalGasValue">Consumo de gas aplicable : </label>
                                <input name="expectedNaturalGasValue"  placeholder="Consumo de gas aplicable.." type="number" class="w3-input" id="expectedNaturalGasValue"/>
                            </div>
                            <div class="form-group">
                                <label for="expectedWaterValue">Consumo de agua aplicable : </label>
                                <input name="expectedWaterValue" type="number" placeholder="Consumo de agua aplicable.." class="w3-input" id="expectedWaterValue"/>
                            </div>
                            <div class="form-group">
                                <label for="expectedEnergyValue">Consumo eléctrico aplicable : </label>
                                <input name="expectedEnergyValue" type="number" placeholder="Consumo eléctrico aplicable" class="w3-input" id="expectedEnergyValue"/>
                            </div>
                        </div>

                        <!-- Modal Footer -->
                        <div class="modal-footer">
                            <button type="submit" name="action" value="Calcular" class="btn btn-sm btn-success">Calcular</button>
                            <button type="submit" name="action" value="Guardar" class="btn btn-sm btn-primary">Guardar</button>
                            <button type="submit" name="action" value="Borrar" class="btn btn-sm btn-danger">Borrar</button>
                            <button name="action" value="Borrar" class="btn btn-sm btn-warning" data-dismiss="modal">Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
    <script src="js/Subsidy.js"></script>
</html>
