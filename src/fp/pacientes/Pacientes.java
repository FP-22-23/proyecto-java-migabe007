package fp.pacientes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Pacientes {
	private SortedSet<Paciente> pacientes;
	
	public Pacientes() {
		this.pacientes = new TreeSet<Paciente>();
	}
	
	public Pacientes(Collection<Paciente> pacientes) {
		this.pacientes = new TreeSet<Paciente>(pacientes);
	}

	@Override
	public String toString() {
		return "Pacientes [pacientes=" + pacientes + "NumPacientes=" + numPacientes() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pacientes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacientes other = (Pacientes) obj;
		return Objects.equals(pacientes, other.pacientes);
	}
	
	//Operaciones
	/* Obtener el número de elementos.
	 * Añadir un elemento.
	 * Añadir una colección de elementos.
	 * Eliminar un elemento.
	 */
	
	public Integer numPacientes() {
		return pacientes.size();
	}
	
	public void addPaciente(Paciente s) {
		pacientes.add(s);
	}
	
	public void addAllPacientes(Collection<Paciente> s) {
		pacientes.addAll(s);
	}
	
	public void delPaciente(Paciente s) {
		pacientes.remove(s);
	}
	
	//Operaciones 
	/*
	 * - A escoger uno de los dos siguientes: existe / para todo. 
	 * - A escoger uno de los tres siguientes: contador / suma / media.
	 * - Una selección con filtrado.
	 * - Un método de agrupación que devuelva un Map en el que las claves sean una propiedad del tipo base,
	 * y los valores una colección (List, Set, SortedSet) de objetos del tipo base. 
	 * - Un método de acumulación que devuelva un Map en el que las claves sean una propiedad del tipo base,
	 * y los valores el conteo o la suma de los objetos del tipo base almacenados en el contenedor que tienen como valor esa propiedad.
	 */
	
	public Boolean existePacienteFechaEspecifica(LocalDate s) {
		Boolean res = false;
		for (Paciente p :pacientes) {
			if (p.getAppointmentDate().equals(s)) {
				res = true;
				break;
			}
		}
		return res;
		
	}
	
	public Double mediaPesoPacientes() {
		Double suma = 0.0;
		for (Paciente p :pacientes) {
			suma = suma + p.getMedidasPaciente().patientWeight();
		}
		return suma / numPacientes();		
	}
	
	public List<Paciente> pacientesAlergicos(){
		List<Paciente> res = new ArrayList<Paciente>();
		for (Paciente p :pacientes) {
			if (p.getIsAllergic().equals(true)) {
				res.add(p);
			}
		}
		return res;
	}
	
	
	public Map<LocalDate, Set<String>> pacientesPorFecha(){
		Map<LocalDate, Set<String>> res = new HashMap<LocalDate, Set<String>>();
		for (Paciente p :pacientes) {
			LocalDate clave = p.getAppointmentDate();
			String valor = p.getPatientName();
			if (!res.containsKey(clave)) {
				Set<String> conj = new HashSet<String>();
				conj.add(valor);
				res.put(clave, conj);
			} else {
				res.get(clave).add(valor);
			}
		}
		return res;
	}
	
	public Map<Gender, Integer> numPacientesPorGenero(){
		Map<Gender, Integer> res = new HashMap<Gender, Integer>();
		for (Paciente p :pacientes) {
			Gender clave = p.getPatientGender();
			if (!res.containsKey(clave)) {
				res.put(clave, 1);
			} else {
				res.put(clave, res.get(clave)+1);
			}
		}
		return res;
	}
}
