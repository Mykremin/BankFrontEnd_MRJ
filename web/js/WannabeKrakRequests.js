$(document).ready(function() {
        // validate the comment form when it is submitted
        $("#btnupdate").click(function(){
                countRequestsKrak();
                
            });
            
             function countRequestsKrak(){
                $.ajax({
                    url: "WannabeKrakRequestsServlet",
                    cache: false,
                    dataType: "text"
                    
                }).done(function(data){
                    $("#countrequest").val(data);
                });
            }
              });
            