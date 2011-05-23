package com.xored.emfjson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;

import jsontest.Data;
import jsontest.JsontestFactory;
import jsontest.JsontestPackage;
import jsontest.Town;
import jsontest.TownKind;
import jsontest.User;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.gson.JsonObject;

import com.xored.emfjson.*;
import org.junit.Test;

public class EmfJsonTest {

	@Test
	public void testContaiment() throws Exception {
		Data initData = createData();
		Emf2Json emf2Json = new Emf2Json(JsontestPackage.eINSTANCE);
		JsonObject jsonObject = emf2Json.serialize(initData);

		Data data = (Data) emf2Json.deserialize(jsonObject);
		
		assertTrue(EcoreUtil.equals(initData, data));

		assertEquals(jsonObject.toString(), emf2Json.serialize(data)
				.toString());
		assertEquals("@//towns.1/users.0", jsonObject.get("admin"));
		assertEquals(data.getTowns().get(1).getUsers().get(0), data.getAdmin());
	}

/*	private void showJson(JsonObject jsonObject) {
		PrintWriter writer = new PrintWriter(System.out);
		jsonObject.prettyPrint(writer);
		writer.flush();
		System.out.println("\n");
	}*/

	private Data createData() {

		JsontestFactory f = JsontestFactory.eINSTANCE;

		Data data = f.createData();
		
		
		Town novos = newTown("Novosibirsk", TownKind.BIG, 320);
		Town kem = newTown("Kemerovo", TownKind.SMALL, 480);
		Town omsk = newTown("Omsk", null, 590);

		EList<Town> towns = data.getTowns();
		towns.add(novos);
		towns.add(kem);
		towns.add(omsk);

		User ivan = newUser("Ivan");
		User egor = newUser("Egor");
		User vitya = newUser("Vitya");
		User dasha = newUser("Dasha");
		User anton = newUser("Anton");
		User vova = newUser("Vova");

		addRoles(ivan, "admin", "user");
		addRoles(egor, "admin", "manager");
		addRoles(vitya, "psycho", "manager", "sales");
		addRoles(dasha, "manager", "dummy");
		addRoles(anton, "admin", "sales");
		addRoles(vova, "sales");

		addUser(novos, ivan, vitya);
		addUser(kem, egor, dasha);
		addUser(omsk, anton, vova);

		data.setAdmin(egor);

		return data;

	}

	private void addUser(Town town, User... users) {
		town.getUsers().addAll(Arrays.asList(users));
	}

	private void addRoles(User user, String... roles) {
		user.getRoles().addAll(Arrays.asList(roles));
	}

	private Town newTown(String name, TownKind kind, int age) {
		Town town = JsontestFactory.eINSTANCE.createTown();
		town.setName(name);
		town.setKind(kind);
		town.setAge(age);
		town.setFoundation(Calendar.getInstance().getTime());
		return town;
	}

	private User newUser(String name) {
		User user = JsontestFactory.eINSTANCE.createUser();
		user.setName(name);
		return user;
	}
}

