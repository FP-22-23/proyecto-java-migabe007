package fp.pacientes.test;

import java.time.LocalDate;

import fp.pacientes.FactoriaPacientes;
import fp.pacientes.Gender;
import fp.pacientes.Pacientes;

public class TestFactoriaPacientes {
	
	private static final Pacientes PACIENTES = FactoriaPacientes.leerPaciente("data/patient-admission-dataset_generated.csv");

	public static void main(String[] args) {
		//Entrega 2
		testCreacionPacientes();
		testExistePacienteFechaEspecifica(LocalDate.of(1, 28, 2020));
		testMediaPesoPacientes();
		testPacientesAlergicos();
		testPacientesPorFecha();
		testNumPacientesPorGenero();
		
		//Entrega 3
		testExistePacienteFechaEspecifica2(LocalDate.of(1, 28, 2020));
		testMediaPesoPacientes2();
		testPacientesAlergicos2();
		testMaxNumPulsacionesPorGenero(Gender.MALE);
		testPacientesOrdenadosPorFechaSegunGenero(Gender.FEMALE);
		testNumPacientesPorGenero2();
		testIMCPorPaciente();
		
		testNPacientesMayorTemperaturaPorGenero(5);
		testMesMayorNumeroPacientes();
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
	
	//Entrega 3
	
	private static void testExistePacienteFechaEspecifica2(LocalDate s) {
		System.out.println("\nTest de testExistePacienteFechaEspecifica2");
		try {
			System.out.println(PACIENTES.existePacienteFechaEspecifica2(s));
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}


	private static void testMediaPesoPacientes2() {
		System.out.println("\nTest de testMediaPesoPacientes2");
		try {
			System.out.println(PACIENTES.mediaPesoPacientes2());
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}


	private static void testPacientesAlergicos2() {
		System.out.println("\nTest de testPacientesAlergicos2");
		try {
			System.out.println(PACIENTES.pacientesAlergicos2());
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}


	private static void testMaxNumPulsacionesPorGenero(Gender gender) {
		System.out.println("\nTest de testMaxNumPulsacionesPorGenero");
		try {
			System.out.println(PACIENTES.maxNumPulsacionesPorGenero(gender));
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}


	private static void testPacientesOrdenadosPorFechaSegunGenero(Gender genero) {
		System.out.println("\nTest de testPacientesOrdenadosPorFechaSegunGenero");
		try {
			System.out.println(PACIENTES.pacientesOrdenadosPorFechaSegunGenero(genero));
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}


	private static void testNumPacientesPorGenero2() {
		System.out.println("\nTest de testNumPacientesPorGenero2");
		try {
			System.out.println(PACIENTES.numPacientesPorGenero2());
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}


	private static void testIMCPorPaciente() {
		System.out.println("\nTest de testIMCPorPaciente");
		try {
			System.out.println(PACIENTES.IMCPorPaciente());
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}		
	}
	
	
	private static void testNPacientesMayorTemperaturaPorGenero(Integer n) {
		System.out.println("\nTest de testNPacientesMayorTemperaturaPorGenero");
		try {
			System.out.println(PACIENTES.nPacientesMayorTemperaturaPorGenero(n));
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}
	

	private static void testMesMayorNumeroPacientes() {
		System.out.println("\nTest de testMesMayorNumeroPacientes");
		try {
			System.out.println(PACIENTES.mesMayorNumeroPacientes());
		} catch (Exception e) {
			System.out.println("Excepci�n capturada:\n   " + e);
		}
		
	}


}

