package utils;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import modelos.Evento;
import modelos.Fuente;

public class Funciones {
	
	/**
	 * Muestra una lista con los eventos filtrados por un intervalo de fechas
	 * 
	 * @param listaEventos
	 * @param fecha
	 */
	
	public static void ObtenerEventosPorTimestamp(List<Evento> listaEventos, String fechaInicial, String fechaFinal) {
		Timestamp fechaInicio;
		Timestamp fechaFin;
		fechaInicio = Timestamp.valueOf(fechaInicial);
		fechaFin = Timestamp.valueOf(fechaFinal);
		listaEventos = listaEventos
			.stream()
			.filter(e -> e.getFecha().after(fechaInicio) && e.getFecha().before(fechaFin))
			.collect(Collectors.toList());
		
		System.out.println("Lista de eventos registrados entre " + fechaInicial + " y " + fechaFinal);
		if (listaEventos.size() == 0) {
			System.out.println("No hay eventos en " + fechaInicial);
		} else {
			System.out.println(listaEventos.toString());			
		}
		System.out.println("\n#################################\n");
	}
	
	/**
	 * Muestra una lista con los eventos filtrados por el idFuente
	 * 
	 * @param listaEventos
	 * @param listaFuentes
	 * @param fuenteId
	 * @throws Exception
	 */
	public static void ObtenerEventosPorFuenteId(final List<Evento> listaEventos, final List<Fuente> listaFuentes,final int fuenteId) throws Exception {
		int fuentesLength = listaFuentes.size();
		
		if (fuenteId < 0) {
			System.out.println("El id de la fuente no puede ser negativo");
		}
		
		if (fuenteId == 0) {
			System.out.println("El id no puede ser igual a cero");
		}
		
		if (fuenteId > fuentesLength) {
			System.out.println("El id " + fuenteId + " no está dentro de lista");
		}
		else {
			if (fuenteId > 0 && fuenteId <= fuentesLength) {
				System.out.println("Lista de eventos del id " + fuenteId + "\n");				
			}
			for (Evento evento : listaEventos) {
				if (evento.getFuenteId() == fuenteId) {
					for (Fuente fuente : listaFuentes) {
						if (fuente.getId() == fuenteId) {
							System.out.println(fuente.getNombre() + " -> " + evento.getFecha() + " -> " + evento.getValor());
							break;
						}
					}
				}
			}
		}
	}
	
	/**
	 * Muestra una lista con los eventos filtrados entre un rango mínimo y máximo
	 * 
	 * @param listaEventos
	 * @param min
	 * @param max
	 */
	
	public static void ObtenerEventosRango(List<Evento> listaEventos, final int min, final int max) {
		listaEventos = listaEventos
			.stream()
			.filter(e -> e.getValor() > min && e.getValor() < max)
			.collect(Collectors.toList());
		
		System.out.println("\n#################################\n");
		System.out.println("Lista de eventos entre " + min + " y " + max);
		if (listaEventos.size() == 0) {
			System.out.println("No hay eventos entre " + min + " y " + max);
		} else {
			System.out.println(listaEventos.toString());			
		}
	}

}
