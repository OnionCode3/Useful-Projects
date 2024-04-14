package JavaPractice.ProjectsAndMisc;
import java.util.Arrays;

class BasicRecursion{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Basic Recursion is Removed !!!");
        super.finalize();
    }

    void whichSort(int[] arr) {
        if (arr[0] > arr[arr.length - 1]) {
            if (whichSortHelperDescending(arr, 0, 1)) {
                System.out.println("Descending sorted");
            } else {
                System.out.println("unsorted");
            }
        } else {
            if (whichSortHelperAscending(arr, 0, 1)) {
                System.out.println("Ascending sorted");
            } else {
                System.out.println("unsorted");
            }
        }
    }

    boolean whichSortHelperAscending(int[] arr, int iToCompare, int iCompareWith) {
        if (iCompareWith > arr.length - 1) return true;

        return (arr[iToCompare] < arr[iCompareWith]) &&
                (whichSortHelperAscending(arr, iToCompare + 1, iCompareWith + 1));
    }

    boolean whichSortHelperDescending(int[] arr, int iToCompare, int iCompareWith) {
        if (iCompareWith > arr.length - 1) return true;

        return (arr[iToCompare] > arr[iCompareWith]) &&
                (whichSortHelperDescending(arr, iToCompare + 1, iCompareWith + 1));
    }



    boolean armstrongCheckerHelper(int n){
        return n == armstrongChecker(n,(int)Math.log10(n)+1,0);
    }
    int armstrongChecker(int n, int digit, int ans) {
        if (n == 0) {
            return ans;
        }
        int r = n % 10;
        ans += (int) Math.pow(r, digit);

        return armstrongChecker(n / 10, digit, ans);
    }

    int fibonacci(int n){
        if(n < 2){
            return 0;
        }
        if(n == 2){
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }


    int power(int iBase , int iExp){
        if(iExp == 0){
            return 1;
        }

        return iBase * power(iBase , iExp - 1);
    }


    void fibonacci(int iFrom, int iTo, int iZeroth, int iFirst, int iStep) {
        if (iStep == iTo) {
            System.out.println(iFirst);
            return;
        }

        if (iStep >= iFrom && iStep < iTo) System.out.println(iFirst);
        fibonacci(iFrom, iTo, iFirst, iZeroth + iFirst, iStep + 1);
    }


    int decimalToBinary(int n){
        if(n == 0){
            return 0;
        }else{
            return n % 2 + (10*decimalToBinary(n/2));
        }
    }

    int minInArray(int n , int[] arr){
        if(n == 0) return arr[0];
        return Math.min(arr[n-1],minInArray(n-1,arr));
    }

    void printPattern(int row , int col ){
        if(row < 0) return;
        if(col == 0){
            System.out.println();
            printPattern(row - 1 , row - 1 );
            return;
        }
        System.out.print("*");
        printPattern(row ,col - 1 );
    }

}
class AdvanceRecursion extends BasicRecursion{
    static class SubsetsAndPermutations{
        void printPermutationNoRepeat(String sProcessed , String sUnprocessed){
            if(sUnprocessed.isEmpty()){
                System.out.println(sProcessed);
                return;
            }

            char cZeroth = sUnprocessed.charAt(0);

            for (int i = 0; i <= sProcessed.length(); i++) {

                String sFirst = sProcessed.substring(0,i);
                String sLast = sProcessed.substring(i);

                printPermutationNoRepeat(sFirst + cZeroth + sLast , sUnprocessed.substring(1));
            }
        }


        int numberOfSubsets(String sProcessed , String sUnprocessed){
            if(sUnprocessed.isEmpty()){
                return 1;
            }

            char cZeroth = sUnprocessed.charAt(0);

            int left = numberOfSubsets(sProcessed+cZeroth , sUnprocessed.substring(1));
            int right = numberOfSubsets(sProcessed , sUnprocessed.substring(1));

            return left + right;
        }

        void printSubsets(String sProcessed , String sUnprocessed){
            if(sUnprocessed.isEmpty()){
                System.out.println(sProcessed);
                return;
            }

            char cZeroth = sUnprocessed.charAt(0);

            printSubsets(sProcessed + cZeroth , sUnprocessed.substring(1));
            printSubsets(sProcessed , sUnprocessed.substring(1));
        }
    }

