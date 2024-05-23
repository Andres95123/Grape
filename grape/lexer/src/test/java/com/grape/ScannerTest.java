package com.grape;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.StringReader;

public class ScannerTest {

    private Scanner getLexer(String input) {
        return new Scanner(new StringReader(input));
    }
}
