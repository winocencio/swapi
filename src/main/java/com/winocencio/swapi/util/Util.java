package com.winocencio.swapi.util;

import java.util.List;
import java.util.stream.Collectors;

public class Util {

	private Util() {}
	
	public static List<Integer> getIdsFromUrls(List<String> urls){
		return urls.stream().map(Util::getIdFromUrl).collect(Collectors.toList());
	}
	
	public static Integer getIdFromUrl(String url) {
		return Integer.valueOf(url.split("/")[5]);
	}
}
