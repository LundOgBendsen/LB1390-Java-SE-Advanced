package dk.lundogbendsen.javase8advanced.io.lab03.writerfork;

import java.io.IOException;
import java.io.Writer;

public class WriterFork extends Writer {

	private Writer w1;
	private Writer w2;

	public WriterFork(final Writer w1, final Writer w2) {
		this.w1 = w1;
		this.w2 = w2;
	}

	@Override
	public void write(final char[] cbuf, final int off, final int len) throws IOException {
		this.w1.write(cbuf, off, len);
		this.w2.write(cbuf, off, len);
	}

	@Override
	public void flush() throws IOException {
		this.w1.flush();
		this.w2.flush();
	}

	@Override
	public void close() throws IOException {
		this.w1.close();
		this.w2.close();
	}

}