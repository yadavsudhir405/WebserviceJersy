package com.sudhir.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sudhir.dao.SplitterDAO;
import com.sudhir.dao.entity.SplitterEntity;

/**
 * The SplitterEntityService class performs operations on Splitter Table
 * 
 * @author sudhir
 *
 */
@Service("splitterEntityService")
public class SplitterEntityService {
	@Autowired
	private SplitterDAO splitterDAO;

	public void setSplitterDAO(SplitterDAO splitterDAO) {
		this.splitterDAO = splitterDAO;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public void addSplitter(SplitterEntity splitter) {
		splitterDAO.addSplitter(splitter);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public List<SplitterEntity> getAllSplitter() {
		return splitterDAO.getAllSplitter();
	}
}
