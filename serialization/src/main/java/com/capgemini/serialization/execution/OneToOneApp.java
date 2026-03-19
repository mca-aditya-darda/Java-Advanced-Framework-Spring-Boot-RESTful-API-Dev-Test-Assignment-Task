package com.capgemini.serialization.execution;

import java.io.IOException;
import java.util.Arrays;

import com.capgemini.serialization.entity.Project;
import com.capgemini.serialization.entity.Student;
import com.capgemini.serialization.filehandler.FileHandler;

public class OneToOneApp {

	public static void execution() {

		Project project = new Project(1, "Flight System", "Java");

		Student student = new Student(1, "Raja", "raja@gmail.com", 9876543210L, Arrays.asList(project));

		String path = "src/main/resources/one_to_one.json";

		try {
			FileHandler.createFile(path);

			FileHandler.writeStudent(student, path);

			Student s = FileHandler.readStudent(path);
			System.out.println(s);

			FileHandler.deleteFile(path);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}