<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
    <link href="css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen"  href="css/bootstrap-datetimepicker.min.css">
      <link rel="stylesheet" href="css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="css/bootstrap.css">

  <link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>

  <script type="text/javascript">
//auto expand textarea
function adjust_textarea(h) {
    h.style.height = "45px";
    h.style.height = (h.scrollHeight)+"px";
}
</script>

  <style type="text/css">
    .bs-example{
      margin: 20px;
    }
  /* Fix alignment issue of label on extra small devices in Bootstrap 3.2 */
    .form-horizontal .control-label{
        padding-top: 7px;
    }

    body{
  background: #348A96;
}
.form-style-8{
  font-family: 'Open Sans Condensed', arial, sans;
  width: 500px;
  padding: 30px;
  background: #FFFFFF;
  margin: 50px auto;
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
  -moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
  -webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);

}
.form-style-8 h2{
  background: #4D4D4D;
  text-transform: uppercase;
  font-family: 'Open Sans Condensed', sans-serif;
  color: #797979;
  font-size: 18px;
  font-weight: 100;
  padding: 20px;
  margin: -30px -30px 30px -30px;
}
.form-style-8 input[type="text"],
.form-style-8 input[type="date"],
.form-style-8 input[type="datetime"],
.form-style-8 input[type="email"],
.form-style-8 input[type="number"],
.form-style-8 input[type="search"],
.form-style-8 input[type="time"],
.form-style-8 input[type="url"],
.form-style-8 input[type="password"],
.form-style-8 textarea,
.form-style-8 select 
{
  box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  outline: none;
  display: block;
  width: 100%;
  padding: 7px;
  border: none;
  border-bottom: 1px solid #ddd;
  background: transparent;
  margin-bottom: 10px;
  font: 16px Arial, Helvetica, sans-serif;
  height: 45px;
}
.form-style-8 textarea{
  resize:none;
  overflow: hidden;
}
.form-style-8 input[type="button"], 
.form-style-8 input[type="submit"]{
  -moz-box-shadow: inset 0px 1px 0px 0px #45D6D6;
  -webkit-box-shadow: inset 0px 1px 0px 0px #45D6D6;
  box-shadow: inset 0px 1px 0px 0px #45D6D6;
  background-color: #2CBBBB;
  border: 1px solid #27A0A0;
  display: inline-block;
  cursor: pointer;
  color: #FFFFFF;
  font-family: 'Open Sans Condensed', sans-serif;
  font-size: 14px;
  padding: 8px 18px;
  text-decoration: none;
  text-transform: uppercase;
}
.form-style-8 input[type="button"]:hover, 
.form-style-8 input[type="submit"]:hover {
  background:linear-gradient(to bottom, #34CACA 5%, #30C9C9 100%);
  background-color:#34CACA;
}

</style>
</head>
<body>

  <div class="container">
    <div class="form-style-8">   
<form action="MainController" >
  <h2>Add New Task</h2>
<input type="text" name="taskname" placeholder="Task To Do">

 <div id="datetimepicker1" class="input-append date"><input type="text" data-format="yyyy-MM-dd" name="taskdate" placeholder="Date"></input> <span class="add-on glyphicon glyphicon-calendar"></span></div>




<div id="datetimepicker2" class="input-append date">
        <input type="text" data-format="hh:mm" name="tasktime" placeholder="Time"></input>

        <span class="add-on">
         <span class="glyphicon glyphicon-time"></span>
        </span>
      </div>


<select name="category" title="select category">
      <option value="General">General</option>
      <option value="Personal">Personal</option>
      <option value="Work">Work</option>
    </select>  


 <select name="priority" title="select priority">
    <option value="5">5</option>
    <option value="4">4</option>
    <option value="3">3</option>
    <option value="2">2</option>
    <option value="1">1</option>
  </select>
  
<input type="hidden" name="handler" value="addNewTask">
<input type="submit" value="OK" >
<%//check for the null conditions with javascript %>
<br>
</form>
</div>

</div>
    <script type="text/javascript" src="js/jquery.min.js">
    </script> 
    <script type="text/javascript" src="js/bootstrap.min.js">
    </script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js">
    </script>
 
    <script type="text/javascript">
      $('#datetimepicker1').datetimepicker({
        pickTime:false
      });
      
    </script>
        <script type="text/javascript">
      $('#datetimepicker2').datetimepicker({
        pickDate:false
      });
      
    </script>
</body>
</html>