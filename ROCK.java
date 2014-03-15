import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: gaurav
 * Date: 3/14/14
 * Time: 7:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static final int STRING_MAX_SIZE = 201;

    private int[][] indexesMapping = null;

    private int[][] memoizedVals = null;

    private boolean memoizedInitialised = false;

    private String input;

    private int maxValue = 0;

    public static void main(String [] args)
    {
        int t;
        Scanner scanner = new Scanner( System.in );
        String temp1 = scanner.nextLine();
        t = Integer.parseInt(temp1);
        while(t-- > 0)
        {
            int len = Integer.parseInt(scanner.nextLine()) ;
            String input = scanner.nextLine();
            int length = new Main( input ).calculateMaximumLength();
            System.out.println( length );
        }

    }

    public Main( String str )
    {
        this.input = str;

        // initialise 2d mapping
        initialiseMapping();

        // create 2D matrix using this string
        load2DMapping();



    }

    private void initialiseMapping()
    {
        this.indexesMapping = new int[STRING_MAX_SIZE][STRING_MAX_SIZE];
        for(int i = 0;i < STRING_MAX_SIZE; ++i)
        {
            for(int j = 0;j < STRING_MAX_SIZE; ++j)
                this.indexesMapping[i][j] = 0;
        }

        if( !memoizedInitialised )
        {
            memoizedVals = new int[STRING_MAX_SIZE][STRING_MAX_SIZE];
            for(int i = 0;i < STRING_MAX_SIZE; ++i)
            {
                for(int j = 0;j < STRING_MAX_SIZE; ++j)
                    this.memoizedVals[i][j] = -1;
            }
            memoizedInitialised = true;
        }

    }

    public void load2DMapping()
    {
        for(int i = 0;i < this.input.length(); ++i)
        {
//             starting with value i
            int oneCount = 0;
            int zeroCount = 0;
            for(int j = i;j < this.input.length(); ++j)
            {
                if( this.input.charAt(j) == '0' )
                    zeroCount++;
                else if( this.input.charAt(j) == '1' )
                    oneCount++;

                if( oneCount > zeroCount )
                    this.indexesMapping[i][j] = 1;
            }
        }

    }

    public int calculateMaximumLength()
    {
        return calculateMaximumLength(0, this.input.length());
    }

    private int calculateMaximumLength(int start, int end)
    {
        if( memoizedVals[start][end] != -1 )
            return memoizedVals[start][end];


        if( start > end )
            return 0;
        if( start > this.input.length() || end > this.input.length() )
            return 0;

        if( start < 0 || end < 0 )
            return 0;

        if( start == end )
        {
            if( this.indexesMapping[start][end] == 1 )
                return 1;
            return 0;
        }

        int max = 0;
        for(int i = start; i < end; ++i)
        {

            for(int j = i; j < end; ++j)
            {
                int length = 0;
                if( this.indexesMapping[i][j] == 1 )
                {
                    length = length + (j- i + 1);
                    if( start < i-1 )
                        length = length + ( memoizedVals[start][i-1] = calculateMaximumLength( start, i-1 ) );
                    if( end < j + 1 )
                        length = length + (  memoizedVals[j+1][end] = calculateMaximumLength(j+1, end) );
                }
                if(max < length)
                    max = length;

            }


        }
        return max;

    }


}

