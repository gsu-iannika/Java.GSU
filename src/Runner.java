import by.gsy.pms.Schedule;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Runner{

    private static final String INPUT = "src/input.txt";
    private static final String OUTPUT = "src/output.txt";

    public static void main(String[] args) throws IOException {
        List<Schedule> schedules = readSchedules();
        Collections.sort(schedules);
        writeSchedules(schedules);
    }

    private static List<Schedule> readSchedules() throws IOException {
        return Files.lines(Paths.get(INPUT)).map(s -> {
            String[] splitted = s.split(";");
            return new Schedule(
                    splitted[0],
                    splitted[1],
                    Integer.parseInt(splitted[2]),
                    Integer.parseInt(splitted[3]),
                    Integer.parseInt(splitted[4]),
                    splitted[5],
                    splitted[6]);
        }).collect(Collectors.toList());
    }

    private static void writeSchedules(List<Schedule> schedules) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT));
        for (Schedule schedule : schedules) {
            writer.write(schedule.toString() + "\n");
        }

        writer.close();
    }

}
