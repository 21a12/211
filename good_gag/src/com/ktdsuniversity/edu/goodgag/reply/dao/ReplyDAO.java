package com.ktdsuniversity.edu.goodgag.reply.dao;

import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;

public interface ReplyDAO {

	/**
	 * 댓글 등록
	 * @param replyVO (댓글 정보)
	 * @return insert한 개수
	 */
	public int createReply(ReplyVO replyVO);
	
	public String createNewReplyNo();

}
