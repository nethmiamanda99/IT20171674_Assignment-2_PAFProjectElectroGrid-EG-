$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
 {
 $("#alertSuccess").hide();
 }
 $("#alertError").hide();
});




//SAVE ============================================
$(document).on("click", "#btnlog", function(event)
{

$("#alertSuccess2").val("1sssssssssssssssssssssssssssssss");
$("#alertSuccess2").show();
var user=$('#fname').val();
var pass=$('#password').val();
$.ajax(
		{
		 url : "LoginController",
		 type : GET,
		 data : {"fname":user,"password":pwd},
		 success: function (data) {
                  if(data=='True'){
                   	alert('Fail....');
                  }else{
                      alert('Fail....');
                  }
               }
		});

});
