<%-- 
    Document   : relatorioMensal
    
    Author     : Rafael
--%>

<%@page import="org.jfree.data.category.DefaultCategoryDataset"%>
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
            String sql = "select sum(valorLancamentoEntrada) as valor,descricaoTipoSaida as descricao from categoria inner join lacamento_entrada on"+ 
                        " categoria.codigo= lacamento_entrada.categoriaLacamentoEntrada"+
                        " inner join tipo_entrada_saida on tipo_entrada_saida.codTipoSaida  = categoria.tipo_entrada_saida "+
                        " where categoria.loginUsuario = '"+UsuarioBean.loginUsuario+"' and Year(dataLancamentoEntrada) = Year(now()) and month(dataLancamentoEntrada)= month(now()) "+
                        " group by descricao";
            
            
            ResultSet rs = cmd.executeQuery(sql);
               
            try{
                            DefaultCategoryDataset data= new DefaultCategoryDataset();
                           while(rs.next())
                           {
                               data.setValue(rs.getDouble(1),rs.getString("descricao"),rs.getDouble(1) +"-"+ rs.getString("descricao") );
                           }
                               
                           JFreeChart grafico = ChartFactory.createBarChart("Tipo de Lançamento Mensal / Equilibrio Financeiro","Tipo de entrada","Valor",data,PlotOrientation.VERTICAL,true,true,true);
                           
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
