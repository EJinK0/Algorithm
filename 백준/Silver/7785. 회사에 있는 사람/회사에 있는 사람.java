import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int logCount = Integer.parseInt(sc.nextLine()); // 출입기록수
        Set<String> workingPeoples = new HashSet<>();

        for (int i = 0; i < logCount; i++) {
            String line = sc.nextLine();
            String workingPeoPle = line.split(" ")[0];
            String workingStatus = line.split(" ")[1];

            if(Objects.equals(workingStatus, "enter")) {
                workingPeoples.add(workingPeoPle);
            } else {
                workingPeoples.remove(workingPeoPle);
            }
        }
        
        List<String> workingPeopleList = new ArrayList<>(workingPeoples);
        workingPeopleList.sort((a, b) -> b.compareTo(a));

        for(String name: workingPeopleList) {
            System.out.println(name);
        }
    }
}
