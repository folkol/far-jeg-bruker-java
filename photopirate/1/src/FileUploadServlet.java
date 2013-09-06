import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream in = req.getPart("file").getInputStream();
        File filename = new File("/opt/tomcat/webapps/photopirate/bild.jpg");
        FileOutputStream out = new FileOutputStream(filename);

        int read = 0;
        while ((read = in.read()) != -1) out.write(read);
        out.close();
    }

}
