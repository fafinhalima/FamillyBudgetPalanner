<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<%@include file="conexao.jsp" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@include file="cabecalho.jsp" %>
          
         <%
             
             
       
                       try{
                            DefaultPieDataset data= new DefaultPieDataset();
                            
                           while( rs.next())
                           {
                               data.setValue(rs.getString("descricao"),rs.getDouble(1));
                           }
                           
                            
                            JFreeChart grafico = ChartFactory.createPieChart("Relatório Trimestral de Lançamento por Categoria",data,true,true,true);
                           
                           response.setContentType("image/JPEG");
                           OutputStream sa = response.getOutputStream();
                           
                           ChartUtilities.writeChartAsJPEG(sa,grafico,600,600);
                               
                           
                       }catch(Exception ex)
                       {
                           out.print(ex);
                       }
                  %>
          
        <%@include file="rodape.jsp" %>
    </body>
</html>
