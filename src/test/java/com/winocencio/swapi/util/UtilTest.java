package com.winocencio.swapi.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class UtilTest {

	
	@Test
	void whenUrlIsNullAssertNull() {
		Integer idFromUrl = Util.getIdFromUrl(null);
		assertEquals(null,idFromUrl);
	}
	
	@Test
	void whenUrlIsNotDefaultFormatThrowsArrayIndexOutOfBoundsException() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> Util.getIdFromUrl("XXXXXXX/XXXXX"));
	}
	
	@Test
	void whenUrlIsDefaultFormatAssertCorrectNumber() {
		Integer idFromUrl = Util.getIdFromUrl("https://swapi.dev/api/people/1/");
		assertEquals(1,idFromUrl);
	}
	
	@Test
	void whenUrlListIsNullAssertEmptyList() {
		List<Integer> idFromUrl = Util.getIdsFromUrls(null);
		assertTrue(idFromUrl.isEmpty());
	}
	
	@Test
	void whenUrlListIsEmptyAssertEmptyList() {
		List<Integer> idFromUrl = Util.getIdsFromUrls(Collections.emptyList());
		assertTrue(idFromUrl.isEmpty());
	}
	
	@Test
	void whenUrlListContaisAItemAssertOneItem() {
		List<Integer> idsFromUrls = Util.getIdsFromUrls(new ArrayList<String>(List.of("https://swapi.dev/api/people/1/")));
		assertEquals(1,idsFromUrls.size());
	}
}
