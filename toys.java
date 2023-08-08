import java.util.PriorityQueue;

public class ToyLottery {
    private PriorityQueue<Toy> toyQueue;

    public ToyLottery(String[] toyIds, String[] toyNames, int[] toyFrequencies) {
        if (toyIds.length != toyNames.length || toyIds.length != toyFrequencies.length) {
            throw new IllegalArgumentException("Длины массивов должны совпадать.");
        }

        toyQueue = new PriorityQueue<>(toyIds.length, (t1, t2) -> t2.getFrequency() - t1.getFrequency());

        for (int i = 0; i < toyIds.length; i++) {
            Toy toy = new Toy(toyIds[i], toyNames[i], toyFrequencies[i]);
            toyQueue.offer(toy);
        }
    }

    public void runLottery() {
        System.out.println("Выигранные игрушки: ");
        while (!toyQueue.isEmpty()) {
            Toy winner = toyQueue.poll();
            System.out.println(winner.getName());
        }
    }

    public static void main(String[] args) {
        String[] toyIds = {"1", "2", "3"};
        String[] toyNames = {"Мишка", "Кукла", "Робот"};
        int[] toyFrequencies = {3, 2, 4};

        ToyLottery toyLottery = new ToyLottery(toyIds, toyNames, toyFrequencies);
        toyLottery.runLottery();
    }
}

class Toy {
    private String id;
    private String name;
    private int frequency;

    public Toy(String id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }
}