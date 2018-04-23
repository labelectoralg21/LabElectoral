<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Laboratorio electoral</title>

<link rel="icon" href="laboratorio.jpg">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<img src="laboratorio.jpg" alt="Logo" class="flotanteizquierda">
<h1>LABORATORIO ELECTORAL</h1>
<p>Bienvenido al laboratorio electoral.<br>Elige el año y ley electoral, y la circunscripción que quieras aplicar.</p><br>
<br>
<form action="RedireccionarServlet">
 <label>Provincia:
  <select name="ley" id="ley">
    <optgroup label = "Ley">
    <option value="D'Hont">Ley D'Hont</option>
    <option value="Saint Lagüe">Saint Lagüe</option>
  </select>
 </label>
 
 <label>Año:
  <select name="ano" id="ano">
    <optgroup label = "Año">
    <option value="2016">2016</option>
    <option value="2015">2015</option>
  </select>
 </label>
 
 <label>Circunscripción:
  <select name="circu" id="circu">
    <optgroup label = "Circunscripción">
    <option value="provincia">Provincia</option>
    <option value="comunidad">Comunidad autónoma</option>
    <option value="pais">Única</option>
  </select>
 </label>
<br>
<button type="submit" class="btn btn-danger" style="margin-left:45%">Calcular</button>


</form> 

</body>
</html>

      