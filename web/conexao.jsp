<%-- 
    Document   : conexao
    Created on : 06/10/2016, 20:48:56
    Author     : Rafael
--%>

<%@page import="beans.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="org.jfree.chart.*"%>
<%@page import="org.jfree.chart.plot.*"%>
<%@page import="org.jfree.data.general.*"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset.*"%>

<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   
    
        
        
        <%
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fbp","root","root");
            Statement cmd = cn.createStatement();
            String sql = "select sum(valorLancamentoEntrada) as valor,descricao from categoria inner join lacamento_entrada on"+ 
                        " categoria.codigo= lacamento_entrada.categoriaLacamentoEntrada"+
                        " where categoria.loginUsuario = 'admin' and dataLancamentoEntrada >= date_add(now(), interval -3 month)"+
                        " group by descricao";
            
            
            ResultSet rs = cmd.executeQuery(sql);
            
        %>
    

