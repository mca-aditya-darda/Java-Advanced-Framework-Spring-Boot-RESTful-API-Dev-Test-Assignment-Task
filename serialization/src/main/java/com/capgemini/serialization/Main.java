package com.capgemini.serialization;

import com.capgemini.serialization.execution.OneToOneApp;
import com.capgemini.serialization.execution.OneToManyApp;
import com.capgemini.serialization.execution.ManyToOneApp;
import com.capgemini.serialization.execution.ManyToManyApp;

public class Main {

	public static void main(String[] args) {

		 OneToOneApp.execution();

		 OneToManyApp.execution();

		 ManyToOneApp.execution();

		 ManyToManyApp.execution();
	}
}