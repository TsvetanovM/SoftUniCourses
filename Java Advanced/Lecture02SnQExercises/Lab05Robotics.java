package softuni.advanced.java;

import java.util.*;

public class Lab05Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robots = scanner.nextLine().split(";");
        Map<Robot, Integer> workingRobots = new LinkedHashMap<>();
        for (String robot : robots) {
            String[] current = robot.split("-");
            Robot robot1 = new Robot(current[0], Integer.parseInt(current[1]));
            workingRobots.put(robot1, 0);
        }

        int[] theTime = Arrays.stream(scanner.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int seconds = theTime[2];
        int minutes = theTime[1];
        int hours = theTime[0];

        String input = scanner.nextLine();
        ArrayDeque<String> assemblyLine = new ArrayDeque<>();

        while (!input.equals("End")) {
            assemblyLine.offer(input);
            input = scanner.nextLine();
        }

        while (!assemblyLine.isEmpty()) {
            seconds++;
            if (seconds>59) {
                seconds = 0;
                minutes++;
                if (minutes>59) {
                    minutes = 0;
                    hours++;
                    if (hours>23) {
                        hours = 0;
                    }
                }
            }

            for (Map.Entry<Robot, Integer> entry : workingRobots.entrySet()) {
                entry.setValue(entry.getValue()-1);
            }

            boolean robotAvailable = false;
            for (Map.Entry<Robot, Integer> entry : workingRobots.entrySet()) {
                if (entry.getValue()<1) {
                    System.out.printf("%s - %s [%02d:%02d:%02d]%n", entry.getKey().getName(), assemblyLine.poll(), hours, minutes, seconds);
                    entry.setValue(entry.getKey().getProcessingTime());
                    robotAvailable = true;
                    break;
                }
            }
            if (!robotAvailable&&assemblyLine.size()>1) {
                assemblyLine.offer(assemblyLine.poll());
            }
        }
    }
}

class Robot{
    String name;
    int processingTime;

    Robot(String name, int processingTime){
        this.name = name;
        this.processingTime = processingTime;
    }

    public String getName() {
        return name;
    }

    public int getProcessingTime() {
        return processingTime;
    }
}
