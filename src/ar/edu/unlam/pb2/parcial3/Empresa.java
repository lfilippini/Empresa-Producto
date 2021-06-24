package ar.edu.unlam.pb2.parcial3;

import java.util.Map;
import java.util.TreeMap;

public class Empresa {

	private Map<Integer, Persona> lista = new TreeMap<Integer, Persona>();
	private Map<Integer, Producto> listaDeProductos = new TreeMap<Integer, Producto>();
	private String nombreDeLaEmpresa;

	public Empresa(String nombreDeLaEmpresa) {
		this.nombreDeLaEmpresa = nombreDeLaEmpresa;
	}

	public void vincularPersona(Persona persona) {
		this.lista.put(persona.getDni(), persona);
	}

	public Integer getCantidadDePersonasVinculadas() {
		return this.lista.size();
	}

	public void agregarProducto(Producto producto) {
		this.listaDeProductos.put(producto.getCodigo(), producto);
	}

	public Producto buscarProducto(Producto producto) {
		return this.listaDeProductos.get(producto.getCodigo());
	}

	public void sacarDeLaListaUnaPersona(Persona persona) {
		this.lista.remove(persona.getDni());
	}

	public Empleado aplicarDescuentoAEmpleado(Empleado empleado,Producto producto) {
		Double totalADescontar=empleado.getDESCUENTO()*producto.getPrecio();
		Double totalAPagar = producto.getPrecio() - totalADescontar;
		empleado.setProductoComprado(totalAPagar);
		return empleado;
	}

	public void registrarCompra(Persona persona, Producto producto)
			throws ProductoNoEncontradoException, ConflictoDeInteresesException {

		if (persona instanceof Director)
			throw new ConflictoDeInteresesException("conflicto de intereses");

		if (persona instanceof Empleado) {
			Empleado persona2 = (Empleado) persona;

			if (this.buscarProducto(producto) != null) {
				this.sacarDeLaListaUnaPersona(persona);
				this.aplicarDescuentoAEmpleado(persona2, producto);
				this.vincularPersona(persona2);
			}

			else
				throw new ProductoNoEncontradoException("Producto no encontrado");
		}

		else {
			if (this.buscarProducto(producto) != null)
				persona.setProductoComprado(producto.getPrecio());

			else
				throw new ProductoNoEncontradoException("Producto no encontrado");
		}
	}
}
