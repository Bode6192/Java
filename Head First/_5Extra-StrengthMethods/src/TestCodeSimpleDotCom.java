import java.util.ArrayList;

public class TestCodeSimpleDotCom {

    public static void main(String[] args) {

        SimpleDotCom dot = new SimpleDotCom();

        int[] locations = {2, 3, 4};
        dot.setLocationCells(locations);

        String userGuess = "2";
        String result = dot.checkYourself(userGuess);
        String testResult = "failed";
        if (result.equals("hit")) {
            testResult = "passed";
        }

        System.out.println(testResult);
    }
}

class SimpleDotCom {

    private int[] locationCells;

    int numOfHits = 0;

    public void setLocationCells (int[] locs) {
        locationCells = locs;
    }

    public  String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";

        for (int cell : locationCells){
            if (guess == cell) {
                result = "hit";
                numOfHits++;
                break;
            }   //  out of the loop
        }

        if (numOfHits == locationCells.length) {
            result = "kill";
        }

        System.out.println(result);
        return result;
    }   // close method
}   // close class

// An ArrayList version of the Simple Dot Com class.
class DotCom{
    private ArrayList<String> locationCells;
    // private int numOfHits;
    // don’t need that now
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {

            locationCells.remove(index);


            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            } // close if

        } // close outer if

        return result;
    }
}