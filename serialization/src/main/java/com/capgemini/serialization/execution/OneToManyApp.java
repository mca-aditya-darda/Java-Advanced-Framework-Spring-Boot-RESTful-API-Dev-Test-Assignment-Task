package com.capgemini.serialization.execution;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.capgemini.serialization.entity.Project;
import com.capgemini.serialization.entity.Student;
import com.capgemini.serialization.filehandler.FileHandler;

public class OneToManyApp {

	public static void execution() {

		List<Project> projects = Arrays.asList(new Project(1, "Flight", "Java"), new Project(2, "Train", "C#"),
				new Project(3, "Bus", "C"));

		Student student = new Student(1, "Rani", "rani@gmail.com", 9876543211L, projects);

		String path = "src/main/resources/one_to_many.json";

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