package dao;

import java.util.List;

import dto.AccountDTO;

public interface AccountDAO {
	public List<AccountDTO> list();
	public AccountDTO list(String id);
	public AccountDTO list(AccountDTO dto);
	public void register(AccountDTO dto);
	public void update(AccountDTO dto);
	public void delete(String id, String pass);
	
}
