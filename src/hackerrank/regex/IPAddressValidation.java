package hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidation {

	public static void main(String[] args)  throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int numberOfLines = Integer.parseInt(in.readLine());

		while(numberOfLines-- > 0){

			String input = in.readLine();

			String ip4 = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

			String ip6 = "^([0-9|a-f|A-F]{1,4})[:]([0-9|a-f|A-F]{1,4})[:]([0-9|a-f|A-F]{1,4})[:]([0-9|a-f|A-F]{1,4})[:]([0-9|a-f|A-F]{1,4})[:]([0-9|a-f|A-F]{1,4})[:]([0-9|a-f|A-F]{1,4})[:]([0-9|a-f|A-F]{1,4})$";                              

			Pattern p = Pattern.compile(ip4);
			Matcher m = p.matcher(input);

			if(m.find()){
				System.out.println("IPv4");
			}
			else{

				Pattern p2 = Pattern.compile(ip6);
				Matcher m2 = p2.matcher(input);

				if(m2.find())
					System.out.println("IPv6");
				else
					System.out.println("Neither");
			}            
		}
	}
}