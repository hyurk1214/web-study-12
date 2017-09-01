/**
 * 
 */

function bookCheck(){
	if(document.frm.title.value.length == 0){
		alert("책 제목을 입력하세요.");
		return false;
	}
	if(document.frm.price.value.length == 0){
		alert("가격을 입력하세요.");
		return false;
	}
	if(isNaN(document.frm.price.value)){
		alert("가격에는 숫자를 입력해야 합니다.");
		frm.price.focus();
		return false;
	}
	if(document.frm.bookcount.value.length == 0){
		alert("수량을 입력하세요.");
		return false;
	}
	if(isNaN(document.frm.bookcount.value)){
		alert("수량에는 숫자를 입력해야 합니다.");
		frm.price.focus();
		return false;
	}
	if(document.frm.writer.value.length == 0){
		alert("작가를 입력하세요.");
		return false;
	}
	if(document.frm.publisher.value.length == 0){
		alert("출판사를 입력하세요.");
		return false;
	}
	return true;
	
	function bookSearch(){
		if(document.frm.search.value = ""){
			alert("검색어를 입력해주세요");
			return false;
		}
	return true;
	}
	
	function open_win(url , name){
		window.open(url , name , "width = 500 , height = 230");
	}
	
	function loginCheck() {
		if(document.frm.userid.value.length == 0){
			alert("아이디를 써주세요.");
			frm.userid.focus();
			return false;
		}
		if(document.frm.pwd.value == ""){
			alert("암호는 반드시 입력해야 합니다.");
			frm.pwd.focus();
			return false;
		}
		return true;
	}
}