package com.qat.crud.BAR;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qat.crud.domain.Bundle.BAR.BundleBuilder;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.Status;

@ExtendWith(MockitoExtension.class)
public class BundleBuilderTest {
	
	  @Test
	  public void TestBuilderInstantiation() {

	     Bundle bundleExpected =
	        new Bundle(1, "name", "72820200", "72820201", "description", Status.confirmed);

	     Bundle bundleActual1 =
	        BundleBuilder.builder()
	            .id(1).namePackage("name").zipCodeOrigin("72820200").zipCodeDestin("72820201").description("description").status(Status.confirmed)
	            .build();

	    final Bundle bundleActual2 = new Bundle();
	    bundleActual2.setId(1);
	    bundleActual2.setNamePackage("name");
	    bundleActual2.setZipCodeOrigin("72820200");
	    bundleActual2.setZipCodeDestin("72820201");
	    bundleActual2.setDescription("description");
	    bundleActual2.setStatus(Status.confirmed);

	    assertEquals( bundleActual1,bundleExpected);
	    assertEquals( bundleActual2,bundleExpected);



	  }

}
