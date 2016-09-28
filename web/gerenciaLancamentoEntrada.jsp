<%-- 
    Document   : gerenciaLancamentoEntrada
    
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
         <jsp:include page="cabecalho.jsp" />
                <!-- === INCIA CONTEUDO === -->
           
            <div id="content">
                <div class="container background-white">
                    <div class="container">
                        <div class="row margin-vert-30">
                           
                            <!--  Box -->
                        <div class="col-md-6 col-md-offset-3 col-sm-offset-3">
                            <h:form styleClass="signup-page">
                                <div class="signup-header">
                                    <h2>Lançamento de Entrada</h2>
                                    <p><a href="lacamento.jsp">Click aqui</a> para lançamento de entrada.</p>
                                </div>
                                <label>Descrição: </label>
                                <h:inputText title="lancamento" styleClass="form-control margin-bottom-20" value="#{lEntrada.descricaoLacamentoEntrada}" required="true" requiredMessage="Digite a descrição"/>
                                <label>Data de lançamento: </label>
                                <h:inputText title="data" styleClass="form-control margin-bottom-20" value="#{lEntrada.dataLancamentoEntrada}" required="true" requiredMessage="Digite uma data de lançamento">
                                    <f:convertDateTime type="date" pattern="dd/mm/yyyy" />
                                </h:inputText>
                                <label>Recebido de: </label>
                                <div class="row">
                                    <div class="col-lg-4 text-right">
                                        <h:selectOneMenu id="selectPes" value="#{pessoa.codigoPessoa}" >  
                                            <f:selectItems value="#{pessoa.busca(usuario)}"/>

                                        </h:selectOneMenu>
                                    </div>
                                </div>
                                
                                <label>Selecione uma categoria de lançamento: </label>
                                <div class="row">
                                    <div class="col-lg-4 text-right">
                                        <h:selectOneMenu id="selectCat" value="#{categoria.codigo}" >  
                                            <f:selectItems value="#{categoria.buscaCategoria(usuario)}"/>

                                        </h:selectOneMenu>
                                    </div>
                                </div>
                                   <label>Valor: </label>
                                   <h:inputText title="valor" styleClass="form-control margin-bottom-20" value="#{lEntrada.valorLancamentoEntrada}" required="true" requiredMessage="Digite um valor"/>
                                
                                <div class="row">
                                    <div class="col-lg-4 text-right">
                                        <h:commandButton styleClass="btn btn-primary pull-right"  action="#{lEntrada.onInsert(usuario, pessoa, categoria)}" value="Novo Lançamento"   />                                      
                                    </div>
                                </div>
                            </h:form>
                        </div>
                        <!-- Fim Box -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- === FIM CONTEUDO === -->
        <jsp:include page="rodape.jsp" />
    </body>
</html>
</f:view>
