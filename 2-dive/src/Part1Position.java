public class Part1Position implements Position {
    private int horizontal = 0;
    private int depth = 0;

    @Override
    public void forward(int value) {
        horizontal += value;
    }

    @Override
    public void down(int value) {
        depth += value;
    }

    @Override
    public void up(int value) {
        depth -= value;
    }

    @Override
    public int getPosition() {
        return horizontal * depth;
    }
}
