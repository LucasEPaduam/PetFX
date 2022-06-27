/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petFX;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Eduardo
 */
public class teste {

    public static void main(String[] args) {
        
        List<String> listaHorarios = new ArrayList<>();
        
     int hora = 7;
     String horaMinuto;
     String minuto00 = "00";
     String minuto15 = "15";
     String minuto30 = "30";
     String minuto45 = "45";
     
        for (int i = 0; i < 9; i++) {
          
            hora = hora + 1;
            horaMinuto = hora + ":" + minuto00;            
            listaHorarios.add(horaMinuto);
            horaMinuto = hora + ":" + minuto15;            
            listaHorarios.add(horaMinuto);
            horaMinuto = hora + ":" + minuto30;            
            listaHorarios.add(horaMinuto);
            horaMinuto = hora + ":" + minuto45;            
            listaHorarios.add(horaMinuto);
        }
        
        for (String lista : listaHorarios) {
            
            System.out.println(lista);
            
        }
        
        
    }
    
}
