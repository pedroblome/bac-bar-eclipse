package com.qat.crud.domain.Bundle.BAC;

import com.qat.crud.domain.Bundle.Validator;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.Status;

public class BundleValidator extends Validator {

	private final Bundle bundle;

	public BundleValidator(Bundle abundle) {
		bundle = abundle;
	}

	@Override
	public void checkValidState() {

		checkRequired("namePackage", bundle.getNamePackage());
		checkMaxLength("namePackage", bundle.getNamePackage(), 20);

		checkRequired("zipCodeOrigin", bundle.getZipCodeOrigin());
		checkLength("zipCodeOrigin", bundle.getZipCodeOrigin(), 8);

		checkRequired("zipCodeDestin", bundle.getZipCodeDestin());
		checkLength("zipCodeDestin", bundle.getZipCodeDestin(), 8);

		checkRequired("description", bundle.getDescription());
		checkMaxLength("description", bundle.getDescription(), 60);

		checkStatus("status", bundle.getStatus());

	}

}
