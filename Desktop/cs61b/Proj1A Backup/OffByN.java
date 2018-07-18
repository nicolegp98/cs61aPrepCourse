public class OffByN implements CharacterComparator {

    private int number;

    public OffByN(int N) {
        this.number = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        return (diff == this.number);
    }
    
}
