import java.util.Scanner;

/**
 * Created by gaurav on 4/13/14.
 */
public class Main {

    private int k;

    private boolean []bitmap ;

    private String inputString;

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()) ;
        while (t-->0)
        {
            String temp = scanner.nextLine() ;
            int n = Integer.parseInt(temp.split("\\s+")[0]);
            int k = Integer.parseInt(temp.split("\\s+")[1]);
            String input = scanner.nextLine();
            new Main(k, input).printLeftOverString();
        }
    }

    Main(int k, String input)
    {
        this.k = k;
        this.inputString = input;
        this.bitmap = new boolean[input.length()];

    }

    public void printLeftOverString()
    {

        int stringLength = this.inputString.length();
        int leftOverTitle = stringLength - this.k;
        int turn = 1;

        // sharry turns

        int leftOnes = 0;
        for(int j = 0 ;j < stringLength && leftOnes < (leftOverTitle+1)/2 ; ++j)
        {
            if(this.inputString.charAt(j) == '1' && !this.bitmap[j]   )
            {
                this.bitmap[j] = true;
                leftOnes++;
            }
        }


        if( leftOnes != ( leftOverTitle + 1)/2 )
        {
//            leftOnes = ( leftOverTitle + 1)/2 - leftOnes;
            for(int j = 0 ;j < stringLength && leftOnes < (leftOverTitle+1)/2 ; ++j)
            {
                if(this.inputString.charAt(j) == '0' && !this.bitmap[j]   )
                {
                    this.bitmap[j] = true;
                    leftOnes++;
                }
            }
        }

        

        // digo turns
        int leftZeros = 0;

        for(int j = 0 ;j < stringLength && leftZeros < (leftOverTitle)/2 ; ++j)
        {
            if(this.inputString.charAt(j) == '0' && !this.bitmap[j] )
            {
                this.bitmap[j] = true;
                leftZeros++;
            }
        }

        if( leftZeros != ( leftOverTitle)/2 )
        {
//            leftZeros = ( leftOverTitle )/2 - leftZeros;
            for(int j = 0 ;j < stringLength && leftZeros < (leftOverTitle)/2 ; ++j)
            {
                if(this.inputString.charAt(j) == '1' && !this.bitmap[j]  )
                {
                    this.bitmap[j] = true;
                    leftZeros++;
                }
            }
        }

        //print left over value
        for(int i = 0;i < stringLength; ++i)
        {
            if(!this.bitmap[i])
                System.out.print(this.inputString.charAt(i));
        }
        System.out.println();

    }




}



