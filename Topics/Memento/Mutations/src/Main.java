import java.util.*;
import java.util.stream.Collectors;

class Originator {
    private List<Integer> numbers = new ArrayList<>();

    public void addNumber(Integer number) {
        numbers.add(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Memento getMemento() {
        return new Memento(numbers);
    }

    public void setMemento(Memento lastState) {
        this.numbers = lastState.savedState;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    class Memento {
        private List<Integer> savedState = new ArrayList<>();

        private Memento(List<Integer> state) {
            this.savedState = state.stream().collect(Collectors.toList());
        }

    }
}

class Caretaker {
    private final Originator originator;
    private Originator.Memento snapshot = null;

    Caretaker(Originator originator) {
        this.originator = originator;
    }

    public void save() {
        snapshot = originator.getMemento();
    }

    public void restore() {
        if (snapshot != null) {
            originator.setMemento(snapshot);
        }
    }
}