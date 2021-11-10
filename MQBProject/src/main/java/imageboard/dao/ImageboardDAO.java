package imageboard.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;
import imageboard.bean.ImageboardDTO;


public class ImageboardDAO {
	private static ImageboardDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	
	public static ImageboardDAO getInstance() {
		if(instance == null) { 
			synchronized (ImageboardDAO.class) {
				instance = new ImageboardDAO(); 
			}
		}
		return instance;
	}
	
	public ImageboardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void imageboardWrite(ImageboardDTO imageboardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("imageboardSQL.imageboardWrite", imageboardDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<ImageboardDTO> imageboardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ImageboardDTO> list = sqlSession.selectList("imageboardSQL.getImageboardList",map);
		sqlSession.close();
		return list;
	}

	public int getTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("imageboardSQL.getTotalA");
		sqlSession.close();
		
		return totalA;
	}

	public void imageboardDelete(String[] choice) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("choice",choice);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("imageboardSQL.imageboardDelete",map);
		sqlSession.commit();
		sqlSession.close();
		
	}
}
