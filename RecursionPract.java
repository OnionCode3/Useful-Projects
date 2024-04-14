package JavaPractice.ProjectsAndMisc;

class Patterns{
    void leftTriangle(int row , int col){
        /*
        Prints This :
            ****
            ***
            **
            *
        */
        if(row == 0) return;
        if(col == 0) {
            System.out.println();
            leftTriangle(row - 1 , row - 1);
            return;
        }
        System.out.print("*");
        leftTriangle(row , col - 1);
    }

    void rightTriangle(int r , int c , int l){
        /*
            prints This :
            * * * *
             * * *
              * *
               *
        */
        if(r == 0) return;
        if(c == 0){
            System.out.println();
            printSpaces(l - r + 1);
            rightTriangle(r - 1, r - 1 , l);
            return;
        }
        System.out.print("* ");
        rightTriangle(r , c - 1 , l);
    }

    void printSpaces(int n){
        if(n == 0) return;
        System.out.print(" ");
        printSpaces(n - 1);
    }

    int power(int iBase , int iExp , int ans){
        if(iExp == 0) return ans;
        if((iExp & 1) == 1){
            ans *= iBase;
        }

        return power(iBase*iBase , iExp >> 1 , ans);
    }
}

public class RecursionPract {
    public static void main(String[] args) {
        Patterns lannister = new Patterns();
        System.out.println(lannister.power(2,0,1));
    }
}