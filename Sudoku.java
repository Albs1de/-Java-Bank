public class Sudoku {

    static int[][] grid = new int[9][9];

    public static void main(String[] args) {
        showSudoku();
        
        insert(0, 4, 5);
        insert(1, 8, 1);
        insert(2, 6, 9);
        insert(3, 0, 2);
        insert(4, 1, 9);
        insert(5, 7, 3);
        insert(6, 8, 7);
        insert(7, 3, 6);
        insert(8, 7, 5);
        insert(4, 4, 1);
        insert(8, 1, 7);
        insert(7, 3, 9);
        insert(6, 7, 8);
        insert(5, 6, 7);
        insert(4, 5, 6);
        insert(3, 4, 7);
        insert(2, 3, 4);
        insert(1, 2, 3);
        insert(2, 4, 2);
        insert(0, 8, 6);
        
        showSudoku();
    }

    static void showSudoku() {
        System.out.println("-------------------------");
        for (int x = 0; x < 9; x++) {
            System.out.print("| ");
            for (int y = 0; y < 9; y++) {
                if (grid[x][y] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print(grid[x][y]);
                }
                System.out.print(" ");
               if (y % 3 == 2) {
                  // System.out.print("| ");
                   System.out.print("| ");
                }
            }
            System.out.println();
            if (x % 3 == 2) {
                System.out.println("-------------------------");
            }
        }
    }

    static void insert(int x, int y, int zahl) {
        if (!(x < 0 || x > 8 || y < 0 || y > 8 || zahl < 1 || zahl > 9) && grid[x][y] == 0) {
            grid[x][y] = zahl;
        } else {
            // Do nothing
        }
    }
    static boolean conflictInRow(int x, int y) {
      
        /**Überprüft ob für das Feld mit den Koordinaten ein Zeilenkonflikt besteht.
         * wenn der gleiche wert nochmal in derselben Zeile vorkommt = return true
         * wenn nicht || Feld leer = return false
         */

         int[] count = new int[9];
         for (x=0; x<9; x++) {
             int value = grid[x] [y];
             count[value -1]++;
         }
         for (int value: count) {
             if (value> 1)
             return true;
         }
         return false;
        }
        /**if (zweidimArray[x] == zweidimArray[x]) {
        return true;
        }
        else {return false;*/
    
    static boolean conflictInColumn( int x, int y) {
       
        /**Über prüft wie oben jedoch dieses Mal Spaltenkonflikt */
        int[] count = new int[9];
        for(y=0; y<9; y++) {
            int value = grid[x] [y];
            count[value -1]++;
        }
        for(int value: count) {
            if(value > 1)
            return true;
        }
        return false;


    }

    static boolean conflictInSquare(int x, int y) {
        
        /** Überprüft Konflikt im selben 3x3 Quadrat 
         * Hinwei: Modulo Operator verwenden!
         */
        if (x % 3 == 2 && y % 3 ==2) {
            return true;
        }
        else {
            return false;
        }
    }
    static boolean anyConflict(int x, int y) {
        if (!(conflictInRow(x,y) || conflictInColumn(x,y) || conflictInSquare(x,y))) {
            return true;
        }
      
        /**Besteht mindestens ein Konflikt aus den vorherigen dan
         *n return true */
      
        return false;
    }
    static boolean tryNumber(int x, int y, int zahl) {
           

        if(!(conflictInRow(x,y) || conflictInColumn(x, y)|| conflictInSquare(x, y))) {

            
            return true;
   
           
        } else {
            return false;
        }

    
        //**  trägt probeweise in das x,y Feld Zahl ein wenn Feld leer & überprüft
        /**ob Konflikt herrscht. Wenn ja dann Feld wieder löschen und return false
         * else Zahl eingetragen lassen und return true.
         * Die vorhandenn Methoden verwenden.
         */
        
    
}}