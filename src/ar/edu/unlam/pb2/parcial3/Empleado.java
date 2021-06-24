package ar.edu.unlam.pb2.parcial3;

public class Empleado extends Persona {

	private final Double DESCUENTO =0.2;
	
	public Empleado(Integer dni, String nombreDelCliente) {
		super(dni, nombreDelCliente);
	}

	public Double getDESCUENTO() {
		return DESCUENTO;
	}

	
}
