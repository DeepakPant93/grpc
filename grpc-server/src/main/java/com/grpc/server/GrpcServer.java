package com.grpc.server;

import java.io.IOException;

import com.grpc.service.BankServiceDemo;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

	private static final int SERVER_PORT = 6565;

	public static void main(String[] args) throws IOException, InterruptedException {

		Server server = ServerBuilder.forPort(SERVER_PORT).addService(new BankServiceDemo()).build();

		server.start();
		System.out.println("Server started on " + SERVER_PORT);
		server.awaitTermination();
	}
}
