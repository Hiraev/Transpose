public final class TCommandLineWriter implements TWriter {
    @Override
    public void write(String[] lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
