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
                <h:dataTable value="#{usuario.categorias}" var="item" border="1" cellpadding="2" cellspacing="0">
                    <f:facet name="header">
                        <h:outputText value="Categorias" />
                    </f:facet>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="descricao" />
                        </f:facet>
                        <h:outputLabel value="#{item.descricao}" />
                    </h:column>
               
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Excluir Categoria" />
                        </f:facet>
                        <h:commandLink action="#{categoria.onDelete}" value="Excluir">
                           <f:setPropertyActionListener target="#{categoria}" value="#{item}" />
                        </h:commandLink>
                    </h:column>
                </h:dataTable> <br /> <br />
                <h:commandLink action="#{usuario.onLogoff}" value = "Fazer logoff" />
            </h:form>
        </body>
    </html>
</f:view>
