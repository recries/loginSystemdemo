package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.AccountDTO;

public class AccountDaoImp implements AccountDAO {
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
		return null;
	}

	@Override
	public AccountDTO list(AccountDTO dto) {
		return sqlSession.selectOne("account.search",dto);
	}

	@Override
	public void register(AccountDTO dto) {
		sqlSession.insert("account.ins",dto);
	}

	@Override
	public void update(AccountDTO dto) {
		sqlSession.update("account.upt",dto);

	}

	@Override
	public void delete(int user_num) {
		sqlSession.delete("account.del", user_num);
	}

	@Override
	public AccountDTO list(int num_user) {
		return sqlSession.selectOne("account.one",num_user);
	}

}
