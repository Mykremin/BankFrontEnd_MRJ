$(document).ready(function() {

    $("#btntransfer").click(function() {
        transferValidation();

 });


        function transferValidation() {

            $("#mytransferform").validate({
                rules: {// her bruges name
                    amount: {required: true, minlength: 1},
                    target: {required: true, minlength:9, maxlength:9}
                    // date: {required: true, ...... husk denne
                },
                messages: {// her bruges id
                    amount: {
                        required: "Please enter an amount",
                        minlength: jQuery.format("At least {1} characters required!")
                    },
                    
                    target: {
                        required: "Please enter an accountnumber",
                        minlength: jQuery.format("At least {9} characters required!"),
                        maxlength: jQuery.format("Maximum {9} characters required")
                    }

                }
            });
        }

});

