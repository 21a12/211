package com.ktdsuniversity.edu.market;

public class Main {

	public static void main(String[] args) {
		//	파라미터 ( String 이름 , int 돈 , int 사과개수 )
		Buyer buyer = new Buyer("구매자", 5_000_000, 0);
		Seller seller = new Seller("판매자", 10_000_000, 10);
		
		// buy(Seller seller, int num) seller에게 num 만큼 산다.
		buyer.buy(seller, 5);
		
		
		
	}
	
}
