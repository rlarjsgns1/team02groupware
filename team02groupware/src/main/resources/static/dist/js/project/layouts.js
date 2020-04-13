(function($) {
    'use strict';
    $(function() {
    $('.file-upload-browse').on('click', function() {
        var file = $(this).parent().parent().parent().find('.file-upload-default');
        file.trigger('click');
      });
      $('.file-upload-default').on('change', function() {
        $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, ''));
      });
    });
 
    $(document).ready(function() {
        var listDelete = $('.list-delete');
        listDelete.on('click', function() {
            swal({
                title: "Are you sure?",
                text: "Do you really want to delete this item?",
                icon: "warning",
                buttons: ["Cancel", "Delete Now"],
                dangerMode: true,
            })
            .then((willDelete) => {
                if (willDelete) {
                    swal({
                        title: "Deleted",
                        text: "The list item has been deleted!",
                        icon: "success",
                    });
                } else {
                    swal("The item is not deleted!");
                }
            });
        });
        $('.html-editor').summernote({
          height: 300,
          tabsize: 2
        });
    })


    
    
    
    /*
     * @file layouts.js
     * @brief 프로젝트 삭제시 SweetAlert Library 수정
     * @author 김연지
     */
    $(document).ready(function() {
            var listDelete = $('.project-delete-btn');
            listDelete.on('click', function() {
                swal({
                    title: "해당 프로젝트를 삭제하시겠습니까?",
                    icon: "warning",
                    buttons: ["취소", "삭제"],
                    dangerMode: true,
                })
                .then((willDelete) => {
                    if (willDelete) {
                        swal({
                            title: "프로젝트가 삭제되었습니다.",
                            icon: "success",
                        });
                    } else {
                        swal("삭제가 취소되었습니다.");
                    }
                });
            });
            $('.html-editor').summernote({
              height: 300,
              tabsize: 2
            });
        }) 
})(jQuery);