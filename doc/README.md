# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  \<22\>/\<23\>)
Autor/a: Miguel Garc�a Begines   uvus: miggarbeg

Este proyecto se trata del proyecto del segundo cuatrimestre en el curso 2022/23, que corresponde a la parte de java.

## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes.
  * **fp.pacientes**: Paquete que contiene los tipos del proyecto.
  * **fp.pacientes.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
* **/doc**: carpeta que contiene el fichero README.md.
   * **patient-admission-dataset_generated.csv**: dataset que contiene información sobre los pacientes que se presentan en el hospital. Se han recortado columnas y añadido otras tantas nuevas.
    

    
## Estructura del *dataset*

El dataset original Patient admission dataset for learning data mining se puede obtener de la URL https://www.kaggle.com/datasets/miles99/patient-admission-dataset-for-learning-data-mining. Originalmente ten�a 17 columnas, aunque de ellas solo se han tomado 8 para este proyecto. Además, se han añadido 2 columnas nuevas a través de un módulo de Python para generar columanas aleatorias. Cada fila contiene datos referentes a un paciente. A continuaci�n se describen las 10 columnas del dataset:

El dataset está compuesto por 10 columnas, con la siguiente descripción:

* **id**: de tipo String, representa el identificador del paciente.
* **patient_name**: de tipo String, representa el nombre y apellidos del paciente.
* **patient_gender**: de tipo Gender, es un enumerado que representa el género del paciente.
* **is_allergic**: de tipo Boolean, indica si el paciente es alérgico o no.
* **patient_weight**: de tipo Integer, representa el peso del paciente en kilogramos.
* **patient_height**: de tipo Integer, representa la altura del paciente en centímetros.
* **appointment_date**: de tipo LocalDate, representa la fecha de la cita del paciente con el médico.
* **prescribed_medicines**: de tipo List<String>, es una lista con los medicamentos recomendados por el medico.
* **temperature**: de tipo Double, representa la temperatura corporal del paciente.
* **heartbeats_per_minute**: de tipo Integer, representa el número de pulsaciones por minuto del paciente.

## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base -	Paciente
Representa un paciente, cuyos datos se reflejan en sus propiedades y métodos.

**Propiedades**:

- iD, de tipo String, consultable y modificable. 
- patientName, de tipo String, consultable y modificable. 
- patientGender, de tipo Gender, consultable y modificable. Puede tomar valores entre Male y Female. 
- isAllergic, de tipo Boolean, consultable y modificable. 
- medidasPaciente, de tipo MedidasPaciente, consultable y modificable. Record cuyos atributos son temperature, de tipo Double, y heartbeats, de tipo Integer.
- appointmentDate, de tipo LocalDate, consultable y modificable.
- prescribedMedicines, de List<String>, consultable y modificable. 
- temperature, de tipo Double, consultable y modificable. 
- heartbeats, de tipo Integer, consultable y modificable.r

**Constructores**: 

- C1: clase que crea un objeto de tipo Paciente a partir de los siguientes par�metros: 
iD, patientName, patientGender, isAllergic, medidasPaciente, appointmentDate, pescribedMedicines,

temperature, heartbeats.
- C2: constructor vacío que crea un objeto de tipo Paciente sin parametros de entrada. 

**Restricciones**:

- R1: El nombre del paciente no puede estar vac�o.
- R2: El peso del paciente no puede ser cero ni negativo.
- R3: La altura del paciente no puede ser negativa ni cero.
- R4: El número de pulsaciones no puede ser negativo.
 
**Criterio de igualdad**:

El criterio de igualdad se basa en el id, el nombre del paciente, y en su fecha con el médico para distinguir a un paciente de otro. 

**Criterio de ordenación**: 

El criterio de ordenación se basa en el id, el nombre del paciente, y en su fecha con el médico para ordenarlos, las mismas propiedades que con el criterio de igualdad. 

**Otras operaciones**:
 
-	Double patientIMC(): Devuelve el IMC(**I**ndice de **M**asa **C**orporal) del paciente, lo cual se calcula en base a la altura y el peso del paciente. En concreto es dividir el peso entre la altura al cuadrado(kg/m^2).

-	Boolean tieneFiebre(): Confirma si el paciente tiene fiebre o no, y para ello la temperatura corporal del paciente tiene que sobrepasar los 37.8 grados.

-	String pulsaciones(): Devuelve el estado del paciente según su número de pulsaciones. Si son menos de 60, tiene bradicardia, si están entre 60 y 100 esta normal, y si supera las 100, tiene taquicardia.

