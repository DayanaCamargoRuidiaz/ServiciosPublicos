<%-- 
    Document   : Subsidy
    Created on : 5/11/2017, 01:09:03 PM
    Author     : Jose
--%>


<%@page import="java.util.List"%>
<%@page import="Entidades.EntReport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String info = request.getAttribute("info") != null ? request.getAttribute("info").toString() :  null;
    List<EntReport> list = (List<EntReport>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Informes</title>
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
                <h1 class="w3-xxxlarge w3-animate-bottom">INFORMES</h1>
            </div>
        </header>
            <form action="./ReportServlet" method="post">
            <%if (list != null && !list.isEmpty()) {%>  
            <div class="form-group col-lg-7 col-sm-offset-3" style="text-align: center">
                <div class="table-responsive" style="   padding-top: 43px;">
                   <table class="w3-table w3-striped w3-bordered">
                        <thead>
                            <tr class="w3-theme">
                                <th>HOGAR</th>
                                <th>CICLO</th>
                                <th>AGUA</th>
                                <th>ELECTRICIDAD</th>
                                <th>GAS</th>
                                <th>AGUA</th>
                                <th>ELECTRICIDAD</th>
                                <th>GAS</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (EntReport report : list) {%>
                                <td><%=report.getIdHome()%></td>
                                <td><%=report.getIdCycle()%></td>
                                <td><%=report.getWater()%></td>
                                <td><%=report.getElectricity()%></td>
                                <td><%=report.getNaturalGas()%></td>
                                <td><%=report.getWaterValueObtained()%></td>
                                <td><%=report.getEnergyValueObtained()%></td>
                                <td><%=report.getNaturalGasValueObtained()%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
            <%} else {%>
            NO SE ENCONTRARON REGISTROS PARA MOSTRAR
            <%}%>
            
        </form>
    </body>
</html>
