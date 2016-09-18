<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Categorias do Usuario</title>
        </head>
        <body>
            <h:form>
                 <jsp:include page="cabecalho_n_menu.jsp" />
                 <!-- === INCIA CONTEUDO === -->
             
            <div id="content">
                <div class="container background-white">
                    <div class="container">
                        <div class="row margin-vert-30">
                            <h:outputText value="Nenhuma categoria cadastrada..." rendered="#{usuario.categorias.rowCount==0}" /><br/>
                            
                            <h:dataTable styleClass="table" value="#{usuario.categorias}" var="item" border="1" cellpadding="2" cellspacing="0" rendered="#{usuario.categorias.rowCount>0}">
                                <f:facet name="header">
                                    <h:outputText value="Categorias" />
                                </f:facet>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="descricao" />
                                    </f:facet>
                                    <h:outputLabel value="#{item.descricao}" />
                                </h:column>

                                <h:column rendered="#{usuario.categorias.rowCount>0}">
                                    <f:facet name="header">
                                        <h:outputText value="Excluir Categoria" />
                                    </f:facet>
                                    <h:commandLink action="#{categoria.onDelete}" onclick=" return confirm('Deseja excluir a categoria #{item.descricao} ?')" value="Excluir" rendered="#{usuario.categorias.rowCount>0}">
                                       <f:setPropertyActionListener target="#{categoria}" value="#{item}" />
                                    </h:commandLink>
                                </h:column>
                            </h:dataTable> <br /> <br/>
                            <h:commandLink action="#{categoria.onGernciaCategora()}" styleClass="btn btn-primary"  >
                                 Nova categoria
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