#### Tipos auxiliares

**MedidasPaciente**:
- Se trata de un record que recoge los valores de las columnas patientWeight(Integer) y patientHeight(Integer).
Tiene operaciones propias como 'Double patientIMC()'.

### Factoría

Clase de factor�a para construir objetos de tipo Pacientes.

- Pacientes leerPaciente(String rutaFichero): Crea un objeto de tipo Pacientes a partir de la informaci�n recogida en el archivo csv, cuya ruta se da como par�metro. Usa el constructor del tipo Pacientes que toma como parámetr una Collection de tipo Paciente. 

- Pacientes leerPaciente2(String rutaFichero): Crea un objeto de tipo Pacientes a partir de la informaci�n recogida en el archivo csv, cuya ruta se da como par�metro. Usa el constructor del tipo Pacientes que toma como parámetr un Stream de tipo Paciente. 

- Paciente parsearPaciente(String linea): método privado a través del cual se hace la transformación de datos del csv a los distintos tipos de la clase.


### Tipo Contenedor

Clase contenedora de los objetos de tipo Paciente.

**Propiedades**:

- pacientes, de tipo SortedSet<Paciente>, consultable. Conjunto de obras de arte. 
- 

**Constructores**: 

- C1: Pacientes(). Constructor por defecto. Crea un objeto de tipo Pacientes sin ningún paciente almacenado.
- C2: Pacientes(Collection<Paciente> pacientes). Constructor con un par�metro de tipo Collection<Paciente>. Crea un objeto de tipo Pacientes con los pacientes incluidos en la colecci�n dada como par�metro.
- C3: Pacientes(Stream<Paciente> pacientes). Constructor con un parámetro de tipo Stream<Paciente>. Crea una lista de pacientes con los pacientes incluidos en el Stream dado como parámetro.

**Criterio de igualdad**: Dos pacientes son iguales si lo son su propiedad pacientes.

**Otras operaciones**:


Integer numPacientes(): obtiene el número de pacientes que hay en el objeto.

	
void addPaciente(Paciente s): añade un paciente pasado como parámetro al objeto.
	
	
void addAllPacientes(Collection<Paciente> s): añade todos los pacientes dentro de la colección al objeto.

	
void delPaciente(Paciente s): borra el paciente que se pasa como parámetro.
	
 
- Boolean existePacienteFechaEspecifica(LocalDate s): este método indica si existe un paciente que tenga una cita con el médico en la fecha que se pasa por parámetro.

- Double mediaPesoPacientes(): este método devuelve la media del peso de todos los pacientes.

- List<Paciente> pacientesAlergicos(): devuelve una lista que contiene los pacientes que son alérgicos. 

- Map<LocalDate, Set<String>> pacientesPorFecha(): devuelve un Map que tiene como clave una fecha, y como el conjunto de pacientes que han tenido cita con el médico en esa fecha.

- Map<Gender, Integer> numPacientesPorGenero(): devuelve un Map que cuenta el número de pacientes de cada género.

*******************************************************************************************************************

- Boolean existePacienteFechaEspecifica2(LocalDate s): hace lo mismo que el método public Boolean existePacienteFechaEspecifica(LocalDate s), pero este se implementa con streams.

- Double mediaPesoPacientes2(): hace lo mismo que el método Double mediaPesoPacientes(), pero este se implementa con streams.

- List<Paciente> pacientesAlergicos2(): hace lo mismo que el método List<Paciente> pacientesAlergicos(), pero este se implementa con streams.

- Integer maxNumPulsacionesPorGenero(Gender gender): devuelve el mayor número de pulsaciones según el género que se pasa como parámetro.

- List<String> pacientesOrdenadosPorFechaSegunGenero(Gender genero): devuelve una lista de pacientes ordenados por fecha, con el género pasado como parámetro.

- Map<Gender, Long> numPacientesPorGenero2(): hace lo mismo que el método Map<Gender, Long> numPacientesPorGenero(), pero este se construye mediante streams.

- Map<String, List<Double>> IMCPorPaciente(): a partir de un stream de Pacientes, devuelve un Map en el que las claves son el nombre de cada paciente, y los valores, una lista de IMC asociada a dicho nombre.

-

-

- Map<Month, Long> mesMayorNumeroPacientes(): dado un stream de pacientes, devuelve el mes en el que ha habido mayor número de pacientes.






 
