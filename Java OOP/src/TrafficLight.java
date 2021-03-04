import java.util.ArrayDeque;

public class TrafficLight {
    private ArrayDeque<String> trafficLights;

    public TrafficLight(String...args) {
        trafficLights = new ArrayDeque<>();
        for (String arg : args) {
            trafficLights.offer(arg);
        }
    }

    public void changeTrafficLight() {
        if (!trafficLights.isEmpty()) {
            String lastLight = trafficLights.poll();
            trafficLights.offer(lastLight);
        }
    }

    public void showTrafficLight() {
        for (String light : trafficLights) {
            System.out.print(light + " ");
        }
        System.out.println();
    }
}
