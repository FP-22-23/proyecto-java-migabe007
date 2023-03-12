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

El dataset original Patient admission dataset for learning data mining se puede obtener de la URL https://www.kaggle.com/datasets/miles99/patient-admission-dataset-for-learning-data-mining. Originalmente ten�a 17 columnas, aunque de ellas solo se han tomado 7 para este proyecto. Además, se han añadido 3 columnas nuevas a través de un módulo de Python para generar columanas aleatorias. Cada fila contiene datos referentes a un paciente. A continuaci�n se describen las 8 columnas del dataset:

El dataset está compuesto por 10 columnas, con la siguiente descripción:

* **id**: de tipo String, representa el identificador del paciente.
* **patient_name**: de tipo String, representa el nombre y apellidos del paciente.
* **patient_gender**: de tipo Gender, es un enumerado que representa el género del paciente.
* **appointment_date**: de tipo LocalDate, representa la fecha de la cita del paciente con el médico.
* **patient_weight**: de tipo Integer, representa el peso del paciente en kilogramos.
* **patient_height**: de tipo Integer, representa la altura del paciente en centímetros.
* **is_allergic**: de tipo Boolean, indica si el paciente es alérgico o no.
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
- appointmentDate, de tipo LocalDate, consultable y modificable. 
- patientWeight, de tipo Integer, consultable y modificable. 
- patientHeight, de tipo Integer, consultable y modificable. 
- isAllergic, de tipo Boolean, consultable y modificable. 
- prescribedMedicines, de List<String>, consultable y modificable. 
- patient_statistics, de tipo Patient_statistics, consultable y modificable. Record cuyos atributos son temperature, de tipo Double, y heartbeats, de tipo Integer. 

**Constructores**: 

- C1: clase que crea un objeto de tipo Paciente a partir de los siguientes par�metros: iD,
patientName, patientGender, appointmentDate, patientWeight, patientHeight, isAllergic, prescribedMedicines, patient_statistics.

- C2: constructor vacío que crea un objeto de tipo Paciente sin parametros de entrada. 


**Restricciones**:
 
- R1: El nombre del paciente no puede estar vac�o.
- R2: El peso del paciente no puede ser cero ni negativo.
- R3: La altura del paciente no puede ser negativa ni cero.	

**Criterio de igualdad**:

El criterio de igualdad se basa en el id, el nombre del paciente, y en su fecha con el médico para distinguir a un paciente de otro. 

**Criterio de ordenación**: 

El criterio de ordenación se basa en el id, el nombre del paciente, y en su fecha con el médico para ordenarlos, las mismas propiedades que con el criterio de igualdad. 

**Otras operaciones**:
 
-	Double patientIMC(): Devuelve el IMC(**I**ndice de **M**asa **C**orporal) del paciente, lo cual se calcula en base a la altura y el peso del paciente. En concreto es dividir el peso entre la altura al cuadrado(kg/m^2).

-	Boolean tieneFiebre(): Confirma si el paciente tiene fiebre o no, y para ello la temperatura corporal del paciente tiene que sobrepasar los 37.8 grados.

-	String pulsaciones(): Devuelve el estado del paciente según su número de pulsaciones. Si son menos de 60, tiene bradicardia, si están entre 60 y 100 esta normal, y si supera las 100, tiene taquicardia.

#### Tipos auxiliares

**Patient_statistics**:
- Se trata de un record que recoge los valores de las columnas temperature(Double) y heartbeats_per_minute(Integer).
Tiene operaciones propias como 'tieneFiebre()' o 'pulsaciones()'.
