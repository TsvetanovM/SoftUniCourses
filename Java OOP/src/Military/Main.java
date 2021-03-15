package Military;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Soldier> soldiers = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String rank = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];
            switch (rank) {
                case "Private":
                    double salary = Double.parseDouble(tokens[4]);
                    soldiers.add(new PrivateImpl(id, firstName, lastName, salary));
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    LieutenantGeneralImpl lg = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    addPrivateSoldier(soldiers, tokens, lg);
                    soldiers.add(lg);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(tokens[4]);
                    String corps = tokens[5];
                    if (isValidCorps(corps)) {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < tokens.length; i += 2) {
                            String partName = tokens[i];
                            int hoursWorked = Integer.parseInt(tokens[i+1]);
                            Repair repair = new Repair(partName, hoursWorked);
                            engineer.addRepair(repair);
                        }
                        soldiers.add(engineer);
                    }
                    break;
                case "Commando":
                    salary = Double.parseDouble(tokens[4]);
                    corps = tokens[5];
                    if (isValidCorps(corps)) {
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < tokens.length; i += 2) {
                            String codeName = tokens[i];
                            String missionState = tokens[i+1];
                            Mission mission = new Mission(codeName, missionState);
                            commando.addMission(mission);
                        }
                        soldiers.add(commando);
                    }
                    break;
                case "Spy":
                    String codeNumber = tokens[4];
                    soldiers.add(new SpyImpl(id, firstName, lastName, codeNumber));
                    break;
            }
            input = scanner.nextLine();
        }

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());
        }
    }

    private static void addPrivateSoldier(List<Soldier> soldiers, String[] tokens, LieutenantGeneralImpl lg) {
        for (int i = 5; i < tokens.length; i++) {
            int privateId = Integer.parseInt(tokens[i]);
            for (Soldier soldier : soldiers) {
                if (soldier.getId() == privateId) {
                    lg.addPrivate((PrivateImpl) soldier);
                    break;
                }
            }
        }
    }

    private static boolean isValidCorps(String corps) {
        for (Corps corps1 : Corps.values()) {
            if (corps1.name().equals(corps)) {
                return true;
            }
        }
        return false;
    }
}
