package fp.pacientes;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Paciente implements Comparable<Paciente>{
	private String iD;
	private String patientName;
	private Gender patientGender;
	private Boolean isAllergic;
	//Tipo auxiliar
	private MedidasPaciente medidasPaciente;
	
	private LocalDate appointmentDate;
	private List<String> prescribedMedicines;
	private Double temperature;
	private Integer heartbeats;
	
	
	
	//C1
	public Paciente(String iD, String patientName, Gender patientGender, Boolean isAllergic, 
			MedidasPaciente medidasPaciente, LocalDate appointmentDate,
			List<String> prescribedMedicines, Double temperature, Integer heartbeats) {
		this.iD = iD;
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.isAllergic = isAllergic;
		this.medidasPaciente = medidasPaciente;
		this.appointmentDate = appointmentDate;
		this.prescribedMedicines = new LinkedList<String>();
		this.temperature = temperature;
		this.heartbeats = heartbeats;
		
		
		Checkers.check("El nombre del paciente no puede estar vacio", !patientName.equals(""));
		Checkers.check("El número de pulsaciones no puede ser negativo", heartbeats >= 0);
		
	}
	
	//C2
	public Paciente() {
		
	}
	
	//Propiedades derivadas
	
	public Boolean tieneFiebre() {
		Boolean res = false;
		if (temperature > 37.8) {
			res = true;
		}
		return res;
	}	
	
	public String pulsaciones() {
		String res;
		if (heartbeats <  60) {
			res = "Tiene bradicardia";
		} else if (heartbeats >= 60 && heartbeats <= 100){
			res = "Tiene un numero de pulsaciones dentro de la media esperada";
		} else {
			res = "Tiene taquicardia";
		}
		return res;
	}
	
	//Getters
	public String getiD() {
		return iD;
	}

	public String getPatientName() {
		return patientName;
	}

	public Gender getPatientGender() {
		return patientGender;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public Boolean getIsAllergic() {
		return isAllergic;
	}

	public List<String> getPrescribedMedicines() {
		return prescribedMedicines;
	}

	public Double getTemperature() {
		return temperature;
	}

	public Integer getHeartbeats() {
		return heartbeats;
	}

	public MedidasPaciente getMedidasPaciente() {
		return medidasPaciente;
	}
	
	
	//Setters
	
	public void setiD(String iD) {
		this.iD = iD;
	}

	public void setPatientName(String patientName) {
		Checkers.check("El nombre del paciente no puede estar vacio", !patientName.equals(""));
		this.patientName = patientName;
	}

	public void setPatientGender(Gender patientGender) {
		this.patientGender = patientGender;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public void setIsAllergic(Boolean isAllergic) {
		this.isAllergic = isAllergic;
	}

	public void setPrescribedMedicines(List<String> prescribedMedicines) {
		this.prescribedMedicines = prescribedMedicines;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public void setHeartbeats(Integer heartbeats) {
		Checkers.check("El número de pulsaciones no puede ser negativo", heartbeats >= 0);
		this.heartbeats = heartbeats;
	}

	public void setMedidasPaciente(MedidasPaciente medidasPaciente) {
		this.medidasPaciente = medidasPaciente;
	}

	
	//Representación como cadena
	@Override
	public String toString() {
		return "Paciente [iD=" + iD + ", patientName=" + patientName + ", patientGender=" + patientGender
				+ ", isAllergic=" + isAllergic + ", medidasPaciente=" + medidasPaciente + ", appointmentDate="
				+ appointmentDate + ", prescribedMedicines=" + prescribedMedicines + ", temperature=" + temperature
				+ ", heartbeats=" + heartbeats + "]";
	}
	

	//Criterio de igualdad
	@Override
	public int hashCode() {
		return Objects.hash(appointmentDate, iD, patientName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(appointmentDate, other.appointmentDate) && Objects.equals(iD, other.iD)
				&& Objects.equals(patientName, other.patientName);
	}
	
	
	//Orden natural
	@Override
	public int compareTo(Paciente p) {	
		int r;
		if (p == null) {
			throw new NullPointerException();
		}
		r = getPatientName().compareTo(p.getPatientName());
		if (r == 0) {
			r = getAppointmentDate().compareTo(p.getAppointmentDate());
		} else if (r == 0) {
			r = getiD().compareTo(p.getiD());
		}
		return r;
	}	
}

