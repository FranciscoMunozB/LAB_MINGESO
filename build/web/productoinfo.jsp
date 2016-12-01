<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion Productos</title>
    </head>
    <body action="ProductoServlet">
        <h1>Información Productos </h1>
        <form action="./ProductoServlet" method="POST">
            <table>
                <tr>
                    <td>Id producto</td>
                    <td><input type="text" name="productoId" value="${producto.idProducto}" /></td>
                </tr>
                <tr>
                    <td>Nombre Producto</td>
                    <td><input type="text" name="nombreProducto" value="${producto.nombreProducto}" /></td>
                </tr>
                <tr>
                    <td>Cantidad Producto</td>
                    <td><input type="text" name="cantidadProducto" value="${producto.cantidad}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>                
                </tr>            
            </table>
        </form>        
        <br>
        <table border="1">
            <th>Id</th>
            <th>Nombre</th>
            <th>Cantidad</th>
            <c:forEach items="${allProductos}" var="product">
                <tr>
                    <td>${product.idProducto}</td>
                    <td>${product.nombreProducto}</td>
                    <td>${product.cantidad}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
