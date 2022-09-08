package com.qat.crud.domain.Bundle.BAC;

import com.qat.crud.domain.Bundle.Validator;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.Status;

public class BundleValidator extends Validator {

	private final Bundle bundle;

	public BundleValidator(Bundle aBundle) {
		super();
		bundle = aBundle;
	}

	@Override
	public Boolean validate() {

		if (bundle.getNamePackage().isEmpty()) {
			addError("name: ", "name is required to insert bundle");
		}
		if (bundle.getZipCodeOrigin().toString().length() != 8) {
			addError("zipCodeOrigin: ", "zip code must be only 8 digits of numbers.");
		}
		if (bundle.getZipCodeDestin().toString().length() != 8) {
			addError("zipCodeDestin: ", "zip code must be only 8 digits of numbers.");
		}
		if(bundle.getDescription().isEmpty()) {
			addError("description", "description cant be null");
		}
		
		if (bundle.getStatus() != Status.analisys &
				bundle.getStatus() != Status.confirmed &
				bundle.getStatus() != Status.route &
				bundle.getStatus() != Status.waiting_payment) {

			addError("status", "status must be confirmed, canceled, analisys, waiting payment or in route");
		}


		return getErrors().isEmpty();
	}

}
