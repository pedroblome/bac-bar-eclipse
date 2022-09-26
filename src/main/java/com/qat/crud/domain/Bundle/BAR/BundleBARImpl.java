package com.qat.crud.domain.Bundle.BAR;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qat.crud.domain.Bundle.STATUSERROR;
import com.qat.crud.domain.Bundle.BAR.mapper.BundleMapper;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;

@Repository
public class BundleBARImpl implements BundleBAR {
    @Autowired
    private BundleMapper mapper;

    public BundleBARImpl(BundleMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BundleResponse fetchAllBundles(BundleRequest request) {

        final List<Bundle> bundles = mapper.fetchAll();
        if(Objects.nonNull(bundles)) {
            return new BundleResponse().withDataList(bundles).withStatus(STATUSERROR.OPERATIONSUCCESS);
        }
        return new BundleResponse().withStatus(STATUSERROR.NOROWSFOUNDERROR);        

    }

    @Override
    public BundleResponse fetchBundleById(BundleRequest request) {
        final Bundle bundle = mapper.fetchById(request.getData().getId());

        if(Objects.nonNull(bundle)) {
            return new BundleResponse().withData(bundle).withStatus(STATUSERROR.OPERATIONSUCCESS);
        }
        return new BundleResponse().withStatus(STATUSERROR.NOROWSFOUNDERROR);

    }

    @Override
    public BundleResponse insertBundle(BundleRequest request) {
        final Bundle bundle = request.getData();
        if(mapper.insert(bundle)) {
            return new BundleResponse().withData(bundle).withStatus(STATUSERROR.OPERATIONSUCCESS);
        }
        return new BundleResponse().withStatus(STATUSERROR.PERSISTENCEERROR);
    }

    @Override
    public BundleResponse updateBundle(BundleRequest request) {
        final Bundle bundle = request.getData();
        if(mapper.updatedById(bundle)) {
            return new BundleResponse().withData(bundle).withStatus(STATUSERROR.OPERATIONSUCCESS);
        }
        return new BundleResponse().withStatus(STATUSERROR.PERSISTENCEERROR);
    }

    @Override
    public BundleResponse deleteBundleById(BundleRequest request) {
        
        if(mapper.deleteById(request.getData().getId())) {
            return new BundleResponse().withStatus(STATUSERROR.OPERATIONSUCCESS);
        }
        return new BundleResponse().withStatus(STATUSERROR.NOROWSREMOVEDERROR);
    }

}
