package fp.pacientes;

public record Patient_statistics(Double temperature, Integer heartbeats) implements Comparable<Patient_statistics> {
	
	public Boolean tieneFiebre() {
		Boolean res = false;
		if (temperature() > 37.8) {
			res = true;
		}
		return res;
	}	
	
	public String pulsaciones() {
		String res;
		if (heartbeats() <  60) {
			res = "Tiene bradicardia";
		} else if (heartbeats() >= 60 && heartbeats() <= 100){
			res = "Tiene un numero de pulsaciones dentro de la media esperada";
		} else {
			res = "Tiene taquicardia";
		}
		return res;
	}
	
	@Override
	public int compareTo(Patient_statistics o) {
		int res;
		res = temperature().compareTo(o.temperature());
		if (res == 0) {
			res = heartbeats().compareTo(o.heartbeats());
		}
		return res;
	}
	
}
