/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Rafael
 */
public class Juros {
     //declara variaveis com ponto flutuante e inteiro
        double montante, juros1;
        double total, resultado;
        int mes;
        
    public double CalculaJuros(Juros juros)
    {
        
        for (int tempo1=1; tempo1<=mes; ++tempo1){
        total = (montante*juros1);
        resultado = total + montante;
        }
        
        
        return resultado;
    }
}
