<%--
  Created by IntelliJ IDEA.
  User: sulad
  Date: 4/2/23
  Time: 1:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Read</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="page-heading">Board Read Page</div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="form-group">
                    <label>Bno</label>
                    <input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly />
                </div>
                <div class="form-group">
                    <label>Title</label>
                    <input class="form-control" name="title" value='<c:out value="${board.title}"/>' readonly/>
                </div>
                <div class="form-group">
                    <label>Text area</label>
                    <textarea class="form-control" rows="3" name="content" readonly><c:out value="${board.content}"/> </textarea>
                </div>
                <div class="form-group">
                    <label>Writer</label>
                    <input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly/>
                </div>
                <button data-oper="modify"
                        class="btn btn-default"
                        onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">
                    Modify
                </button>
                <button data-oper="list"
                        class="btn btn-info"
                        onclick="location.href='/board/list'">
                    List
                </button>
            </div>
            <!-- end panel-boy -->
        </div>
        <!-- end panel-body -->
    </div>
    <!-- end panel -->
</div>
<!-- /.row -->

<%@ include file="../includes/footer.jsp"%>