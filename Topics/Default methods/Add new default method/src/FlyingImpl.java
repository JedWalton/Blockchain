public class FlyingImpl implements Flying {

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getHeightInkm(int in) {
        return in / 1000;
    }
}