    static class MatrixAndMazeProblems{
        int noOfPathsTwoDirection(int iRow , int iCol){
            if(iRow == 1 || iCol == 1){
                return 1;
            }

            int left = noOfPathsTwoDirection(iRow-1,iCol);
            int right = noOfPathsTwoDirection(iRow,iCol - 1);

            return left + right;
        }

        void printPathsTwoDirection(String sPath , int iRow , int iCol){
            if(iRow == 1 && iCol == 1){
                System.out.println(sPath);
                return;
            }

            if(iRow > 1)
                printPathsTwoDirection(sPath + "V" , iRow - 1 , iCol);
            if(iCol > 1)
                printPathsTwoDirection(sPath + "H" , iRow  , iCol - 1);

        }

        void printPathsThreeDirection(String sPath, int iRow, int iCol) {
            if (iRow == 1 && iCol == 1) {
                System.out.println(sPath);
                return;
            }

            if (iRow > 1)
                printPathsThreeDirection(sPath + "V", iRow - 1, iCol);
            if (iCol > 1)
                printPathsThreeDirection(sPath + "H", iRow, iCol - 1);
            if (iRow > 1 && iCol > 1)
                printPathsThreeDirection(sPath + "D", iRow - 1, iCol - 1);
        }

        void printPathsThreeDirectionObstacle(String sPath, int iRow, int iCol, boolean[][] obs) {
            if (iRow == obs.length - 1 && iCol == obs[0].length - 1) {
                System.out.println(sPath);
                return;
            }

            if (!obs[iRow][iCol]) return;

            if (iRow < obs.length - 1)
                printPathsThreeDirectionObstacle(sPath + "V", iRow + 1, iCol, obs);
            if (iCol < obs[0].length - 1)
                printPathsThreeDirectionObstacle(sPath + "H", iRow, iCol + 1, obs);
            if (iRow < obs.length - 1 && iCol < obs[0].length - 1)
                printPathsThreeDirectionObstacle(sPath + "D", iRow + 1, iCol + 1, obs);
        }

        void printAllPath(String sPath, int iRow, int iCol, boolean[][] obsAndBacktrack) {
            if (iRow == obsAndBacktrack.length - 1 && iCol == obsAndBacktrack[0].length - 1) {
                System.out.println(sPath);
                return;
            }

            if (!obsAndBacktrack[iRow][iCol]) return;
            obsAndBacktrack[iRow][iCol] = false;

            if (iRow < obsAndBacktrack.length - 1)
                printAllPath(sPath + "D", iRow + 1, iCol, obsAndBacktrack);
            if (iCol < obsAndBacktrack[0].length - 1)
                printAllPath(sPath + "R", iRow, iCol + 1, obsAndBacktrack);
            if (iRow > 0)
                printAllPath(sPath + "U", iRow - 1, iCol, obsAndBacktrack);
            if (iCol > 0)
                printAllPath(sPath + "L", iRow, iCol - 1, obsAndBacktrack);

            obsAndBacktrack[iRow][iCol] = true;
        }


        void printAllPathMatrix(int[][] pathToPrint, int iRow, int iCol, boolean[][] obsAndBacktrack, int step) {
            if (iRow == obsAndBacktrack.length - 1 && iCol == obsAndBacktrack[0].length - 1) {

                pathToPrint[pathToPrint.length - 1][pathToPrint[0].length - 1] = step;

                for (int[] ar : pathToPrint) {
                    System.out.println(Arrays.toString(ar));
                }
                System.out.println();

                return;
            }

            if (!obsAndBacktrack[iRow][iCol]) return;
            obsAndBacktrack[iRow][iCol] = false;
            pathToPrint[iRow][iCol] = step;

            if (iRow < obsAndBacktrack.length - 1)
                printAllPathMatrix(pathToPrint, iRow + 1, iCol, obsAndBacktrack, step + 1);
            if (iCol < obsAndBacktrack[0].length - 1)
                printAllPathMatrix(pathToPrint, iRow, iCol + 1, obsAndBacktrack, step + 1);
            if (iRow > 0)
                printAllPathMatrix(pathToPrint, iRow - 1, iCol, obsAndBacktrack, step + 1);
            if (iCol > 0)
                printAllPathMatrix(pathToPrint, iRow, iCol - 1, obsAndBacktrack, step + 1);

            pathToPrint[iRow][iCol] = 0;
            obsAndBacktrack[iRow][iCol] = true;
        }
    }
}
class Pattern extends AdvanceRecursion{
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
public class JavaSystem{
    public static void main(String[] args) {

    }
}