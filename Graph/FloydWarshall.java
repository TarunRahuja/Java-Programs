package Graph;
public class FloydWarshall {
	static int inf = 999999;
	public static void main(String[] args) {
	int [][] graph = {{0,0,0,0,0},{0,0,3,inf,7},{0,8,0,2,inf},{0,5,inf,0,1},{0,2,inf,inf,0}};
	int [][]old = graph;
	int [][] newadj = new int[5][5];
	for(int k=1; k<5; k++) {
		for(int i=1; i<5; i++) {
			for(int j=1; j<5; j++) {
				if(i==k||j==k) {
					newadj[i][j] = old[i][j];
					continue;
				}
				if(old[i][j]>old[i][k]+old[k][j]) {
					newadj[i][j] = old[i][k]+old[k][j];
				}
				else {
					newadj[i][j] = old[i][j];
				}
			}
		}
		old = newadj;
		newadj = new int[5][5];
	}
	for(int i=1; i<old.length; i++) {
		for(int j=1; j<old.length; j++) {
			System.out.print(old[i][j]+" ");
		}
		System.out.println();
	}
}

}
