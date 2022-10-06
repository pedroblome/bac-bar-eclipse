package com.qat.crud.BAR;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.STATUSERROR;
import com.qat.crud.domain.Bundle.BAR.BundleBARImpl;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleBuilder;
import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;
import com.qat.crud.domain.Bundle.model.Status;

@SpringBootTest
class BundleBARTestDB {

    @Autowired
    private BundleBARImpl bar;

    private Bundle givenBundle() {
        return givenBundle(1);
    }

    private Bundle givenBundle(Integer id) {
        return BundleBuilder.builder().id(id).namePackage("monitor").zipCodeOrigin("72820200").zipCodeDestin("72820201")
                .description("used in computer").status(Status.confirmed).build();
    }

    private List<Bundle> givenBundles() {
        return List.of(givenBundle(1), givenBundle(2));
    };

    @Test
    @Order(1)
    void InsertBundle() {

        final Bundle bundleExpected = givenBundle(1);
        final BundleResponse responseExpected = new BundleResponse().withData(bundleExpected).withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest().withData(bundleExpected);

        BundleResponse bundlesResponse = bar.insertBundle(request);
        assertEquals(responseExpected, bundlesResponse);

    }

    @Test
    @Order(2)
    void fetchAllBundles() {
        final List<Bundle> bundleExpected = givenBundles();
        final BundleResponse responseExpected = new BundleResponse().withDataList(bundleExpected).withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest();

        BundleResponse bundlesResponse = bar.fetchAllBundles(request);

        assertEquals(responseExpected, bundlesResponse);

    }

    @Test
    @Order(3)
    void fetchBundleById() {
        final Bundle bundleExpected = givenBundle(1);
        final BundleResponse responseExpected = new BundleResponse().withData(bundleExpected).withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest().withData(bundleExpected);

        BundleResponse bundlesResponse = bar.fetchBundleById(request);

        assertEquals(responseExpected, bundlesResponse);

    }

    @Test
    @Order(4)
    void updateBundleById() {
        final Bundle bundleExpected = givenBundle(1);
        final BundleResponse responseExpected = new BundleResponse().withData(bundleExpected).withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest().withData(bundleExpected);

        BundleResponse bundlesResponse = bar.updateBundle(request);

        assertEquals(responseExpected, bundlesResponse);

    }

    @Test
    @Order(5)
    void deleteBundleById() {
        final Bundle bundleExpected = givenBundle(1);
        final BundleResponse responseExpected = new BundleResponse().withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest().withData(bundleExpected);

        BundleResponse bundlesResponse = bar.deleteBundleById(request);

        assertEquals(responseExpected.getStatusError(), bundlesResponse.getStatusError());

    }

}
