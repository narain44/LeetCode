package TreesFloodFill;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FloodFill {
    public static void main(String[] args){
        FloodFill instance=new FloodFill();
        int[][] image=new int[][]{
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        System.out.println(Arrays.deepToString(image));
        instance.floodFill(image,1,1,2);
        System.out.println(Arrays.deepToString(image));
    }

    int[] dr=new int[]{1,-1,0,0};
    int[] dc=new int[] {0,0,1,-1};
    Set<String> visited=new HashSet<String>();
    public int[][] floodFill(int[][] image, int r, int c, int newColor){
        int currentColor=image[r][c];
        image[r][c]=newColor;
        visited.add(r+""+c);
        int R=image.length;
        int C=image[0].length;
        for(int di=0;di<4;di++){
            int nr=r+dr[di];
            int nc=c+dc[di];
            if(0<= nr && nr<R && 0<=nc && nc<C&&image[nr][nc]==currentColor&& !visited.contains(nr+""+nc)){
                floodFill(image,nr,nc,newColor);
            }
        }
        return image;
    }
}
