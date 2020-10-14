<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/topjava.common.js" defer></script>
<script type="text/javascript" src="resources/js/topjava.meals.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="modal fade" tabindex="-1" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>

                <h3 class="modal-title"><spring:message code="${meal.isNew() ? 'meal.add' : 'meal.edit'}"/></h3>
                <button type="button" class="close" data-dismiss="modal" onclick="closeNoty()">&times;</button>
            </div>
            <hr>
            <div class="modal-body">
            <form id="detailsForm" method="post" action="meals">
                <input type="hidden" name="id" value="${meal.id}">
                <dl>
                    <dt><spring:message code="meal.dateTime"/>:</dt>
                    <dd><input type="datetime-local" value="${meal.dateTime}" name="dateTime" required></dd>
                </dl>
                <dl>
                    <dt><spring:message code="meal.description"/>:</dt>
                    <dd><input type="text" value="${meal.description}" size=40 name="description" required></dd>
                </dl>
                <dl>
                    <dt><spring:message code="meal.calories"/>:</dt>
                    <dd><input type="number" value="${meal.calories}" name="calories" required></dd>
                </dl>
                <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="save()">
                    <span class="fa fa-check"></span>
                    <spring:message code="common.save"/>
                </button>


                <button onclick="window.history.back()" type="button" class="btn btn-secondary" data-dismiss="modal" onclick="closeNoty()">
                    <span class="fa fa-check"></span>
                    <spring:message code="common.cancel"/>
                </button>
                </div>
            </form>
            </div>
        </div>
    </div>
</div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
