import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.AbstractCollection;

public class First extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.getOutputStream().print("<h1>HELLO WORLD</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
