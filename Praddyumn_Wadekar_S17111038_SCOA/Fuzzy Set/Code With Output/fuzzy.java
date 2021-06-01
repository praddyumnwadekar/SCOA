import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class fuzzy {
         
	ArrayList acomp=new ArrayList<>();
	ArrayList bcomp=new ArrayList<>();
	
 	void union(ArrayList<Number> al,ArrayList<Number> al1,ArrayList<Number> al3) {
		
		for(int i=0;i<al.size();i++) {
			if(al.get(i).floatValue()>al1.get(i).floatValue()) {
				al3.add(al.get(i));
			}
			else
			    al3.add(al1.get(i));
		}
		
		System.out.println("Union of two Fuzzy Set"+al3);
	    al3.removeAll(al3);
	}

	void intersaction(ArrayList<Number> al,ArrayList<Number> al1,ArrayList<Number> al3) {
		for(int i=0;i<al.size();i++) {
			if(al.get(i).floatValue()<al1.get(i).floatValue()) {
				al3.add(al.get(i));
			}
			else
			    al3.add(al1.get(i));
		}
		
		System.out.println("Intersaction of two Fuzzy Set"+al3);
		al3.removeAll(al3);
	}

	void complement(ArrayList<Number> al,ArrayList<Number> al1,ArrayList<Number> al3) {
		for(int i=0;i<al.size();i++) {
			al3.add((1-al.get(i).floatValue()));
			acomp.add(al3.get(i));
		}
		System.out.println("Complement Of Fuzzy Set A:"+al3);
		al3.removeAll(al3);
		for(int i=0;i<al1.size();i++) {
			al3.add((1-al1.get(i).floatValue()));
			bcomp.add(al3.get(i));
		}
		System.out.println("Complement Of Fuzzy Set B:"+al3);
		al3.removeAll(al3);
	}
	void difference(ArrayList<Number> al,ArrayList<Number> al1,ArrayList<Number> al3) {
		ArrayList<Number> bc=new ArrayList<Number>();
		for(int i=0;i<al1.size();i++) {
			bc.add((1-al1.get(i).floatValue()));
		}
		for(int i=0;i<al.size();i++) {
			if(al.get(i).floatValue()<bc.get(i).floatValue()) {
				al3.add(al.get(i));
			}
			else
			    al3.add(bc.get(i));
		}
		
		System.out.println("Difference of two Fuzzy Set(A-B)"+al3);
		al3.removeAll(al3);
		bc.removeAll(bc);
		
		for(int i=0;i<al.size();i++) {
			bc.add((1-al.get(i).floatValue()));
		}
		for(int i=0;i<al1.size();i++) {
			if(bc.get(i).floatValue()<al1.get(i).floatValue()) {
				al3.add(bc.get(i));
			}
			else
			    al3.add(al1.get(i));
		}
		
		System.out.println("Difference of two Fuzzy Set(B-A)"+al3);
		al3.removeAll(al3);
		bc.removeAll(bc);
	}
	
	void cartesian(ArrayList<Number> al,ArrayList<Number> al1) {
		
	   double arr[][];
	   
	   arr=new double[al.size()][al.size()];
		for(int i=0;i<al.size();i++) {
			for(int j=0;j<al1.size();j++) {
				if(al.get(i).floatValue()<al1.get(j).floatValue()) {
					arr[i][j]=al.get(i).floatValue();
				}
				else
					arr[i][j]=al1.get(j).floatValue();
			}
		}
		System.out.println("Cartesian Product :");
		for(int i=0;i<al.size();i++) {
			for(int j=0;j<al.size();j++) {
				System.out.print(arr[i][j]+"   ");
			}
			System.out.println();
		}
	}
	
	void max_min(ArrayList<Number> al,ArrayList<Number> al1) {
		double r1[][];
		   
		   r1=new double[al.size()/2][al.size()/2];
		   double r2[][];
		   r2=new double[al.size()/2][al.size()/2];
		   double res[][];
		   res=new double[al.size()/2][al.size()/2];
		   int p=0;
		   for(int i=0;i<al.size()/2;i++) {
			   for(int j=0;j<al.size()/2;j++) {
				   r1[i][j]=al.get(p).floatValue();
				   r2[i][j]=al1.get(p).floatValue();
				   p++;
			   }
		   }
		   System.out.println("R1:");
		   for(int i=0;i<al.size()/2;i++) {
			   for(int j=0;j<al.size()/2;j++) {
				   System.out.print(r1[i][j]+"  ");
			   }
			   System.out.println();
		   }
		   System.out.println("\nR2:");
		   for(int i=0;i<al.size()/2;i++) {
			   for(int j=0;j<al.size()/2;j++) {
				   System.out.print(r2[i][j]+"  ");
			   }
			   System.out.println();
		   }
		   double temp[];
		   
		   
		   temp=new double[al.size()/2];
		   for(int i=0;i<al.size()/2;i++) {
			   
			   for(int j=0;j<al.size()/2;j++) {
				   int q=0;
				   for(int h=0;h<al.size()/2;h++) {
					   if(r1[i][h]<r2[h][j]) {
						   temp[q]=r1[i][h];
						   q++;
					   }
					   else {
						   temp[q]=r2[h][j];
						   q++;
					   }   
				   }
				   
				   double max=0;
				   for(int k=0;k<al.size()/2;k++) {
					   //double max=temp[k];
					   if(max<temp[k]) {
						   max=temp[k];
					   }
					   
				   }
				   res[i][j]=max;
			   }
			  
			   
		   }
		   System.out.println("\nMAX MIN Relation");
		   for(int i=0;i<al.size()/2;i++) {
			   for(int j=0;j<al.size()/2;j++) {
				   System.out.print(res[i][j]+"  ");
			   }
			   System.out.println();
		   }
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("Enter the No. of elements:");
		n=sc.nextInt();
		
		ArrayList<Number> al=new ArrayList<Number>();
		ArrayList<Number> al1=new ArrayList<Number>();
		ArrayList<Number> al3=new ArrayList<Number>();
		
		while(n>0) {
		al.add(Math.random()*1);
		al1.add(Math.random()*1);
		n--;
		}

		//al.add(0.5);
		//al.add(0.7);
		//al.add(0);
		
	//	al1.add(0.8);
		//al1.add(0.2);
		//al1.add(1);
		
		fuzzy f=new fuzzy();
		System.out.println("Fuzzy Set A:"+al);
		System.out.println("Fuzzy Set B:"+al1);
		System.out.println("\n");
		f.union(al, al1, al3);
		System.out.println("\n");
		f.intersaction(al, al1, al3);
		System.out.println("\n");
		f.complement(al, al1, al3);
		System.out.println("\n");
		f.difference(al, al1, al3);
		System.out.println("\n");
		f.cartesian(al, al1);
		System.out.println("\n");
		f.max_min(al, al1);
		
		//System.out.println("A Complement"+f.acomp);
		//System.out.println("B Complement"+f.bcomp);

	}

}
