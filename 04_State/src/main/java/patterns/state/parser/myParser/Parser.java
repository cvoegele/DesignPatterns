package patterns.state.parser.myParser;

public class Parser implements ParserInterface {

    private interface State {
        void nextE();
        void nextDigit(String l);
        void nextDot();
        void nextSign();
    }

    private State state;
    private double value;

    private class InitState implements State {

        @Override
        public void nextE() {
            state = new ErrorState();
        }

        @Override
        public void nextDigit(String l) {
            value = Double.parseDouble(l);
            state = new DigitState();
        }

        @Override
        public void nextDot() {

            state = new DigitState();
        }

        @Override
        public void nextSign() {
            state = new ErrorState();
        }
    }

    private class ErrorState implements State {

        @Override
        public void nextE() {

        }

        @Override
        public void nextDigit(String l) {

        }

        @Override
        public void nextDot() {

        }

        @Override
        public void nextSign() {

        }
    }

    private class DigitState implements State{

        @Override
        public void nextE() {

        }

        @Override
        public void nextDigit(String l) {

        }

        @Override
        public void nextDot() {

        }

        @Override
        public void nextSign() {

        }
    }

    @Override
    public void addLetter(String l) {

    }

    @Override
    public String getResult() {
        return null;
    }
}
