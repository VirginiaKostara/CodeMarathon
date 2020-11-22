package codemarathon;

import java.io.FileOutputStream;

public class createfile {
	public static void editfile () {
		try {
			FileOutputStream fout=new FileOutputStream("newdata.txt");
			for (int i=0; i<29; i++) {
				fout.write(Mask.nomask[i]);
			}
			fout.close();
			System.out.println("success..");
		} catch (Exception e) {System.out.println(e);}
	}
}
