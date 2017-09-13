package pa2;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Method;

class TokenTest {
    private static Token testToken = null;
    //if values not given, these hold the defaults from the last created token
    private static Token.Type defaultCorrectType = Token.Type.NOT;
    private static String defaultCorrectData = "testdata";
    @org.junit.jupiter.api.Test

    //force creation of a new test token
    static Token createTestToken(Token.Type correctType, String correctData) {
        defaultCorrectType = correctType;
        defaultCorrectData = correctData;
        try {
            Class tokenClass = Class.forName("com.company.Token");
            Method tokenOfMethod = tokenClass.getMethod("of", Token.Type.class, String.class);
            return testToken = (Token) tokenOfMethod.invoke(null, correctType, correctData);
        }
        catch (Exception e) {
            System.out.println("Unable to create test class");
            e.printStackTrace();
            return testToken; //attempt to continue with the last successfully created Token
        }
    }

    void of() {
        Type testType = new Type("not", false);
        TokenTest tester = new TokenTest();
       Assertions.assertEquals(testToken,testType,"not");
    }
}