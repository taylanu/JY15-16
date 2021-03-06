package proj113;

public class wordSearch {
    static Scanner input = new Scanner(System.in);

    // Implemented idea from https://stackoverflow.com/questions/13029922/find-specific-word-in-text-file-and-count-it
    public static int countWord(String word, File file) throws FileNotFoundException {
        int count = 0;
        Scanner search = new Scanner(file);
        while (search.hasNextLine()) {
            String nextToken = search.next();
            if (nextToken.equalsIgnoreCase(word)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to WordSearch v0.0.1");
        System.out.println("Please enter the file that you would like to search through.");
        String fileName = input.nextLine();
        System.out.println("Enter the target word.");
        String target = input.nextLine();
        File file1 = new File(fileName);

        if (countWord(target, file1) == 0) {
            System.out.println("Your target word couldn't be found in the file.");
        } else {
            System.out.println("Times Your Word Was Found: " + countWord(target, file1) + "\nYour word was first seen on line: " + countWord(target, file1));
        }
    }
}

/*//Implemented from http://stackoverflow.com/questions/19973543/scanner-keeps-throwing-filenotfound-exception#19973734
 * Try catch code to help prevent filenotfoundexceptions
    try {
    System.out.println(f.exists());
    new Scanner(f);
}
//catch the exception
catch(FileNotFoundException e) {
    e.printStackTrace();
	}
}
	*/

/* //Implemented from code created by http://www.roseindia.net/java/beginners/DirectoryListing.shtml
//Just for style points if I can get it to work :)

private static void dirlist(String fname) {
		File dir = new File(fname);
	    String[] chld = dir.list();

	  if(chld == null){
		  System.out.println("Specified directory does not exist or is not a directory.");
		  System.exit(0);
	 }
	  else{
		  for(int i = 0; i < chld.length; i++){
			  String fileName = chld[i];
			  System.out.println(fileName);
	  }
	}

  }
}
*/

