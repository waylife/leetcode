package rxread.leetcode;

import java.util.ArrayList;

/**
 * Date:2014-09-12 00:42<br/>
 * Day 1:<br/>
 * Address:https://oj.leetcode.com/problems/reverse-words-in-a-string/<br/>
 * */
public class D1ReverseWordsInAString {

	public static void main(String[] args) {
		System.out.println(reverseWords("   a   b "));
		System.out.println(reverseWords(null));
		System.out.println(reverseWords("   "));
		System.out.println(reverseWords("a   b   "));
		System.out.println(reverseWords("   sa   b "));
		System.out.println(reverseWords("a"));
		System.out.println(reverseWords("a bg"));
		System.out.println(reverseWords(" ab "));
		System.out.println(reverseWords("   a   fsb "));
	}

	public static String reverseWords(String s) {
		if (s == null)
			return s;
		char[] charArray = s.toCharArray();
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		int sLength = charArray.length;
		int currentSbCount=0;
		for (int i = 0; i < sLength; i++) {
			if (charArray[i] == ' ') {
				if(currentSbCount!=0){
					list.add(sb.toString());
					sb.delete(0, currentSbCount);
					currentSbCount=0;
				}else{
					continue;
				}
			}else{
				sb.append(charArray[i]);
				++currentSbCount;
				if(i==sLength-1){//judge if the last letter
					list.add(sb.toString());
					sb.delete(0, currentSbCount);
					currentSbCount=0;
				}
			}
		}
		if(currentSbCount>0){//reset the StringBuilder
			sb.delete(0, currentSbCount);
		}
		
		if(list.size()==0)
			return "";
		else{
			int size=list.size();
			for(int i=size-1;i>=0;--i){
				sb.append(list.get(i));
				if(i!=0){
					sb.append(' ');
				}
			}
		}
		return sb.toString();
	}

}
