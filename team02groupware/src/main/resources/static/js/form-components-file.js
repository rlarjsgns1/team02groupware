(function($) {
  'use strict';
  $(function() {
    $('.file-upload-browse').on('click', function() {
      var file = $(this).parent().parent().parent().find('.file-upload-default');
      file.trigger('click');
      
    });
    
    $('.file-upload-default').on('change', function(e) {
    	var file = $(this).parent().parent().parent().find('.file-upload-default');
    	console.log(file.val());
    	var files = e.target.files; // FileList 객체
    	  console.log(files);
    	  console.log(files[0]);
    	var fileSize = files[0].size;
    	var maxSize = 5 * 1024 * 1024;
    	
    	// 파일 사이즈 유효성검사
    	if(fileSize > maxSize){
    		file.val("");
    		console.log(file.val());
    		alert('첨부파일의 용량은 5MB 이내로 등록 가능합니다.')
    		
    	}else{
    		// 파일 사이즈 문자열 추가
        	if(fileSize < 1024){
        		fileSize = fileSize+"바이트";
        	}else if(fileSize < 1048576){
        		fileSize = Math.floor((fileSize / 1024)*100)/100+"KB";
        	}else if(fileSize < 1.0737e+9){
        		fileSize = Math.floor((fileSize / 1048576)*100)/100+"MB";
        	}
        	
          $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, '')+" "+fileSize);
    	}
    });
  });
})(jQuery);

