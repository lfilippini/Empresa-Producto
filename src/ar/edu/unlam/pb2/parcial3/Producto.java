package ar.edu.unlam.pb2.parcial3;

public class Producto implements Comparable<Producto>{

	private Integer codigo;
	private String descripcion;
	private Double precio;
	
	public Producto(Integer codigo, String descripcion, Double precio) {
		this.codigo=codigo;
		this.descripcion=descripcion;
		this.precio=precio;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	@Override
	public int compareTo(Producto otroProducto) {
		return this.codigo.compareTo(otroProducto.getCodigo());
	}

	
}
