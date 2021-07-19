/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.mycompany.models.Inmuebles;
import com.mycompany.models.Propietarios;

/**
 *
 * @author CARLOS
 */
public interface Comprobable {
    public boolean comprobar_inmuebles (Inmuebles a);
    public boolean comprobar_propietarios (Propietarios a);
}
