package com.ktdsuniversity.edu.goodgag.article.service;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.article.vo.ArticleVO;

public interface ArticleService {
	
	/**
	 * 새로운 게시글을 등록한다.
	 * (게시글의 ID를 발급 받아서
	 * setArticleNo 에 할당한다)
	 * @param articleVO 
	 * @return 등록 결과
	 */
	public boolean createArticle(ArticleVO articleVO);

	public List<ArticleVO> getAllArticles();
	
	public boolean deleteArticle(String articleNo);
}
