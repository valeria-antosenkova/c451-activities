void main() {
    Map<String, String> stateCapitals = new HashMap<>();

    try(BufferedReader reader = new BufferedReader(new FileReader("/Users/v-an/c451-activities/Exercises/src/StateCapitals"));
    ){
        String line;
        while((line = reader.readLine()) != null){
            stateCapitals.put(line.split("::")[0], line.split("::")[1]);

        }
    }
    catch(IOException e){
        System.out.println("Error reading a file");
    }

    System.out.println("State Capitals:" + stateCapitals.size());
    for (String state : stateCapitals.keySet()){
        System.out.println(state);
    };

    List<String> states = new ArrayList<>(stateCapitals.keySet());
    String randomState = states.get(new Random().nextInt(states.size()));
    System.out.println("What is the capital of " + randomState + "?");
    Scanner sc = new Scanner(System.in);
    String userGuess = sc.nextLine();
    if (userGuess.equals(stateCapitals.get(randomState))){
        System.out.println("Correct!");
    }
    else{
        System.out.println("Wrong!");
    }
}