import java.util.*;

public class knapsack{
  public static void main(String[] args) throws InterruptedException{
   Scanner input = new Scanner(System.in);
   System.out.println("no. of items");
   int n = input.nextInt();
   System.out.println("total sack weight");
   int SackWeight = input.nextInt();
   Storage []objarr = new Storage[n];
   for(int i = 0;i<n;i++){
    System.out.println("weight for sack"+(i+1));
    int wt = input.nextInt();
    System.out.println("profit for sack"+(i+1));
    int profit = input.nextInt();
    float ratio = (float)profit/ wt;
    objarr[i]  = new Storage(i,wt,ratio);
   }
   Storage [] desc_objarr = Storage.sorting(objarr);
   
   float []arr = new float[n];
   for(int i=0;i<n;i++){
    arr[i] = 0;
   }
   int Weight_used = 0;
   float max_profit = 0F;
   
   for(Storage s: desc_objarr){
    
    if(s.weight+Weight_used<= SackWeight){
     arr[s.id]=1;
     Weight_used = Weight_used+s.weight;
     max_profit = max_profit+ (s.ratio*s.weight);  //profit = ratio*weight
     
    }
    else{
     float frac = (float)(SackWeight-Weight_used)/s.weight;
     arr[s.id]=frac;
     Weight_used = SackWeight;
     max_profit = max_profit+(frac*( s.ratio*s.weight));
     break;
    }
   }
   for(int i=0;i<n;i++){
    System.out.printf("%f, ",arr[i]);
   }
   System.out.println();
   System.out.println(max_profit);

  
  }
 }

 class Storage implements Comparable<Storage>{
  public float ratio;
  int id;
  int weight;
  public Storage(int id,int weight,float ratio){
    this.weight=weight;
    this.id=id;
    this.ratio=ratio;
  }
  public int compareTo(Storage temp){
    return Float.compare(temp.ratio, this.ratio);
  }
  static Storage[] sorting(Storage[] s){
    Arrays.sort(s);
   return s;
  }
 }
