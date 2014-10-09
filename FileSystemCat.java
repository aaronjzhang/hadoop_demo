import java.net.URI;
import java.io.InputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.conf.*;

public class FileSystemCat
{
	public static void main( String[] args ) throws Exception
	{
		if( args.length == 0 )
		{
			System.out.println("hadoop FileSystemCat uri"); 
			return;
		}
		String uri = args[0];
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get( URI.create(uri), conf );

		InputStream in = null;
		try{
			in = fs.open( new Path(uri) );
			IOUtils.copyBytes( in, System.out, 4096, false );
		}
		finally
		{
			IOUtils.closeStream( in );
		}
	}
}
