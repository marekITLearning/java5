package sk.itlearning.java5.biz.accframe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {

		List<AccFrame> accFrameList = new ArrayList<>();

		File f = new File("../../product1_backend_doc/osnova.csv");
		f.setReadOnly();
		try {
			Files.lines(f.toPath()).forEach(l -> {
				String[] cols = l.split("\t");
				for (int i = 0; i < cols.length; i++) {
					cols[i] = cols[i].trim().strip();
				}
				Instant todayInstant = LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC);
				Instant endOfYearInstant = LocalDate.of(2021, 12, 31).atStartOfDay().toInstant(ZoneOffset.UTC);
				if (cols.length == 8) {
					AccFrame af = new AccFrame(cols[0], cols[1], cols[2], cols[3], cols[4], cols[5], cols[6], cols[7],
							Date.from(todayInstant), Date.from(endOfYearInstant));
					accFrameList.add(af);
					System.out.println(l);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			f.setWritable(true);
		}

		String result = new GsonBuilder().setPrettyPrinting().create().toJson(accFrameList);

		try (FileWriter fw = new FileWriter(new File("../../product1_backend_doc/osnova.json"))) {
			fw.append(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
