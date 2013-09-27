package image;

import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

public class Image {
	int[][] valeurPixels;
	
	public Image(String name) throws IOException {
		InputStream is = Image.class.getResourceAsStream(name);
        byte[] bb = new byte[is.available()];
        is.read(bb);
        String file = new String(bb);
        StringTokenizer st = new StringTokenizer(file, "\r\n");
        st.nextToken();
        st.nextToken();
        String gr = st.nextToken();
        StringTokenizer stt = new StringTokenizer(gr, " \t");
        String token;
        token = stt.nextToken();
        int largeur = Integer.parseInt(token);
        token = stt.nextToken();
        int longueur = Integer.parseInt(token);
        st.nextToken();
        valeurPixels = new int[largeur][longueur];
        int i=0;
        int j=0;
        while (st.hasMoreTokens()) {
        	gr = st.nextToken();
            stt = new StringTokenizer(gr, " \t");
        	while (stt.hasMoreTokens()) {
        		token = stt.nextToken();
        		valeurPixels[i][j] = Integer.parseInt(token);
        		j++;
        	}
        	j=0;
        	i++;
        }
	}
}
