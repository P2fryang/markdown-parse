// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        System.out.println(markdown.length());
        //System.out.println(mark)
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            System.out.println("Start while!");
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket == -1) {
                break;
            }
            if(nextOpenBracket > 0 && markdown.substring(nextOpenBracket - 1,nextOpenBracket).equals("!")) {
                currentIndex++;
                System.out.println("Continue at image");
                continue;
            }
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            if(nextCloseBracket == -1) {
                break;
            }
            if(markdown.substring(nextOpenBracket, nextCloseBracket).contains("\n")) {
                currentIndex++;
                System.out.println("continue at new line in brackets");
                continue;
            }
            int openParen = markdown.indexOf("(", nextCloseBracket);
            if(openParen == -1) {
                break;
            }
            int tempBracket = nextCloseBracket;
            boolean exited = false;
            System.out.println("open: " + openParen + " | close: " + nextCloseBracket);
            while(openParen != nextCloseBracket + 1) {
                nextCloseBracket = markdown.indexOf("]", tempBracket);
                if(nextCloseBracket == -1) {
                    exited = true;
                    break;
                }
                openParen = markdown.indexOf("(", nextCloseBracket);
                if(openParen == -1) {
                    exited = true;
                    break;
                }
                System.out.println("open: " + openParen + " | close: " + nextCloseBracket);
                tempBracket = nextCloseBracket + 1;
            }
            if(exited) {
                System.out.println("No more ']('");
                break;
            }
            if(markdown.substring(nextOpenBracket, nextCloseBracket).indexOf("\n")!=-1) {
                currentIndex++;
                System.out.println("continue at newline in brackets 2");
                continue;
            }
            int closeParen = markdown.indexOf(")", openParen);
            if(closeParen == -1) {
                break;
            }
            String thePotentialLink = markdown.substring(openParen + 1, closeParen).trim();
            //System.out.println("the curr text: " + markdown.substring(nextOpenBracket, closeParen + 1));
            if(thePotentialLink.contains("\n")) {
                currentIndex = nextOpenBracket + 1;
                continue;
            }
            else if(thePotentialLink.contains(" ")) {
                System.out.println("There is an invalid space, skipping...");
            }
            else {
                toReturn.add(thePotentialLink);
            }
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}