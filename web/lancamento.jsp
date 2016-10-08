<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML ">
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Lancamento</title>
        </head>
        <body>
            <h:form>
                 <jsp:include page="cabecalho.jsp" />
                 <!-- === INCIA CONTEUDO === -->
             
            <div id="content">
                <div class="container background-white">
                    <div class="container">
                        <div class="row margin-vert-30">
                            <h:outputText value="Nenhum lançamento realizado..." rendered="#{usuario.lancamentosEntrada.rowCount==0}" /><br/>
                            
                            <h:dataTable styleClass="table" value="#{usuario.lancamentosEntrada}" var="item" border="1" cellpadding="2" cellspacing="0" rendered="#{usuario.lancamentosEntrada.rowCount>0}">
                                <f:facet name="header">
                                    <h:outputText value="Lançamento" />
                                </f:facet>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="descrição" />
                                    </f:facet>
                                    <h:outputLabel value="#{item.descricaoLacamentoEntrada}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="categoria" />
                                    </f:facet>
                                    <h:outputLabel  value="#{item.categoriaLacamentoEntrada.descricao}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="recebido de" />
                                    </f:facet>
                                    <h:outputLabel value="#{item.recebidoPessoal.nome}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="data" />
                                    </f:facet>
                                    <h:outputLabel  value="#{item.dataLancamentoEntrada}" >
                                         <f:convertDateTime  type="date" pattern="dd/MM/yyyy" />
                                    </h:outputLabel>
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="valor" />
                                    </f:facet>
                                    <h:outputLabel value="#{item.valorLancamentoEntrada}" />
                                         
                                </h:column>

                                <h:column rendered="#{usuario.lancamentosEntrada.rowCount>0}">
                                    <f:facet name="header">
                                        <h:outputText value="Excluir Categoria" />
                                    </f:facet>
                                    <h:commandLink action="#{lEntrada.onDelete}" onclick=" return confirm('Deseja excluir o lançamento #{item.descricaoLacamentoEntrada} ?')" value="Excluir" rendered="#{usuario.lancamentosEntrada.rowCount>0}">
                                        <f:setPropertyActionListener target="#{lEntrada}" value="#{item}" />
                                    </h:commandLink>
                                </h:column>
                            </h:dataTable> <br /> <br/>
                            <h:commandLink action="#{lEntrada.onGerenciaLancamentoEntrada()}" styleClass="btn btn-primary"  >
                                 Novo Lançamento
                            </h:commandLink><br/><br/>
                            <h:commandLink  action="#{usuario.onLogoff}" value = "Fazer logoff" />
                        </div>
                    </div>
                </div>
            </div>
                
                <jsp:include page="rodape.jsp" />
            </h:form>
        </body>
    </html>
</f:view>