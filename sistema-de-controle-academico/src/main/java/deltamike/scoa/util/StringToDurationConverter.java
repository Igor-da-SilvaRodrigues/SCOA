/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.util;

import java.time.Duration;

/**
 *
 * @author rodri
 */
public class StringToDurationConverter {

    public static Duration convert(String source) {
        if (source == null){ return null; }
        String horas = source.split(":")[0];
        String minutos = source.split(":")[1];
        
        return Duration.parse("PT" + horas + "H"+minutos+"M");
    }
    
}
