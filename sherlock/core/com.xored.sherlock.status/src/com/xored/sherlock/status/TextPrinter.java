package com.xored.sherlock.status;

import java.io.PrintStream;
import java.io.PrintWriter;

interface TextPrinter {

	void print(String text);

	void println(String text);

	void println();

	static class Stream implements TextPrinter {

		public Stream(PrintStream stream) {
			this.stream = stream;
		}

		@Override
		public void print(String text) {
			stream.print(text);
		}

		@Override
		public void println() {
			stream.println();
		}

		@Override
		public void println(String text) {
			stream.println(text);
		}

		private PrintStream stream;

	}

	static class Writer implements TextPrinter {

		public Writer(PrintWriter writer) {
			this.writer = writer;
		}

		@Override
		public void print(String text) {
			writer.print(text);
		}

		@Override
		public void println() {
			writer.println();
		}

		@Override
		public void println(String text) {
			writer.println(text);
		}

		private PrintWriter writer;

	}

}
