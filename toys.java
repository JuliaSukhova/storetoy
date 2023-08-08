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