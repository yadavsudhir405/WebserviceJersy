package com.sudhir.dao;

import java.util.List;

import com.sudhir.dao.entity.SplitterEntity;

/**
 * The SplitterDAO provides an interface for doing opertatin on splitter Table
 * @author sudhir
 *
 */
public interface SplitterDAO {
	public List<SplitterEntity> getAllSplitter();

	public void addSplitter(SplitterEntity splitter);

	public void deleteSplitter(SplitterEntity splitter);

	public SplitterEntity getSplitterByUserName(String userName);

	public void updateSplitter(SplitterEntity splitter);

}
