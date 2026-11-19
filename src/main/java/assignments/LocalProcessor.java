package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName = new StringBuilder();
    private Long period = 10000000000000L;
    private StringBuilder processorVersion = new StringBuilder();
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(StringBuilder processorName, Long period, StringBuilder processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);

        for (String value : stringArrayList) {
            if(value!=null) {
                System.out.println(value.hashCode());
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        for (String name:stringList) {
            processorName.append(name).append(" ");
        }
        return processorName.toString().trim();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws IllegalStateException, FileNotFoundException {
        informationScanner = new Scanner(file);
        while (informationScanner.hasNext()) {
            processorVersion.append(informationScanner.nextLine());
        }
    }
}
