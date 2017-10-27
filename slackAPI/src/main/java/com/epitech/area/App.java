package com.epitech.area;


/**
 * Hello world!
 *
 */
public class App 
{
    private static final String token = "xoxp-261529746561-262931379814-262067619282-b6f6b558734a92b6866ccf48e2c718f0";
    private static final String tokenWG = "xoxp-122008013473-138041964547-262807431572-e124690976ef970de2777f5d936e4e32";

    public static void main( String[] args )
    {
        //System.out.println( "Hello! World!" );
        slackAPI api = new slackAPI(token);
        api.sendMessage("général", "next");
    }
}