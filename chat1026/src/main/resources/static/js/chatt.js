/**
 * web socket
 */
// 화면에서 아이디를 입력받은 엘리먼트 반환
function getId(id){
	return document.getElementById(id);
}
// 사용자로부터 입력받은 메시지 담기
let data = {};//전송 데이터(JSON)

let ws ; // 웹소켓 객체 (생성하는) 인스턴스 변수
const mid = getId('mid');
const btnLogin = getId('btnLogin');
const btnSend = getId('btnSend');
const talk = getId('talk');
const msg = getId('msg');

btnLogin.onclick = function(){
	ws = new WebSocket("ws://" + location.host + "/chatt");
	
	ws.onmessage = function(msg){
		var data = JSON.parse(msg.data);
		var css;
		
		if(data.mid == mid.value){
			css = 'class=me';
		}else{
			css = 'class=other';
		}
		
		var item = `<div ${css} >
		                <span><b>${data.mid}</b></span> [ ${data.date} ]<br/>
                      <span>${data.msg}</span>
						</div>`;
					
		talk.innerHTML += item;
		talk.scrollTop=talk.scrollHeight;//스크롤바 하단으로 이동
	}
}

msg.onkeyup = function(ev){
	if(ev.keyCode == 13){
		send();
	}
}

btnSend.onclick = function(){
	send();
}

function send(){
	if(msg.value.trim() != ''){
		data.room = getId('room').value;
		data.mid = getId('mid').value;
		data.msg = msg.value;
		data.date = new Date().toLocaleString();
		var temp = JSON.stringify(data);
		ws.send(temp);
	}
	msg.value ='';
	
}