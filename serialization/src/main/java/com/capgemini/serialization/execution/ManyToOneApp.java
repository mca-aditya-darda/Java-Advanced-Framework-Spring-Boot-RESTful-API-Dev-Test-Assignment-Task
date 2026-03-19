package com.capgemini.serialization.execution;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.capgemini.serialization.entity.Project;
import com.capgemini.serialization.entity.Student;
import com.capgemini.serialization.filehandler.FileHandler;

public class ManyToOneApp {

	public static void execution() {

		Project commonProject = new Project(1, "Common Project", "Shared");

		List<Student> students = Arrays.asList(new Student(1, "A", "a@gmail.com", 111L, Arrays.asList(commonProject)),
				new Student(2, "B", "b@gmail.com", 222L, Arrays.asList(commonProject)),
				new Student(3, "C", "c@gmail.com", 333L, Arrays.asList(commonProject)));

		String path = "src/main/resources/many_to_one.json";

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