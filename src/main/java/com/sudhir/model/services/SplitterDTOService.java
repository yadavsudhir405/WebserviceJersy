package com.sudhir.model.services;

import com.google.gson.Gson;
import com.sudhir.model.SplitterDTO;
/**
 * 
 * @author sudhir
 *
 */
public class SplitterDTOService {
	private static final Gson GSON = new Gson();

	private SplitterDTOService() {
		throw new AssertionError("Object is instantion is not allowed");
	}

	public static SplitterDTO getSplitterDTO(String splitterDTOJson) {
		return GSON.fromJson(splitterDTOJson, SplitterDTO.class);
	}
}
