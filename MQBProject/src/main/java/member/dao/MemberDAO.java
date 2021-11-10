package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public class MemberDAO {
	private static MemberDAO instance = null;
	private SqlSessionFactory sqlSessionFactory;
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();//�깮�꽦
			}
		}
		
		return instance;
	}
	
	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MemberDTO login(String id, String pwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();//�깮�꽦
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.login", map);
		sqlSession.close();
		return memberDTO;
	}
	
	public boolean isCheckId(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();//�깮�꽦
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.isCheckId",id);
		sqlSession.close();
		if(memberDTO == null)
			return false; //�븘�씠�뵒 �궗�슜 媛��뒫
		else
			return true; //�븘�씠�뵒 �궗�슜 遺덇��뒫
	}
	
	public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sido", sido);
		map.put("sigungu", sigungu);
		map.put("roadname", roadname);
		
		
		SqlSession sqlSession = sqlSessionFactory.openSession();//�깮�꽦
		List<ZipcodeDTO> list = sqlSession.selectList("memberSQL.getZipcodeList", map);
		sqlSession.close();
		
		return list;
	}
	
	public void write(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("memberSQL.write",memberDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	
}



















