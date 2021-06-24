package ar.edu.unlam.pb2.parcial3;

public abstract class Persona implements Comparable<Persona>{

	private Integer dni;
	private String nombreDelCliente;
	private Double productoComprado=0.0;
	
	public Persona(Integer dni, String nombreDelCliente) {
		this.dni=dni;
		this.nombreDelCliente=nombreDelCliente;
	}

	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombreDelCliente;
	}

	@Override
	public int compareTo(Persona otroCliente) {
		return this.dni.compareTo(otroCliente.dni);
	}

	public Double getPrecioDelProducto(Producto producto) {
		return this.productoComprado;
	}

	public void setProductoComprado(Double productoComprado) {
		this.productoComprado = productoComprado;
	}
	
	

	
}
