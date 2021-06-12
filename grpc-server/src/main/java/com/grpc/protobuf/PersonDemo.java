package com.grpc.protobuf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.protobuf.InvalidProtocolBufferException;
import com.grpc.model.Person;

public class PersonDemo {

	public static void main(String[] args) throws IOException {
		Person person1 = Person.newBuilder().setName("Deepak").setAge(28).build();
		Person person2 = Person.newBuilder().setName("Deepak").setAge(28).build();

		System.out.println(person1);
		System.out.println(person1.equals(person2));
		
		
		// Serialization and De-Serialization eg
		
		Path path = serialize();
		
		Person person3 = deserialize(path);
		
		System.out.println(person3);
	}

	private static Person deserialize(Path path) throws IOException, InvalidProtocolBufferException {
		byte[] personBytes = Files.readAllBytes(path);
		Person person3 = Person.parseFrom(personBytes);
		return person3;
	}

	private static Path serialize() {
		Path path = Paths.get("person.srf");
//		Files.write(path, person1.toByteArray());
		return path;
	}
}
