

 function validateForm() {
  let x = document.forms["myForm"]["username"].value;
  if (x == "") {
    alert("Username must be filled out");
    return false;
  }
    
    let y = document.forms["myForm"]["password"].value;
  if (y == "") {
    alert("Password must be filled out");
    return false;
  }
    let z = document.forms["myForm"]["password"].value;
  if (z.length <5) {
    alert("Please enter a password of more than 5 characters");
    return false;
  }
  
}


/*
function validate()
            {
                var uname = document.getElementById("username").value;
                var password = document.getElementById("password").value;
      
                var patcheck = new RegExp("^[a-z0-9]");
                if(uname==="")
                {
                    document.getElementById("username").innerHTML="Enter a value";
                    document.getElementById("username").style.color="Red";
                    
                }
                else
                {
                    document.getElementById("username").innerHTML="";
                }
                /*if(Email.indexOf("@")> -1)
                {
                    document.getElementById("password").innerHTML="";
                }
                 else
                {
                    document.getElementById("password").innerHTML="Enter the correct email address";
                    document.getElementById("password").style.color="Red";
                    
                }*//*
                if(password.length<=6)
                {
                    document.getElementById("password").innerHTML="Password is weak";
                    document.getElementById("password").style.color="Red";
                }
                /* else
                {
                    document.getElementById("div3").innerHTML="";
                }
                *//*
                if(!patcheck.test(pattern))
                {
                    document.getElementById("div4").innerHTML="Only Alphabets/Numbers";
                    document.getElementById("div4").style.color="Red";
                }
                else
                {
                    document.getElementById("div4").innerHTML="";
                }
            }*/
            
        