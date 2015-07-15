package com.pat.te;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class A_plus_B_for_Polynomials {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskF solver = new TaskF();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskF {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n1 = in.nextInt();
        Map<Integer, Float> map_a = new HashMap<Integer, Float>();
        for(int i=0;i<n1;i++){
        	int ex = in.nextInt();
        	float xi_shu = in.nextFloat();
        	map_a.put(ex, xi_shu);
        }
        
        int n2 = in.nextInt();
        Map<Integer, Float> map_b = new HashMap<Integer, Float>();
        for(int i=0;i<n2;i++){
        	int ex = in.nextInt();
        	float xi_shu = in.nextFloat();
        	if(map_a.containsKey(ex)){
        		map_b.put(ex, xi_shu+map_a.get(ex));
        		map_a.remove(ex);
        	}else{
        		map_b.put(ex, xi_shu);	
        	}
        }
        map_b.putAll(map_a);
        
        Object[] key_arr = map_b.keySet().toArray();
        int[] arr = new int[key_arr.length];
        for(int i=0;i<key_arr.length;i++){
        	arr[i] = (int) key_arr[i];
        }
        Arrays.sort(arr);
                
        out.print(arr.length+" ");
        for(int i=arr.length-1;i>0;i--){
        	out.print(arr[i]+" "+map_b.get(arr[i])+" ");
        }
        out.print(arr[0]+" "+map_b.get(arr[0]));
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    
    public float nextFloat() {
        return Float.parseFloat(next());
    }
}