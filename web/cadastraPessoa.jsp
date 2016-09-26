<%-- 
    Document   : cadastraPessoa
    
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
                           
                            <!-- Categoria Box -->
                        <div class="col-md-6 col-md-offset-3 col-sm-offset-3">
                            <h:form styleClass="signup-page">
                                <div class="signup-header">
                                    <h2>Cadastre uma nova pessoa</h2>
                                    <p><a href="lacamento.jsp">Click aqui</a> para lançamento de entrada.</p>
                                </div>
                                <label>Nome</label>
                                <h:inputText title="nome" styleClass="form-control margin-bottom-20" value="#{pessoa.nome}" required="true" requiredMessage="Digite a descrição"/>
                                <label>CPF</label>
                                <h:inputText title="cpf" styleClass="form-control margin-bottom-20" value="#{pessoa.cpf}" required="true" requiredMessage="Digite a senha"/>
                                <label>Endereço</label>
                                <h:inputText title="endereco" styleClass="form-control margin-bottom-20" value="#{pessoa.endereco}" required="true" requiredMessage="Digite a senha"/>
                                 <label>Telefone</label>
                                 <h:inputText title="telefone" styleClass="form-control margin-bottom-20" value="#{pessoa.telefone}" required="true" requiredMessage="Digite a senha"/>
                                <label>Celular</label>
                                <h:inputText title="Senha" styleClass="form-control margin-bottom-20" value="#{pessoa.celular}" required="true" requiredMessage="Digite a senha"/>
                                <label>e-mail:</label>
                                <h:inputText title="e-mail" styleClass="form-control margin-bottom-20" value="#{pessoa.email}" required="true" requiredMessage="Digite a senha"/>
                                
                                  
                                <div class="row">
                                    <div class="col-lg-4 text-right">
                                        <h:commandButton styleClass="btn btn-primary pull-right"  action="#{pessoa.onInsert(usuario)}" value="Nova Categoria"   />                                      
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