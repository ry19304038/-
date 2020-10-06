package teset;


import java.util.ArrayList;

import factory.Factory;

public class PropertieTest {
	public static void main(String []args) {

		ArrayList list=(ArrayList)Factory.createInstance("list");
		list.add(1);
		list.add(2);

		System.out.println(list);
	}
}
