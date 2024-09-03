import java.util.*;
public class max_Sub {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            int x = input.nextInt();
            arr[i] = x;
        }
        int [] res = new int[3];            //low , high , sum
        res = maxsubarray(arr,0,n-1);
        System.err.println("from pos "+(res[0]+1)+" to "+(res[1]+1)+" and max sum= "+res[2]);
    }
    static int[] maxsubarray(int []arr,int low,int high){
        int[] reslt = new int[3];
        int[] lfreslt = new int[3];
        int[] rgreslt = new int[3];
        int[] crreslt = new int[3];
        if (high == low){
            reslt[0] = low;
            reslt[1] = high;
            reslt[2] = arr[low];
            return reslt;
            }
        else{
            int mid = (low+high)/2;
            lfreslt = maxsubarray(arr, low, mid);
            rgreslt = maxsubarray(arr, mid+1, high);
            crreslt = maxcrosssubarray(arr, low,mid, high);
            if(lfreslt[2]>rgreslt[2] && lfreslt[2]>crreslt[2]){
                return new int[] {lfreslt[0],lfreslt[1],lfreslt[2]};
            }
            else if(rgreslt[2]>lfreslt[2] && rgreslt[2]>crreslt[2]){
                return new int[] {rgreslt[0],rgreslt[1],rgreslt[2]};
            }
            else{
                return new int[] {crreslt[0],crreslt[1],crreslt[2]};
            }
        }
    }
    static int[] maxcrosssubarray(int[] arr,int low,int mid, int high){
        int leftsum = Integer.MIN_VALUE;
        int lsum = 0;
        int maxleft=0;
        int rightsum = Integer.MIN_VALUE;
        int rsum = 0;
        int maxright =0;
        for(int i = mid;i>-1;i--){
            lsum += arr[i];
            if(lsum>leftsum){
                leftsum=lsum;
                maxleft = i;
            }
        }
        for(int j = mid+1;j<high+1;j++){
            rsum += arr[j];
            if(rsum>rightsum){
                rightsum=rsum;
                maxright = j;
            }
        }

        return new int[] {maxleft,maxright,leftsum+rightsum};
    }
}
