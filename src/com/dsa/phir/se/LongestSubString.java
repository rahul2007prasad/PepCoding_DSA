package com.dsa.phir.se;

public class LongestSubString {

	    public int lengthOfLongestSubstring(String s) {
	        int maxLen =0;
	        int currLen =0;

	        int i=0;
	        int j= -1;

	        boolean[] set = new boolean[256];

	        while(i < s.length()){
	            char ch_to_acquire = s.charAt(i);


	            //dupliccy
	            while(set[ch_to_acquire] == true){
	                j++;
	                char ch_to_release = s.charAt(j);
	                set[ch_to_release] = false;
	            }

	            //acquire
	            set[ch_to_acquire] = true;

	            //update lenght
	            currLen = i - j;
	            if(currLen > maxLen){
	                maxLen = currLen;
	            }
	            i++;
	        }
	        return maxLen;
	    }
	}

