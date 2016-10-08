<%-- 
    Document   : gerenciaCategoria
    
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
        
            <jsp:include page="cabecalho.jsp" />
             <!-- === INCIA CONTEUDO === -->
           
            <div id="content">
                <div class="container background-white">
                    <div class="container">
                        <div class="row margin-vert-30">
                           
                            <!-- Categoria Box -->
                        <div class="col-md-6 col-md-offset-3 col-sm-offset-3">
                            <h:form styleClass="signup-page">
                                <div class="signup-header">
                                    <h2>Cadastre uma nova categoria</h2>
                                    <p><a href="categoria.jsp">Click aqui</a> para voltar.</p>
                                </div>
                                
                                <label>Descrição</label>
                                <h:inputText title="categoria"  styleClass="form-control margin-bottom-20" value="#{categoria.descricao}" required="true" requiredMessage="Digite a descrição"/>
                                <label>Tipo de entrada e saida</label>
                                <div class="row">
                                    <div class="col-lg-4 text-right">
                                        <h:selectOneMenu id="selectCar" value="#{tipo.codTipoSaida}" >  
                                            <f:selectItems value="#{categoria.buscaTipoEntradaSaida()}"/>

                                        </h:selectOneMenu>
                                    </div>
                                </div>
                                <br/>
                                <div class="row">
                                    <div class="col-lg-4 text-right">
                                        <h:commandButton styleClass="btn btn-primary pull-right"  action="#{categoria.onInsert(usuario,tipo)}" value="Nova Categoria"  />                                      
                                    </div>
                                </div>
                            </h:form>
                        </div>
                        <!-- Fim Categoria Box -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- === FIM CONTEUDO === -->
           
          <jsp:include page="rodape.jsp" />
          
    </body>
</html>
</f:view>