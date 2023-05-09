package com.dim.FX.Ejercicio106;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

import javafx.beans.property.ReadOnlyObjectWrapper;

public class Person {
	
//PROPIEDAD nombre
	/*Esta es la definición de la propiedad nombre de tipo StringProperty de lectura/escritura. 
	 * En la llamada al constructor SimpleStringProperty(this, "nombre", "?") hemos indicado,
	 *  primero, una referencia al objeto a que pertenece la propiedad, 
	 * segundo, el nombre de la propiedad y tercero, el valor inicial de la misma. 
	 */
    private final StringProperty nombre = new SimpleStringProperty(this, "nombre", "?");
    
    /*Los métodos getNombre() y setNombre(String) son para obtener y cambiar el valor de la propiedad, 
     * estos se marcan como final y siguen la convención de nombres de los JavaBeans, 
     */
   

    /* este método es usado para acceder a la propiedad. Tiene la forma XXXProperty(), 
     * donde XXX se refiere al nombre de la propiedad.
    */
    public final StringProperty nombreProperty() {
    	return nombre;
    	}
  public StringProperty getNombre() {
		return nombre;
	}
	//PROPIEDAD id
  	private final ReadOnlyIntegerWrapper id = new ReadOnlyIntegerWrapper(this, "id", 1);
  	
  	// devuelve el valor de la propiedad
  	public final int getId() {
  	    return id.get();
  	}
  	//idProperty() obtiene la propiedad.
  	public ReadOnlyIntegerProperty idProperty() {
  	    return id.getReadOnlyProperty();
  	}
  	// La propiedad id es de tipo IntegerProperty de solo-lectura por lo que no requerimos el método setter, 

  //PROPIEDAD fecha
  	private final ObjectProperty<LocalDate> fecha = new ReadOnlyObjectWrapper<>(this, "fecha");
  	
  	public final LocalDate getFecha() {
  	    return fecha.get();
  	}
  	
  	public final void setFecha(LocalDate value) {
  	    fecha.set(value);
  	}
  	
  	public ObjectProperty<LocalDate> fechaProperty() {
  	    return fecha;
  	}

  	//Esta última propiedad la llamaremos fecha de tipo ObjectProperty<LocalDate>, no indicamos su valor inicial por lo que será nulo, todo lo demás ya lo hemos visto.


}


