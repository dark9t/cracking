package cracking;
import java.util.*;

public class FindNonRepeatedCharacter {
	public static Character Find(String input){
		
		//prepare the hash table for further use
		Hashtable<Character, Integer> record=new Hashtable<Character, Integer>();
		for(int i=0; i<input.length();i++){
			Character key=input.charAt(i);
			if(record.containsKey(key)){
				record.put(key, record.get(key)+1);
			}else{
				record.put(key, 1);
			}
		}
		
		//scan for the first character has occured only once
		for(int i=0; i<input.length(); i++){
			int count=record.get(input.charAt(i));
			if(count==1)
				return input.charAt(i);
		}
		return null;
	}
}
