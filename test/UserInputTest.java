import com.myproject.Human;
import com.myproject.Prompter;
import com.myproject.TicTacToe;
import org.junit.Test;
import org.junit.Assert;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class UserInputTest {



    @Test
    public void testValidInput() throws Exception{
        Prompter prompter = new Prompter(new Scanner(new File("Randall.txt")));
        String name = prompter.prompt("Please enter your name: ");


        Human h = new Human(name);
        assertEquals("Randall", h.getName());


    }




}