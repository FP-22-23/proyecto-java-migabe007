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
	private LocalDate appointmentDate;
	private Integer patientWeight;
	private Integer patientHeight;
	private Boolean isAllergic;
	private List<String> prescribedMedicines;
	//Tipo auxiliar
	private Patient_statistics patient_statistics;
	
	//C1
	public Paciente(String iD, String patientName, Gender patientGender, LocalDate appointmentDate,
	Integer patientWeight, Integer patientHeight, Boolean isAllergic,
	List<String> prescribedMedicines, Patient_statistics patient_statistics) {
		this.iD = iD;
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.appointmentDate = appointmentDate;
		this.patientWeight = patientWeight;
		this.patientHeight = patientHeight;
		this.isAllergic = isAllergic;
		this.prescribedMedicines = new LinkedList<String>();
		this.patient_statistics = patient_statistics;
		Checkers.check("El nombre del paciente no puede estar vacio", !patientName.equals(""));
		Checkers.check("El peso del paciente no puede ser negativo ni nulo", patientWeight > 0);
		Checkers.check("La altura del paciente no puede ser negativa ni nula", patientHeight > 0);
		
	}
	
	//C2
	public Paciente() {
		
	}
	
	//Propiedades derivadas
	public Double patientIMC() {
		Integer IMC = (patientWeight / (patientHeight*patientHeight));
		return IMC.doubleValue();
		
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

	public Integer getPatientWeight() {
		return patientWeight;
	}

	public Integer getPatientHeight() {
		return patientHeight;
	}

	public Boolean getIsAllergic() {
		return isAllergic;
	}

	public List<String> getPrescribedMedicines() {
		return prescribedMedicines;
	}
	
	public Patient_statistics getPatient_statistics() {
		return patient_statistics;

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

	public void setPatientWeight(Integer patientWeight) {
		Checkers.check("El peso del paciente no puede ser negativo ni nulo", patientWeight > 0);
		this.patientWeight = patientWeight;
	}

	public void setPatientHeight(Integer patientHeight) {
		Checkers.check("La altura del paciente no puede ser negativa ni nula", patientHeight > 0);
		this.patientHeight = patientHeight;
	}

	public void setIsAllergic(Boolean isAllergic) {
		this.isAllergic = isAllergic;
	}

	public void setPrescribedMedicines(List<String> prescribedMedicines) {
		this.prescribedMedicines = prescribedMedicines;
	}
	
	public void setPatient_statistics(Patient_statistics patient_statistics) {
		this.patient_statistics = patient_statistics;
	}
	
	
	//Representación como cadena
	
	@Override
	public String toString() {
		return "Paciente [iD=" + iD + ", patientName=" + patientName + ", patientGender=" + patientGender
				+ ", appointmentDate=" + appointmentDate + ", patientWeight=" + patientWeight + ", patientHeight="
				+ patientHeight + ", isAllergic=" + isAllergic + ", prescribedMedicines=" + prescribedMedicines
				+ ", patient_statistics=" + patient_statistics + "]";
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

