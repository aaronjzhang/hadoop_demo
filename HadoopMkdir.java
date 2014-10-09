import java.net.URI;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;

public class HadoopMkdir
{
	public static void main( String[] args ) throws Exception
	{
		if( args.length == 0 )
		{
			System.out.println("hadoop HadoopMkdir uri");
			return;
		}

		String uri = args[0];
		Configuration conf = new Configuration();
		
		FileSystem fs = FileSystem.get( URI.create( uri ), conf );
		fs.mkdirs( new Path(uri) );
	}
}
