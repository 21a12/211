package com.ktdsuniversity.edu.goodgag.reply.serivce;

import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;

public interface ReplyService {
	/**
	 * 댓글 등록
	 * @param replyVO
	 * @return 등록 결과
	 */
	public boolean createReply(ReplyVO replyVO);

	public void updateReply(ReplyVO replyVO);
	
	

}
