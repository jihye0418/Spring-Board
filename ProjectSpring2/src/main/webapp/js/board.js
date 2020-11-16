$(function(){
  /* 글쓰기 템플릿 설정 */
  // $('#summernote').summernote({
  //   placeholder: '내용을 입력하세요.',
  //   minHeight: 400,
  //   maxHeight: 400,
  //   lang:'ko-KR'
  //   });

  // 유효성 검사
  $('#writeform').validate({
    rules:{
      ask_qna:{
        required: true
      },
      qna_title:{
        required: true,
        minlength : 5
      },
      qna_content:{
        required: true,
        minlength: 10
      }
    },
    messages:{
      ask_qna:{
        required:'카테고리를 선택하세요'
      },
      qna_title:{
        required:'제목은 필수입니다 :)',
        minlength:'최소 5글자 이상 입력해주세요.'
      },
      qna_content:{
        required:'내용을 입력해주세요:)',
        minlength:'최소 10글자 이상 입력해주세요.'
      }
    },
    errorElement:'label',
    errorClass:'bad',
    validClass:'good'
  });

  /* 파일첨부 */
$(".custom-file-input").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});
})