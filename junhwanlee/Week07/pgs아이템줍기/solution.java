import java.util.*;
class Solution {
    static int[] xx={0,0,-1,1};
    static int[] yy={-1,1,0,0};
    static int[][] map=new int[101][101];
    public int solution(int[][] rectangle, int X, int Y, int itemX, int itemY) {
        for(int i=0;i<rectangle.length;i++){
            make(rectangle[i][0]*2, rectangle[i][1]*2,rectangle[i][2]*2,rectangle[i][3]*2);
        }
        return bfs(Y*2,X*2,itemY*2,itemX*2);   
    }
    public static int bfs(int Y,int X,int iY,int iX){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[] {Y,X,0});
        boolean[][] visited=new boolean[101][101];
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            int pY=temp[0];
            int pX=temp[1];
            int count=temp[2];
            if(pY==iY&&pX==iX)
                return count/2;
            for(int i=0;i<4;i++){
                int nY= pY+yy[i];
                int nX= pX+xx[i];
                if(nY<0||nX<0||nY>=map.length||nX>=map[0].length)
                    continue;
                if(visited[nY][nX]==true||map[nY][nX]!= 1)
                    continue;
                
                visited[nY][nX]=true;
                queue.add(new int[] {nY,nX,count+1});
              
            }
        }
        
        return 0;
    }
    public static void make(int x1,int y1,int x2,int y2){
        for(int i=y1;i<=y2;i++){
            for(int j=x1;j<=x2;j++){
            	if(map[i][j]== -1 ) continue;
                map[i][j]= -1;
                if(i==y1||i==y2||j==x1||j==x2)
                    map[i][j]= 1;
            }
        }
        
    }
}
