package com.capgemini.serialization.filehandler;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.capgemini.serialization.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileHandler {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static void createFile(String path) throws IOException {
		File file = new File(path);
		if (file.createNewFile()) {
			System.out.println("JSON File Created Successfully!");
		} else {
			System.out.println("JSON File Already Exists!");
		}
	}

	public static void writeStudent(Student student, String path) throws IOException {
		File file = new File(path);
		OBJECT_MAPPER.writeValue(file, student);
		System.out.println("Serialization Done Successfully!");
	}

	public static void writeStudentList(List<Student> students, String path) throws IOException {
		File file = new File(path);
		OBJECT_MAPPER.writeValue(file, students);
		System.out.println("Serialization Done Successfully!");
	}

	public static Student readStudent(String path) throws IOException {
		File file = new File(path);
		Student student = OBJECT_MAPPER.readValue(file, Student.class);
		System.out.println("Deserialization Done Successfully!");
		return student;
	}

	public static Student[] readStudentArray(String path) throws IOException {
		File file = new File(path);
		Student[] students = OBJECT_MAPPER.readValue(file, Student[].class);
		System.out.println("Deserialization Done Successfully!");
		return students;
	}

	public static void deleteFile(String path) {
		File file = new File(path);
		if (file.delete()) {
			System.out.println("JSON File Deleted Successfully!");
		} else {
			System.out.println("JSON File Doesn't Exist!");
		}
	}
}