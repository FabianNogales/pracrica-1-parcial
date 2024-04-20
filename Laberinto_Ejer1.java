
public class Laberinto_Ejer1
{
    /*para ingresar el maze se debe ingresar los String sin espacios(" ") por ejemplo: 
     {"S*???", "?****", "??*?*", "??*?*", "??**E"}    */
    public boolean puedoSalir(int n, String[] maze){
        int[] posS = getPosS(0, 0, maze);
        if(posS != null){
            return puedoSalir(posS[0], posS[1], maze); 
        }
        return false;
    }

    private int[] getPosS(int i, int j, String[] maze){
        if(i < maze.length){
            if(j < maze[i].length()){
                if(maze[i].charAt(j) == 'S'){
                    return new int[]{i, j};
                }else{
                    j += 1;
                }
            }else{
                i += 1;
                j = 0;
            }
            return getPosS(i, j, maze);
        }
        return null;
    }

    private boolean puedoSalir(int x, int y, String[] maze){
        if (valida(x, y, maze)) {
            char charActual = maze[x].charAt(y);
            if (charActual == 'E') {
                return true;
            }
            maze[x] = maze[x].substring(0, y) + 'x' + maze[x].substring(y + 1); //para dejar rastro 
            boolean encontro = puedoSalir(x - 1, y, maze) ||
                puedoSalir(x, y + 1, maze) ||
                puedoSalir(x + 1, y, maze) ||
                puedoSalir(x, y - 1, maze);
            maze[x] = maze[x].substring(0, y) + charActual + maze[x].substring(y + 1); //restaurar el cambio del rastro
            return encontro;
        }
        return false;
    }

    private boolean valida(int x, int y, String[] maze){    //metodo para validar las posiciones
        int n = maze.length;
        return x >= 0 && x < n && y >= 0 && y < n && maze[x].charAt(y) != '?' && maze[x].charAt(y) != 'x';
    }
}
