package modelos;

import java.sql.Timestamp;

public class Evento {
	private int id;
	private int fuenteId;
	private Timestamp fecha;
	private int valor;
	
	public Evento(int id, int fuenteId, Timestamp timestamp, int valor) {
		this.id = id;
		this.fuenteId = fuenteId;
		this.fecha = timestamp;
		this.valor = valor;
	}

	public Evento() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFuenteId() {
		return fuenteId;
	}

	public void setFuenteId(int fuenteId) {
		this.fuenteId = fuenteId;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "\nEvento id = " + id + ", fuenteId = " + fuenteId + ", fecha = " + fecha + ", valor = " + valor;
	}
	
}
