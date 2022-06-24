package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.AccountDTO;

public class AccountDaoImp implements AccountDAO{
	private SqlSessionTemplate sqlSession;
	public AccountDaoImp() {
}
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<AccountDTO> list() {
		return sqlSession.selectList("account.all");
	}

	@Override
	public AccountDTO list(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountDTO list(AccountDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(AccountDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AccountDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id, String pass) {
		// TODO Auto-generated method stub
		
	}

}
