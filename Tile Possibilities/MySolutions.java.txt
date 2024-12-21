package string;

import java.util.ArrayList;
import java.util.List;

import com.printer.PrintArray;

public class PrintAllSubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AAABBC";
		int len = s.length();
		PrintArray pa = new PrintArray();
		PrintAllSubStrings pass = new PrintAllSubStrings();
		List<String> lst = new ArrayList<>();
		for(int i=0;i<len;i++) {
			char revChar;
			String reverse = "";
			if(lst.indexOf(String.valueOf(s.charAt(i)))==-1) { //A/B/C
				revChar = s.charAt(i);
				reverse= revChar+reverse;
				lst.add(String.valueOf(s.charAt(i)));//[A]/[A,AB,ABC,ABCC]+[B]/[A,AB,ABC,ABCC,B,BC,BCC]+C
				String temp = String.valueOf(s.charAt(i));
				for(int j=0;j<len;j++) {
					temp +=String.valueOf(s.charAt(j)); //AB/ABC/ABCC/BC/BCC
					revChar = s.charAt(j);
					reverse= revChar+reverse;
					if(lst.indexOf(temp)==-1 && temp.length()<=len && pass.wordCountMatch(s.charAt(i), s, temp)) {
						lst.add(temp);	//[A,AB,ABC,ABCC,B,BC,BCC]
					}
					if(lst.indexOf(reverse)==-1 && temp.length()<=len && pass.wordCountMatch(s.charAt(i), s, reverse)) {
						lst.add(reverse);
					}
				}
				temp="";
			}
		}
		System.out.println("Count:"+lst.size());
		pa.printOneDimArrayList(lst);
	}
	
	public boolean wordCountMatch(char c,String s,String word) {
		int countS = s.split(String.valueOf(c),-1).length-1;
		int countWord = word.split(String.valueOf(c),-1).length-1;
		if(countS>=countWord) {
			return true;
		}
		return false;
	}

}
