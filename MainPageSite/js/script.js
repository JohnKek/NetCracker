$(document).ready(function() {
    $('.header_menu_burger').click(function(event) {
        $('.header_menu_burger,.header_menu').toggleClass('active');
        $('body').toggleClass('lock');
    });
});