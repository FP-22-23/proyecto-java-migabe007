package fp.pacientes;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FactoriaPacientes {
	
	public static Pacientes leerPaciente(String rutaFichero) {
		Pacientes res = null;
		try {
			Collection<Paciente> s = Files.lines(Paths.get(rutaFichero))
					.skip(1)	
					.map(FactoriaPacientes::parsearPaciente)
					.collect(Collectors.toList());
			res = new Pacientes(s);
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + rutaFichero);
			e.printStackTrace();
		}
		return res;
	}
	
	
	public static Pacientes leerPaciente2(String rutaFichero) {
		Pacientes res = null;
		try {
			Stream<Paciente> s = Files.lines(Paths.get(rutaFichero)).skip(1).map(FactoriaPacientes::parsearPaciente);
			res = new Pacientes(s);
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + rutaFichero);
			e.printStackTrace();
		}
		return res;
	}
	
	private static Paciente parsearPaciente(String linea) {
		String[] trozos = linea.split(",");
		String iD = trozos[0].trim();
		String patientName = trozos[1].trim()	;
		Gender patientGender = Gender.valueOf(trozos[2].toUpperCase().trim());
		Boolean isAllergic = Boolean.valueOf(trozos[3].trim());
		Integer patientWeight = Integer.valueOf(trozos[4].trim());
		Integer patientHeight = Integer.valueOf(trozos[5].trim());
		MedidasPaciente medidasPaciente = new MedidasPaciente(patientWeight, patientHeight);
		LocalDate appointmentDate = LocalDate.parse(trozos[6].trim(), DateTimeFormatter.ofPattern("M/d/yyyy"));
		List<String> prescribedMedicines = parseaLista(trozos[7].trim());
		Double temperature = Double.valueOf(trozos[8].trim());
		Integer heartbeats = Integer.valueOf(trozos[9].trim());
		
		return new Paciente(iD, patientName, patientGender, isAllergic, medidasPaciente, appointmentDate,
				prescribedMedicines, temperature, heartbeats);
	}
	
	private static List<String> parseaLista(String lista) {
		String[] trozos = lista.split(",|\\band\\b");
		List<String> newList = new LinkedList<String>();
		for (String t: trozos) {
			newList.add(t);
		}
		
		return newList;
	}
	

	
	
}
