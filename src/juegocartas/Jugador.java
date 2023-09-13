package juegocartas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JPanel;
import java.util.Comparator;

public class Jugador {

    public int TOTAL_CARTAS = 10;
    private int sumaTotal;

    private Random r = new Random();

    private Carta[] cartas;
    
    public Jugador(){
        sumaTotal = 0;
    }
    
    

    public void repartir() 
    {
        cartas = new Carta[TOTAL_CARTAS];
        for (int i = 0; i < cartas.length; i++) 
        {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) 
    {
        pnl.removeAll();
        for (int i = 0; i < cartas.length; i++) {
            cartas[i].mostrar(pnl, 5 + i * 40, 5);
        }
        pnl.repaint();
        
        
    }
       public String getEscaleras()
       {
        
        Comparator<Carta> verificacion = (a,b) -> a.getIndice()- b.getIndice();
        Arrays.sort(cartas, verificacion);
        
        String mensaje = "El jugador no cuenta con escaleras ";
        
        ArrayList<String> pintasDeEscalas = new ArrayList<>();
        ArrayList<Integer> escalas = new ArrayList<>();
        
        escalas.add(1);
        pintasDeEscalas.add(cartas[0].getPinta().name());
        
        for (int i = 1; i < cartas.length; i++) 
        
        {

            if (cartas[i-1].getIndice() == cartas[i].getIndice()-1 && cartas[i-1].getPinta() == cartas[i].getPinta())
            {

                Integer lastElement = escalas.get(escalas.size() - 1);
                lastElement++;
                escalas.set(escalas.size() - 1, lastElement);

                pintasDeEscalas.set(pintasDeEscalas.size() - 1, cartas[i].getPinta().name());
            }

            else 
                
                if (cartas[i-1].getIndice() == cartas[i].getIndice() && cartas[i-1].getPinta() == cartas[i].getPinta())
                {
                    
                continue;
            }
                
            else
                {
                escalas.add(1);
                pintasDeEscalas.add(cartas[i].getPinta().name());
            }
        }
        
        boolean verificarEscalas = false;
        for (int i = 0; i < escalas.size(); i++) 
        
        {
            if (escalas.get(i)> 2) {
                
                verificarEscalas = true;
                break;
            }
        }
        
        if (verificarEscalas)
        
        {
            mensaje = "Las escaleras encontradas fueron:\n";
        
            for (int i = 0; i < escalas.size(); i++) 
            
            {
                if (escalas.get(i)> 2){
                    mensaje += escalas.get(i) + " de "  + pintasDeEscalas.get(i) + "\n";
                }

            }
        }
        
        return mensaje;
            
    }
   
    public String getGrupos() 
    {
        String mensaje = "No hay grupos";
        int[] contadores = new int[NombreCarta.values().length];
        for (int i = 0; i < cartas.length; i++) 
        {
            contadores[cartas[i].getNombre().ordinal()]++;
        }

        int totalGrupos = 0;
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] >= 2) {
                totalGrupos++;
            }
        }
        if (totalGrupos > 0) {
            mensaje = "Los grupos encontrados fueron:\n";
            for (int i = 0; i < contadores.length; i++) {
                if (contadores[i] >= 2) {
                    mensaje += Grupo.values()[contadores[i]] +  " de "  + NombreCarta.values()[i]+"\n";
                }
            }
        }
        return mensaje;
    }
    
    public String getSumaTotal()
    {
        String mensajeSuma=null;
        int as =10;
        int d = 2;
        int t = 3;
        int c = 4;
        int ci = 5;
        int s = 6;
        int si = 7;
        int oc = 8;
        int n = 9;
        int diez = 10;
        
        int jack = 10;
        int q = 10;
        int k = 10;
        
        int[] contadores = new int[NombreCarta.values().length];
        for (int i = 0; i < cartas.length; i++) 
        {
            contadores[cartas[i].getNombre().ordinal()]++;
            
            System.out.println("carta "+ cartas[i].getNombre());
            
            
            if(cartas[i].getNombre().toString().equals("AS"))
            {
                sumaTotal+= as;
                
            }
            else if(cartas[i].getNombre().toString().equals("QUEEN"))
            {
                sumaTotal+= q;
            }
            else if(cartas[i].getNombre().toString().equals("DOS"))
            {
                sumaTotal += d;
            }
             else if(cartas[i].getNombre().toString().equals("TRES"))
            {
                sumaTotal += t;
            }
           else if(cartas[i].getNombre().toString().equals("CUATRO"))
            {
                sumaTotal += c;
            }
             else if(cartas[i].getNombre().toString().equals("CINCO"))
            {
                sumaTotal += ci;
            }
           else if(cartas[i].getNombre().toString().equals("SEIS"))
            {
                sumaTotal += s;
            }
             else if(cartas[i].getNombre().toString().equals("SIETE"))
            {
                sumaTotal += si;
            }
             else if(cartas[i].getNombre().toString().equals("OCHO"))
            {
                sumaTotal += oc;
            }
             else if(cartas[i].getNombre().toString().equals("NUEVE"))
            {
                sumaTotal += n;
            }
            else if(cartas[i].getNombre().toString().equals("KING"))
            {
                sumaTotal+= k;
            }
            else if(cartas[i].getNombre().toString().equals("JACK"))
            {
                sumaTotal+= jack;
            }
            else if(cartas[i].getNombre().toString().equals("DIEZ"))
            {
                sumaTotal+= diez;
            }
              mensajeSuma = "El puntaje es: "+sumaTotal;
        }
        return  mensajeSuma;
    }
}
