package com.sudhir.dao.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sudhir.dao.SplitterDAO;
import com.sudhir.dao.entity.SplitterEntity;



@Repository("splitterDAOImpl")
public class SplitterDAOImpl implements SplitterDAO {
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<SplitterEntity> getAllSplitter() {
		return sessionFactory.getCurrentSession().createCriteria(SplitterEntity.class).list();
	}
	

	@Override
	public void addSplitter(SplitterEntity splitter) {
		sessionFactory.getCurrentSession().save(splitter);
	}

	@Override
	public void deleteSplitter(SplitterEntity splitter) {
		sessionFactory.getCurrentSession().delete(splitter);
	}

	@Override
	public SplitterEntity getSplitterByUserName(String userName) {
		return null;
		
	}

	
	@Override
	public void updateSplitter(SplitterEntity splitter) {
		
		
	}

}
