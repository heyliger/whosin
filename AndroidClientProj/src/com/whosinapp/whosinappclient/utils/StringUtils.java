package com.whosinapp.whosinappclient.utils;

import java.util.List;

public class StringUtils {

	public static String join(List<Integer> list, String delim) {

	    StringBuilder sb = new StringBuilder();

	    String loopDelim = "";

	    for(Integer s : list) {

	        sb.append(loopDelim);
	        sb.append(s);            

	        loopDelim = delim;
	    }

	    return sb.toString();
	}

	
}

