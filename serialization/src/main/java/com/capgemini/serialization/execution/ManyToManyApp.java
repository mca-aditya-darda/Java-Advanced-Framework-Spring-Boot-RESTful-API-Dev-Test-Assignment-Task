package com.capgemini.serialization.execution;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.capgemini.serialization.entity.Project;
import com.capgemini.serialization.entity.Student;
import com.capgemini.serialization.filehandler.FileHandler;

public class ManyToManyApp {

	public static void execution() {

		Project p1 = new Project(1, "Flight", "Java");
		Project p2 = new Project(2, "Train", "C#");

		List<Student> students = Arrays.asList(new Student(1, "Raja", "raja@gmail.com", 111L, Arrays.asList(p1, p2)),
				new Student(2, "Rani", "rani@gmail.com", 222L, Arrays.asList(p1)),
				new Student(3, "Kranti", "kranti@gmail.com", 333L, Arrays.asList(p2)));

		String path = "src/main/resources/many_to_many.json";

		try {
			FileHandler.createFile(path);

			FileHandler.writeStudentList(students, path);

			Student[] list = FileHandler.readStudentArray(path);

			for (Student s : list) {
				System.out.println(s);
			}

			FileHandler.deleteFile(path);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}