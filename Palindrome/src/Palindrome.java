
public class Palindrome {
	public static void main(String [] args){
		
		createPalindrome("ABCDEF");
	}
	
	public static void createPalindrome(String input){
		int stringTable[][] = new int[input.length()][input.length()];
		int charAdded = 0;
		
		for(int i = 0; i < input.length(); i ++){
			for(int j = 0; j < input.length(); j ++){
				if(input.charAt(i) == input.charAt(input.length() - 1 - j)){
					if(i == 0 || j == 0){
						stringTable[i][j] = 1;
					}else{
						stringTable[i][j] = stringTable[i - 1][j - 1] + 1;
					} 
				}else{
					if(i == 0 || j == 0){
						stringTable[i][j] = 0;
					}else{
						stringTable[i][j] = Math.max(stringTable[i - 1][j],stringTable[i][j - 1]);
					}					
				}
			}
		}
		charAdded = input.length() - stringTable[input.length() - 1][input.length() - 1];	
		char palindrome[] = new char[input.length() + charAdded];
		
		int i = 0;
		int j = input.length() - 1;
		int index = 0;
		while( i <= j){
			if(input.charAt(i) == input.charAt(j)){
				if( i  == j){
					palindrome[index] = input.charAt(i);
					i ++;
					j --;
				}else{
					palindrome[index] = input.charAt(i);
					palindrome[palindrome.length - 1 - index] = input.charAt(j);
					index ++;
					i ++;
					j --;
				}				
			}else{
				palindrome[index] = input.charAt(i);
				palindrome[palindrome.length - 1 - index] = input.charAt(i);
				index ++;
				palindrome[index] = input.charAt(j);
				palindrome[palindrome.length - 1 - index] = input.charAt(j);
				index ++;
				i ++;
				j --;
			}
		}
		
		i = 0;
		String palindromeString = "";
		while( i < palindrome.length){
			palindromeString += palindrome[i];
			i ++;
		}
		System.out.println(palindromeString);
	}
}
