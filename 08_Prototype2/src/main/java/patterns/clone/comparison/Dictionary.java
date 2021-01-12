package patterns.clone.comparison;

import java.io.*;

@SuppressWarnings("unused")
public class Dictionary implements Serializable, Cloneable {

	private String language;
	private final int size;
	private String[] words;
	public Oof oof;

	public class Oof implements Serializable{
		private int happyNumber;

		public int getHappyNumber() {
			return happyNumber;
		}

		public void setHappyNumber(int happyNumber) {
			this.happyNumber = happyNumber;
		}
	}


	public Dictionary(String language, int size) {
		this.oof = new Oof();
		oof.happyNumber = size;
		this.language = language;
		this.size = size;
		this.words = new String[size];
		for (int i = 0; i < size; i++)
			this.words[i] = "sample word " + i;
	}

	private Dictionary() {
		size = 2;
		System.out.println("default called");
	}

	//	@Override
//	public Dictionary clone() {
//		try {
//			Dictionary d = (Dictionary) super.clone();
//			if (words != null) {
//				d.words = words.clone();
//			}
//			return d;
//		} catch (CloneNotSupportedException e) {
//			throw new InternalError();
//		}
//	}

	public Object clone () {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream oout = new ObjectOutputStream(out);
			oout.writeObject(this);
			ObjectInputStream oin = new ObjectInputStream(
					new ByteArrayInputStream(out.toByteArray()));
			return oin.readObject();
		}
		catch (Exception e) {
			throw new RuntimeException ("cannot clone class");
		}
	}
}
