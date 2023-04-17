package fp.pacientes;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FactoriaPacientes {
	
	public static Pacientes leerPaciente(String rutaFichero) {
		Pacientes res = null;
		try {
			Stream<Paciente> s = Files.lines(Paths.get(rutaFichero)).skip(1).map(FactoriaPacientes::parsearPaciente);
			res = new Pacientes(s.toList());
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + rutaFichero);
			e.printStackTrace();
		}
		return res;
	}
	
	private static Paciente parsearPaciente(String linea) {
		String[] trozos = linea.split(",");
		String iD = trozos[0].trim();
		String patientName = trozos[1].trim();
		Gender patientGender = Gender.valueOf(trozos[2].trim());
		Boolean isAllergic = Boolean.valueOf(trozos[3].trim());
		Integer patientWeight = Integer.valueOf(trozos[4].trim());
		Integer patientHeight = Integer.valueOf(trozos[5].trim());
		MedidasPaciente medidasPaciente = new MedidasPaciente(patientWeight, patientHeight);
		LocalDate appointmentDate = LocalDate.parse(trozos[6].trim(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		List<String> prescribedMedicines = new ArrayList<String>();
		Double temperature = Double.valueOf(trozos[8].trim());
		Integer heartbeats = Integer.valueOf(trozos[9].trim());
		
		return new Paciente(iD, patientName, patientGender, isAllergic, medidasPaciente, appointmentDate,
				prescribedMedicines, temperature, heartbeats);
	}
	

	
	
}
