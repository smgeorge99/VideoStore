<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><%@ page session="false"%><!DOCTYPE html><html><title>Video Store Customer Summary Page</title><body>	<div>		<table>			<thead>				<tr>					<th>Customer Id</th><th>Customer Name</th><th>Membership Type</th>				</tr>			</thead>			<c:forEach items="${customers}" var="customer">				<tr>					<td>${customer.customerId}</td>					<td>${customer.name}</td>					<td>						<c:choose>							<c:when test="${customer['class'].name == 'com.excella.bootcamp.videostore.model.VIPCustomer' }">VIP Customer</c:when>							<c:otherwise>Regular Joe</c:otherwise>						</c:choose>					</td>				</tr>			</c:forEach>		</table>	</div></body></html>