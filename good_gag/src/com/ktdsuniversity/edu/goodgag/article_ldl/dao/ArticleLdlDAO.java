package com.ktdsuniversity.edu.goodgag.article_ldl.dao;

import com.ktdsuniversity.edu.goodgag.article.vo.ArticleLdlVO;
import com.ktdsuniversity.edu.goodgag.article.vo.ArticleVO;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;

public interface ArticleLdlDAO {
	
	public int newLdlArticle(MemberVO memberVO, ArticleVO articleVO, boolean ldl);

	public int deleteLdlArticle(MemberVO memberVO, ArticleVO articleVO, boolean ldl);

	public int updateLdlArticle(MemberVO memberVO, ArticleVO articleVO, boolean ldl);

	public ArticleLdlVO getArticleLdl(ArticleLdlVO articleLdlVO);

}
