package ap_lab1;
import java.io.IOException;

/**
 *
 * @author Abdul Moeed
 * AP Lab 1
 * main class
 */
public class AP_Lab1 {

    public static void main(String[] args) throws IOException {
        //int [][]A = new int [2][3];
        /*
        Matrix A = new Matrix();
        A.num_rows = 3;
        A.num_cols = 3;
        A.vals = new int[A.num_rows][A.num_cols];
        
        Matrix B = new Matrix();
        B.num_rows = 3;
        B.num_cols = 3;
        B.vals = new int[B.num_rows][B.num_cols];
        
        for (int i=0;i<A.num_rows;i++) {
            for(int j=0; j<A.num_cols; j++) {
                A.vals[i][j] = i;
            }
        }
        for (int i=0;i<B.num_rows;i++) {
            for(int j=0; j<B.num_cols; j++) {
                B.vals[i][j] = i;
            }
        }*/
        test_automated();
        //print the A matrix
        /*
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                System.out.print(A.vals[i][j]+" ");
            System.out.println();
        }
        System.out.println();
        //print the B matrix
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                System.out.print(B.vals[i][j]+" ");
            System.out.println();
        }
        System.out.println();
        */
    }
    
    //starts automated tests
    public static int test_automated() throws IOException{
        unit_test_1();
        unit_test_2();
        unit_test_3();
        return 0;
    }
    
    //test: multiply 2 matrices
    public static void unit_test_1() throws IOException {
        System.out.println("***Unit Test 1***");
        
        //read file data
        Reader fr = new Reader();
        fr.read_file("C://Users//Abdul Moeed//Desktop//unit_test_1.txt"); //data file path
        System.out.println("___File Data___");
        //dump matrix list
        for(int i=0; i<fr.total_lines; i++) {
            System.out.println("Line(Matrix) "+(i+1)+": "+fr.matrices.get(i));
        }
        System.out.println();
        
        //populate matrices by data given in file
        Matrix[] matrix_array = new Matrix[fr.total_lines];
        for(int i=0; i<matrix_array.length; i++) {
            populate_matrix(fr.matrices.get(i), matrix_array, i);
        }
        //call multiplication method
        matrix_multi(matrix_array[0],matrix_array[1]);
    }
    
    //test: add 3 matrices
    public static void unit_test_2() throws IOException {
        System.out.println("\n***Unit Test 2***");
        //read file data
        Reader fr = new Reader();
        fr.read_file("C://Users//Abdul Moeed//Desktop//unit_test_2.txt"); //data file path
        System.out.println("___File Data___");
        for(int i=0; i<fr.total_lines; i++) {
            System.out.println("Line(Matrix) "+(i+1)+": "+fr.matrices.get(i));
        }
        System.out.println();
        
        //populate matrices with file data
        Matrix[] matrix_array = new Matrix[fr.total_lines];
        for(int i=0; i<matrix_array.length; i++) {
            populate_matrix(fr.matrices.get(i), matrix_array, i);
        }
        //operations
        Matrix temp = new Matrix();
        temp = matrix_addition(matrix_array[0],matrix_array[1]);
        matrix_addition(temp,matrix_array[2]);
    }
    
    //test: multiply 2 matrices and add a 3rd to the result
    public static void unit_test_3() throws IOException {
        System.out.println("\n***Unit Test 3***");
        //read file data
        Reader fr = new Reader();
        fr.read_file("C://Users//Abdul Moeed//Desktop//unit_test_3.txt"); //data file path
        System.out.println("___File Data___");
        for(int i=0; i<fr.total_lines; i++) {
            System.out.println("Line(Matrix) "+(i+1)+": "+fr.matrices.get(i));
        }
        System.out.println();
        
        //populate matrices with file data
        Matrix[] matrix_array = new Matrix[fr.total_lines];
        for(int i=0; i<matrix_array.length; i++) {
            populate_matrix(fr.matrices.get(i), matrix_array, i);
        }
        //operations
        Matrix temp = new Matrix();
        temp = matrix_multi(matrix_array[0],matrix_array[1]);
        matrix_addition(temp,matrix_array[2]);
    }
    
    //fills matrices with file data
    public static void populate_matrix(String line, Matrix[] matrix_array, int index) {
        //tokenize string to get matrix
        String[] rows = line.split(";");
        String[] cols = rows[0].split(" ");
        //create matrix with tokenized parameters
        matrix_array[index] = new Matrix();
        matrix_array[index].num_rows = rows.length;
        matrix_array[index].num_cols = cols.length;
        matrix_array[index].vals = new int[matrix_array[index].num_rows][matrix_array[index].num_cols];
        
        //populate matrix with values
        for(int i=0; i<rows.length; i++) {
            cols = rows[i].split(" ");
            for(int j=0; j<cols.length; j++){
                matrix_array[index].vals[i][j] = Integer.parseInt(cols[j]); 
            }
        }
        //dump populated matrix
        System.out.println("Populated Matrix: ");
        for(int i=0; i<rows.length; i++){
            for(int j=0;j<cols.length;j++)
                System.out.print(matrix_array[index].vals[i][j]+" ");
            System.out.println();
        }
    }
    
