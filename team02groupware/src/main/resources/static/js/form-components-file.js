(function($) {
  'use strict';
  $(function() {
	  
	// 파일 선택 클릭시
    $(document).on('click', '.file-upload-browse', function() {
      var file = $(this).parent().parent().find('.file-upload-default');
      file.trigger('click');
      
    });
    
    // 파일 선택
    $(document).on('change', '.file-upload-default', function(e) {
    	
    	var file = $(this).parent().parent().find('.file-upload-default');
    	console.log(file.val());
    	var files = e.target.files; // FileList 객체
    	  console.log(files);
    	  console.log(files[0]);
    	var fileSize = files[0].size;
    	var maxSize = 5 * 1024 * 1024;	// 5MB
    	
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
    
    $(document).on('click', '.file-update-cancle', function() {
    	
    	if(confirm('파일을 내리시겠습니까?')){
    		
    		var file = $(this).parent().parent().find('.file-upload-default');
    		var fileNum = $(this).prev().attr('fileNum')
    		file.val("");
    		$(this).prev().val("");
    		$(this).next().val(fileNum);
    		console.log(fileNum)
    	}else{}
        
      });
    
    $(document).on('click', '.file-upload-cancle',function(e) {
    	
    	e.preventDefault()
    	
    	var inputGroup = $(this).closest('.file-input-group');
    	console.log(inputGroup.length)
    	var fileInputGroup = $('.file-group-div').find('.file-input-group')
    	
    	if(fileInputGroup.length == 1){
    		$(this).prev().val('');
    	}else{
    		inputGroup.remove();
    	}
    	
        
      });
    
    $('.file-add-btn').on('click', function() {
    	
    	var fileInputGroupLength = $('.file-input-group').length;
    	console.log(fileInputGroupLength);
    	
    	if(fileInputGroupLength >= 5){
    		
    		alert('파일은 최대 5개까지 첨부하실 수 있습니다.')
    		
    	}else{
    		
    		var fileInputGroup = $('.file-input-group').eq(0).clone();
        	fileInputGroup.find('.file-upload-info').val('');
    	   			    
        	$('.file-group-div').append(fileInputGroup)
    	}
      });

  });
})(jQuery);

