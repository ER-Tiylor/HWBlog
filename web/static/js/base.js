window.onload=function(){
    var aLi=document.getElementsByTagName('li');

    for(var i=0; i<aLi.length; i++){
        aLi[i].onmouseover=function(){
            var subnav=this.getElementsByTagName('ul')[0];
            if(subnav){
                var This=subnav;
                clearInterval(This.time);
                This.time=setInterval(function(){
                    This.style.display = "block";
                },30)
            }
        }
        //鼠标离开菜单，二级菜单动画收缩起来。
        aLi[i].onmouseout=function(){
            var subnav=this.getElementsByTagName('ul')[0];
            if(subnav){
                var This=subnav;
                clearInterval(This.time);
                This.time=setInterval(function(){
                    This.style.display = "none";
                },30)
            }
        }

    }

}
function login(){
    var login = document.getElementById("login");
    var register = document.getElementById("regist");
    var btn_log = document.getElementById("choose_login");
    var btn_reg = document.getElementById("choose_regist");
    register.style.display = "none";
    btn_reg.style.backgroundColor = "darkgray";
    login.style.display = "block";
    btn_log.style.backgroundColor = "white";
}
function register(){
    var login = document.getElementById("login");
    var register = document.getElementById("regist");
    var btn_log = document.getElementById("choose_login");
    var btn_reg = document.getElementById("choose_regist");
    login.style.display = "none";
    btn_log.style.backgroundColor = "darkgray";
    register.style.display = "block";
    btn_reg.style.backgroundColor = "white";
}
