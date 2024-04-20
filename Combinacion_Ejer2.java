
public class Combinacion_Ejer2
{
    public boolean puedoGenerar(String [] a,String x){
        String [] y = new String[x.length()];
        int aux = 0;
        y = rellenar(y,x,aux);
        int pos1 = 0;
        int pos2 = 0;
        return puedoGenerar(a, y, false, pos1, pos2);
    }
    
    private boolean puedoGenerar(String [] a, String [] y, boolean res, int pos1, int pos2){
        if(pos1 < a.length){
            if(a[pos1].length() < 2){
                if(a[pos1].equals(y[pos2])){
                    if(y[pos2].equals(y[y.length-1])){
                        res = true;
                    }else{
                        res = puedoGenerar(a, y, res, pos1+1, pos2+1);
                    }
                }else{
                    res = puedoGenerar(a, y, res, pos1+1, pos2);
                }
            }else{
                String [] c = new String[a[pos1].length()];
                c = rellenar(c, a[pos1], 0);
                boolean bandera = flag(c, y, 0, pos2);
                if(bandera == true){
                    pos2 = pos2 + c.length;
                }
                if(pos2 == y.length){
                    res = true;
                }else{
                    res = puedoGenerar(a, y, res, pos1+1, pos2);
                }   
            } 
        }
        return res;
    }
    
    private boolean flag(String [] c, String [] y, int pos1, int pos2){
        boolean res = false;
        if(pos1 < c.length){
            if(c[pos1].equals(y[pos2])){
                if(c[pos1].equals(c[c.length-1])){
                    res = true;
                }else{
                    res = flag(c, y, pos1+1, pos2+1);
                }
            }else{
                res = false;
            }
        }
        return res;
    }
      
    private String[] rellenar(String [] y, String x, int pos){
        if(pos < y.length){
            y[pos] = Character.toString(x.charAt(pos));
            rellenar(y, x, pos+1);
        }
        return y;
    }
}
