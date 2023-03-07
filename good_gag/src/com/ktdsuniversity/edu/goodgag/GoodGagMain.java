package com.ktdsuniversity.edu.goodgag;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.article.service.ArticleService;
import com.ktdsuniversity.edu.goodgag.article.service.ArticleServiceImpl;
import com.ktdsuniversity.edu.goodgag.article.vo.ArticleVO;
import com.ktdsuniversity.edu.goodgag.article_ldl.service.ArticleLdlService;
import com.ktdsuniversity.edu.goodgag.article_ldl.service.ArticleLdlServiceImpl;
import com.ktdsuniversity.edu.goodgag.member.dao.MemberDAO;
import com.ktdsuniversity.edu.goodgag.member.dao.MemberDAOImpl;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;
import com.ktdsuniversity.edu.goodgag.reply.serivce.ReplyService;
import com.ktdsuniversity.edu.goodgag.reply.serivce.ReplyServiceImpl;
import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;

public class GoodGagMain {

	public static void main(String[] args) {
		// 회원가입
		MemberDAO memberDAO = new MemberDAOImpl();
		MemberVO memberVO = new MemberVO();
		memberVO.setEmail("1111@gmail.com");
		memberVO.setNickname("tester1");
		memberVO.setPassword("1q2w3e4r");
//		memberDAO.createMember(memberVO);
		
		// 게시글 작성
		ArticleService articleService = new ArticleServiceImpl();
		ArticleVO articleVO = new ArticleVO();
		
		articleVO.setEmail(memberVO.getEmail());
		articleVO.setTitle("오늘 점심");
		articleVO.setDescript("순대볶음");
		articleVO.setSource("방배동케이티");
		articleVO.setNotiYN("N");
		boolean isSuccess = articleService.createArticle(articleVO);
//		System.out.println(isSuccess);
//		System.out.println(articleVO.getArticleNo());
		
		// 게시글 목록 조회 (댓글 개수 포함)
		List<ArticleVO> articleList = articleService.getAllArticles();
		for (ArticleVO eachArticle : articleList) {
			System.out.println("====================================");
			System.out.println(eachArticle.getTitle());
			System.out.println(eachArticle.getArticleNo() + "\t" + eachArticle.getRegistDate());
			System.out.println(eachArticle.getMemberVO().getNickname());
			System.out.println(eachArticle.getReplyList().size());
		}
		
		// 게시글 상세 조회 (댓글 포함)
		
		// 게시글 수정
		
		// 댓글 작성
		ReplyService replyService = new ReplyServiceImpl();
		ReplyVO replyVO = new ReplyVO();

		replyVO.setArticleNo("AR-20230302-00074");
		replyVO.setEmail(memberVO.getEmail());
		replyVO.setDescript("댓글달았읍니다");
//		replyVO.setParentReplyNo(null);		// 입력안하면 알아서 null
		
//		boolean isSuccess = replyService.createReply(replyVO);
//		System.out.println(isSuccess);
//		System.out.println(replyVO.getReplyNo());
		// 리플번호 게시글번호 이메일 내용 작성날자 수정날자 상위댓글
		
		
		// 댓글 수정
		
//		replyService.updateReply(replyVO);
		// !!게시글 삭제
		// String으로 하는것이 맞을까, articleVO로 하는것이 맞을까 
		String articleNo;
		articleNo = "AR-20230306-00193";
		isSuccess = articleService.deleteArticle(articleNo);
		System.out.println(isSuccess);
		
		
		// 댓글 삭제
		
		// !!게시글 좋아요
		MemberVO testMem = new MemberVO();
		ArticleVO testArt = new ArticleVO();
		boolean decl = false;
		testMem.setEmail("1@gmail.com");
		testArt.setArticleNo("AR-20230303-00121");
		
		ArticleLdlService articleLdlService = new ArticleLdlServiceImpl();
		articleLdlService.articleLdl(testMem, testArt, decl);
		
		// 다시 누르기
		
		
		
		// !!게시글 싫어요
		// 게시글 신고
		
		
		
		// 댓글 좋아요
		// 댓글 싫어요

	}

}
