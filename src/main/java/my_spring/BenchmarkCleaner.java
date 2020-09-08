package my_spring;

public class BenchmarkCleaner implements Cleaner {

    @InjectByType
    private Cleaner cleaner;

    @Override
    public void clean() {
        long startTime = System.nanoTime();
        cleaner.clean();
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
