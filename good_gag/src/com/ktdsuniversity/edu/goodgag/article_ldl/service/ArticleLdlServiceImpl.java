package com.ktdsuniversity.edu.goodgag.article_ldl.service;

import com.ktdsuniversity.edu.goodgag.article.vo.ArticleVO;
import com.ktdsuniversity.edu.goodgag.article_ldl.dao.ArticleLdlDAO;
import com.ktdsuniversity.edu.goodgag.article_ldl.dao.ArticleLdlDAOImpl;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;

public class ArticleLdlServiceImpl implements ArticleLdlService{

	private ArticleLdlDAO articleLdlDAO;
	
	public ArticleLdlServiceImpl() {
		articleLdlDAO = new ArticleLdlDAOImpl();
	}
	
	@Override
	public boolean articleLdl(MemberVO memberVO, ArticleVO articleVO, boolean decl) {
//		boolean result = false;
		// 조회시 없다면 new
		// 있다면(1) 입력값과 같으면 delete, 있다면(2) 입력값과 다르면 update
		
		
		
		
		articleLdlDAO.newLdlArticle(memberVO, articleVO, decl);
		articleLdlDAO.deleteLdlArticle(memberVO, articleVO, decl);
		articleLdlDAO.updateLdlArticle(memberVO, articleVO, decl);
		
		return false;
	}

}
