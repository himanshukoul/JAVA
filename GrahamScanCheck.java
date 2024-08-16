import java.util.*;
public class GrahamScanCheck {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Points[] pts = new Points[n];
        for(int i=0;i<n;i++){
            int x = input.nextInt();
            int y = input.nextInt();
            pts[i] = new Points(x,y);
        }
        Arrays.sort(pts);
        Points p0 = pts[0];
        System.out.println("Sorted points");
        for(int i=0;i<n;i++){
            System.out.println(pts[i].x + " "+ pts[i].y);
        }
        System.out.println("Sorted Polar angles wrt p0");
        Arrays.sort(pts,1,n,new PolarCompar(p0));  
        for(int i=0;i<n;i++){
            System.out.println(pts[i].x + " "+ pts[i].y);
        }
        Stack<Points> stk = new Stack<>();
        stk.push(p0);
        stk.push(pts[1]);
        stk.push(pts[2]);
        for(int i=3; i<n;i++){
            while(PolarCompar.ccw(stk.get(stk.size()-2),stk.peek(),pts[i])<=0){
                stk.pop();
            }
            stk.push(pts[i]);
        }
        System.out.println("Convex Hull points:");
        for (Points p : stk) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
class PolarCompar implements Comparator<Points> {
    Points p0;
    PolarCompar(Points p0) {
        this.p0 = p0;
    }
    public static int ccw(Points p0,Points p1,Points p2) {
        double cross = (p1.x-p0.x)*(p2.y-p0.y) - (p1.y-p0.y)*(p2.x-p0.x);
        if (cross < 0)
            return -1;
        else if (cross > 0)
            return 1;
        else
            return 0;
    }
    public int compare(Points p1, Points p2) {
        int cr = ccw(p0, p1, p2);
        if(cr==0){
            double dist1 = Math.pow(p1.x-p0.x, 2) + Math.pow(p1.y-p0.y, 2);
            double dist2 = Math.pow(p2.x-p0.x, 2) + Math.pow(p2.y-p0.y, 2);
            if(dist1>dist2){
                return 1;
            }
            return -1;
            }
        return -cr;
    }
}
class Points implements Comparable<Points>{
    int x;
    int y;
    Points(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(Points temp){
        if(this.y>temp.y){
            return 1;
        }
        if(this.y<temp.y){
            return -1;
        }
        if(this.x>temp.x){
            return 1;
        }
        return -1;
    }
}
