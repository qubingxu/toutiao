(function(){
    $(document).ready(function(){
        $("#time").click(function(){
            $("#sorco").hide();
            $("#sorti").show();
        });
        $("#count").click(function(){
            $("#sorti").hide();
            $("#sorco").show();
        });
    });
})();