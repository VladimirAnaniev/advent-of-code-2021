public class Part2Position implements Position {
    private int horizontal = 0;
    private int depth = 0;
    private int aim = 0;

    @Override
    public void forward(int value) {
        horizontal += value;
        depth += value * aim;
    }

    @Override
    public void down(int value) {
        aim += value;
    }

    @Override
    public void up(int value) {
        aim -= value;
    }

    @Override
    public int getPosition() {
        return horizontal * depth;
    }
}
