function login(){
  var loginForm = document.loginForm;
  var email = loginForm.email.value;
  var password = loginForm.password.value;

  if(!email || !password){
    alert("이메일과 비밀번호를 모두 입력해주세요")
  }else{
    alert("login!");
    loginForm.submit();
  }
}