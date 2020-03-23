$(function () {
    $('.dd').nestable();

    $(document).on('change','.dd',function () {
        var $this = $(this);
        var serializedData = window.JSON.stringify($($this).nestable('serialize'));

        $this.parents('div.body').find('textarea').val(serializedData);
    });

    $('.dd4').nestable();

    $(document).on('change','.dd4',function () {
        var $this = $(this);
        var serializedData = window.JSON.stringify($($this).nestable('serialize'));
    });
});