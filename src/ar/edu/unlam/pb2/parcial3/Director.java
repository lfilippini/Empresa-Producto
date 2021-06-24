package ar.edu.unlam.pb2.parcial3;

public class Director extends Persona {

	private String patenteCorporativa;
	
	public Director(int dni, String nombreDelCliente, String patenteCorporativa) {
		super(dni,nombreDelCliente);
		this.patenteCorporativa=patenteCorporativa;
	}

	public String getPatenteCorporativa() {
		return patenteCorporativa;
	}
	
	

}
