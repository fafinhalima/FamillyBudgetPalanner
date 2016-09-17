<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML >
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Orçamento Familiar</title>
        </head>
        <body>
            <h:form>
            <jsp:include page="cabecalho_n_menu.jsp" />
             <!-- === INCIA CONTEUDO === -->
             
            <div id="content">
                <div class="container background-white">
                    <div class="container">
                        <div class="row margin-vert-30">
                            <!-- Login -->
                            <div class="col-md-6 col-md-offset-3 col-sm-offset-3">
                                <form class="login-page">
                                    <div class="login-header margin-bottom-30">
                                        <h2>Acesse sua Conta</h2>
                                    </div>
                                    <div class="input-group margin-bottom-20">
                                        <span class="input-group-addon">
                                            <i class="fa fa-user"></i>
                                        </span>
                                        <h:inputText title="usuário" styleClass="form-control" value="#{usuario.login}"/>
                                    </div>
                                    <div class="input-group margin-bottom-20">
                                        <span class="input-group-addon">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                        
                                        <h:inputSecret styleClass="form-control" value="#{usuario.senha}"/>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label class="checkbox">
                                                <input type="checkbox">Stay signed in</label>
                                        </div>
                                        <div class="col-md-6">
                                                <h:commandButton styleClass="btn btn-primary pull-right" value="Fazer Login" action="#{usuario.onLogin}"/>
                                        </div>
                                    </div>
                                    <hr>
                                    <h4>Cadastre-se</h4>
                                    <p>
                                        <a href="cadastraUsuario.jsp">Clique Aqui</a> e cadastre-se agora |
                                        <a href="cadastraUsuario.jsp">Clique Aqui</a> e recuper sua senha
                                    </p>
                                </form>
                            </div>
                            <!-- FIM Login Box -->
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
