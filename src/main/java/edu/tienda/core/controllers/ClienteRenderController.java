package edu.tienda.core.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class ClienteRenderController
{
    @GetMapping(value = "/clientes-html", produces = MediaType.TEXT_HTML_VALUE)
    public String getClienteAsHtml()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(" <div><h1>Cliente</h1>");
        sb.append("  <ul>");
        sb.append("   <li>Nombre: Yunier Aguilera</li>");
        sb.append("   <li>Username: YAB</li>");
        sb.append("  </ul>");
        sb.append(" </div>");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    @GetMapping(value = "/clientes-xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getClienteAsXML()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<cliente>");
        sb.append("  <nombre> Nombre: Yunier Aguilera</nombre>");
        sb.append("   <username>Username: YAB</username>");
        sb.append("</cliente>");
        sb.append("</xml>");

        return sb.toString();
    }
}
