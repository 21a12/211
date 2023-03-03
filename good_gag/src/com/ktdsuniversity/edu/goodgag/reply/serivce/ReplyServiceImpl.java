package com.ktdsuniversity.edu.goodgag.reply.serivce;

import com.ktdsuniversity.edu.goodgag.reply.dao.ReplyDAO;
import com.ktdsuniversity.edu.goodgag.reply.dao.ReplyDAOImpl;
import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService{
	
	private ReplyDAO replyDAO;
	
	public ReplyServiceImpl() {
		replyDAO = new ReplyDAOImpl();
	}

	@Override
	public boolean createReply(ReplyVO replyVO) {
		// 1. 새로운 댓글의 PK값 (REPLY_NO)를 받아온다.
		String newArticleNo = replyDAO.createNewReplyNo();

		// 2. PK값 (REPLY_NO)을 파라미터 (replyVO)에 할당한다.
		replyVO.setArticleNo(newArticleNo);

		// 3. 댓글을 등록한다.
		int insertCount = replyDAO.createReply(replyVO);

		return insertCount > 0;
	}

	@Override
	public void updateReply(ReplyVO replyVO) {
		
	}

}
