package com.qat.crud.domain.Bundle.BAR;

import java.util.List;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.qat.crud.domain.Bundle.STATUSERROR;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;

@Repository
public class BundleBARImpl implements BundleBAR {

    private final SqlSession sqlSession;

    public BundleBARImpl( SqlSession sqlSession) {
      this.sqlSession = sqlSession;
    }
    
    

    @Override
    @Transactional(readOnly = true)
    public BundleResponse fetchAllBundles(BundleRequest request) {

        final List<Bundle> bundles = sqlSession.selectList("fetchAllBundle");
        if(Objects.nonNull(bundles)) {
            return new BundleResponse().withDataList(bundles).withStatus(STATUSERROR.OPERATIONSUCCESS);
        }
        return new BundleResponse().withStatus(STATUSERROR.NOROWSFOUNDERROR);      

    }

    @Override
    @Transactional(readOnly = true)
    public BundleResponse fetchBundleById(BundleRequest request) {
        final Bundle bundle =sqlSession.selectOne("fetchByIdBundle", request.getData().getId());

        if(Objects.nonNull(bundle)) {
            return new BundleResponse().withData(bundle).withStatus(STATUSERROR.OPERATIONSUCCESS);
        }
        return new BundleResponse().withStatus(STATUSERROR.NOROWSFOUNDERROR);

    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public BundleResponse insertBundle(BundleRequest request) {
        final Bundle bundle = request.getData();
        if (sqlSession.insert("insertBundle", bundle)>0) {
        return new BundleResponse().withData(bundle).withStatus(STATUSERROR.OPERATIONSUCCESS);
        }
        return new BundleResponse().withStatus(STATUSERROR.PERSISTENCEERROR);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public BundleResponse updateBundle(BundleRequest request) {
        final Bundle bundle = request.getData();
        if (sqlSession.update("updateBundle",bundle ) == 1) {
            return new BundleResponse().withData(bundle).withStatus(STATUSERROR.OPERATIONSUCCESS);
        }
        return new BundleResponse().withStatus(STATUSERROR.PERSISTENCEERROR);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public BundleResponse deleteBundleById(BundleRequest request) {
        final Integer id = request.getData().getId();
        
        if (sqlSession.delete("deleteBundle",id)== 1) {
            return new BundleResponse().withStatus(STATUSERROR.OPERATIONSUCCESS);
        }
        return new BundleResponse().withStatus(STATUSERROR.NOROWSREMOVEDERROR);
    }
    
    public SqlSession getSqlSession() {
        return sqlSession;
      }

}