    //matrix addition
    public static Matrix matrix_addition(Matrix A, Matrix B) {
        System.out.println("\nMATRIX ADDITION");
        
        //handle empty matrix
        if(A.num_rows == -1 || B.num_rows == -1) {
            System.out.println("Error. One of the matrices is empty.");
            Matrix empty = new Matrix();
            empty.num_rows = -1;
            return empty;
        }
        //print 1st matrix
        System.out.println("\n1st Matrix: ");
        for(int i=0;i<A.num_rows;i++)
        {
            for(int j=0;j<A.num_cols;j++)
                System.out.print(A.vals[i][j]+" ");
            System.out.println();
        }
        //print 2nd matrix
        System.out.println("\n2nd Matrix: ");
        for(int i=0;i<B.num_rows;i++)
        {
            for(int j=0;j<B.num_cols;j++)
                System.out.print(B.vals[i][j]+" ");
            System.out.println();
        }
        //handler for order mismatch
        if((A.num_rows != B.num_rows) || (A.num_cols != B.num_cols)){
            System.out.println("Error. Addition not applicable. Order mismatch.");
            Matrix empty = new Matrix();
            empty.num_rows = -1; 
            return empty;
        }
        
        //result matrix
        Matrix sum = new Matrix();
        sum.num_rows = A.num_rows;
        sum.num_cols = A.num_cols;
        sum.vals = new int[sum.num_rows][sum.num_cols];
        
        //addition loop
        for(int i=0; i<A.num_rows; i++) {
            for(int j=0; j<A.num_cols; j++){
                sum.vals[i][j] = A.vals[i][j] + B.vals[i][j];
            }
        }
        //print the addition matrix
        System.out.println("\nSum: ");
        for(int i=0;i<sum.num_rows;i++)
        {
            for(int j=0;j<sum.num_cols;j++)
                System.out.print(sum.vals[i][j]+" ");
            System.out.println();
        }
        return sum;
    }
    
    //matrix subtraction
    public static Matrix matrix_subtraction(Matrix A, Matrix B) {
        
        System.out.println("\nMATRIX SUBTRACTION");
        
        //handle empty matrix
        if(A.num_rows == -1 || B.num_rows == -1) {
            System.out.println("Error. One of the matrices is empty.");
            Matrix empty = new Matrix();
            empty.num_rows = -1;
            return empty;
        }
        //print 1st matrix
        System.out.println("\n1st Matrix: ");
        for(int i=0;i<A.num_rows;i++)
        {
            for(int j=0;j<A.num_cols;j++)
                System.out.print(A.vals[i][j]+" ");
            System.out.println();
        }
        //print 2nd matrix
        System.out.println("\n2nd Matrix: ");
        for(int i=0;i<B.num_rows;i++)
        {
            for(int j=0;j<B.num_cols;j++)
                System.out.print(B.vals[i][j]+" ");
            System.out.println();
        }
        //handler for order mismatch
        if((A.num_rows != B.num_rows) || (A.num_cols != B.num_cols)){
            System.out.println("Error. Subtraction not applicable. Order mismatch.");
            Matrix empty = new Matrix();
            empty.num_rows = -1; 
            return empty;
        }
        //result matrix
        Matrix diff = new Matrix();
        diff.num_rows = A.num_rows;
        diff.num_cols = A.num_cols;
        diff.vals = new int[diff.num_rows][diff.num_cols];
        
        //subtraction loop
        for(int i=0; i<A.num_rows; i++) {
            for(int j=0; j<A.num_cols; j++){
                diff.vals[i][j] = A.vals[i][j] - B.vals[i][j];
            }
        }
        
        //print the difference matrix
        System.out.println("\nDifference: ");
        for(int i=0;i<diff.num_rows;i++)
        {
            for(int j=0;j<diff.num_cols;j++)
                System.out.print(diff.vals[i][j]+" ");
            System.out.println();
        }
        return diff;
    }
    
    //matrix multiplication
    public static Matrix matrix_multi(Matrix A, Matrix B) {
        System.out.println("\nMATRIX MULTIPLICATION");
        
        //handle empty matrix
        if(A.num_rows == -1 || B.num_rows == -1) {
            System.out.println("Error. One of the matrices is empty.");
            Matrix empty = new Matrix();
            empty.num_rows = -1;
            return empty;
        }
        //print 1st matrix
        System.out.println("\n1st Matrix: ");
        for(int i=0;i<A.num_rows;i++)
        {
            for(int j=0;j<A.num_cols;j++)
                System.out.print(A.vals[i][j]+" ");
            System.out.println();
        }
        //print 2nd matrix
        System.out.println("\n2nd Matrix: ");
        for(int i=0;i<B.num_rows;i++)
        {
            for(int j=0;j<B.num_cols;j++)
                System.out.print(B.vals[i][j]+" ");
            System.out.println();
        }
        //handler for order mismatch
        if(A.num_cols != B.num_rows) {
            System.out.println("Error. Multiplication not applicable.");
            System.out.println("Columns of 1st matrix and rows of 2nd matrix must be equal.");
            Matrix empty = new Matrix();
            empty.num_rows = -1;
            return empty;
        }
        //result matrix
        Matrix product = new Matrix();
        product.num_rows = A.num_rows;
        product.num_cols = B.num_cols;
        product.vals = new int[product.num_rows][product.num_cols];
        
        //multiplication loop
        for (int i = 0; i < A.num_rows; i++) {
           for (int j = 0; j < B.num_cols; j++) {
               for (int k = 0; k < A.num_cols; k++) {
                   product.vals[i][j] = product.vals[i][j] + A.vals[i][k] * B.vals[k][j];
               }
           }
       }
        //print the product matrix
        System.out.println("\nProduct: ");
        for(int i=0;i<product.num_rows;i++)
        {
            for(int j=0;j<product.num_cols;j++)
                System.out.print(product.vals[i][j]+" ");
            System.out.println();
        }
        return product;
    }
}
