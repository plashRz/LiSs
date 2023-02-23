
public class LiSs {

    public static void main(String[] args) {
        //input
        int arr[] = {10, -2, -9, 0, 13, -50, 81, 90};
        int seq = 1;

        System.out.println("Input array: ");
        for(int q : arr){
            System.out.print(q+"\t");
        }
        System.out.println();

        //seq fn calls actual logic and returns the seq number
        seq = tryIt(arr, seq);

        System.out.println("=====> LIS: " + seq);


    }

    private static int tryIt(int[] arr, int seq) {

        //an array to store the LIS sequence
        int[] temp = new int[arr.length];
        //length for ease of use
        int l = arr.length;
        //a seq value to return and compare
        int biggerSeq = 0;
        //to track elements of an instance array, which we will use to compare
        int n = 0;

        //outer loop for addressing all elements
        for (int k = 0; k < l; k++) {
            //this array will get reset each iteration
            int[] ar = new int[arr.length];
            ar[n] = arr[k];
            //inner loop for computing greater number each iteration and adding it to our instance array
            for (int i = k; i < l; i++) {
                if (ar[n] < arr[i]) {
                    ar[n + 1] = arr[i];
                    seq++;
                    n++;
                }
            }
            //resetting its counter/index for next iteration
            n = 0;

            //solution
            if (biggerSeq < seq) {
                //updating the longest seq value if found
                biggerSeq = seq;
                //also storing that instance arrays values if we want to display it at the end.
                temp = ar;
            }
            //now re-setting seq for next iteration
            seq = 1;
        }

        //display LIS
        for (int x : temp) {
            System.out.print(x+"\t");
        }
        return biggerSeq;
    }
}
