package patterns.inheritance;

import java.io.*;

public class CountedOutputStream extends StringOutputStream {

    public CountedOutputStream(OutputStream s) {
        super(s);
    }

    int writtenChars = 0;
    boolean isCounted = true;

    public int writtenChars() {
        // TODO return number of written characters
        return writtenChars;
    }

    @Override
    public void write(char ch) throws IOException {
        // TODO Auto-generated method stub

        if (isCounted)
            super.write(ch);
        else {
            isCounted = true;
            writtenChars++;
            super.write(ch);
            isCounted = false;
        }

    }

    @Override
    public void write(String s) throws IOException {
        // TODO Auto-generated method stub

        if (isCounted)
            super.write(s);
        else {
            isCounted = true;
            writtenChars += s.length();
            super.write(s);
            isCounted = false;
        }

    }

}

