package ar.edu.unlam.pb2.parcial3;

import static org.junit.Assert.*;

import org.junit.Test;

public class tests {

	@Test
	public void queSePuedaCrearUnCliente() {
		Cliente nuevo = new Cliente(1000, "Camila");

		assertEquals((Integer)1000, nuevo.getDni());
		assertEquals("Camila", nuevo.getNombre());
		
	}
	
	@Test
	public void queSePuedaCrearUnEmpleado() {
		Empleado nuevo = new Empleado(1000, "Celeste");
		
		assertEquals((Integer)1000, nuevo.getDni());
		assertEquals("Celeste", nuevo.getNombre());
		
	}
	
	@Test
	public void  queSePuedaCrearUnDirector() {
		Director nuevo = new Director(1000, "Monica", "JJZ526");

		assertEquals((Integer) 1000, nuevo.getDni());
		assertEquals("Monica", nuevo.getNombre());
		assertEquals("JJZ526", nuevo.getPatenteCorporativa());
		
	}
	@Test
	public void  queSePuedaCrearUnProducto() {
		Producto nuevo = new Producto(1000, "Seguro de vida", 1000.0);

		assertEquals((Integer) 1000, nuevo.getCodigo());
		assertEquals("Seguro de vida", nuevo.getDescripcion());
		assertEquals((Double)1000.0, nuevo.getPrecio(), 0.01);
		
	}
	
	@Test
	public void  queSePuedanAsociarLasPersonasAUnaEmpresaSinRepetirNinguna() {		
		Empresa actual = new Empresa("Seguros La Tercera");
		
		actual.vincularPersona(new Director(1000, "Monica", "JJZ526"));
		actual.vincularPersona(new Empleado(2000, "Camila"));
		actual.vincularPersona(new Empleado(1500, "Celeste"));
		actual.vincularPersona(new Empleado(4000, "Luz"));
		actual.vincularPersona(new Cliente(5000, "Claudio"));
		actual.vincularPersona(new Cliente(6000, "Raquel"));
		actual.vincularPersona(new Cliente(7000, "Jorge"));
		actual.vincularPersona(new Cliente(8000, "Tamara"));
		actual.vincularPersona(new Cliente(9000, "Lucrecia"));
		actual.vincularPersona(new Cliente(4000, "Celeste"));
		actual.vincularPersona(new Cliente(9500, "Ricardo"));
		
		
		assertEquals((Integer) 10, actual.getCantidadDePersonasVinculadas());		
	}
	
	@Test
	public void  queUnClientePuedaComprarUnNuevoProducto() throws ConflictoDeInteresesException, ProductoNoEncontradoException{		
		Cliente celeste = new Cliente(4000, "Celeste");
		Empresa actual = new Empresa("Seguros La Tercera");
		Producto aVender = new Producto(1000, "Seguro de vida", 1000.0);
		
		actual.vincularPersona(celeste);
		actual.agregarProducto(aVender);
		
		actual.registrarCompra(celeste, aVender);
		
		assertEquals((Double) 1000.0, celeste.getPrecioDelProducto(aVender));
	}
	
	@Test
	public void  queUnEmpleadoTengaUnDescuentoDelVeintePorCiento() throws ConflictoDeInteresesException, ProductoNoEncontradoException{		
		Persona camila = new Empleado(2000, "Camila");
		Empresa actual = new Empresa("Seguros La Tercera");
		Producto aVender = new Producto(1000, "Seguro de vida", 1000.0);
		
		actual.vincularPersona(camila);
		actual.agregarProducto(aVender);
		
		try{
			actual.registrarCompra(camila, aVender); 
		} 
		
		catch(ProductoNoEncontradoException exception){
			exception.printStackTrace();
		}
		
		catch(ConflictoDeInteresesException exception){
			exception.printStackTrace();
		}
		
		
		
		
		assertEquals((Double) 800.0, camila.getPrecioDelProducto(aVender));
	}
	
	@Test (expected = ConflictoDeInteresesException.class)
	public void  queUnDirectorNoPuedaComprarProductosDeLaPropiaEmpresa() throws ConflictoDeInteresesException, ProductoNoEncontradoException{		
		Persona monica = new Director(1000, "Monica", "JJZ526");
		Empresa actual = new Empresa("Seguros La Tercera");
		Producto aVender = new Producto(1000, "Seguro de vida", 1000.0);
		
		actual.vincularPersona(monica);
		actual.agregarProducto(aVender);
		
		actual.registrarCompra(monica, aVender);
		
		assertEquals((Double) 1000.0, monica.getPrecioDelProducto(aVender));
	}

}
