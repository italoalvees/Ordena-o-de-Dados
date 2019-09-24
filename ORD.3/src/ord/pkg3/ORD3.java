package ord.pkg3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class ORD3 {

    static public int[] countSort(int[] A, int[] B, int max , int min){
        
        if(min < 0){
            for(int i = 0 ; i < A.length ; i++){
                A[i] -= min;
                if(max < A[i]){
                    max = A[i];
                }
            }
        }
        
        int[] C = new int[max+1]; 
        
        for(int i = 0; i <= max ; i++){
            C[i] = 0;
        }
        
        for(int j = 0 ; j < A.length ; j++){
            C[A[j]]++;
        }
        
        for(int i = 1; i <= max ; i++){
            C[i] += C[i-1];
        }
        
        for(int j = A.length-1 ; j >= 0 ; j--){
            B[C[A[j]]-1] = A[j];
            C[A[j]]--;
        }
        
        if(min < 0){
            for(int i = 0 ; i < B.length ; i++){
                B[i]+= min;
            }
        }
        
        return B;
    }
    
    static public int[] radixSort(int[] A, int[] B, int max, int min){
        
        if(min < 0){
            for(int i = 0 ; i < A.length ; i++){
                A[i]+= min*-1;
            }
        }
        
        int p = 1;
        
        int x;
        
        while((max/p) > 0){
            int C[] = new int[10];
            
            for(int i = 0; i < C.length ; i++){
                C[i] = 0;
            }

            for(int j = 0 ; j < A.length ; j++){

                x = (A[j]/p)%10;
                C[x]++;
                
              }

            for(int i = 1; i < C.length ; i++){
                C[i] += C[i-1];
            }
            
            
            
            for(int j = A.length-1 ; j >= 0 ; j--){
                x = (A[j]/p)%10;
                
                B[C[x]-1] = A[j];
                
                C[x]--;
                
            }   
            
            p *=10;
            A = B.clone();
            
        }
        
        if(min < 0){
            for(int i = 0 ; i < B.length ; i++){
                B[i]+= min;
            }
        }
        
        return B;
    }
    
    static public int[] max(int[] A){
        int[] F = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < A.length ; i++){
            if(A[i] > max){
                max = A[i];
            }
            if(A[i] < min){
                min = A[i];
            }
        }
        F[0] = max;
        F[1] = min;
        return F;
    }
    
    static public int[] leitor(String nome){
        try {
      FileReader arq = new FileReader(nome);
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); 
      int[] A = new int[Integer.parseInt(linha)];
      int i = 0;  
         
      while (linha != null) {
 
        linha = lerArq.readLine(); // lê da segunda até a última linha
        if(linha != null){
            A[i++] = Integer.parseInt(linha);
        }
      }
 
      arq.close();
    
        return A;
        
        } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
          int[] A = {0};
        return A;
    }
                
        }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] A = leitor("num.100000.2.in");
        int[] B = new int[A.length];
        int max = max(A)[0];
        int min = max(A)[1];
        int[] A1 = A.clone();
        int[] B1 = B.clone();
        long tempo;
        
        long start = System.currentTimeMillis();
        int[] C = radixSort(A,B,max,min);
        long end = System.currentTimeMillis();
        
        System.out.print("Radix Sort:\n");
        for(int i = 0 ; i < C.length ; i++){
            System.out.print(C[i]+" ");
        }
        tempo = (end - start);
        System.out.print("\ntempo:"+tempo+"\n");
       
        start = System.currentTimeMillis();
        C = countSort(A1,B1,max,min);
        end = System.currentTimeMillis();
        
        
        System.out.print("Count Sort:\n");
        for(int i = 0 ; i < C.length ; i++){
            System.out.print(C[i]+" ");
        }
        
        tempo = (end - start);
        System.out.print("\ntempo:"+tempo+"\n");
    }
    
}
