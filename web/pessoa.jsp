<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Lista de Pessoa/Empresas</title>
        </head>
        <body>
            <h:form>
                 <jsp:include page="cabecalho.jsp" />
                 <!-- === INCIA CONTEUDO === -->
             
            <div id="content">
                <div class="container background-white">
                    <div class="container">
                        <div class="row margin-vert-30">
                            <h:outputText value="Nenhuma pessoa cadastrada..." rendered="#{usuario.pessoas.rowCount==0}" /><br/>
                            
                            <h:dataTable styleClass="table" value="#{usuario.pessoas}" var="item" border="1" cellpadding="2" cellspacing="0" rendered="#{usuario.categorias.rowCount>0}">
                                <f:facet name="header">
                                    <h:outputText value="Pessoas/Empresas" />
                                </f:facet>
                                 <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="CPF" />
                                    </f:facet>
                                    <h:outputLabel value="#{item.cpf}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="Nome" />
                                    </f:facet>
                                    <h:outputLabel value="#{item.nome}" />
                                </h:column>

                                <h:column rendered="#{usuario.pessoas.rowCount>0}">
                                    <f:facet name="header">
                                        <h:outputText value="Excluir Pessoa" />
                                    </f:facet>
                                    <h:commandLink action="#{pessoa.onDelete}" onclick=" return confirm('Deseja excluir a pessoa/empresa #{item.nome} ?')" value="Excluir" rendered="#{usuario.pessoas.rowCount>0}">
                                       <f:setPropertyActionListener target="#{pessoa}" value="#{item}" />
                                    </h:commandLink>
                                </h:column>
                            </h:dataTable> <br /> <br/>
                            <h:commandLink action="#{pessoa.onGerenciaPessoa()}" styleClass="btn btn-primary"  >
                                 Nova Pessoa/Empresa
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

