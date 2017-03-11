public final class TCommandLineWriter implements TWriter {
    @Override
    public void write(String[][] stringMatrix) {
        for (String[] line : stringMatrix) {
            for (String word : line) {
                if (word != null) System.out.print(word + "  ");
            }
            System.out.print("\n");
        }
    }
}
