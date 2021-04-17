package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Tower {

	private int[] towers;
	private int disk;
	public static final int TOWER = 3;
	public static final int TOWER_1 = 0;
	public static final int TOWER_2 = 1;
	public static final int TOWER_3 = 2;
	
	public Tower(int n) {
		towers = new int [TOWER];
		disk = n;
		towers[TOWER_1]=n;
		towers[TOWER_2]=0;
		towers[TOWER_3]=0;
	}
	
	public void hanoi(int n) {
		hanoi(n,n,0,0);
	}
	public void hanoi(int k, int start, int end, int middle) {
		if(k==1) {
			System.out.println((start-1)+" "+middle+" "+end);
			return;
		}else {
			System.out.println(start+" "+middle+" "+end);
			hanoi(k-1,start,end+1,((middle>=1) ? middle-1 : middle));
			if(start >=1) {
				hanoi(k-1,start-1,end,middle+1);
			}if(middle >=1) {
				hanoi(k-1,start,end+1,middle-1);
			}if(end>=1) {
				hanoi(k-1,start+1,end-1,middle);
			}
		}
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de discos");
		int n = sc.nextInt();sc.nextLine();
		Tower tw = new Tower(n);
		tw.hanoi(n);
		
	}
	
	
	public String leerTxt(String direction) {
		
		String texto = "";
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(direction));
			String temp = "";
			String bfRead;
			
			while((bfRead = bf.readLine()) != null) {
				temp = temp + bfRead;
			}
			
			texto = temp;
		}catch(Exception e){
			System.err.println("No se encontro archivo");
		}
		return texto;
		
	}
	
}
