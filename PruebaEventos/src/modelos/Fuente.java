package modelos;

public class Fuente {
	private int id;
	private String nombre;
	
	public Fuente(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Fuente() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
