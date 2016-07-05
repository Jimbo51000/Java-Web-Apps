<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<link href="css/stylish-portfolio.css" rel="stylesheet">

	<!-- Custom Fonts -->
	<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-combined.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" media="screen"  href="css/bootstrap-datetimepicker.min.css">

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<style type="text/css">

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

	</style>
<script language="javascript" type="text/javascript">
var tid;
var taskname;
var taskdate;
var tasktime;
var priority;
var category;
var taskstatus;
function run(item){
	var id=item.id;
	//alert(id);
	//document.getElementById('todotable')
    document.getElementById(id).onclick = function(event){
        event = event || window.event; //for IE8 backward compatibility
        var target = event.target || event.srcElement; //for IE8 backward compatibility
        while (target && target.nodeName != 'TR') {
            target = target.parentElement;
        }
        var cells = target.cells; //cells collection
        //var cells = target.getElementsByTagName('td'); //alternative
        if (!cells.length || target.parentNode.nodeName == 'THEAD') { // if clicked row is within thead
            return;
        }
       
		tid=cells[0].innerHTML;
		taskname=cells[1].innerHTML;
		category=cells[2].innerHTML;
		taskdate=cells[3].innerHTML;
		tasktime=cells[4].innerHTML;
		priority=cells[5].innerHTML;
		if(id=='todotable'){
			taskstatus='todo';
		}
		else if(id=='pendingtable'){
			taskstatus='pending';
		}
		//alert('from run'+taskname);
		var table=document.getElementById(id);
	
 		rows = table.rows;
 		rowcount = rows.length;
 		
	for( r=1; r<rowcount; r++) {
	    cells1 = rows[r].cells;
	    //alert("6"+cells1[6]);
	    //alert("7"+cells1[7]);
	    cells1[6].style.display="none";
		cells1[6].style.visibility="collapse";
		cells1[7].style.display="none";
		cells1[7].style.visibility="collapse";
	    //alert(cells1[r][0].innerHTML);
	    //alert("xxxx");
	} 
	//alert('before edicell');
	/*var elems = table.getElementsByClassName("editcell");
	alert('after classcall');
	   for(var i = 0; i<elems.length; i++) {
	     elems[i].style.display = "none";
	     elems[i].style.visibility="collapse";
	   }
	  
	   alert('after edicell');
*/		
		cells[6].style.display="inline-table";
		cells[6].style.visibility="visible";
		cells[7].style.display="inline-table";
		cells[7].style.visibility="visible";
		
		
       // alert(val1);

    }
}

function editTask(item){
	
	//run();
	// var elt = document.getElementById('editselect');
	//alert('editask');
	var elt=document.getElementById(item.id);
	
	    if (elt.selectedIndex == -1)
	        return null;
		var option=elt.options[elt.selectedIndex].value;
	     //alert(elt.options[elt.selectedIndex].value);
	     if(option=='taskname'){
	     	var input;
	     	
	     	input=prompt("Please enter the new task",window.taskname );
		     document.location.href="MainController?handler=editTask&option="+option+"&tid="+tid+"&taskname="+input+"&taskdate="+taskdate+"&tasktime="+tasktime+"&priority="+priority+"&category="+category+"&taskstatus="+taskstatus;

	     }
	     else if(option=='category'){
	    	 var input = prompt("Please enter the new category",window.category );
		     document.location.href="MainController?handler=editTask&option="+option+"&tid="+tid+"&taskname="+taskname+"&taskdate="+taskdate+"&tasktime="+tasktime+"&priority="+priority+"&category="+input+"&taskstatus="+taskstatus;

	    	
	     }
	     else if(option=='taskdate'){
	    	 var input = prompt("Please enter the new date",window.taskdate);
		     document.location.href="MainController?handler=editTask&option="+option+"&tid="+tid+"&taskname="+taskname+"&taskdate="+input+"&tasktime="+tasktime+"&priority="+priority+"&category="+category+"&taskstatus="+taskstatus;

	     }
	     else if(option=='tasktime'){
	    	 var input = prompt("Please enter the new time",window.tasktime );
		     document.location.href="MainController?handler=editTask&option="+option+"&tid="+tid+"&taskname="+taskname+"&taskdate="+taskdate+"&tasktime="+input+"&priority="+priority+"&category="+category+"&taskstatus="+taskstatus;

	     }
	     else if(option=='priority'){
	    	 var input = prompt("Please enter the new priority",window.priority );
		     document.location.href="MainController?handler=editTask&option="+option+"&tid="+tid+"&taskname="+taskname+"&taskdate="+taskdate+"&tasktime="+tasktime+"&priority="+input+"&category="+category+"&taskstatus="+taskstatus;
	    	 
	     }
	    
	    
	     
}

