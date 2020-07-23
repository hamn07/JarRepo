import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.Test;
import org.xhtmlrenderer.pdf.ITextRenderer;

//
// HtmlToPdfTest.java
// Project JarRepo
// 
// Created by HamnLee on 2020年3月7日 下午8:45:10
//

public class HtmlToPdfTest {

	@Test
	public void test() throws Exception {
		
		String html = "<html><head></head><body><h1>html to pdf success</h1></body></html>";
		
		OutputStream outputStream = new FileOutputStream("/tmp/message.pdf");
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(html);
		renderer.layout();
		renderer.createPDF(outputStream);
		outputStream.close();
	}
}
