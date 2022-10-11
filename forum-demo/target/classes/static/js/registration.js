

const btnReg = document.getElementById('btn-reg');

let idRes = 0;
let idResHome = 0;

btnReg.addEventListener("click",()=>{

    let login = document.getElementById('login');
    let username = document.getElementById('username');
    let password = document.getElementById('password');

    if(login.value.length < 6  ){
        document.getElementById('reg-info').innerHTML =+ "login length < 6";
        return;
    }

    if( username.value.length < 6 ){
        document.getElementById('reg-info').innerHTML =+ "username length < 6";
        return;
    }

    if(password.value.length < 6 ){
        document.getElementById('reg-info').innerHTML =+ "password length < 6";
        return;
    }
    

 
    let head = {
        login: login.value,
        username:  username.value,
        password: password.value
    }


    

    repoGet(head,'/registration/user');
    repoGetHome();

});

function repoPost(json,url,head){

    let xhr = new XMLHttpRequest();

    let respons;

    xhr.open("POST", url, true);

    xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(json);

    xhr.onload  = function() {
        respons = xhr.responseText;

    }
    return respons;
}


function repoGetHome(){
   let xhr = new XMLHttpRequest();

   xhr.open('GET', '/home');


   xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');

   var obj = {};
   var cookies = document.cookie.split(/;/);
   for (var i = 0, len = cookies.length; i < len; i++) {
       var cookie = cookies[i].split(/=/);
       obj[cookie[0]] = cookie[1];
   }

   xhr.setRequestHeader('Authorization', obj.jwt);

   xhr.send();

   xhr.onload = function() {
    console.log(idResHome);
    if(idResHome == 0){
        console.log(xhr.responseText);
        document.write(xhr.responseText);
        idResHome = 1;

        name();
    }
    
   }
}

function repoGet(head,url){

    let xhr = new XMLHttpRequest();

    xhr.open('GET', url);


   

    xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
    xhr.setRequestHeader('login', head.login);
    xhr.setRequestHeader('username', head.username);
    xhr.setRequestHeader('password', head.password);

    xhr.send();

    xhr.onload  = function() {
        if(idRes == 0){
            document.cookie = "jwt=Bearer "+xhr.responseText;
            idRes = 1;
        }
       
    }
}

