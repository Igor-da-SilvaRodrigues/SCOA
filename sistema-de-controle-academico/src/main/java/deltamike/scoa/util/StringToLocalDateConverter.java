/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.util;

import java.time.LocalDate;

/**
 *
 * @author rodri
 */
public class StringToLocalDateConverter {
    
    public static LocalDate convert(String source) throws Exception{
        if(source == null){return null;}
        
        String[] arrayOfStrings = source.split("-");
        
        
        if(arrayOfStrings.length != 3){
            throw new Exception("Data invalida");
        }
        if(arrayOfStrings[0].length() != 4){
            throw new Exception("Ano invalido");
        }
        if(arrayOfStrings[1].length()!=2){
            throw new Exception("Mes invalido");
        }
        if(arrayOfStrings[2].length()!=2){
            throw new Exception("Dia invalido");
        }
        
        Integer ano = Integer.valueOf(arrayOfStrings[0]);
        Integer mes = Integer.valueOf(arrayOfStrings[1]);
        Integer dia = Integer.valueOf(arrayOfStrings[2]);
        
        if(ano < 1){
            throw new Exception("ano invalido");
        }
        if(mes < 1 || mes > 12){
            throw new Exception("mes invalido");
        }
        
        if(dia < 1 || dia > 31){
            throw new Exception("dia invalido");
        }
        
        return LocalDate.of(ano, mes, dia);
        
    }
    
}
