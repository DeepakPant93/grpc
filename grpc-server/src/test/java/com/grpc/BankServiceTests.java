package com.grpc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.grpc.model.Balance;
import com.grpc.model.BalanceCheckRequest;
import com.grpc.model.BankServiceGrpc;
import com.grpc.model.BankServiceGrpc.BankServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@TestInstance(Lifecycle.PER_CLASS)
public class BankServiceTests {

	private BankServiceBlockingStub blockingStub;

	@BeforeAll
	public void setup() {
		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
		blockingStub = BankServiceGrpc.newBlockingStub(managedChannel);
	}

	@Test
	void contextLoads() {
		BalanceCheckRequest request = BalanceCheckRequest.newBuilder().setAccountNo(10).build();
		Balance balance = blockingStub.getBalance(request);
		System.out.println("Received : " + balance.getAmount());
	}

}
