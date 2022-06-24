package loginsystem;

import java.util.List;

import org.springframework.stereotype.Controller;
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
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<AccountDTO> listMethod() {
		return dao.list();
	}

}
