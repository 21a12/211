package com.ktdsuniversity.edu.goodgag.reply.dao;

import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;
import com.ktdsuniversity.edu.goodgag.utils.db.AbstractDaoPoolSupport;

public class ReplyDAOImpl extends AbstractDaoPoolSupport<ReplyVO> 
							implements ReplyDAO{

	@Override
	public int createReply(ReplyVO replyVO) {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO REPLIES                                 ");
		query.append("  (REPLY_NO                                          ");
		query.append(" , ARTICLE_NO                                        ");
		query.append(" , EMAIL                                             ");
		query.append(" , DESCRIPT                                          ");
		query.append(" , REGIST_DATE                                       ");
		query.append(" , MODIFY_DATE                                       ");
		query.append(" , PARENT_REPLY_NO)                                  ");
		query.append(" VALUES                                              ");
		query.append(" ( ? /*REPLY_NO*/                                    ");
		query.append(" , ? /*ARTICLE_NO     */                               ");
		query.append(" , ? /*EMAIL          */                               ");
		query.append(" , ? /*DESCRIPT       */                               ");
		query.append(" , SYSDATE /*REGIST_DATE    */                               ");
		query.append(" , SYSDATE /*MODIFY_DATE    */                               ");
		query.append(" , ? /*PARENT_REPLY_NO*/)                              ");
		
		return insert(query.toString(), (pm) -> {
			pm.setString(1, replyVO.getReplyNo());
			pm.setString(2, replyVO.getArticleNo());
			pm.setString(3, replyVO.getEmail());
			pm.setString(4, replyVO.getDescript());
			pm.setString(5, replyVO.getParentReplyNo());
		});
	}

	@Override
	public String createNewReplyNo() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT 'RP-'                           ");
		query.append("  || TO_CHAR(SYSDATE,'YYYYMMDD')        ");
		query.append("  || '-'                                ");
		query.append("  || LPAD(SEQ_REPLIES_PK.NEXTVAL,5,'0') NEW_SEQ ");
		query.append(" FROM DUAL                                ");
		
		return selectOneString(query.toString(), null, (rm) -> {
			return rm.getString("NEW_SEQ");
		});
	}
	
	

}
