package hibernate.futbol;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Competicion {
	private int id, cantidadPremio;
	private String nombre;
	private Date FechaInicio;
	private Set<Equipo> equipos;
	
	public Competicion() {	
	}

	public Competicion(int id, int cantidadPremio, String nombre, Date fechaInicio) {
		this.id = id;
		this.cantidadPremio = cantidadPremio;
		this.nombre = nombre;
		this.FechaInicio = fechaInicio;
	}

	@Id
	@Column
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadPremio() {
		return cantidadPremio;
	}

	public void setCantidadPremio(int cantidadPremio) {
		this.cantidadPremio = cantidadPremio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}

	//@ManyToMany(mappedBy = "competicion", cascade = CascadeType.ALL)
	public Set<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "Competicion [id=" + id + ", cantidadPremio=" + cantidadPremio + ", nombre=" + nombre + ", FechaInicio="
				+ FechaInicio + ", equipos=" + equipos + "]";
	}
	
	
	

}
