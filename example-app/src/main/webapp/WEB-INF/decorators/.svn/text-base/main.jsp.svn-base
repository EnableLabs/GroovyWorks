<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><decorator:title /></title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/main.css" />
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/menu.css" />
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/menu-styles.css" />
	<script type="text/javascript"><!--//--><![CDATA[//><!--
		sfHover = function() {
			var sfEls = document.getElementById("menu").getElementsByTagName("LI");
			for (var i=0; i<sfEls.length; i++) {
				sfEls[i].onmouseover=function() {
					this.className+=" sfhover";
				}

				/*
				sfEls[i].onmouseout=function() {
					setTimeout (function () {
						this.className=this.className.replace(new RegExp(" sfhover\\b"), "");
					}, 1000);
				}
				*/
				sfEls[i].onmouseout=function() {
					this.className=this.className.replace(new RegExp(" sfhover\\b"), "");
				}
			}
		}
		if (window.attachEvent) window.attachEvent("onload", sfHover);
	//--><!]]></script>
	<decorator:head /><%--pulls the header from the page we are decorating and inserts it here --%>
</head>
<body>
<decorator:body />
</body>
</html>
