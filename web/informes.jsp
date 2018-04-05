<%-- 
    Document   : informes
    Created on : Oct 17, 2017, 6:31:51 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Servicios publicos</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
<body>
<!-- Header -->
<header class="w3-container w3-teal w3-padding" id="myHeader">
     <a href="index.jsp" class="hoverable"><button class="w3-btn w3-xlarge w3-theme-dark w3-hover-teal"><img src="imagenes/back.png">
  </button></a>
  <div class="w3-center">
  <div class="w3-padding-25" style="text-align: right;">
  </div>
  <h4>SERVICIOS PUBLICOS</h4>
  <h1 class="w3-xxxlarge w3-animate-bottom">GESTION DE INFORMES</h1>
    <div class="w3-padding-32">
      <button class="w3-btn w3-xlarge w3-theme-dark w3-hover-teal" onclick="document.getElementById('reports').style.display='block'" style="font-weight:900;">GESTIONAR</button>
    </div>
  </div>
</header>

<!--Modal informes-->
<div id="reports" class="w3-modal">
  <div class="w3-modal-content w3-card-4 w3-animate-top">
    <header class="w3-container w3-theme-l1"> 
      <span onclick="document.getElementById('reports').style.display='none'"
      class="w3-button w3-display-topright">×</span>
      <h2>Generar informe</h2>
    </header>
    <div class="w3-padding">
      <form>
        <div class="w3-section">
          <div class="w3-section w3-half">      
            <input class="w3-input" type="date" required>
            <label>Fecha inicial</label>
          </div>
          <div class="w3-section w3-half">      
            <input class="w3-input" type="date" required>
            <label>Fecha final</label>
          </div>
        </div>
        <div class="w3-section">
          <button class="w3-btn w3-theme w3-block" style="size: 500;">Generar</button>
        </div>
      </form>
    </div>
  </div>
</div>

<br><br>
<div class="w3-container">
<table class="w3-table w3-striped w3-bordered">
<thead>
<tr class="w3-theme">
  <th>prueba</th>
  <th>prueba</th>
  <th>prueba</th>
  <th>prueba</th>
  <th>prueba</th>
</tr>
</thead>
<tbody>
<tr>
  <td>prueba</td>
  <td>prueba</td>
  <td>prueba</td>
  <td>prueba</td>
  <td>prueba</td>
</tr>
</tbody>
</table>
</div>

</body>
</html>