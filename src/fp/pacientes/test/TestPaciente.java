package fp.pacientes.test;

import java.time.LocalDate;

import java.util.ArrayList;

import fp.pacientes.Gender;
import fp.pacientes.MedidasPaciente;
import fp.pacientes.Paciente;


public class TestPaciente {

	public static void main(String[] args) {
		Paciente p1 = new Paciente("1", "Celestyna Dillimore", Gender.FEMALE,
				true, new MedidasPaciente(59, 170), LocalDate.of(2018, 1, 5),
				new ArrayList<String>(), 36.0, 90);
		Paciente p2 = new Paciente();
		
		System.out.println(p1);
		//Getters
		System.out.println(p1.getiD());
		System.out.println(p1.getPatientName());
		System.out.println(p1.getPatientGender());
		System.out.println(p1.getIsAllergic());
		System.out.println(p1.getAppointmentDate());
		System.out.println(p1.getMedidasPaciente().patientWeight());
		System.out.println(p1.getMedidasPaciente().patientHeight());
		System.out.println(p1.getPrescribedMedicines());
		System.out.println(p1.getTemperature());
		System.out.println(p1.getHeartbeats());
		
		//Derivadas
		System.out.println(p1.getMedidasPaciente().patientIMC());
		System.out.println(p1.tieneFiebre());
		System.out.println(p1.pulsaciones());
		
		//Setters
		p2.setiD("2");
		p2.setPatientName("Meta Micheli");
		p2.setPatientGender(Gender.FEMALE);
		p2.setIsAllergic(true);
		p2.setMedidasPaciente(new MedidasPaciente(77, 187));
		p2.setAppointmentDate(LocalDate.of(2018, 5, 10));
		p2.setPrescribedMedicines(new ArrayList<String>());
		p2.setTemperature(37.0);
		p2.setHeartbeats(110);
		
		System.out.println(p2);
		
		//Hashcode, equals y compareTo
		System.out.println(p1.hashCode());
		System.out.println(p1.equals(p2));
		System.out.println(p1.compareTo(p2));
		
		
	/*
	 * //Checkers
	 *	try {
	 *	System.out.println(p3);
		}catch(IllegalArgumentException e){
			
		}
		System.out.println("Programa finalizado");	
	 * 
	 * 
	 * 
	 */
		}
}
