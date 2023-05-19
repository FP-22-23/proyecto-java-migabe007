package fp.pacientes;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pacientes {
	private List<Paciente> pacientes;
	
	//C1
	public Pacientes() {
		this.pacientes = new LinkedList<Paciente>();
	}
	
	//C2
	public Pacientes(Collection<Paciente> pacientes) {
		this.pacientes = new LinkedList<Paciente>(pacientes);
	}
	
	//C3
	public Pacientes(Stream<Paciente> pacientes) {
		this.pacientes = pacientes.collect(Collectors.toList());
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
	
	/*
	 * Bloque I: Implementar, documentar y probar CINCO métodos que trabajen sobre el dataset y respondan a preguntas interesantes.
	 *		A escoger uno de los dos siguientes: existe / para todo (el mismo implementado en la entrega 2, pero con streams).
	 *		A escoger uno de los tres siguientes: contador/suma/media (el mismo implementado en la entrega 2, pero con streams).
	 *		Una selección con filtrado (la misma implementada en la entrega 2, pero con streams).
	 *		Un máximo/mínimo con filtrado.
	 *		Una selección, con filtrado y ordenación.
	 */
	
	
	//1
	public Boolean existePacienteFechaEspecifica2(LocalDate s) {
		return pacientes.stream().anyMatch(x->x.getAppointmentDate().equals(s));
	}
	
	//2
	public Double mediaPesoPacientes2() {
		return pacientes.stream().collect(Collectors.averagingDouble(x->x.getMedidasPaciente().patientWeight()));	
	}
	
	//3
	public List<Paciente> pacientesAlergicos2(){
		return pacientes.stream().filter(x->x.getIsAllergic().equals(true)).toList();
	}
	
	//4
	public Integer maxNumPulsacionesPorGenero(Gender gender) {
		Comparator<Paciente> cmp = Comparator.comparing(Paciente::getHeartbeats);
		return pacientes.stream().filter(x->x.getPatientGender().equals(gender))
				.max(cmp)
				.map(Paciente::getHeartbeats)
				.get();
	}
	
	//5
	public List<String> pacientesOrdenadosPorFechaSegunGenero(Gender genero) {
		return pacientes.stream().filter(x -> x.getPatientGender().equals(genero))
				.sorted(Comparator.comparing(Paciente::getAppointmentDate))
				.map(Paciente::getPatientName)
				.toList();
	}
	
	/*
	 * Bloque II: Implementar, documentar y probar CINCO métodos que trabajen sobre el dataset y respondan a preguntas interesantes.
	 * 		Uno de los métodos (4) o (5) implementados en la entrega 2, pero con streams.
	 * 		Un método en cuya implementación se use, o bien el Collector collectingAndThen, o bien el Collector mapping.
	 * 		Un método que devuelva un Map en el que las claves sean un atributo o una función sobre un atributo, y los valores son máximos/mínimos de los elementos que tienen ese valor.
	 * 		Un método que devuelva un SortedMap en el que las claves sean un atributo o una función sobre un atributo, y los valores sean listas con los n mejores o peores elementos que comparten el valor de ese atributo (o función sobre el atributo).
	 * 		Un método que calcule un Map y devuelva la clave con el valor asociado (mayor o menor) de todo el Map.
	 */
	
	//6
	public Map<Gender, Long> numPacientesPorGenero2(){
		return pacientes.stream().collect(Collectors.groupingBy(Paciente::getPatientGender, Collectors.counting()));
	}
	
	//7
	
	public Map<String, List<Double>> IMCPorPaciente(){
		/*
		 * return pacientes.stream().collect(Collectors.groupingBy(Paciente::getPatientName, 
		 * Collectors.collectingAndThen(Collectors.minBy(
		 * Comparator.comparing(x->x.getMedidasPaciente().patientIMC())), optional->optional.get())));
		 */
		
		return pacientes.stream().collect(Collectors.groupingBy(Paciente::getPatientName,
				Collectors.mapping(x->x.getMedidasPaciente().patientIMC(), Collectors.toList())));
	}
	
	//8
	
	public Map<Gender, List<Integer>> pacienteMayorTemperaturaSegunGenero(Gender gender){
		return null;
	}
	
	//10
	public Map<Month, Long> mesMayorNumeroPacientes(){
		Map<Month, Long> mp = pacientes.stream().collect(Collectors.groupingBy(x->x.getAppointmentDate().getMonth(), Collectors.counting()));
		Entry<Month, Long> res = Collections.max(mp.entrySet(), Map.Entry.comparingByValue());
		return Collections.singletonMap(res.getKey(), res.getValue());
 	}
	
	
	
}