function taskComplete(item){
	var id=item.value;
	//alert('task complete js , tid '+id);
    document.location.href="MainController?handler=taskComplete&tid="+id;
	
	
}

function empty(){
	//alert('before');
	
	
	
}

function deleteTask(){
	//alert(tid);
	document.location.href="MainController?handler=deleteTask&tid="+tid;
}
</script>
</head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<body onload="empty()" bgcolor="#348A96" style="background:#348A96;filter:blur(20px);">
	<!--HTML elements -->

		<!-- Navigation -->
	<a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
	<nav id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
			<li class="sidebar-brand">
				<a href="#top"  onclick = $("#menu-close").click(); >${sessionScope.username}</a>
			</li>
			<li>
				<a href="#" onclick = "$("#menu-close").click();" >Show Pending</a>
			</li>
			<li>
				<a href="#about" onclick = $("#menu-close").click(); >Show Completed</a>
			</li>
			<li>
				<a href="#services" onclick = $("#menu-close").click(); >Todays Tasks</a>
			</li>
			<li>
				<a href="#portfolio" onclick = $("#menu-close").click(); >General</a>
			</li>
			<li>
				<a href="#contact" onclick = $("#menu-close").click(); >Work</a>
			</li>
		</ul>
	</nav>


	<div name="titlebar" style="height:80px"  style="background:#ffffff;">

	</div>
<!--JSP tags-->
		<c:set var="flag" scope="session" value="false"></c:set>
		<c:forEach items="${sessionScope.taskset }" var="task">
			<c:if test="${task.taskstatus=='todo'}">
				<c:set var="flag" scope="session" value="true"></c:set>
			</c:if>
	</c:forEach>
		<c:if test="${flag=='false'}">
		<script type="text/javascript">
			alert('No tasks to do');
		</script>
	</c:if>

	<!-- Main Container-->
	<div class="form-style-8" >

		<div name="topcontainer" >
			<!-- Header -->
			<header id="top" class="header">
				<div class="text-vertical-center">
					<div class="form-style-8"> 
					<h2>To Do Tasks</h2>

					<br>


	
	<table id="todotable" onclick="run(this)" class="table table-bordered table-hover table-condensed">
		<thead>
							<tr  bgcolor="#000000">
								<th align="center" text-shadow: 2px 2px #ff0000;><font color="#FFFFFF">Task</font></th>
								<th align="center"><font color="#FFFFFF">Category</font></th>
								<th align="center"><font color="#FFFFFF">DueDate</font></font></font></th>
								<th align="center"><font color="#FFFFFF">Time</font></font></th>
								<th align="center"><font color="#FFFFFF">Priority</font></th>
							</tr>
						</thead>
	<tbody>
	
		<c:forEach items="${sessionScope.taskset }" var="task">
			<c:if test="${task.taskstatus=='todo'}">
			<!-- <tr onclick="run(this)"> -->
			<tr>
				<%-- <td><input type="hidden" name="celltid" value="<c:out value="${task.tid }"/>"></td>
				 --%>
				 <td style="visibility: collapse;display:none;">${task.tid}</td>
				 <td>${task.taskname }</td>
				<td>${task.category}</td>
				<td>${task.taskdate}</td>
				<td>${task.tasktime}</td>
				<td>${task.priority}</td>
				<td style="visibility: collapse;display:none;" class="editcell"><select id="<c:out value="${task.tid}"/>" onchange="editTask(this)">
				<option value="default">--Select The Option--</option>
				<option value="taskname">Change TaskName</option>
				<option value="category">Change category</option>
				<option value="taskdate">Change Taskdate</option>
				<option value="tasktime">Change TaskTime</option>
				<option value="priority">Change Priority</option>
				</select></td>
				<td style="visibility: collapse;display:none;" class="deletecell"><input type="button" name="delete" value="Delete" onclick="deleteTask()"></td>
				<td><input type="checkbox" value="<c:out value="${task.tid}"/>" onclick="taskComplete(this)"></td>
			</tr>
			</c:if>
			
		</c:forEach>
	</tbody>

	</table>

	<form action="MainController" name="form1">
		<input type="submit" name="ok" value="Add new Task" class="btn btn-dark btn-lg"> 
		<input type="hidden" name="handler" value="addHandler">
	</form>
	
					</div>
			</div>


