package unidireccional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Entrenador {

	private long id;
	private int edad;
	private String nombre, apellidos;
	private Equipo equipo;

	public Entrenador() {
	}

	public Entrenador(int edad, String nombre, String apellidos) {
		this.edad = edad;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	@Id
	@Column
	@GeneratedValue(generator = "foreigngen")
	public long getId() {
		return id;
	}

	@OneToOne(mappedBy = "entrenador")
	public Equipo getEquipo() {
		return equipo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

}
