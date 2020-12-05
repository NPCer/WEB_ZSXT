<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.mouseOut{
			background:#708090;
			color:#FFFAFA;
		}
		.mouseOver{
			background:#FFFAFA;
			color:#000000;
		}
	
	</style>
	<script type="text/javascript">
		var xmlHttp;
		var completeDiv;
		var inputFiled;
		var nameTable;
		var nameTableBody;
		
		function createXMLHttp(){
			
			if(window.XMLHttpRequest){
	    		xmlHttp = new XMLHttpRequest();
			}
			if (window.ActiveXObject){
    			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    			if (!xmlHttp){
        		xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    			}
    		}
		}
		
		function initVars(){
			inputFiled = document.getElementById("names");
			nameTable = document.getElementById("name_table");
			nameTableBody = document.getElementById("name_table_body");
			completeDiv = document.getElementById("pop");
		}
		
		function findNames(){
			
			initVars();
			if(inputFiled.value.length>0){
				createXMLHttp();
				var url="FindNameServlet?names="+escape(inputFiled.value);
				xmlHttp.open("GET",url,true);
				xmlHttp.onreadystatechange =callback;
				xmlHttp.send(null);
			}
		}
		
		
		function callback(){
			if(xmlHttp.readyState==4){
				if(xmlHttp.status==200){
					var name = xmlHttp.responseXML.getElementsByTagName("name")[0].firstChild.data;
					clearName();
					setName(xmlHttp.responseXML.getElementsByTagName("name"));					
				}else if(xmlHttp.status==204){
					clearName();
				}
			}
		}
		
		function setName(nameStr){
		
			clearName();
			var size = nameStr.length;
			setOffsets();
			
			var row,cell,txtNode;
			
			for(var i = 0;i<size; i++){
				var nextNode = nameStr[i].firstChild.data;
				row = document.createElement("tr");
				cell = document.createElement("td");
				
				cell.onmouseover = function(){this.className='mouseOut';};
				cell.onmouseout = function(){this.className='mouseOver';};
				cell.setAttribute("bgcolor","#FFFAFA");
				cell.setAttribute("border","0");
				cell.onclick = function(){populateName(this);};
			
				txtNode = document.createTextNode(nextNode);
				cell.appendChild(txtNode);
				row.appendChild(cell);
				nameTableBody.appendChild(row);
			}
		}
		
		function setOffsets(){
			
			var end = inputFiled.offsetWidth;
			var left = caculateOffSetLeft(inputFiled);
			var top = caculateOffSetTop(inputFiled) + inputFiled.offsetHeight;
			
			completeDiv.style.border = "black 1px solid";
			completeDiv.style.left = left + "px";
			completeDiv.style.top = top + "px";
			completeDiv.style.width = end + "px";
			nameTable.style.width = end + "px";
		}
		
		function caculateOffSetLeft(filed){
			return caculateOffSet(filed,"offsetLeft");
		}
		
		function caculateOffSetTop(filed){
			return caculateOffSet(filed,"offsetTop");
		}
		
		function caculateOffSet(filed,attr){
			var offset = filed[attr];
			//while(filed){
			//	offset += filed[attr];
			//	filed = filed.offsetParent;
			//}
			return offset;
		}
		
		function populateName(cell){
			inputFiled.value = cell.firstChild.nodeValue;
			clearName();
		}
		
		function clearName(){
			var size = nameTableBody.childNodes.length;
			for(var i = size -1 ;i>= 0 ;i--){
				nameTableBody.removeChild(nameTableBody.childNodes[i]);
			}
			completeDiv.style.border = "none";
		}
	</script>
  </head>
  
  <body>
  	Names:<input type="text" size="20" id="names" onkeyup="findNames();" />
  	<div style="postion:absolute;" id="pop">
  		<table id="name_table" bgcolor="#FFFAFA" border="0" cellspacing="0" cellpadding="0"/>
  			<tbody id="name_table_body">
  			</tbody>
  			
  		</table>
  	</div>
  </body>
</html>
