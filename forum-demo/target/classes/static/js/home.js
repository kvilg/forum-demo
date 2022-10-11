function name(){
    const usrName = document.getElementById('usrName');
    const myRoom = document.getElementById('myRoom');

    console.log("asdasd");

    let txt = repoUsrAndRoom();

    let obj = JSON.parse(txt);

    console.log(obj);


    function repoUsrAndRoom(){

        var obj = {};
        var cookies = document.cookie.split(/;/);
        for (var i = 0, len = cookies.length; i < len; i++) {
            var cookie = cookies[i].split(/=/);
            obj[cookie[0]] = cookie[1];
        }

        let xhr = new XMLHttpRequest();

        let respons;

        xhr.open("GET", '/user/info');

        xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
        xhr.setRequestHeader('Authorization', obj.jwt);

        xhr.send();

        xhr.onload  = function() {
            respons = xhr.responseText;
        }

        return respons;
    }



    // function repoUsrAndRoom(){
    //     let xhr = new XMLHttpRequest();

    //     xhr.open('POST', '/home');


    //     xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');

    //     var obj = {};
    //     var cookies = document.cookie.split(/;/);
    //     for (var i = 0, len = cookies.length; i < len; i++) {
    //         var cookie = cookies[i].split(/=/);
    //         obj[cookie[0]] = cookie[1];
    //     }

    //     xhr.setRequestHeader('Authorization', obj.jwt);

    //     xhr.send();

    //     xhr.onload = function() {
    //     console.log(idResHome);
    //     if(idResHome == 0){
    //         console.log(xhr.responseText);
    //         document.write(xhr.responseText);
    //         idResHome = 1;
    //         console.log(idResHome);
    //     }

    //     }
    //  }
}