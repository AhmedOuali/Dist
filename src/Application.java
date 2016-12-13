import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

//---------------------------------------------------------------------------
//------------Avoir l'adresse Local du client -------------------------------
//---------------------------------------------------------------------------
	
	public String getlocalip(){
		String ip="0 . 0 . 0 . 0";
		try {
			ip = InetAddress.getLocalHost().getHostAddress().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ip;
	}
//-----------------------------------------------------------------------------	
// ----------------Avoir l'adresse Public du client----------------------------
//-----------------------------------------------------------------------------
	
	public String getpublicip() {
		URL url;
		String line="0 . 0 . 0 . 0";
		try {
			url = new URL("http://yveran.ephian.net/test/ipaddress.php");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			InputStreamReader isr = new InputStreamReader(con.getInputStream());
			BufferedReader rd = new BufferedReader(isr);

			line = rd.readLine();
			rd.close();
		} catch (Exception e) {
		}
		return line;
	}
}
