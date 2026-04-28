void main() {

    // writing to a file
    try (PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
    ){
        out.println("this is a line in my file...");
        out.println("a second line in my file...");
        out.println("a third line in my file...");
        out.flush();
        out.close();
    }
    catch (IOException e){
        System.out.println("Error writing to file: " + e.getMessage());
    }

    // reading from a file
    try (Scanner sc = new Scanner(
            new BufferedReader(new FileReader("OutFile.txt")))){
        // go through the file line by line
    while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            System.out.println(currentLine);
        }
    }
    catch(IOException e){
        System.out.println("Error reading a file");
    }


}