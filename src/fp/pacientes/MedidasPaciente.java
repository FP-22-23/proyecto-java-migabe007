package fp.pacientes;

import fp.utiles.Checkers;

public record MedidasPaciente(Integer patientWeight, Integer patientHeight) implements Comparable<MedidasPaciente> {

	
	public MedidasPaciente {
		Checkers.check("El peso del paciente no puede ser negativo ni nulo", patientWeight > 0);
		Checkers.check("La altura del paciente no puede ser negativa ni nula", patientHeight > 0);
	}
	
	@Override
	public int compareTo(MedidasPaciente o) {
		int res = 0;
		res = patientWeight().compareTo(o.patientWeight());
		if (res == 0) {
			res = patientHeight().compareTo(o.patientHeight()); 
		}
		return res;
	}
	
	public Double patientIMC() {
		Integer IMC = (patientWeight / (patientHeight*patientHeight));
		return IMC.doubleValue();
		
	}

	


}
