import java.net.URI;
import java.io.InputStream;
import java.io.*;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.conf.*;

public class HadoopWriter
{
	public static void main( String[] args ) throws Exception
	{
		if( args.length == 0 )
		{
			System.out.println("hadoop HadoopWriter uri"); 
			return;
		}

		String uri = args[0];
		Configuration conf = new Configuration();
		OutputStream out = null;
		InputStream in = null;
		try
		{
			FileSystem fs = FileSystem.get( URI.create(uri), conf );
			out = fs.create( new Path( uri ) );
			IOUtils.copyBytes( System.in, out, conf );
			
		}
		finally
		{
			IOUtils.closeStream( out );
		}
	}
}
