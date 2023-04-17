package fp.pacientes.test;

import java.time.LocalDate;

import fp.pacientes.FactoriaPacientes;
import fp.pacientes.Pacientes;

public class TestFactoriaPacientes {
	
	private static final Pacientes PACIENTES = FactoriaPacientes.leerPaciente("data/patient-admission-dataset_generated.csv");

	public static void main(String[] args) {
		testCreacionPacientes();
		testExistePacienteFechaEspecifica(LocalDate.of(1, 28, 2020));
		testMediaPesoPacientes();
		testPacientesAlergicos();
		testPacientesPorFecha();
		testNumPacientesPorGenero();
		
	}
	

	private static void testCreacionPacientes() {
		System.out.println("\nTEST de la creacion de pacientes");
		try {
			System.out.println("Le�dos: " + PACIENTES.numPacientes() + " pacientes");
			System.out.println("REGISTROS: \n" + PACIENTES);
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}
	
	private static void testExistePacienteFechaEspecifica(LocalDate s) {
		System.out.println("\nTest de testExistePacienteFechaEspecifica");
		try {
			System.out.println(PACIENTES.existePacienteFechaEspecifica(s));
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}

	private static void testMediaPesoPacientes() {
		System.out.println("\nTest de testMediaPesoPacientes");
		try {
			System.out.println(PACIENTES.mediaPesoPacientes());
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}

	private static void testPacientesAlergicos() {
		System.out.println("\nTest de testPacientesAlergicos");
		try {
			System.out.println(PACIENTES.pacientesAlergicos());
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}

	private static void testPacientesPorFecha() {
		System.out.println("\nTest de testPacientesPorFecha");
		try {
			System.out.println(PACIENTES.pacientesPorFecha());
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}

	private static void testNumPacientesPorGenero() {
		System.out.println("\nTest de testNumPacientesPorGenero");
		try {
			System.out.println(PACIENTES.numPacientesPorGenero());
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
	}


}

