package edu.tienda.core.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")//Debido a que las propiedas de nosotros tienen el prefijo "app"
public class ConfigurationParameters {
	
	private String nombre;
	private String lenguaje;
	private String pais;
	private String autor;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLenguaje() {
		return lenguaje;
	}
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public String toString() {
		return "ConfigurationParameters [nombre=" + nombre + ", lenguaje=" + lenguaje + ", pais=" + pais + ", autor="
				+ autor + "]";
	}
	
}
