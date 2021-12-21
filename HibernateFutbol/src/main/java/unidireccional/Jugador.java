package unidireccional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Jugador {

	private int id, edad, posicion;
	private String nombre;


	public Jugador() {
	}

	public Jugador(int edad, int posicion, String nombre) {
		this.edad = edad;
		this.posicion = posicion;
		this.nombre = nombre;
	}

	@Id
	@Column
	@GeneratedValue
	public int getId() {
		return id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setId(int id) {
		this.id = id;
	}

}
