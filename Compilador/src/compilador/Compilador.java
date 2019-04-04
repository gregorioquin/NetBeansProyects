/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author elearning02
 */
public class Compilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String line = "This order was placed for QT3000! OK?";
        Pattern pat = Pattern.compile("abc");
		Matcher mat = pat.matcher(line);
		if (mat.matches()) {
			System.out.println("SI");
		} else {
			System.out.println("NO");
                }
    }
    
}
