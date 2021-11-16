package main;

import java.util.List;

import modelos.Evento;
import modelos.Fuente;
import utils.Parametros;
import utils.Funciones;

/**
 * Prueba funcional trabajando con eventos
 * 
 * @author Carlos Parra
 *
 */
public class Prueba {

	public static void main(String[] args) {
		
		Parametros parametros = new Parametros();
		Funciones funciones = new Funciones();
		try {
			List <Evento> listaEventos = parametros.obtenerEventos();
			List <Fuente> listaFuentes = parametros.obtenerFuentes();

			// Pruebas Obtener eventos por lista de timestamps
			funciones.ObtenerEventosPorTimestamp(listaEventos, "2021-01-01 00:00:00", "2021-01-02 00:00:00");
			funciones.ObtenerEventosPorTimestamp(listaEventos, "2021-04-01 00:00:00", "2021-06-01 00:00:00");
			funciones.ObtenerEventosPorTimestamp(listaEventos, "2021-07-01 00:00:00", "2021-09-02 00:00:00");
			funciones.ObtenerEventosPorTimestamp(listaEventos, "2022-01-01 00:00:00", "2022-01-02 00:00:00");
			
			// Pruebas Obtener eventos por fuenteId
			funciones.ObtenerEventosPorFuenteId (listaEventos, listaFuentes, 2);
			funciones.ObtenerEventosPorFuenteId (listaEventos, listaFuentes, -1);
			funciones.ObtenerEventosPorFuenteId (listaEventos, listaFuentes, 0);
			funciones.ObtenerEventosPorFuenteId (listaEventos, listaFuentes, 6);
			
			// Pruebas Obtener eventos dentro de una rango de valores (valor min, valor max)
			funciones.ObtenerEventosRango(listaEventos, 1900, 2400);
			funciones.ObtenerEventosRango(listaEventos, 2900, 3300);
			funciones.ObtenerEventosRango(listaEventos, 3700, 4400);
			funciones.ObtenerEventosRango(listaEventos, 5900, 7000);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
