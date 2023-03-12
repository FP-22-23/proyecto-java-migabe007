package fp.pacientes.test;

import java.time.LocalDate;
import java.util.ArrayList;

import fp.pacientes.Gender;
import fp.pacientes.Paciente;
import fp.pacientes.Patient_statistics;

public class TestPaciente {

	public static void main(String[] args) {
		Paciente p1 = new Paciente("1", "Celestyna Dillimore", Gender.FEMALE,
				LocalDate.of(2018, 1, 5), 59, 176, true,
				new ArrayList<String>(), new Patient_statistics(36.5, 70));
		Paciente p2 = new Paciente();
		
		System.out.println(p1);
		//Getters
		System.out.println(p1.getiD());
		System.out.println(p1.getPatientName());
		System.out.println(p1.getIsAllergic());
		System.out.println(p1.getPatientHeight());
		System.out.println(p1.getPatientWeight());
		System.out.println(p1.getAppointmentDate());
		System.out.println(p1.getPatientGender());
		System.out.println(p1.getPrescribedMedicines());
		System.out.println(p1.getPatient_statistics());
		
		//Derivadas
		System.out.println(p1.patientIMC());
		System.out.println(p1.getPatient_statistics().tieneFiebre());
		System.out.println(p1.getPatient_statistics().pulsaciones());
		
		//Setters
		p2.setiD("2");
		p2.setPatientName("Meta Micheli");
		p2.setIsAllergic(true);
		p2.setPatientHeight(186);
		p2.setPatientWeight(77);
		p2.setAppointmentDate(LocalDate.of(2018, 5, 10));
		p2.setPatientGender(Gender.FEMALE);
		p2.setPrescribedMedicines(new ArrayList<String>());
		p2.setPatient_statistics(new Patient_statistics(38.0, 120));
		
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
