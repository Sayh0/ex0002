<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Modify</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Modify</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

      <form role="form" action="/board/modify" method="post">
      
        <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
        <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
	    <input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>
		<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'>
      
		<div class="form-group">
		  <label>Bno</label> 
		  <input class="form-control" name='bno' 
		     value='<c:out value="${board.bno }"/>' readonly="readonly">
		</div>
		
		<div class="form-group">
		  <label>Title</label> 
		  <input class="form-control" name='title' 
		    value='<c:out value="${board.title }"/>' >
		</div>
		
		<div class="form-group">
		  <label>Text area</label>
		  <textarea class="form-control" rows="3" name='content' ><c:out value="${board.content}"/></textarea>
		</div>
		
		<div class="form-group">
		  <label>Writer</label> 
		  <input class="form-control" name='writer'
		    value='<c:out value="${board.writer}"/>' readonly="readonly">            
		</div>
		
		<div class="form-group">
		  <label>RegDate</label> 
		  <input class="form-control" name='regDate'
		    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.regdate}" />'  readonly="readonly">            
		</div>
		
		<div class="form-group">
		  <label>Update Date</label> 
		  <input class="form-control" name='updateDate'
		    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.updateDate}" />'  readonly="readonly">            
		</div>
		
		<!-- data-oper 를 이용해 각각 private 한 데이터 값을 가질 수 있도록 함 -->
		 <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
		 <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
		 <button type="submit" data-oper='list' class="btn btn-info">List</button>
		</form>

      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {


	  var formObj = $("form");

	  $('button').on("click", function(e){
	    
	    e.preventDefault(); 
	    
	    var operation = $(this).data("oper");
	    // this 는 클릭한 button.
	    // oper 에 등록돤 변수를 빼올 수 있음.
	    
	    console.log(operation);
	    
	    if(operation === 'remove'){
	      formObj.attr("action", "/board/remove");
	      
	    }else if(operation === 'list'){
	      //move to list 일 때
	      // 폼에 딱 만들어두고 action 값만 바꿔버리면 편하다. >> 각각의 버튼 구분 필요. 여기서는 oper 사용
	      formObj.attr("action", "/board/list").attr("method","get");
	      // 자기가 필요한 태그를 복사하고
	      var pageNumTag = $("input[name='pageNum']").clone();
	      var amountTag = $("input[name='amount']").clone();
	      var keywordTag = $("input[name='keyword']").clone();
	      var typeTag = $("input[name='type']").clone();      
	      // 폼 안 태그를 싹 날리고
	      formObj.empty();
	      // 필요해서 복사했던 것만 넣어서 보낸다.
	      formObj.append(pageNumTag);
	      formObj.append(amountTag);
	      formObj.append(keywordTag);
	      formObj.append(typeTag);	       
	    }
	    
	    formObj.submit();
	    // 마지막에 제출. 폼에 있는 데이터 값이 액션에 따라 제출됨
	  });

});
</script>
  




<%@include file="../includes/footer.jsp"%>
