
public class hebb {

	static int w1,w2,b1;
	static int calculate(int x1,int y) {
		
		w1=w1+(x1*y);
		return w1;
		
	}
static int calculate1(int x2,int y) {
		
		w2=w2+(x2*y);
		return w2;
		
	}
static int calculate2(int b,int y) {
	
	b1=b1+y;
	return b1;
	
}
static void equation(int w1,int w2,int b) {
	
	System.out.println("y="+(-w1/w2)+"x+("+(-b/w2)+")");
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int w1[],w2[],b1[];
		int x1[]= {1,1,-1,-1};
		int x2[]= {1,-1,1,-1};
		int b[]= {1,1,1,1};
		int y[]= {1,-1,-1,-1};
		w1=new int[4];
		w2=new int[4];
		b1=new int[4];
		
		for(int i=0;i<4;i++) {
		w1[i]=calculate(x1[i],y[i]);
		w2[i]=calculate1(x2[i],y[i]);
		b1[i]=calculate2(b[i],y[i]);
		}
		System.out.println("w1 w2 b  ");
		for(int i=0;i<4;i++) {
			System.out.println(w1[i]+"  "+w2[i]+"  "+b1[i]+"  ");
		}
		System.out.println("Equation of lines");
		for(int i=0;i<4;i++) {
			equation(w1[i],w2[i],b1[i]);
		}

	}

}
