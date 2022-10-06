package com.qat.crud.BAC;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.STATUSERROR;
import com.qat.crud.domain.Bundle.ValidationError;
import com.qat.crud.domain.Bundle.Validator;
import com.qat.crud.domain.Bundle.BAC.BundleBACImpl;
import com.qat.crud.domain.Bundle.BAR.BundleBAR;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleBuilder;
import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;
import com.qat.crud.domain.Bundle.model.Status;

@ExtendWith(MockitoExtension.class)
public class BundleBACTest {

    @Mock
    BundleBAR bar;

    @InjectMocks
    BundleBACImpl bac;

    private Bundle givenBundle() {
        return givenBundle(1);
    }

    private Bundle givenBundle(Integer id) {
        return BundleBuilder.builder().id(id).namePackage("monitor").zipCodeOrigin("72820200").zipCodeDestin("72820201")
                .description("used in computer").status(Status.confirmed).build();
    }

    private List<Bundle> givenBundles() {
        return List.of(
                givenBundle(1), givenBundle(2));
    }

    @Test
    public void testFetchAllBundles() {

        final List<Bundle> bundles = givenBundles();

        final BundleResponse responseExpected = new BundleResponse().withDataList(bundles).withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest();

        when(bar.fetchAllBundles(request)).thenReturn(responseExpected);
        BundleResponse bundlesResponse = bac.fetchAllBundles(request);
        assertEquals(responseExpected, bundlesResponse);

    }

    @Test
    public void testFetchBundleById() {

        final Bundle bundle = givenBundle(1);

        final BundleResponse responseExpected = new BundleResponse().withData(bundle).withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest().withData(bundle);

        when(bar.fetchBundleById(request)).thenReturn(responseExpected);
        BundleResponse bundleResponse = bac.fetchBundleById(request);
        assertEquals(responseExpected, bundleResponse);

    }

    @Test
    public void testInsertBundle() {

        final Bundle bundle = givenBundle();

        final BundleResponse responseExpected = new BundleResponse().withData(bundle).withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest().withData(bundle).withData(bundle);

        when(bar.insertBundle(request)).thenReturn(responseExpected);
        BundleResponse bundleResponse = bac.insertBundle(request);
        assertEquals(responseExpected, bundleResponse);

    }

    @Test
    public void testUpdateBundle() {

        final Bundle bundle = givenBundle();

        final BundleResponse responseExpected = new BundleResponse().withData(bundle).withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest().withData(bundle);

        when(bar.updateBundle(request)).thenReturn(responseExpected);
        BundleResponse bundleResponse = bac.updateBundle(request);
        assertEquals(responseExpected.getData(), bundleResponse.getData());

    }

    @Test
    public void testDeleteBundleById() {

        final Bundle bundle = givenBundle();

        final BundleResponse responseExpected = new BundleResponse().withStatus(STATUSERROR.OPERATIONSUCCESS);

        BundleRequest request = new BundleRequest().withData(bundle);
        when(bar.deleteBundleById(request)).thenReturn(responseExpected);
        BundleResponse bundleResponse = bac.deleteBundleById(request);

        assertEquals(responseExpected.getData(), bundleResponse.getData());

    }

    @Test
    public void testUpdateBundleWithInvalidData() {
        final Bundle bundle = givenBundle();
        final BundleResponse responseExpected = new BundleResponse().withStatus(STATUSERROR.VALIDATIONERROR).withMessages(null);
        BundleRequest request = new BundleRequest().withData(bundle);
        when(bar.updateBundle(request)).thenReturn(responseExpected);

        BundleResponse bundleResponse = bac.updateBundle(request);
        assertEquals(responseExpected, bundleResponse);
        
    }

    @Test
    public void testInsertWithInvalidData() {
        final Bundle bundle = givenBundle();
        final BundleResponse responseExpected = new BundleResponse().withStatus(STATUSERROR.VALIDATIONERROR).withMessages(null);
        BundleRequest request = new BundleRequest().withData(bundle);
        when(bar.insertBundle(request)).thenReturn(responseExpected);

        BundleResponse bundleResponse = bac.insertBundle(request);
        assertEquals(responseExpected, bundleResponse);
    }

    @Test
    public void testValidations() {
        final Bundle bundle = new Bundle();
        bundle.setNamePackage(null);

        final BundleResponse responseExpected = new BundleResponse().withStatus(STATUSERROR.VALIDATIONERROR).withMessages(List.of(
                ValidationError.of("namePackage", "namePackage is required")));

        BundleRequest request = new BundleRequest().withData(bundle);

        BundleResponse bundleResponse = bac.insertBundle(request);
        assertEquals(responseExpected.getStatusError(), bundleResponse.getStatusError());
        assertEquals(responseExpected.getData(), bundleResponse.getData());

    }

}
