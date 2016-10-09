<%-- 
    Document   : relatorioMensal
    
    Author     : Rafael
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="beans.UsuarioBean"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="org.jfree.chart.*"%>
<%@page import="org.jfree.chart.plot.*"%>
<%@page import="org.jfree.data.general.*"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fbp","root","root");
            Statement cmd = cn.createStatement();
            String sql = "select sum(valorLancamentoEntrada) as valor,descricao from categoria inner join lacamento_entrada on"+ 
                        " categoria.codigo= lacamento_entrada.categoriaLacamentoEntrada"+
                        " where categoria.loginUsuario = '"+UsuarioBean.loginUsuario+"' and Year(dataLancamentoEntrada) = Year(now()) and month(dataLancamentoEntrada)= month(now()) and tipo_entrada_saida = 2"+
                        " group by descricao";
            
            
            ResultSet rs = cmd.executeQuery(sql);
               
            try{
                            DefaultPieDataset data= new DefaultPieDataset();
                           while(rs.next())
                           {
                               data.setValue(rs.getString("descricao"),rs.getDouble(1));
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
