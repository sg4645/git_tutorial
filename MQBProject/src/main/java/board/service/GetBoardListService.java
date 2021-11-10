package board.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetBoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		//�뜲�씠�꽣
		int pg = Integer.parseInt(request.getParameter("pg"));
		//1�럹�씠吏��떦 5媛쒖뵫
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		List<BoardDTO> list = boardDAO.boardList(map);
		
		//세션
		HttpSession session= request.getSession();
		String memId= (String)session.getAttribute("memId");
		
		//paging
		int totalA=boardDAO.getTotalA();
		
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		//List -> json�쑝濡� 蹂��솚
		JSONObject json = new JSONObject();
		
		if(list != null) {
			JSONArray array = new JSONArray();
			for(BoardDTO boardDTO : list) {
				JSONObject temp = new JSONObject();
	            temp.put("seq", boardDTO.getSeq());
	            temp.put("id", boardDTO.getId());
	            temp.put("name", boardDTO.getName());
	            temp.put("email", boardDTO.getEmail());
	            temp.put("subject", boardDTO.getSubject());
	            temp.put("content", boardDTO.getContent());
	            
	            temp.put("ref", boardDTO.getRef());
	            temp.put("lev", boardDTO.getLev());
	            temp.put("step", boardDTO.getStep());
	            temp.put("pseq", boardDTO.getPseq());
	            temp.put("reply", boardDTO.getReply());
	            
	            temp.put("hit", boardDTO.getHit());
	            temp.put("logtime", sdf.format(boardDTO.getLogtime()));
	         
	            array.add(temp);

			}//for
			
			json.put("list", array);
			
			//세션 -> json
			json.put("memId", memId);
			
		}//if
		
		//BoardPaging -> json
		//JSONObject paging = new JSONObject();
		
		json.put("boardPaging", boardPaging.getPagingHTML().toString());
		//System.out.println(json);
		
		
		request.setAttribute("list", json);
		return "/board/getBoardList.jsp";
	}

}
