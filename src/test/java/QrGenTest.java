import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.junit.Test;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

//
// QrGenTest.java
// Project JarRepo
// 
// Created by HamnLee on Mar 6, 2018 11:54:02 AM
//

public class QrGenTest {

	@Test
	public void test() {
		// get QR file from text using defaults
		String codeString = "Ofertones 3F0AB3F15FD40BFD8C3AB8B39AE72012";
		File file = QRCode.from(codeString).to(ImageType.JPG).withSize(320, 320).file();
		try {
			Files.move(file.toPath(), Paths.get("hello-world.jpg"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
