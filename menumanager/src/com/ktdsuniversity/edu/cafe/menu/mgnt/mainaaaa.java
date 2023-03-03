package com.ktdsuniversity.edu.cafe.menu.mgnt;

public class mainaaaa {

	public static void main(String[] args) {
		
		int a, b ; 
		a = 0;
		b = 0;
		
		String aa = "12345678901234567890";
		
		a = Integer.MAX_VALUE;
		
		if (aa.length() > Integer.toString(a).length()) {
			// 결과조짐
			System.out.println("결과조짐");
		} else if (aa.length() == Integer.toString(a).length()) {
			for (int i=0 ; i<aa.length(); i++) {
				if (aa.charAt(i) >  Integer.toString(a).charAt(i)) {
					// aa는 범위 초과다.
					System.out.println("범위초과다");
				}
				
			}
		}
		
	}
}
