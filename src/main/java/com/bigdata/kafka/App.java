package com.bigdata.kafka;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		KafkaProd x = new KafkaProd();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String data = sc.nextLine();
			if (data.equals("exit"))
				System.exit(0);
			x.Produce(data);
		}

		// x.Produce(args[0]);
	}
}
