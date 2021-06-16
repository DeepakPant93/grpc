package com.grpc.service;

import com.grpc.model.Balance;
import com.grpc.model.BalanceCheckRequest;
import com.grpc.model.BankServiceGrpc.BankServiceImplBase;

import io.grpc.stub.StreamObserver;

public class BankServiceDemo extends BankServiceImplBase {

	@Override
	public void getBalance(BalanceCheckRequest request, StreamObserver<Balance> responseObserver) {

		int accountNo = request.getAccountNo();

		Balance balance = Balance.newBuilder().setAmount(accountNo * 10).build();
		
		responseObserver.onNext(balance);
		responseObserver.onCompleted();
	}
}
