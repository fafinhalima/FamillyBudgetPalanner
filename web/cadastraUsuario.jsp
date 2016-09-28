<%-- 
    Document   : cadastraUsuario
 
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
        <title>Cadastro</title>
    </head>
    <body>
         <jsp:include page="cabecalho_n_menu.jsp" />
                <!-- === INCIA CONTEUDO === -->
           
            <div id="content">
                <div class="container background-white">
                    <div class="container">
                        <div class="row margin-vert-30">
                           
                            <!-- Box -->
                        <div class="col-md-6 col-md-offset-3 col-sm-offset-3">
                            <h:form styleClass="signup-page">
                                <div class="signup-header">
                                    <h2>Registre-se</h2>
                                    <p><a href="index.jsp">Click Aqui</a> para voltar</p>
                                </div>
                                <label>Descrição</label>
                                <h:inputText title="categoria" styleClass="form-control margin-bottom-20" value="#{usuario.login}" required="true" requiredMessage="Digite a descrição"/>
                                <label>Senha</label>
                                <h:inputSecret title="Senha" styleClass="form-control margin-bottom-20" value="#{usuario.senha}" required="true" requiredMessage="Digite a senha"/>
                                <label>e-mail:</label>
                                <h:inputText title="e-mail" styleClass="form-control margin-bottom-20" value="#{usuario.email}" required="true" requiredMessage="Digite a senha"/>
                                
                                  
                                <div class="row">
                                    <div class="col-lg-4 text-right">
                                        <h:commandButton styleClass="btn btn-primary pull-right"  action="#{usuario.onInsert()}" value="Nova Categoria"   />                                      
                                    </div>
                                </div>
                            </h:form>
                        </div>
                        <!-- Fim  Box -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- === FIM CONTEUDO === -->
        <jsp:include page="rodape_login.jsp" />
    </body>
</html>
</f:view>
