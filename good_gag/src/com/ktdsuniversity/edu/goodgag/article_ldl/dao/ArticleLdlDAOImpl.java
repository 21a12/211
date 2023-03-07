package com.ktdsuniversity.edu.goodgag.article_ldl.dao;

import com.ktdsuniversity.edu.goodgag.article.vo.ArticleLdlVO;
import com.ktdsuniversity.edu.goodgag.article.vo.ArticleVO;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;
import com.ktdsuniversity.edu.goodgag.utils.db.AbstractDaoPoolSupport;

public class ArticleLdlDAOImpl 
			extends AbstractDaoPoolSupport<ArticleLdlVO>
			implements ArticleLdlDAO{

	@Override
	public int newLdlArticle(MemberVO memberVO, ArticleVO articleVO, boolean ldl) {
		// 좋싫 목록 조회 시 내것이 없다면 insert.
		// 내것이 있다면...1 입력값과 기존값이 같다면 delete
		// 내것이 있다면...2 입력값과 기존값이 다르다면 update
		
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO ARTICLE_LIKE_DISLIKE ");
		query.append("  (EMAIL                          ");
		query.append(" , ARTICLE_NO                     ");
		query.append(" , TYPE)                          ");
		query.append(" VALUES                           ");
		query.append("  (? /*EMAIL*/                    ");
		query.append(" , ? /*ARTICLE_NO*/               ");
		query.append(" , ? /*TYPE*/ )                   ");

		return insert(query.toString(), (pm) -> {
			pm.setString(1, memberVO.getEmail());
			pm.setString(2, articleVO.getArticleNo());
			String type;
			type = ldl ? "L" : "D";
			pm.setString(3, type);
		});
	}
	
	@Override
	public int deleteLdlArticle(MemberVO memberVO, ArticleVO articleVO, boolean ldl) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE                    ");
		query.append(" FROM ARTICLE_LIKE_DISLIKE ");
		query.append(" WHERE ARTICLE_NO = ?      ");
		
		String articleNo = articleVO.getArticleNo();
		
		return update(query.toString(), (pm) -> {
			pm.setString(1, articleNo);
		});
	}
	
	
	@Override
	public int updateLdlArticle(MemberVO memberVO, ArticleVO articleVO, boolean ldl) {
		StringBuffer query = new StringBuffer();
		query.append(" UPDATE ARTICLE_LIKE_DISLIKE ");
		query.append(" SET TYPE = ?                ");
		query.append(" WHERE ARTICLE_NO = ?        ");
		
		String likeDislike = ldl ? "L" : "D" ;
		
		return update(query.toString(), (pm) -> {
			pm.setString(1, likeDislike);
			pm.setString(2, articleVO.getArticleNo());
			
			
		});
	}

	@Override
	public ArticleLdlVO getArticleLdl(ArticleLdlVO articleLdlVO) {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT EMAIL                ");
		query.append("      , ARTICLE_NO           ");
		query.append("      , TYPE                 ");
		query.append("   FROM ARTICLE_LIKE_DISLIKE ");
		
		selectOne(query.toString(), null, (rm) -> {
			String 
		});
		
		return null;
	}

}
