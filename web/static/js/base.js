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
function checkboxOnclick(checkbox){
    var check = document.getElementById("regist_btn");
    if ( checkbox.checked == true){
        //Action for checked
        //check.setAttribute("disabled", true);
        check.disabled = false;
        check.style.backgroundColor = "#00A7EB";
    }else{
        //Action for not checked
        //check.setAttribute("disabled", false);
        check.disabled = true;
        check.style.backgroundColor = "grey";
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
function saveInf(){
    var form1 = document.getElementById("form1");
    var transBtn = document.getElementById("mod_btn");
    var personInput = document.getElementsByClassName("person_input");
    var introduceInf1 = document.getElementById("introduce_inf1");
    var introduceInf2 = document.getElementById("introduce_inf2");
    var showSex = document.getElementById("sex_show");
    var sexChoose = document.getElementsByClassName("sex_choose");

    if(transBtn.value=="修改信息"){
        introduceInf1.style.display = "none";
        introduceInf2.style.display = "block";
        transBtn.value = "保存信息";
        sexChoose[0].style.display = "block";
        sexChoose[1].style.display = "block";
        showSex.style.display = "none";
        for (var i=0;i<personInput.length;i++)
        {
            personInput[i].disabled = false;
        }
    }else{
        form1.submit();
    }
}
