import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebServlet("/calculateText")
public class CalculateTextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String text = request.getParameter("text");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<i>" + text + "</i>");

        writer.println("<h3> Ilość słów: " + countWords(text) + "</h3>");
        writer.println("<h3> Ilość znaków: " + text.length() + "</h3>");
        writer.println("<h3> Ilość znaków (bez spacji): " + countNonWhiteCharacters(text) + "</h3>");
        writer.println("<h3> Palindrom: " + isPalindrom(text) + "</h3>");
    }

    private int countWords(String text) {
        String[] wordsTable = text.split(" ");
        return wordsTable.length;
    }

    private int countNonWhiteCharacters(String text) {
        String[] wordsTable = text.split(" ");
        int counter = 0;
        for (String word : wordsTable) {
            counter += word.length();
        }
        return counter;
    }

    private boolean isPalindrom(String text) {
        String[] wordsTable = text.split(" ");
        String[] wordsTableClone = wordsTable.clone();

        List<String> stringList = Arrays.asList(wordsTable);
        List<String> stringList2 = Arrays.asList(wordsTableClone);
        Collections.reverse(stringList2);

        for (int i = 0; i < stringList.size(); i++) {
            if (!stringList.get(i).equals(stringList2.get(i))){
                return false;
            }
        }
        return true;
    }
}
