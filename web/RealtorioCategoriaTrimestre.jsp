<%-- 
    Document   : RealtorioCategoriaTrimestre
    Created on : 06/10/2016, 22:25:20
    Author     : Rafael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="conexao.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
         <%
       
                       try{
                            DefaultPieDataset data= new DefaultPieDataset();
                           while(rs.next())
                           {
                               data.setValue(rs.getString("descricao"),rs.getInt(0));
                           }
                               
                           JFreeChart grafico = ChartFactory.createPieChart("Categoria do Lançamento",data,true,true,true);
                           
                           response.setContentType("image/JPEG");
                           OutputStream sa = response.getOutputStream();
                           
                           ChartUtilities.writeChartAsJPEG(sa,grafico,600,600);
                               
                           
                       }catch(Exception ex)
                       {
                           out.print(ex);
                       }
                  %>
    </body>
</html>
