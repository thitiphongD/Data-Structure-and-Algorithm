import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class IntervalUnion{
    class Interval implements Comparable<Interval>{
        private final int left;
        private final int right;
        Interval(int left,int right){
            this.left = left;
            this.right = right;
        }
        public int getRight(){
          return this.right;
        }
        public int getLeft(){
          return this.left; 
        }
        @Override
        public int compareTo(Interval interval){
            if(this.left > interval.left){
              return 1; 
            }else if(this.left < interval.left){
              return -1;    
            }else{
              return 0;
            }
        }
        @Override
        public String toString(){
         return "("+this.left+","+this.right+")";
        }
    }   
    
  
    public List<Interval> getUnion(List<Interval> intervals){
        Collections.sort(intervals);
        List<Interval> union = new ArrayList<Interval>();
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(Interval i:intervals){
            int currentRight = i.getRight();
            int currentLeft = i.getLeft();
            if(currentLeft <= right && currentRight > right){
              right = currentRight;
            }
            if(currentLeft < left && currentRight >= right){
              left = currentLeft;
              right = currentRight; 
            }
            if(currentLeft > right){
              union.add(new Interval(left,right));
              left = currentLeft;
              right = currentRight;
            }
        }
        union.add(new Interval(left,right));
        return union;
    }
   public List<Interval> removeInterval(List<Interval> intervals, int[] toBeRemoved) {
      // intervals = getUnion(intervals) ;
        Collections.sort(intervals);
         List<Interval> removex = new ArrayList<Interval>();
         for(Interval i:intervals){
            if (i.getRight() <= toBeRemoved[0] || i.getLeft() >= toBeRemoved[1]) {
                removex.add(new Interval(i.getLeft(), i.getRight()));
            } else {
                if (i.getLeft() < toBeRemoved[0]) removex.add(new Interval(i.getLeft(), toBeRemoved[0]-1));
                if (i.getRight() > toBeRemoved[1]) removex.add(new Interval(toBeRemoved[1]+1, i.getRight()));
            }
        }
        return removex;
    }
  
    
    
      
    
   
    public static void main(String[] args){
      System.out.println("Testing out the union");
      IntervalUnion intervalUnion = new IntervalUnion();  
      IntervalUnion.Interval i1 = intervalUnion.new Interval(1,7);
      IntervalUnion.Interval i2 = intervalUnion.new Interval(10,20);
      IntervalUnion.Interval i3 = intervalUnion.new Interval(25,100);
      IntervalUnion.Interval i4 = intervalUnion.new Interval(7,12);
      IntervalUnion.Interval i5 = intervalUnion.new Interval(20,25);

      
 System.out.println("=============Start Input data========================");
       List<IntervalUnion.Interval> sample = new ArrayList<IntervalUnion.Interval>()
                    {{
                      add(i1);
                      add(i2);
                      add(i3);
                    }};
        sample = intervalUnion.getUnion(sample) ;
  for (IntervalUnion.Interval i:intervalUnion.getUnion(sample)){
        System.out.println(i);
  }
 System.out.println("=============END Inout data========================");


        
      List<IntervalUnion.Interval> finaldata = new ArrayList<IntervalUnion.Interval>() ;
      IntervalUnion intervalremove = new IntervalUnion();  
      IntervalUnion.Interval j1 = intervalremove.new Interval(2,5);
      IntervalUnion.Interval j2 = intervalremove.new Interval(11,21);
      IntervalUnion.Interval j3 = intervalremove.new Interval(30,50);
         List<IntervalUnion.Interval> removeable = new ArrayList<IntervalUnion.Interval>()
                 {{
                      add(j1);
                      add(j2);
                      add(j3);
                    }};
      
        System.out.println("=============Start negative data========================");
         removeable = intervalUnion.getUnion(removeable) ;
         for (IntervalUnion.Interval i:intervalUnion.getUnion(removeable)){
        System.out.println(i);
  }
          System.out.println("=============END negative data========================");
         
         
        
        
         int[] remove = {2,5} ;
         int[] removeb = {11,21} ;
         int[] removec = {30,50} ;
         
            finaldata = intervalUnion.removeInterval(sample,remove) ;
            finaldata = intervalUnion.removeInterval(finaldata,removeb) ;
            finaldata = intervalUnion.removeInterval(finaldata,removec) ;         
       
        
         
System.out.println("=============Start result data========================");
            
         for (IntervalUnion.Interval i:finaldata){
          System.out.println(i);
        }

System.out.println("=============End result data========================");


        System.out.println("=============Start Show all data========================");
        ArrayList<Integer> Arrayfirst = new ArrayList<Integer>();
         for (IntervalUnion.Interval i:intervalUnion.getUnion(finaldata)){
            int currentRight = i.getRight();
            int currentLeft  = i.getLeft() ;
            for(int ia = currentLeft ; ia <= currentRight ; ia++){
                 
                  Arrayfirst.add(ia);
            }
           }
         
          
          System.out.print(Arrayfirst);
          System.out.println("=============End Show All data========================");
 }
}
