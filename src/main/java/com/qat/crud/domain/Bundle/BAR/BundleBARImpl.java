package com.qat.crud.domain.Bundle.BAR;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.qat.crud.domain.Bundle.model.Bundle;


@Repository
public class BundleBARImpl implements BundleBAR {

	  private final BundleMapper mapper;
	//  private final SqlSession sqlSession;

	  public BundleBARImpl(BundleMapper mapper/*, SqlSession sqlSession*/) {
	    this.mapper = mapper;
//	    this.sqlSession = sqlSession;
	  }
		
	@Override
	public List<Bundle> fetchAllBundles() {
		return mapper.fetchAll();
	}

	@Override
	public Bundle fetchBundleById(Integer id) {
		return mapper.fetchById(id);
	}

	@Override
	public boolean insertBundle(Bundle bundle) {
		return mapper.insert(bundle);
	}

	@Override
	public boolean updateBundle(Bundle bundle) {
		return mapper.updatedById(bundle);
	}

	@Override
	public boolean deleteBundle(Integer id) {
		return mapper.deleteById(id);
	}


}
