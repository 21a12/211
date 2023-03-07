package com.ktdsuniversity.edu.goodgag.article_ldl.service;

import com.ktdsuniversity.edu.goodgag.article.vo.ArticleVO;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;

public interface ArticleLdlService {

	public boolean articleLdl(MemberVO memberVO, ArticleVO articleVO, boolean ldl);
}
