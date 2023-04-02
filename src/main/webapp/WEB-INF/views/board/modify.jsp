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
                <form role="form" action="/board/modify" method="post">
                    <input type="hidden" name="pageNum" value="${criteria.pageNum}"/>
                    <input type="hidden" name="amount" value="${criteria.amount}"/>
                    <input type="hidden" name="type" value='<c:out value="${criteria.type}"/>'>
                    <input type="hidden" name="keyword" value='<c:out value="${criteria.keyword}"/>'>

                    <div class="form-group">
                        <label>Bno</label>
                        <input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly />
                    </div>
                    <div class="form-group">
                        <label>Title</label>
                        <input class="form-control" name="title" value='<c:out value="${board.title}"/>' />
                    </div>
                    <div class="form-group">
                        <label>Text area</label>
                        <textarea class="form-control" rows="3" name="content" ><c:out value="${board.content}"/> </textarea>
                    </div>
                    <div class="form-group">
                        <label>Writer</label>
                        <input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly/>
                    </div>
                    <div class="form-group">
                        <label>RegDate</label>
                        <input type="hidden" class="form-control" name="regDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}"/>' readonly />
                    </div>
                    <div class="form-group">
                        <label>Update Date</label>
                        <input type="hidden" class="form-control" name="updateDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}"/>' readonly />
                    </div>
                    <button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
                    <button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
                    <button type="submit" data-oper="list" class="btn btn-info">List</button>
                </form>
            </div>
            <!-- end panel-boy -->
        </div>
        <!-- end panel-body -->
    </div>
    <!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
    $(document).ready(function() {
        var formObj = $("form")

        $('button').on("click", function(e){
            e.preventDefault();

            var operation = $(this).data("oper");

            console.log(operation);

            if(operation === 'remove' ){
                formObj.attr("action", "/board/remove");
            } else if(operation ==='list'){
                formObj.attr("action", "/board/list").attr("method", "get");
                var pageNumTag = $("input[name='pageNum']").clone();
                var amountTag = $("input[name='amount']").clone();
                var typeTag = $("input[name='type']").clone();
                var keywordTag = $("input[name='keyword']").clone();

                formObj.empty();
                formObj.append(pageNumTag);
                formObj.append(amountTag);
                formObj.append(typeTag);
                formObj.append(keywordTag);
            }
            formObj.submit();
        });
    });
</script>

<%@ include file="../includes/footer.jsp"%>