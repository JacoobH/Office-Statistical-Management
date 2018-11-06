$( ".sidebar li" ).hover(
    function() {
        $(this).find("a").css("color","#FFF");
        $(this).find("span").stop().animate({
            width:"100%",
            opacity:"1"
        }, 600, function () {
            // Animation complete.
            // Show Navigation
        })
    }, function() {
        $(this).find("a").css("color","#9d9d9d");
        $(this).find("span").stop().animate({
            width:"0%",
            opacity:"0"
        }, 600, function () {
            // Animation complete.
            // Show Navigation
        })
    }
);