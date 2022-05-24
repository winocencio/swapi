package com.winocencio.swapi.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

	private Util() {}
	
	public static List<Integer> getIdsFromUrls(List<String> urls){
		if(urls == null)
			return Collections.emptyList();
		
		return urls.stream().map(Util::getIdFromUrl).collect(Collectors.toList());
	}
	
	public static Integer getIdFromUrl(String url) {
		if(url == null)
			return null;
		
		return Integer.valueOf(url.split("/")[5]);
	}
}
