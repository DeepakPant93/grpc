package com.grpc.protobuf;

import com.grpc.model.Credentials;
import com.grpc.model.Email;
import com.grpc.model.Phone;

public class CredentialsDemo {
	public static void main(String[] args) {

		Email email = Email.newBuilder().setEmail("deepak@gmail.com").build();

		Phone phone = Phone.newBuilder().setNumber(282828282).build();

		Credentials credentials = Credentials.newBuilder().setEmailMode(email).setPhoneMode(phone).build();

		cred(credentials);
	}

	private static void cred(Credentials credentials) {
		switch (credentials.getModeCase()) {
		case EMAIL_MODE:
			System.out.println(credentials.getEmailMode());
			break;
		case PHONE_MODE:
			System.out.println(credentials.getPhoneMode());
			break;
		default:
			break;
		}

	}
}
