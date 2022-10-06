package com.qat.crud.BAR;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qat.crud.domain.Bundle.STATUSERROR;
import com.qat.crud.domain.Bundle.BAR.BundleBARImpl;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleBuilder;
import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;
import com.qat.crud.domain.Bundle.model.Status;

@ExtendWith(MockitoExtension.class)
class BundleBARTest {

    @Mock
    SqlSession sqlSession;

    @InjectMocks
    BundleBARImpl bar;

    private Bundle givenBundle() {
        return givenBundle(1);
    }

    private Bundle givenBundle(Integer id) {
        return BundleBuilder.builder().id(id).namePackage("monitor").zipCodeOrigin("72820200").zipCodeDestin("72820201")
                .description("used in computer").status(Status.confirmed).build();
    }

    private List<Bundle> givenBundles() {
        return List.of(givenBundle(1), givenBundle(2), givenBundle(3));
    }

    @Test
    void testFetchAllBundles() {

        final List bundleExpected = givenBundles();
        final BundleResponse responseExpected = new BundleResponse().withDataList(bundleExpected)
                .withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest();

        when(sqlSession.selectList(any(String.class))).thenReturn(bundleExpected);

        BundleResponse bundlesResponse = bar.fetchAllBundles(request);
        Assertions.assertEquals(responseExpected, bundlesResponse);

    }

    @Test
    void testFetchBundleById() {

        final Bundle bundleExpected = givenBundle();
        final BundleResponse responseExpected = new BundleResponse().withData(bundleExpected)
                .withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest().withData(bundleExpected);
        when(sqlSession.selectOne(any(String.class), any(java.lang.Integer.class))).thenReturn(bundleExpected);

        BundleResponse bundleResponse = bar.fetchBundleById(request);
        Assertions.assertEquals(responseExpected, bundleResponse);

    }

    @Test
    void testInsertBundle() {

        final Bundle bundleExpected = givenBundle();
        final BundleResponse responseExpected = new BundleResponse().withData(bundleExpected)
                .withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest().withData(bundleExpected);
        when(sqlSession.insert(any(String.class), any(Bundle.class))).thenReturn(1);

        BundleResponse bundleResponse = bar.insertBundle(request);

        Assertions.assertEquals(responseExpected, bundleResponse);

    }

    @Test
    void testUpdateBundleById() {

        final Bundle bundleExpected = givenBundle();
        final BundleResponse responseExpected = new BundleResponse().withData(bundleExpected)
                .withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest().withData(bundleExpected);
        when(sqlSession.update(any(String.class), any(Bundle.class))).thenReturn(1);

        BundleResponse bundleResponse = bar.updateBundle(request);

        Assertions.assertEquals(responseExpected, bundleResponse);

    }

    @Test
    void testDeleteBundleById() {
        final Bundle bundleExpected = givenBundle();

        final BundleResponse responseExpected = new BundleResponse().withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest().withData(bundleExpected);
        when(sqlSession.delete(any(String.class), any(Integer.class))).thenReturn(1);
        BundleResponse bundleResponse = bar.deleteBundleById(request);

        Assertions.assertEquals(responseExpected, bundleResponse);

    }

    @Test
    void testFetchAllBundlesFail() {

        final List bundleExpected = null;
        final BundleResponse responseExpected = new BundleResponse().withStatus(STATUSERROR.NOROWSFOUNDERROR);

        BundleRequest request = new BundleRequest();
        when(sqlSession.selectList(any(String.class))).thenReturn(bundleExpected);

        BundleResponse bundlesResponse = bar.fetchAllBundles(request);
        Assertions.assertEquals(responseExpected, bundlesResponse);

    }

    @Test
    void testFetchBundleByIdFail() {

        final Bundle bundleExpected = null;
        final BundleResponse responseExpected = new BundleResponse().withStatus(STATUSERROR.NOROWSFOUNDERROR);

        BundleRequest request = new BundleRequest();
        when(sqlSession.selectOne(any(String.class), any(java.lang.Integer.class))).thenReturn(bundleExpected);

        BundleResponse bundlesResponse = bar.fetchBundleById(request);
        Assertions.assertEquals(responseExpected, bundlesResponse);
    }

    @Test
    void testInsertBundleFail() {

        final Bundle bundleExpected = givenBundle();
        final BundleResponse responseExpected = new BundleResponse().withStatus(STATUSERROR.PERSISTENCEERROR);

        BundleRequest request = new BundleRequest().withData(bundleExpected);
        when(sqlSession.insert(any(String.class), any(Bundle.class))).thenReturn(0);

        BundleResponse bundleResponse = bar.insertBundle(request);

        Assertions.assertEquals(responseExpected, bundleResponse);

    }

    @Test
    void testUpdateBundleByIdFail() {

        final Bundle bundleExpected = givenBundle();
        final BundleResponse responseExpected = new BundleResponse().withStatus(STATUSERROR.PERSISTENCEERROR);

        BundleRequest request = new BundleRequest().withData(bundleExpected);
        when(sqlSession.update(any(String.class), any(Bundle.class))).thenReturn(0);

        BundleResponse bundleResponse = bar.updateBundle(request);

        Assertions.assertEquals(responseExpected, bundleResponse);

    }

    @Test
    void testDeleteBundleByIdFaild() {
        final Bundle bundleExpected = givenBundle();

        final BundleResponse responseExpected = new BundleResponse().withStatus(STATUSERROR.NOROWSREMOVEDERROR);

        BundleRequest request = new BundleRequest().withData(bundleExpected);
        when(sqlSession.delete(any(String.class), any(Integer.class))).thenReturn(0);

        BundleResponse bundleResponse = bar.deleteBundleById(request);

        Assertions.assertEquals(responseExpected, bundleResponse);

    }

}