</header>

</div><!-- top container div-->
</div>

<!-- Finished The Main div-->
<!-- 	<script type="text/javascript">
		cell32 = document.getElementByName("celltid");
		cell32.style.display = "none";
	</script>
	
 -->
 
 	<div name="titlebar" style="height:80px"  style="background:#ffffff;">

	</div>
 <div class="form-style-8" >

		<div name="topcontainer" >
			<!-- Header -->
			<header id="top" class="header">
				<div class="text-vertical-center">
					<div class="form-style-8"> 
					<h2>Pending Tasks</h2>

					<br>
 
	<table id="pendingtable" onclick="run(this)" class="table table-bordered table-hover table-condensed">
	<thead>
							<tr  bgcolor="#000000">
								<th align="center" text-shadow: 2px 2px #ff0000;><font color="#FFFFFF">Task</font></th>
								<th align="center"><font color="#FFFFFF">Category</font></th>
								<th align="center"><font color="#FFFFFF">DueDate</font></font></font></th>
								<th align="center"><font color="#FFFFFF">Time</font></font></th>
								<th align="center"><font color="#FFFFFF">Priority</font></th>
							</tr>
						</thead>
	<tbody>
	
		<c:forEach items="${sessionScope.taskset }" var="task">
			<c:if test="${task.taskstatus=='pending'}">
			<!-- <tr onclick="run()"> -->
			
				<%-- <td><input type="hidden" name="celltid" value="<c:out value="${task.tid }"/>"></td>
				 --%>
				 
				 <tr>
				 <td style="visibility: collapse;display:none;">${task.tid}</td>
				 <td>${task.taskname }</td>
				<td>${task.category}</td>
				<td>${task.taskdate}</td>
				<td>${task.tasktime}</td>
				<td>${task.priority}</td>
				<td style="visibility: collapse;display:none;" class="editcell"><select id="<c:out value="${task.tid}"/>" onchange="editTask(this)">
				<option value="default">--Select The Option--</option>
				<option value="taskname">Change TaskName</option>
				<option value="category">Change category</option>
				<option value="taskdate">Change Taskdate</option>
				<option value="tasktime">Change TaskTime</option>
				<option value="priority">Change Priority</option>
				</select></td>
				<td style="visibility: collapse;display:none;" class="deletecell"><input type="button" name="delete" value="Delete" onclick="deleteTask()" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></td>
				<td><input type="checkbox" value="<c:out value="${task.tid}"/>" onclick="taskComplete(this)"></td>
			</tr>
			</c:if>
			
		</c:forEach>
	</tbody>
	</table>
	
					</div>
			</div>


</header>

</div><!-- top container div-->
</div>
	    <script type="text/javascript" src="js/jquery.min.js">
    </script> 
    <script type="text/javascript" src="js/bootstrap.min.js">
    </script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js">
    </script>


     <!-- jQuery -->
  <script src="js/jquery.js"></script>

  <!-- Bootstrap Core JavaScript -->

  <script src="js/bootstrap.min.js"></script>

  <!-- Custom Theme JavaScript -->
  <script>
    // Closes the sidebar menu
    $("#menu-close").click(function(e) {
    	e.preventDefault();
    	$("#sidebar-wrapper").toggleClass("active");
    });

    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
    	e.preventDefault();
    	$("#sidebar-wrapper").toggleClass("active");
    });

    // Scrolls to the selected menu item on the page
    $(function() {
    	$('a[href*=#]:not([href=#])').click(function() {
    		if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

    			var target = $(this.hash);
    			target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
    			if (target.length) {
    				$('html,body').animate({
    					scrollTop: target.offset().top
    				}, 1000);
    				return false;
    			}
    		}
    	});
    });
    </script>
</body>
</html>