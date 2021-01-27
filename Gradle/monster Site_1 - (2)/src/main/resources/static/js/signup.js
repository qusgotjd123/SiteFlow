function signup(){
  var signupForm = document.signupForm;
  var email = signupForm.email.value;
  var password = signupForm.password.value;
  var names = signupForm.names.value;

  if(!names || !email || !password){
    alert("이름, 이메일과 비밀번호 모두 입력해주세요")
  }else{
    alert("회원가입 되었습니다");
    signupForm.submit();
  }
}