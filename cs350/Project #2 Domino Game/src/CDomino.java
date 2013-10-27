import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class CDomino {
	
	private int[][] topMatrix;
	private int[][] botMatrix;
	private double[] Xs;
	private double[] Ys;
	private int Type;
	private int RotateState;
	
	public CDomino(int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3,int topDots, int botDots) {
		Type = 4;
		RotateState = 3;
		Xs=new double[4];
		Ys=new double[4];
		Xs[0]=x0; Ys[0]=y0;
		Xs[1]=x1; Ys[1]=y1;
		Xs[2]=x2; Ys[2]=y2;
		Xs[3]=x3; Ys[3]=y3;
		
		topMatrix = new int[3][1];
		botMatrix = new int[3][1];
		
		///Use a 3x3 matrix to store dot values.
		int[][][] spotMatrix = {
			{{0,0,0},{0,0,0},{0,0,0}}, //blank
			{{0,0,0},{0,1,0},{0,0,0}}, //1
			{{1,0,0},{0,0,0},{0,0,1}}, //2
			{{1,0,0},{0,1,0},{0,0,1}}, //3
			{{1,0,1},{0,0,0},{1,0,1}}, //4
			{{1,0,1},{0,1,0},{1,0,1}}, //5
			{{1,0,1},{1,0,1},{1,0,1}}, //6
		};
		
		switch(topDots) {
			case 0: topMatrix = spotMatrix[0];
				break;
			case 1: topMatrix = spotMatrix[1];
				break;
			case 2: topMatrix = spotMatrix[2];
				break;
			case 3: topMatrix = spotMatrix[3];
				break;
			case 4: topMatrix = spotMatrix[4];
				break;
			case 5: topMatrix = spotMatrix[5];
				break;
			case 6: topMatrix = spotMatrix[6];
				break;
		}
		
		switch(botDots) {
		case 0: botMatrix = spotMatrix[0];
			break;
		case 1: botMatrix = spotMatrix[1];
			break;
		case 2: botMatrix = spotMatrix[2];
			break;
		case 3: botMatrix = spotMatrix[3];
			break;
		case 4: botMatrix = spotMatrix[4];
			break;
		case 5: botMatrix = spotMatrix[5];
			break;
		case 6: botMatrix = spotMatrix[6];
			break;
		}
		
		
	}

	private boolean isLeft(int x, int y, int id) {	// Is Point (x, y) located to the left when walking from id to id+1?
		return (y-Ys[id])*(Xs[(id+1)%Type]-Xs[id])<(x-Xs[id])*(Ys[(id+1)%Type]-Ys[id]);	// note difference btw coordinate systems 
	}

	public boolean isInside(int x, int y) {
		for (int i=0; i<Type; i++) {
			if (!isLeft(x, y, i)) return false;
		}

		return true;
	}

	public void translate(int dx, int dy) {
		for (int i=0; i<Type; i++) {
			Xs[i] += dx;
			Ys[i] += dy;
		}
	}

	public void rotate(int deg) {
		double theta = Math.PI/180*deg;	// in radians
		switch(RotateState){
			case 3: RotateState = 0;
				break;
			case 0: RotateState = 1;
				break;
			case 1: RotateState = 2;
				break;
			case 2: RotateState = 3;
				break;
		}
	
		for (int i=1; i<Type; i++) {
			double tmp_x;
			tmp_x = Xs[0] + (Xs[i] - Xs[0]) * Math.cos(theta) - (Ys[i] - Ys[0]) * Math.sin(theta);
			Ys[i] = Ys[0] + (Xs[i] - Xs[0]) * Math.sin(theta) + (Ys[i] - Ys[0]) * Math.cos(theta);
			Xs[i] = tmp_x;
		}
	}

	public void draw(Graphics g) {
		Polygon p = new Polygon();
		for (int i=0; i<Type; i++) {
			p.addPoint((int)(Xs[i]+0.5), (int)(Ys[i]+0.5));
		}

		g.setColor(Color.gray);
		g.fillPolygon(p);
		g.setColor(Color.blue);
		g.drawPolygon(p);
		g.setColor(Color.red);
		
		//Draw top half
		Polygon c = new Polygon();
		for (int i=0; i<2; i++) {
			for(int[] row : topMatrix){ 	//rows
				for(int cell : row){		//cells
					switch(RotateState) {
						case 0:
							
							g.drawLine((int)Xs[RotateState]+55,(int)Ys[RotateState],(int)Xs[RotateState]+55,(int)Ys[RotateState]+50);
							break;
						case 1:
							
							g.drawLine((int)Xs[RotateState],(int)Ys[RotateState]+50,(int)Xs[RotateState]+50,(int)Ys[RotateState]+50);
							break;
						case 2:
							
							g.drawLine((int)Xs[RotateState]+50,(int)Ys[RotateState]+50,(int)Xs[RotateState]+50,(int)Ys[RotateState]);
							break;
						case 3:
							
							g.drawLine((int)Xs[RotateState],(int)Ys[RotateState]+50,(int)Xs[RotateState]+50,(int)Ys[RotateState]+50);
							break;
						//0->1 1->2 2->3 3->0
						// 3  _____  2
						//   |	   |
						//   |     |
						//   |     |
						// 0  -----  1
						//
					};
				}
			}
		}

	}
}