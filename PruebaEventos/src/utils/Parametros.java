package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import modelos.Evento;
import modelos.Fuente;

public class Parametros {
	private static final String RUTA_SOURCES = "./src/datos/";
	private static final String FICHERO_EVENTOS = "eventos.csv";
	private static final String FICHERO_FUENTES = "fuentes.csv";
	
	public static List<Evento> obtenerEventos() throws Exception {
		
		final String SEPARADOR = ";";
		BufferedReader br = null;
		List<Evento> listaEventos = new ArrayList<Evento>();
		
		try {
			br = new BufferedReader(new FileReader(RUTA_SOURCES.concat(FICHERO_EVENTOS)));
			String linea = br.readLine();
			while (linea != null) {
				String[] campos = linea.split(SEPARADOR);
				Evento evento = obtenerEvento(campos);
				listaEventos.add(evento);
				linea = br.readLine();
			}
			
		} catch (Exception e) {
			throw new Exception("No se ha podido abrir el fichero. " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new Exception("No se ha podido cerrar el archivo.");
				}
			}
		}
		
		return listaEventos;
		
	}
	
	private static Evento obtenerEvento (final String[] campos) throws Exception {
		Evento evento = new Evento();
		int i = 0;
		
		if (campos[i] != null && campos[i] != "") {
			evento.setId(Integer.parseInt(campos[i++]));
		}
		if (campos[i] != null && campos[i] != "") {
			evento.setFuenteId(Integer.parseInt(campos[i++]));
		}
		if (campos[i] != null && campos[i] != "") {
			evento.setFecha(Timestamp.valueOf(campos[i++]));
		}
		if (campos[i] != null && campos[i] != "") {
			evento.setValor(Integer.parseInt(campos[i++]));
		}
		return evento;
	}
	
	public static List<Fuente> obtenerFuentes() throws Exception {
		
		final String SEPARADOR = ";";
		BufferedReader br = null;
		List<Fuente> listaFuentes = new ArrayList<Fuente>();
		
		try {
			br = new BufferedReader(new FileReader(RUTA_SOURCES.concat(FICHERO_FUENTES)));
			String linea = br.readLine();
			while (linea != null) {
				String[] campos = linea.split(SEPARADOR);
				Fuente fuente = obtenerFuente(campos);
				listaFuentes.add(fuente);
				linea = br.readLine();
			}
			
		} catch (Exception e) {
			throw new Exception("No se ha podido abrir el fichero. " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new Exception("No se ha podido cerrar el archivo.");
				}
			}
		}
		
		return listaFuentes;
		
	}
	
	private static Fuente obtenerFuente (final String[] campos) throws Exception {
		Fuente fuente = new Fuente();
		int i = 0;
		
		if (campos[i] != null && campos[i] != "") {
			fuente.setId(Integer.parseInt(campos[i++]));
		}
		if (campos[i] != null && campos[i] != "") {
			fuente.setNombre(campos[i++]);
		}
		
		return fuente;
	}
}
