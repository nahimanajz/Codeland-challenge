// TODO: Get password from UI Form, Validate according 
// to rules given then provide feedback to user interface

/**
 * @param{pass1, pass2} 
 * @description compare two passwords matching
 * @return {String} password match or password not match written in HTML
 */
function verify_password()
{
    var password = document.getElementById('pass1');
    var pass2= document.getElementById('pass2');
    var message = document.getElementById('validation-result');
 if(password.value != pass2.value){
message.innerHTML = "Password does not match";
}
}

/**
 * @param{pass1, pass2} 
 * @description compare two passwords matching
 * @return {String} password match or password not match written in HTML
 */
const hashPassword =(password) =>{}
const submitData=(e)=>{
    alert('hi')
     /*const data = {
         e.target.name: e.target.value
     }
     alert(JSON.stringify(data))
     */
}