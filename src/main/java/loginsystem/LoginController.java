package loginsystem;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.AccountDAO;
import dto.AccountDTO;

@Controller
public class LoginController {
	private AccountDAO dao;

	public LoginController() {
	}

	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}

	// http://localhost:8090/myapp/account/list
	// SQL에 저장되어있는 계정 리스트를 보기 위한 기능
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<AccountDTO> listMethod() {
		return dao.list();
	}
	
	// http://localhost:8090/myapp/account/list/1
	// SQL에 저장되어있는 계정을 고유 계정 넘버를 입력해서 찾아내는 기능 
	@ResponseBody
	@RequestMapping(value = "/list/{user_num}", method = RequestMethod.GET)
	public AccountDTO listMethod(@PathVariable("user_num") int user_num) {
		return dao.list(user_num);
	}
	
	// http://localhost:8090/myapp/account/list/1/홍길동
	// SQL에 저장되어있는 계정을 고유 계정 넘버와 이름을 입력해서 찾아내는 기능
	@ResponseBody
	@RequestMapping(value = "/list/{user_num}/{name}",method = RequestMethod.GET)
	public AccountDTO listMethod(@PathVariable("user_num")int user_num, @PathVariable("name") String name) {
		return dao.list(new AccountDTO(user_num,name));
	}
	
	
	
	//{"id":"Test3","pass":"1234","name":"애옹스","email":"tes3@naver.com"}
	//postman과 JASON을 이용한 계정 입력
	//http://localhost:8090/myapp/account/insert
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<String> insertMethod(@RequestBody AccountDTO dto){
		ResponseEntity<String> entity=null;
		try {
			dao.register(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//{"user_num":3,"name":"김일환"}
	//postman과 JASON을 이용한 계정 이름 수정
	//http://localhost:8090/myapp/account/update
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateMethod(@RequestBody AccountDTO dto){
		ResponseEntity<String> entity= null;
		try {
			dao.update(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			return entity;
	}
	
	//postman과 JASON을 이용한 계정 삭제
//	http://localhost:8090/myapp/account/delete/{user_num}
	@RequestMapping(value = "/delete/{user_num}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletMethod(@PathVariable("user_num") int user_num){
		ResponseEntity<String> entity=null;
		try {
			dao.delete(user_num);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			return entity;
	}
	
}
