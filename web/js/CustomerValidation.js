$(document).ready(function() {
        // validate the comment form when it is submitted
        $("#getaddress").click(function(){
                getAddressByPhone();
                
            });
            
             function getAddressByPhone(){
                $.ajax({
                    url: "GetAddressRestServlet",
                    data: {
                        phone: $("#phone").val()
                    },
                    cache: false,
                    dataType: "json"
                    
                }).done(function(data){
                    $("#firstname").val(data.firstName),
                    $("#lastname").val(data.lastName),
                    $("#street").val(data.address),
                    $("#postalcode").val(data.zip),
                    $("#postaldistrict").val(data.city),
                    $("#email").val(data.email);
                });
            }
        
        $("#mycustomerform").validate({
          rules: { // her bruges name
            cpr: {required: true, minlength: 11, maxlength: 11, remote: "CprValidationServlet"},
            firstName: {required: true, minlength: 2},
            lastName: {required: true, minlength: 2},
            email: {required: true, email: true, remote: "EmailValidationServlet"},
            password: {required: true, minlength: 5},
            passwordrep: {required: true, equalTo: "#password"}
          },
       
          messages: { // her bruges id
            cpr: {
                required: "Please enter your cpr-number",
                minlength: jQuery.format("At least {11} digits required!"),
                maxlength: jQuery.format("At least {11} digits required!"),
                remote: "Not a valid cpr-number, already taken"
            }  ,
              
            firstname: {
              required: "Please enter your first name",
              minlength: jQuery.format("At least {0} characters required!")
            },
            
            lastname: {
              required: "Please enter your lastname",
              minlength: jQuery.format("At least {0} characters required!")
            },
            
            email: {
              required: "Please enter your email",   
              email: "This is not a valid email",
              remote: "Email is already taken"
            },
            
            password: {
              required: "Please enter your password",
              minlenght: jQuery.format("At least {5} characters required!")
            },
            
            passwordrep: {
                required: "Please repeat you password",
                equalTo: "Your password didnt match"
            }
        }
      });
  });




