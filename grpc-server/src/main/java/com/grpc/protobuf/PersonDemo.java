package com.grpc.protobuf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.grpc.model.Car;
import com.grpc.model.CarType;
import com.grpc.model.Person;

public class PersonDemo {

	public static void main(String[] args) throws IOException {
		Person person1 = Person.newBuilder().setName("Deepak").build();
		Person person2 = Person.newBuilder().setName("Deepak").setAge(Int32Value.newBuilder().setValue(28).build()).build();

		System.out.println(person1);
		System.out.println(person1.equals(person2));

		Car xuv = Car.newBuilder().setElectric(true).setCarType(CarType.SUV).setName("XUV 300").build();

		Person deepak = Person.newBuilder().addCar(xuv).setName("Deepak").setAge(Int32Value.newBuilder().setValue(28).build()).putHobbies(1, "Reading").build();

		System.out.println("City : " + deepak.getAddress().getCity());

		System.out.println(deepak.toString());

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
