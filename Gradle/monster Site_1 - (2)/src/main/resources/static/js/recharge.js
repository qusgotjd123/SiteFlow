function recharge(){
var inputbox = document.getElementById("inmoney") 
if (inputbox > 0){
  alert('충전이되었습니다')
} else (inputbox < 0){
  alert('금액을 입력해주세요.')
}
}