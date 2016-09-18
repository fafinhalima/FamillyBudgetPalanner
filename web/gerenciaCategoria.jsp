<%-- 
    Document   : gerenciaCategoria
    Created on : 17/09/2016, 20:30:09
    Author     : Rafael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h:form>
            <jsp:include page="cabecalho_n_menu.jsp" />
             <!-- === INCIA CONTEUDO === -->
             
            <div id="content">
                <div class="container background-white">
                    <div class="container">
                        <div class="row margin-vert-30">
                           
                            <!-- Categoria Box -->
                        <div class="col-md-6 col-md-offset-3 col-sm-offset-3">
                            <form class="signup-page">
                                <div class="signup-header">
                                    <h2>Cadastre uma nova categoria</h2>
                                    <p><a href="lacamento.jsp">Click aqui</a> para lançamento de entrada.</p>
                                </div>
                                <label>Descrição</label>
                                <h:inputText title="categoria" styleClass="form-control margin-bottom-20" value="#{categoria.descricao}" required="true" requiredMessage="Digite a descrição"/>
                                <div class="row">
                                    <div class="col-lg-4 text-right">
                                        <h:commandButton styleClass="btn btn-primary" action="#{categoria.onInsert()}" rendered="#{categoria.codigo == null}" value="Inserir Nova Categoria"></h:commandButton>
                                        <h:commandButton styleClass="btn btn-primary" action="#{categoria.onInsert()}" rendered="#{categoria.codigo != null}" value="Alterar Categoria"></h:commandButton>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- Fim Categoria Box -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- === FIM CONTEUDO === -->
           
          <jsp:include page="rodape.jsp" />
          
         </h:form>
    </body>
</html>
</f:view>